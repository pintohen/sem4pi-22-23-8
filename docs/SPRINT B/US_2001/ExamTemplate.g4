grammar ExamTemplate;


start: exam ;


exam: create_exam_header create_section+;

create_section : ID_SECTION ' '*? DESCRIPTION ' '*? ';' NEWLINE*? quest+;

quest: matching_quest
    | multiple_choice_quest
    | short_answer_quest
    | numerical_quest
    | select_words_quest
    | true_false_quest
    ;

matching_quest: MATCHING ' '*? DESCRIPTION ' '*? ';' NEWLINE*? create_option+ create_solution+;

multiple_choice_quest: MULTIPLE_CHOICE ' '*? DESCRIPTION ' '*? ';' NEWLINE*? create_option+ create_solution+;

short_answer_quest: SHORT_ANSWER ' '*? DESCRIPTION ' '*? ';' NEWLINE*? create_solution+;

numerical_quest: NUMERICAL ' '*? DESCRIPTION ' '*? ';' NEWLINE*? create_solution;

select_words_quest: SELECT_WORDS ' '*? DESCRIPTION ' '*? ';' NEWLINE*? create_solution+;

true_false_quest: TRUE_FALSE ' '*? DESCRIPTION ' '*? ';' NEWLINE*? create_true_false_solution;




create_option : ID_OPTION ' '*? DESCRIPTION ' '*? ';' NEWLINE*?;

create_solution : ID_SOLUTION ' '*? SOLUTION_TEXT ' '*? ';' NEWLINE*?;
create_true_false_solution : ID_SOLUTION ' '*? TRUE_FALSE_SOLUTION_TEXT ' '*? ';' NEWLINE*?;

// FIRST DESCRIPTION IS TITLE SECOND IS EXAM DESCRIPTION
create_exam_header : create_exam create_exam_description create_open_date create_close_date create_feedback_type create_grade_type;

create_exam : ID_EXAM ' '*? DESCRIPTION ' '*? ';' NEWLINE*?;
create_exam_description : ID_EXAM_DESCRIPTION ' '*? DESCRIPTION ' '*? ';' NEWLINE*?;
create_open_date : ID_OPEN_DATE ' '*? DATE ' '*? ';' NEWLINE*?;
create_close_date : ID_CLOSE_DATE ' '*? DATE ' '*? ';' NEWLINE*?;
create_feedback_type : ID_FEEDBACK_TYPE ' '*? TIME_TYPE ' '*? ';' NEWLINE*?;
create_grade_type : ID_GRADE_TYPE ' '*? TIME_TYPE ' '*? ';' NEWLINE*?;


ID_OPTION : 'OPT';
ID_SOLUTION : 'SOL';
ID_EXAM : 'EXAM';
ID_EXAM_DESCRIPTION : 'EXAM_DESCRIPTION';
ID_OPEN_DATE : 'OPEN_DATE';
ID_CLOSE_DATE : 'CLOSE_DATE';
ID_FEEDBACK_TYPE : 'FEEDBACK_TYPE';
ID_GRADE_TYPE : 'GRADE_TYPE';
ID_SECTION : 'SECTION';

DATE: '(' [0-9][0-9] '-' [0-9][0-9] '-' [0-9][0-9][0-9][0-9] ' ' [0-9][0-9] ':' [0-9][0-9] ')';

TIME_TYPE : 'NONE' | 'ONSUB' | 'AFTER' ;

MATCHING : 'MQUES';
MULTIPLE_CHOICE : 'MCQUES';
SHORT_ANSWER : 'SAQUES';
NUMERICAL : 'NQUES';
SELECT_WORDS : 'SWQUES';
TRUE_FALSE : 'TFQUES';

SOLUTION_TEXT : '|' SOL_DESCRIPTION '|' DECIMAL '|' ;

TRUE_FALSE_SOLUTION_TEXT : '<' TRUE_FALSE_SOL_DESCRIPTION '|' DECIMAL '>';




SOL_DESCRIPTION : .*? ;

TRUE_FALSE_SOL_DESCRIPTION : 'True' | 'False';

DESCRIPTION : '"' .*? '"';

NUMBER : [1-9][0-9]*?( '.' [0-9]+ ) ?;

NEWLINE : '\r'? '\n';

DECIMAL : [0-9] '.' [0-9][0-9];