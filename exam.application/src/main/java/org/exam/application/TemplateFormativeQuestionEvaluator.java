package org.exam.application;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;
import org.antlr.v4.runtime.tree.ParseTreeWalker;
import org.domain.model.Course;
import org.domain.model.template.formative.question.*;

import java.io.IOException;

public class TemplateFormativeQuestionEvaluator {

    public static TemplateFormativeQuestion evaluateFromFile(String filePath, Course course) throws IOException {
        TemplateFormativeQuestionLexer lexer = new TemplateFormativeQuestionLexer(CharStreams.fromFileName(filePath));
        CommonTokenStream tokens = new CommonTokenStream(lexer);
        TemplateFormativeQuestionParser parser = new TemplateFormativeQuestionParser(tokens);

        parser.addErrorListener(new TemplateFormativeErrorListener());

        ParseTree tree = parser.start();
        ParseTreeWalker walker = new ParseTreeWalker();
        TemplateFormativeQuestionBuilder builder = new TemplateFormativeQuestionBuilder();
        builder.withCourse(course);

        walker.walk(builder, tree);

        return builder.build();
    }

}
