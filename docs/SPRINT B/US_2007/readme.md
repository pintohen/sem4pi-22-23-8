# US 2007

## 1. Context

In Sprint B client wants us to develop add/update exam questions to a repository of exam questions to be used in automatic formative exams. The team must also create a structure that validates the creation of questions that will be inserted into the repository.

## 2. Requirements

As Teacher I want to add/update exam questions to a repository of exam questions to be used in automatic formative exams

This includes only the specification of single questions to be used only in automatic formative exams, not on regular exams.
The support for exams (its design, feedback and grading) must follow specific technical requirements, specified in LPROG.
The ANTLR tool should be used (https://www.antlr.org/).

## 3. Analysis

**Question Types:**

* Matching - A list of sub-questions is provided, along with a list of answers. The respondent must "match" the correct answers with each question.

* Multiple Choice - With the Multiple Choice question type you can create single-answer and multiple-answer questions and weight individual answers

* Short Answer - In response to a question, the respondent types a word or phrase. There
  may be several possible correct answers, with different grades. Answers may or may not
  be sensitive to case.

* Numerical - From the student perspective, a numerical question looks just like a short-answer question. The difference is that numerical answers are allowed to have an accepted error. This allows a continuous range of answers to be se

* Select Missing Words - Students select a missing word or phrase from a dropdown
  menu. Items may be grouped and used more than once.

* True/False - In response to a question, the respondent selects from two options: True
  or False.


## 4. Grammar definitions

|  CODE   |            MEANING            |
|:-------:|:-----------------------------:|
| MQUES:  |       Matching question       |
| MCQUES: |   Multiple Choice question    |
| SAQUES: |     Short Answer question     |
| NQUES:  |      Numerical question       |
| SWQUES: | Select missing words question |
| TFQUES: |      True/False question      |
|  OPT:   |         Option number         |
|  SOL:   |       Question solution       |

**Matching question**

     MQUES "Identify the type of these creatures: Ant; Cow; Dog; Sparrow;";
     OPT "Insect";
     OPT "Mammal";
     OPT "Mammal";
     OPT "Bird";
     SOL |Ant-Insect|0.25|;
     SOL |Cow-Mammal|0.25|;
     SOL |Dog-Mammal|0.25|;
     SOL |Bird-Sparrow|0.25|;

**Multiple Choice**

The team decided that each multiplie choice should always have 4 options. The number of solutions must always be presented followed by a ";". This way there must be the same number of weight after "|" in solution.

     MCQUES "Choose all animals that have 4 paws";
     OPT "Ant";
     OPT "Cow";
     OPT "Dog";
     OPT "Sparrow";
     SOL |Cow|0.25|;
     SOL |Dog|0.25|;

**Short Answer**

This question has multiple correct answers, however some might me more correct than others.

     SAQUES "What is a rabbit?";
     SOL |animal|0.25|;
     SOL |mammal|0.50|;
     SOL |vertebrate|0.50|;

**Numerical**

The possible solution must be a number (integer or decimal). There is only one solution. This way there must be the same number of weight after "|" in solution.

     NQUES "How many paws does a dog have?";
     SOL |4|0.25|;

**Select Missing Words**

The solution must be placed in order of missing fields.

     SWQUES "On a farm there are different types of animals. Namely the [OPT]. He serves to take care of the other [OPT]. No animal needs to move away from the [OPT].";
     SOL |dog|0.50|;
     SOL |animals|0.50|;
     SOL |place|0.50|;

**True/False**

The question only have 1 solution that can be "True" or "False".

     TFQUES "Does the dog have 4 paws?";
     SOL <True|1.00>;

### 4.1. Grammar rules

***Creating question***

     ID "DESCRIPTION" ;

***Creating options***

     OPT "OPTION";

***Creating solution***

        SOL |DESCRIPTION|WEIGHT|;
        SOL <True|WEIGHT>;

- Basically we followed a programming language alike syntax to follow, with 3 important "commands" to totally create a question.
- Then in the grammar we have patterns of commands that are used to create different types of questions.

## 5. Implementation

```antlrv4
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
```

### 5.1. Builder (Listener)
```java
package org.domain.model.template.formative.question;

import org.antlr.v4.runtime.ParserRuleContext;
import org.antlr.v4.runtime.tree.ErrorNode;
import org.antlr.v4.runtime.tree.TerminalNode;
import org.domain.model.*;

import java.util.ArrayList;
import java.util.List;

public class TemplateFormativeQuestionBuilder extends TemplateFormativeQuestionBaseListener{


  private QuestionDescription description;
  private QuestionType type;
  private List<Answer> options = new ArrayList<>();
  private List<Solution> solutions = new ArrayList<>();

  private Course course;

  @Override
  public void enterMultiple_choice_quest(TemplateFormativeQuestionParser.Multiple_choice_questContext ctx) {
    type = QuestionType.MULTIPLE_CHOICE;

    description = new QuestionDescription(
            ctx.DESCRIPTION().getText()
                    .replace("\"", "")
    );
  }

  @Override
  public void enterMatching_quest(TemplateFormativeQuestionParser.Matching_questContext ctx) {
    type = QuestionType.MATCHING;

    description = new QuestionDescription(
            ctx.DESCRIPTION().getText()
                    .replace("\"", "")
    );
  }

  @Override
  public void enterShort_answer_quest(TemplateFormativeQuestionParser.Short_answer_questContext ctx) {
    type = QuestionType.SHORT_ANSWER;

    description = new QuestionDescription(
            ctx.DESCRIPTION().getText()
                    .replace("\"", "")
    );
  }

  @Override
  public void enterNumerical_quest(TemplateFormativeQuestionParser.Numerical_questContext ctx) {
    type = QuestionType.NUMERICAL;

    description = new QuestionDescription(
            ctx.DESCRIPTION().getText()
                    .replace("\"", "")
    );
  }

  @Override
  public void enterSelect_words_quest(TemplateFormativeQuestionParser.Select_words_questContext ctx) {
    type = QuestionType.MISSING_WORDS;

    description = new QuestionDescription(
            ctx.DESCRIPTION().getText()
                    .replace("\"", "")
    );
  }

  @Override
  public void enterTrue_false_quest(TemplateFormativeQuestionParser.True_false_questContext ctx) {
    type = QuestionType.TRUE_FALSE;

    description = new QuestionDescription(
            ctx.DESCRIPTION().getText()
                    .replace("\"", "")
    );
  }

  @Override
  public void enterCreate_option(TemplateFormativeQuestionParser.Create_optionContext ctx) {
    options.add(
            new Answer(
                    ctx.DESCRIPTION().getText()
                            .replace("\"", "")
            )
    );
  }

  @Override
  public void enterCreate_solution(TemplateFormativeQuestionParser.Create_solutionContext ctx) {
    String solution = ctx.SOLUTION_TEXT().getText().substring(1, ctx.SOLUTION_TEXT().getText().length() - 1);

    String solutionText = solution.split("\\|")[0];
    Double solutionWeight = Double.parseDouble(solution.split("\\|")[1]);

    solutions.add(
            new Solution(
                    new SolutionWeight(solutionWeight),
                    new SolutionDescription(solutionText)
            )
    );
  }

  @Override
  public void enterCreate_true_false_solution(TemplateFormativeQuestionParser.Create_true_false_solutionContext ctx) {
    // no need for validation now, it's done in the parser
    String solution = ctx.TRUE_FALSE_SOLUTION_TEXT().getText().substring(1, ctx.TRUE_FALSE_SOLUTION_TEXT().getText().length() - 1);

    String solutionText = solution.split("\\|")[0];
    Double solutionWeight = Double.parseDouble(solution.split("\\|")[1]);

    solutions.add(
            new Solution(
                    new SolutionWeight(solutionWeight),
                    new SolutionDescription(solutionText)
            )
    );
  }

  public void withCourse(Course course) {
    this.course = course;
  }


  public TemplateFormativeQuestion build() {
    return new TemplateFormativeQuestion(description, type, options, solutions, course);
  }
}
```