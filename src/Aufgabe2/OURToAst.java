package Aufgabe2;

import org.antlr.v4.runtime.CharStreams;
import org.antlr.v4.runtime.CommonTokenStream;
import org.antlr.v4.runtime.tree.ParseTree;

public final class OURToAst {
    private OURToAst() { }

    public static void main(String[] args) throws Exception {
        OURLexer lexer = new OURLexer(CharStreams.fromStream(System.in));
        OURParser parser = new OURParser(new CommonTokenStream(lexer));
        ParseTree tree = parser.start();
        if (parser.getNumberOfSyntaxErrors() > 0) {
            System.err.printf("%d error(s) detected%n",
                              parser.getNumberOfSyntaxErrors());
            System.exit(1);
        }

        OUR ast = new OURBuilder().build(tree);
        if (testStaticSemantik(ast.toString())) {
            System.out.printf("OURtoString() = \"%s\"%n", ast);
        } else {
            System.exit(1);
        }
    }

    public static boolean testStaticSemantik(String tree) {
        char[] ourString = tree.toCharArray();
        char current = ' ';
        for (int i = 0; i < ourString.length; i++) {
            if ((ourString[i] == '{' || ourString[i] == '[') && (current != ourString[i])) {
                current = ourString[i];
            } else if ((ourString[i] == '{' || ourString[i] == '[') && (current == ourString[i])) {
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