package Aufgabe2;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

import static java.lang.System.exit;

public final class OURToAst {
    private OURToAst() { }

    public static void main(String[] args) throws Exception {
        OURLexer lexer = new OURLexer(CharStreams.fromStream(System.in));
        OURParser parser = new OURParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.start();
        if (parser.getNumberOfSyntaxErrors() > 0) {
            System.err.printf("%d error(s) detected%n",
                              parser.getNumberOfSyntaxErrors());
            exit(1);
        }

        OUR ast = new OURBuilder().build(tree);
        if (!testStaticSemantic(ast.toString())) exit(1);

        System.out.printf("OURtoString() = \"%s\"%n", ast);
    }

    static public boolean testStaticSemantic(String tree) {
        char[] ourString = tree.toCharArray();
        char current = ' ';
        for (char c : ourString) {
            if ((c == '{' || c == '[') && (current != c)) {
                current = c;
            } else if (c == '{' || c == '[') {
                System.out.printf("Statisch semantischer Fehler: Es dürfen nicht zwei %c aufeinander folgen !\n", current);
                return false;
            }
        }
        return true;
        // [22]%{hi}%[22]%{hi}%[22]%{hi}%[22]%{hi}%[22].
        // [22]%[22]%[22].
        // [22]%{hi}%[22]%{hi}%[22]%{hi}%[22]%{hi}%{hi}%{hi}.
        // 0 == gleich -> semantisch falsch
        // 1 == ungleich -> semantisch richtig
    }

}