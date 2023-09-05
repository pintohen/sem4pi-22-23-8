package org.exam.application;


import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.domain.model.exam.*;
import org.domain.model.examtemplate.domain.ExamTemplate;
import org.usermanagement.domain.model.User;

import java.io.IOException;

public class ExamEvaluator {
    public static Exam evaluateFromFile (String filePath, User student, ExamTemplate template) throws IOException {
        ExamLexer lexer = new ExamLexer(CharStreams.fromFileName(filePath));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExamParser parser = new ExamParser(tokens);

        parser.addErrorListener(new ExamErrorListener());

        ParseTree tree = parser.exam();
        ParseTreeWalker walker = new ParseTreeWalker();
        ExamBuilder builder = new ExamBuilder();

        builder.withStudent(student);
        builder.withTemplate(template);

        walker.walk(builder, tree);

        return builder.build();
    }
}
