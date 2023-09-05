grammar TemplateFormativeQuestion;


start: quest ;

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


ID_OPTION : 'OPT';
ID_SOLUTION : 'SOL';

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