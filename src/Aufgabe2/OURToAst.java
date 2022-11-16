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
            System.exit(1);
        }

        OUR ast = new OURBuilder().build(tree);
        if (testStaticSemantik(ast.toString())) {
            System.out.printf("OURtoString() = \"%s\"%n", ast);
        } else {
            System.exit(1);
        }

        System.out.println("Numbers for program:");
        String[] ausgabe = giveNums(ast.toString());
        for (String s : ausgabe) {
            System.out.println(s);
        }

        System.out.println(testDynamicSemantic(ast.toString()));

    }

    /*
    Statische Semantik: Nummern und Buchstaben müssen immer abwechselnd sein.

    Dynamische Semantik: Alle Zahlen dürfen addiert nicht über 100 geben
     */

    public static boolean testStaticSemantik(String tree) {
        char[] ourString = tree.toCharArray();
        char current = ' ';
        for (char c : ourString) {
            if ((c == '{' || c == '[') && (current != c)) {
                current = c;
            } else if ((c == '{' || c == '[') && (current == c)) {
                System.out.printf("Statisch semantischer Fehler: Es dürfen nicht zwei %c aufeinander folgen !\n", current);
                return false;
            }
        }
        return true;
        // [22]%{hi}%[12]%{hi}%[22]%{hi}%[22]%{hi}%[22].
        // [22]%[22]%[22].
        // [22]%{hi}%[22]%{hi}%[22]%{hi}%[22]%{hi}%{hi}%{hi}.
        // 0 == gleich -> semantisch falsch
        // 1 == ungleich -> semantisch richtig
    }

    static public boolean testDynamicSemantic(String tree) {
        String[] list = tree.split("%");
        String curr = "";
        for (String s : list) {
            int checksum = 0;
            if (!s.startsWith("[")) continue;
            if (s.contains(".")) {
                curr = s.substring(1, s.length() - 2);
            } else {
                curr = s.substring(1, s.length() - 1);
            }
            String[] currar = curr.split("");
            for (int j = 0; j < curr.length(); j++) {
                    checksum += Integer.parseInt(currar[j]);
            }

            if (checksum < 4) {
                System.out.println("Dynamisch-semantischer Fehler: Keine Quersumme darf kleiner als 4 sein !\n");
                return false;
            }
            tree = tree.replaceFirst(curr, Integer.toString(checksum));
        } return true;
    }

    public static String[] giveNums(String tree) {
        String first = tree.replaceAll("[^0-9]", "@");
        String second = first.replaceAll("[@]+", "@");
        String[] fertig = second.split("@");
        return fertig;
    }
}