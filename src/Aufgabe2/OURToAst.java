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
        if (!(testStaticSemantic(ast.toString()) && testDynamicSemantic(ast.toString()))) exit(1);

        System.out.printf("OURtoString() = \"%s\"%n", ast);
    }

    static public boolean testStaticSemantic(String tree) {
        char[] ourString = tree.toCharArray();
        char current = ' ';
        for (char c : ourString) {
            if ((c == '{' || c == '[') && (current != c)) {
                current = c;
            } else if (c == '{' || c == '[') {
                System.out.printf("Statisch-semantischer Fehler: Es dürfen nicht zwei %c aufeinander folgen !\n", current);
                return false;
            }
        }
        return true;
        // [22]%{hi}%[22]%{hi}%[22]%{hi}%[22]%{hi}%[22].
        // [22]%[22]%[22].
        // [22]%{hi}%[22]%{hi}%[22]%{hi}%[22]%{hi}%{hi}%{hi}.
        // [41]%{hi}%[232]%{hi}%[42]%{hi}%[252]%{hi}.
        // 0 == gleich -> semantisch falsch
        // 1 == ungleich -> semantisch richtig
    }

    static public boolean testDynamicSemantic(String tree) {

        tree = tree.substring(0,tree.length()-1);
        String[] list = tree.split("%");
        String curr;
        for (String s : list) {
            int checksum = 0;
            if (!s.startsWith("[")) continue;
            //System.out.println("curr curr = " + curr);
            curr = s.substring(1, s.length() - 1);
            //System.out.println("curr next = " + curr);
            String[] currar = curr.split("");
            for (int j = 0; j < curr.length(); j++) {
                checksum += Integer.parseInt(currar[j]);
            }

            if (checksum < 4) {
                System.out.println("Dynamisch-semantischer Fehler: Keine Quersumme darf kleiner als 4 sein !\n");
                return false;
            }
            tree = tree.replaceFirst(curr, Integer.toString(checksum));

        }

        System.out.printf("OURtoString() mit Quersummen = \"%s.\"%n", tree);
        return true;





            // [22]%{hi}%[22]%{hi}%[22]%{hi}%[22]%{hi}%[22].
        // [22]%[22]%[22].
        // [22]%{hi}%[22]%{hi}%[22]%{hi}%[22]%{hi}%{hi}%{hi}.
        // 0 == gleich -> semantisch falsch
        // 1 == ungleich -> semantisch richtig
    }


}