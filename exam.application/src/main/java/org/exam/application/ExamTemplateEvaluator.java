package org.exam.application;



import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.tree.*;
import org.domain.model.Course;
import org.domain.model.examtemplate.ExamTemplateBuilder;
import org.domain.model.examtemplate.ExamTemplateErrorListener;
import org.domain.model.examtemplate.ExamTemplateLexer;
import org.domain.model.examtemplate.ExamTemplateParser;
import org.domain.model.examtemplate.domain.ExamTemplate;
import org.usermanagement.domain.model.User;

import java.io.IOException;
import java.util.Set;

public class ExamTemplateEvaluator {
    public static ExamTemplate evaluateFromFile (String filePath, User teacher, Course course, Set<User> students) throws IOException {
        ExamTemplateLexer lexer = new ExamTemplateLexer(CharStreams.fromFileName(filePath));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        ExamTemplateParser parser = new ExamTemplateParser(tokens);

        parser.addErrorListener(new ExamTemplateErrorListener());

        ParseTree tree = parser.start();
        ParseTreeWalker walker = new ParseTreeWalker();
        ExamTemplateBuilder builder = new ExamTemplateBuilder();

        builder.with(course, teacher, students);

        walker.walk(builder, tree);

        return builder.build();
    }
}
