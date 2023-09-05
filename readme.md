[![Open in Visual Studio Code](https://classroom.github.com/assets/open-in-vscode-c66648af7eb3fe8bc4f294546bfd86ef473780cde1dea487d3c4ff354943c9ae.svg)](https://classroom.github.com/online_ide?assignment_repo_id=10488123&assignment_repo_type=AssignmentRepo)
# Project eCourse

## 1. Description of the Project

**Learning Systems (LS)** is an IT company specialized in the development of learning solutions wanting to develop a new remote learning platform called **eCourse**. 

The platform supports the activites of the 3 (three) major actors of a course, such as teachers, students and managers and several functionalities. The most distinctive features are **Automated Exams** and **Shared Boards**.

The first one guarantee that students automatically have feedback and resulting grades after submitting an exam. The second one is a board that is used to share and organize ideas an information.

The platform is also able to manage:
- **Users** (create, disable/enable and list);
- **Courses** (create, open/close enrollment, open/close course, define teachers, approve/reject enlistment);
- **Classes** (schedule a class, schedule an extra class, update schedule);
- **Exams** (create, list, list course exams, take exam, list grades, list course grades);
- **Shared Boards** (create, share, view history, archive);
- **Post-It** (create, change, undo change);
- **Meetings** (schedule, cancel, accept/reject, list);
- Other type of requirements that should be taken into account for the given problem.

The duration of this project is 3 (three) months, starting on February 22th and ending on June 18h.


## 2. Planning and Technical Documentation

[Planning and Technical Documentation](docs/readme.md)

## 3. How to Build (assuming you have maven and java installed)

To build the project, run the files:

    rebuild-all.bat
    or
    rebuild-all.sh

## 4. How to Execute Tests

If you want to run tests for all modules just run in command line:

    mvn test

## 5. How to Run

Assuming the build was done, we can run the application through the files:


eCourse - Manager
    
    run-manager.bat
    or
    run-manager.sh

eCourse - Teacher
    
    run-teacher.bat
    or
    run-teacher.sh

eCourse - Student
    
    run-student.bat
    or
    run-student.sh

## 6. How to Install/Deploy into Another Machine (or Virtual Machine)

For example if you want to deploy into another machine eCourse - Manager you need to:

    rebuild-all.bat
    run-manager.bat
    or
    rebuild-all.sh
    run-manager.sh    

## 7. How to Generate PlantUML Diagrams

To generate plantuml diagrams for documentation execute the script (for the moment, only for linux/unix/macos):

    ./generate-plantuml-diagrams.sh


