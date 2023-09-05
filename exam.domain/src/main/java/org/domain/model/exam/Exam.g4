grammar Exam;



exam: exam_header '{' section+ '}';


exam_header: SUBMISSION_TITLE NAME;

section: SECTION_TITLE NAME '{' question+ '}';

question: matching_quest
              | multiple_choice_quest
              | short_answer_quest
              | numerical_quest
              | select_words_quest
              | true_false_quest
              ;

matching_quest: MATCHING NAME (('[' NAME (',' NAME)*  ']') | NULL_OPERATOR)  ';';

multiple_choice_quest: MULTIPLE_CHOICE NAME (('[' NAME (',' NAME)*  ']') | NULL_OPERATOR) ';';

short_answer_quest: SHORT_ANSWER NAME (('[' NAME ']') | NULL_OPERATOR) ';';

numerical_quest: NUMERICAL NAME (NUMBER | NULL_OPERATOR) ';';

select_words_quest: SELECT_WORDS NAME ('[' NAME (',' NAME)*  ']' | NULL_OPERATOR) ';';

true_false_quest: TRUE_FALSE NAME (TRUE_FALSE_OPT | NULL_OPERATOR) ';';




MATCHING : 'MQUES';
MULTIPLE_CHOICE : 'MCQUES';
SHORT_ANSWER : 'SAQUES';
NUMERICAL : 'NQUES';
SELECT_WORDS : 'SWQUES';
TRUE_FALSE : 'TFQUES';

SUBMISSION_TITLE: 'EXAM SUBMISSION';

SECTION_TITLE: 'SECTION';

NAME: '"' .*? '"';

NULL_OPERATOR: 'null';

NUMBER : [1-9][0-9]*( '.' [0-9]+ ) ?;

TRUE_FALSE_OPT : 'True' | 'False';

WS: [ \t\r\n]+ -> skip;

