# US 3003

## 1. Context

In Sprint B client wants us to develop a study of shyncronization for our System. He wants us to "explore" the synchronization problems related to the shyncronization of shared boards and design a conceptual solution based on practical evidence.

## 2. Requirements

As Project Manager, I want the team to "explore" the synchronization problems related to the shyncronization of shared boards and design a conceptual solution based on practical evidence.

This functional part of the system has very specific technical requirements, particularly some concerns about synchronization problems. 
In fact, several clients will try to concurrently update boards. As such, to explore and study this concurrency scenario a "model" of a solution must be implemented and evaluated in C, using processes and semaphores. 


## 3. Analysis

Faced with the set of synchronization problems, the team decided to carry out an in-depth study on the following question in the statement:

    Users with write permission may post content to a cell in the board. The content can be a text or an image. When the server commits a post it also should notify all clients with access to the board of the update.

## 4. Design

### 4.1. Applied Patterns

#### 4.1.1. Producer/Consumer

- The goal is to ensure synchronization between processes. Where one process produces content and other processes consume it. In this way, the consistency of the data will be guaranteed.

#### 4.1.2. Barrier

- The objective is to guarantee synchronization between processes, requiring that all processes work in parallel until a certain moment. After all processes reach this point (barrier) they must continue.



## 5. Implementation

**Main.c**

```C
#include <stdio.h>
#include <stdlib.h>
#include <unistd.h>
#include <semaphore.h>
#include <fcntl.h>
#include <sys/wait.h>
#include <sys/types.h>
#include <sys/stat.h>
#include <time.h>
#include <sys/mman.h>
#include <string.h>

void down(sem_t *sem){
	if(sem_wait(sem) == -1){
		perror("semphore");
		exit(EXIT_FAILURE);
	}
}

void up(sem_t *sem){
	if(sem_post(sem) == -1){
		perror("semphore");
		exit(EXIT_FAILURE);
	}
}


#define SEM_EXCL "/sem_exclude"
#define SEM_ITEMS "/sem_items"
#define SEM_SPAC "/sem_space"
#define SEM_BAR "/sem_barrier"
#define SHM_MEM "/shm_memory"


typedef struct {
    char postit[3][100];
    int last_postit_changed;
    int number_of_producers;
    int count_proccess;
    int producer;
	int num_users;
} board;


int main() {
    sem_t *sem_excl, *sem_items, *sem_spac, *sem_barrier;
    board *shared_mem;
    
    // Shared memory
    int data_size = sizeof(board);
    int fd = shm_open(SHM_MEM, O_CREAT | O_RDWR, S_IRWXU);
     
    if (fd == -1) {
        perror("shm_open");
        exit(1);
    }

    if (ftruncate(fd, data_size) == -1) {
        perror("ftruncate");
        exit(1);
    }

    shared_mem = (board *) mmap(NULL, data_size, PROT_READ | PROT_WRITE, MAP_SHARED, fd, 0);

    if (shared_mem == MAP_FAILED) {
        perror("mmap");
        exit(1);
    }
    
    //------------------------------------------------

    // Create semaphores
    sem_excl = sem_open(SEM_EXCL, O_CREAT | O_EXCL, 0644, 1);
    
    if (sem_excl == SEM_FAILED) {
        perror("sem_open");
        exit(1);
    }
    
	sem_items = sem_open(SEM_ITEMS, O_CREAT | O_EXCL, 0644, 0);
    
    if (sem_items == SEM_FAILED) {
        perror("sem_open");
        exit(1);
    }
    
    sem_spac = sem_open(SEM_SPAC, O_CREAT | O_EXCL, 0644, 1);
    
    if (sem_spac == SEM_FAILED) {
        perror("sem_open");
        exit(1);
    }
    
    sem_barrier = sem_open(SEM_BAR, O_CREAT | O_EXCL, 0644, 0);
    
    if (sem_barrier == SEM_FAILED) {
        perror("sem_open");
        exit(1);
    }


    //------------------------------------------------
    // initialize values
	shared_mem -> number_of_producers = 0;  
	shared_mem -> count_proccess = 0;
	shared_mem -> producer = 0; 
	shared_mem -> num_users = 10;
	pid_t pid;
	int i;

    // create child processes
    for (i = 0; i < shared_mem -> num_users; i++) {
        pid = fork();

        if (pid == 0) {
            break;
    	}    
    }
    
	if(pid == 0){
		do{				
			if(i == shared_mem -> producer){
				// producer
				down(sem_spac);
				down(sem_excl);
				
				srand(time(NULL) + getpid() + i);
				
				shared_mem -> last_postit_changed = rand() % 3; 
				
				
				char temp_buffer[150];
				snprintf(temp_buffer, sizeof(temp_buffer), "%s %d", shared_mem->postit[shared_mem->last_postit_changed], getpid());
				strcpy(shared_mem->postit[shared_mem->last_postit_changed], temp_buffer);

				
				
				printf("[%d] I CHANGED THE POST-IT %d FOR - %s\n", getpid(), shared_mem -> last_postit_changed, shared_mem -> postit[shared_mem -> last_postit_changed]);
					
				shared_mem -> count_proccess = shared_mem -> count_proccess + 1;
					
				up(sem_excl);
				up(sem_items);
			} else {
				// consumer	
				down(sem_items);
				down(sem_excl);
					
				printf("[%d] CONFIRM CHANGE ON POST-IT %d TEXT -%s\n", getpid(), shared_mem -> last_postit_changed, shared_mem -> postit[shared_mem -> last_postit_changed]);
				shared_mem -> count_proccess = shared_mem -> count_proccess + 1;
					
				up(sem_excl);
					
				if(shared_mem -> count_proccess == shared_mem -> num_users){
					shared_mem -> number_of_producers = shared_mem -> number_of_producers + 1;
					shared_mem -> producer = shared_mem -> producer + 1;
						 						
					up(sem_barrier);
				} else {
					up(sem_items);
				}
			}
				
			down(sem_barrier);
				
			shared_mem -> count_proccess = shared_mem -> count_proccess - 1;
					
			if(!shared_mem -> count_proccess == 0){
				up(sem_barrier);
			} else {					
				up(sem_spac);
			}
		} while(shared_mem -> number_of_producers < shared_mem -> num_users);
	}		
    
    
	// parent
    if (pid > 0){    	
    	// parent should wait for childs to finish
		for(int j = 0; j < shared_mem -> num_users; j++){
			wait(NULL);
		}
		
		// parent print post-it modifications
		for(int i = 0; i < 3; i++){
			printf("POST-IT %d HAS BEEN MODIFIED BY THE FOLLOWING PROCESSES --> %s\n", i, shared_mem -> postit[i]);
		}
		
		// Close and unlink the shared memory
	    if (munmap(shared_mem, data_size) == -1) {
	        perror("munmap failed");
	        exit(EXIT_FAILURE);
	    }
	    
	    if (close(fd) == -1) {
	        perror("close failed");
	        exit(EXIT_FAILURE);
	    }
	    
	    if (shm_unlink(SHM_MEM) == -1) {
			perror("shm_unlink failed");
			exit(EXIT_FAILURE);
		}
		
		// Close and unlink the semaphore
	    if(sem_close(sem_excl) == -1) {
	        perror("sem_close");
	        exit(EXIT_FAILURE);
	    }
	    
	    if(sem_unlink(SEM_EXCL) == -1) {
	        perror("sem_unlink");
	        exit(EXIT_FAILURE);
	    }
	    
	    if(sem_close(sem_items) == -1) {
	        perror("sem_close");
	        exit(EXIT_FAILURE);
	    }
	    
	    if(sem_unlink(SEM_ITEMS) == -1) {
	        perror("sem_unlink");
	        exit(EXIT_FAILURE);
	    }
	    
	    if(sem_close(sem_spac) == -1) {
	        perror("sem_close");
	        exit(EXIT_FAILURE);
	    }
	    
	    if(sem_unlink(SEM_SPAC) == -1) {
	        perror("sem_unlink");
	        exit(EXIT_FAILURE);
	    }
	    
	    if(sem_close(sem_barrier) == -1) {
	        perror("sem_close");
	        exit(EXIT_FAILURE);
	    }
	    
	    if(sem_unlink(SEM_BAR) == -1) {
	        perror("sem_unlink");
	        exit(EXIT_FAILURE);
	    }
	    
	    //------------------------------------------------
		
		return 0;
	}

    exit(0);
}
```

## 6. Integration/Demonstration

Write "make run" in application

```txt
[152742] I CHANGED THE POST-IT 2 FOR -  152742
[152743] CONFIRM CHANGE ON POST-IT 2 TEXT - 152742
[152744] CONFIRM CHANGE ON POST-IT 2 TEXT - 152742
[152745] CONFIRM CHANGE ON POST-IT 2 TEXT - 152742
[152747] CONFIRM CHANGE ON POST-IT 2 TEXT - 152742
[152749] CONFIRM CHANGE ON POST-IT 2 TEXT - 152742
[152746] CONFIRM CHANGE ON POST-IT 2 TEXT - 152742
[152751] CONFIRM CHANGE ON POST-IT 2 TEXT - 152742
[152748] CONFIRM CHANGE ON POST-IT 2 TEXT - 152742
[152750] CONFIRM CHANGE ON POST-IT 2 TEXT - 152742
[152743] I CHANGED THE POST-IT 2 FOR -  152742 152743
[152744] CONFIRM CHANGE ON POST-IT 2 TEXT - 152742 152743
[152745] CONFIRM CHANGE ON POST-IT 2 TEXT - 152742 152743
[152751] CONFIRM CHANGE ON POST-IT 2 TEXT - 152742 152743
[152750] CONFIRM CHANGE ON POST-IT 2 TEXT - 152742 152743
[152742] CONFIRM CHANGE ON POST-IT 2 TEXT - 152742 152743
[152747] CONFIRM CHANGE ON POST-IT 2 TEXT - 152742 152743
[152749] CONFIRM CHANGE ON POST-IT 2 TEXT - 152742 152743
[152746] CONFIRM CHANGE ON POST-IT 2 TEXT - 152742 152743
[152748] CONFIRM CHANGE ON POST-IT 2 TEXT - 152742 152743
[152744] I CHANGED THE POST-IT 0 FOR -  152744
[152743] CONFIRM CHANGE ON POST-IT 0 TEXT - 152744
[152745] CONFIRM CHANGE ON POST-IT 0 TEXT - 152744
[152748] CONFIRM CHANGE ON POST-IT 0 TEXT - 152744
[152751] CONFIRM CHANGE ON POST-IT 0 TEXT - 152744
[152750] CONFIRM CHANGE ON POST-IT 0 TEXT - 152744
[152742] CONFIRM CHANGE ON POST-IT 0 TEXT - 152744
[152747] CONFIRM CHANGE ON POST-IT 0 TEXT - 152744
[152749] CONFIRM CHANGE ON POST-IT 0 TEXT - 152744
[152746] CONFIRM CHANGE ON POST-IT 0 TEXT - 152744
[152745] I CHANGED THE POST-IT 0 FOR -  152744 152745
[152746] CONFIRM CHANGE ON POST-IT 0 TEXT - 152744 152745
[152744] CONFIRM CHANGE ON POST-IT 0 TEXT - 152744 152745
[152743] CONFIRM CHANGE ON POST-IT 0 TEXT - 152744 152745
[152748] CONFIRM CHANGE ON POST-IT 0 TEXT - 152744 152745
[152751] CONFIRM CHANGE ON POST-IT 0 TEXT - 152744 152745
[152750] CONFIRM CHANGE ON POST-IT 0 TEXT - 152744 152745
[152742] CONFIRM CHANGE ON POST-IT 0 TEXT - 152744 152745
[152747] CONFIRM CHANGE ON POST-IT 0 TEXT - 152744 152745
[152749] CONFIRM CHANGE ON POST-IT 0 TEXT - 152744 152745
[152746] I CHANGED THE POST-IT 0 FOR -  152744 152745 152746
[152749] CONFIRM CHANGE ON POST-IT 0 TEXT - 152744 152745 152746
[152744] CONFIRM CHANGE ON POST-IT 0 TEXT - 152744 152745 152746
[152743] CONFIRM CHANGE ON POST-IT 0 TEXT - 152744 152745 152746
[152745] CONFIRM CHANGE ON POST-IT 0 TEXT - 152744 152745 152746
[152748] CONFIRM CHANGE ON POST-IT 0 TEXT - 152744 152745 152746
[152751] CONFIRM CHANGE ON POST-IT 0 TEXT - 152744 152745 152746
[152750] CONFIRM CHANGE ON POST-IT 0 TEXT - 152744 152745 152746
[152742] CONFIRM CHANGE ON POST-IT 0 TEXT - 152744 152745 152746
[152747] CONFIRM CHANGE ON POST-IT 0 TEXT - 152744 152745 152746
[152747] I CHANGED THE POST-IT 1 FOR -  152747
[152746] CONFIRM CHANGE ON POST-IT 1 TEXT - 152747
[152743] CONFIRM CHANGE ON POST-IT 1 TEXT - 152747
[152745] CONFIRM CHANGE ON POST-IT 1 TEXT - 152747
[152748] CONFIRM CHANGE ON POST-IT 1 TEXT - 152747
[152751] CONFIRM CHANGE ON POST-IT 1 TEXT - 152747
[152749] CONFIRM CHANGE ON POST-IT 1 TEXT - 152747
[152742] CONFIRM CHANGE ON POST-IT 1 TEXT - 152747
[152744] CONFIRM CHANGE ON POST-IT 1 TEXT - 152747
[152750] CONFIRM CHANGE ON POST-IT 1 TEXT - 152747
[152748] I CHANGED THE POST-IT 1 FOR -  152747 152748
[152746] CONFIRM CHANGE ON POST-IT 1 TEXT - 152747 152748
[152743] CONFIRM CHANGE ON POST-IT 1 TEXT - 152747 152748
[152745] CONFIRM CHANGE ON POST-IT 1 TEXT - 152747 152748
[152751] CONFIRM CHANGE ON POST-IT 1 TEXT - 152747 152748
[152750] CONFIRM CHANGE ON POST-IT 1 TEXT - 152747 152748
[152742] CONFIRM CHANGE ON POST-IT 1 TEXT - 152747 152748
[152744] CONFIRM CHANGE ON POST-IT 1 TEXT - 152747 152748
[152747] CONFIRM CHANGE ON POST-IT 1 TEXT - 152747 152748
[152749] CONFIRM CHANGE ON POST-IT 1 TEXT - 152747 152748
[152749] I CHANGED THE POST-IT 2 FOR -  152742 152743 152749
[152743] CONFIRM CHANGE ON POST-IT 2 TEXT - 152742 152743 152749
[152746] CONFIRM CHANGE ON POST-IT 2 TEXT - 152742 152743 152749
[152745] CONFIRM CHANGE ON POST-IT 2 TEXT - 152742 152743 152749
[152748] CONFIRM CHANGE ON POST-IT 2 TEXT - 152742 152743 152749
[152751] CONFIRM CHANGE ON POST-IT 2 TEXT - 152742 152743 152749
[152750] CONFIRM CHANGE ON POST-IT 2 TEXT - 152742 152743 152749
[152744] CONFIRM CHANGE ON POST-IT 2 TEXT - 152742 152743 152749
[152742] CONFIRM CHANGE ON POST-IT 2 TEXT - 152742 152743 152749
[152747] CONFIRM CHANGE ON POST-IT 2 TEXT - 152742 152743 152749
[152750] I CHANGED THE POST-IT 1 FOR -  152747 152748 152750
[152747] CONFIRM CHANGE ON POST-IT 1 TEXT - 152747 152748 152750
[152749] CONFIRM CHANGE ON POST-IT 1 TEXT - 152747 152748 152750
[152746] CONFIRM CHANGE ON POST-IT 1 TEXT - 152747 152748 152750
[152743] CONFIRM CHANGE ON POST-IT 1 TEXT - 152747 152748 152750
[152745] CONFIRM CHANGE ON POST-IT 1 TEXT - 152747 152748 152750
[152748] CONFIRM CHANGE ON POST-IT 1 TEXT - 152747 152748 152750
[152751] CONFIRM CHANGE ON POST-IT 1 TEXT - 152747 152748 152750
[152744] CONFIRM CHANGE ON POST-IT 1 TEXT - 152747 152748 152750
[152742] CONFIRM CHANGE ON POST-IT 1 TEXT - 152747 152748 152750
[152751] I CHANGED THE POST-IT 0 FOR -  152744 152745 152746 152751
[152742] CONFIRM CHANGE ON POST-IT 0 TEXT - 152744 152745 152746 152751
[152747] CONFIRM CHANGE ON POST-IT 0 TEXT - 152744 152745 152746 152751
[152749] CONFIRM CHANGE ON POST-IT 0 TEXT - 152744 152745 152746 152751
[152743] CONFIRM CHANGE ON POST-IT 0 TEXT - 152744 152745 152746 152751
[152745] CONFIRM CHANGE ON POST-IT 0 TEXT - 152744 152745 152746 152751
[152746] CONFIRM CHANGE ON POST-IT 0 TEXT - 152744 152745 152746 152751
[152748] CONFIRM CHANGE ON POST-IT 0 TEXT - 152744 152745 152746 152751
[152750] CONFIRM CHANGE ON POST-IT 0 TEXT - 152744 152745 152746 152751
[152744] CONFIRM CHANGE ON POST-IT 0 TEXT - 152744 152745 152746 152751
POST-IT 0 HAS BEEN MODIFIED BY THE FOLLOWING PROCESSES -->  152744 152745 152746 152751
POST-IT 1 HAS BEEN MODIFIED BY THE FOLLOWING PROCESSES -->  152747 152748 152750
POST-IT 2 HAS BEEN MODIFIED BY THE FOLLOWING PROCESSES -->  152742 152743 152749
```