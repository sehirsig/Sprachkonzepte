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

        System.out.println(testDynamicSemantic(ast.toString()));
        System.out.printf("OURtoString() = \"%s\"%n", ast);
    }



    // wäre auch in grammatik möglich -> besser wäre zbb werteberiech für nubers festlegen, da das nur statisch semantisch
    // geprüft werden kann
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
        // [21]%{hi}%[232]%{hi}%[42]%{hi}%[252]%{hi}.
        // 0 == gleich -> semantisch falsch
        // 1 == ungleich -> semantisch richtig
    }

    // auch statische sematik
    // dynamisch wäre anzahl numbers print strings into txt file, weil so haben die zahlen eine beudeutung
    static public boolean testDynamicSemantic(String tree) {
        tree = tree.substring(0, tree.length()-1 );
        String[] list = tree.split("%");
        String first = "";
        String second = "";

        if (!((list.length % 2 ) == 0)) {
            System.out.println("Dynamisch-semantischer Fehler: Satz anzahl muss gerade sein !\n");
            return false;
        }

        // [5]%{gina}%[6]. --> FALSCH da ungerade
        // [5]%{gina}%[6]%{gravestone}%[3]%{spatz}.
        // {toter}%[6]%{spatz}%[2]%{kriegt}%[1]%{gravestone}%[4].

        for (int i  = 0; i < list.length ; i+=2 ) {
            first = list[i].substring(1, list[i].length() - 1);
            second = list[i+1].substring(1, list[i+1].length() - 1);
            System.out.println();
            if (list[i].startsWith("[")) {
                int curr_nbr = Integer.parseInt(first);
                for (int j = 0; j < curr_nbr; j++) {
                    System.out.print(second + ", ");
                }
            } else {
                int curr_nbr = Integer.parseInt(second);
                for (int j = 0; j < curr_nbr; j++) {
                    System.out.print(first + ", ");
                }

            }
            System.out.println();
        } return true;


        // [22]%{hi}%[22]%{hi}%[22]%{hi}%[22]%{hi}%[22].
        // [22]%[22]%[22].
        // [22]%{hi}%[22]%{hi}%[22]%{hi}%[22]%{hi}%{hi}%{hi}.
        // 0 == gleich -> semantisch falsch
        // 1 == ungleich -> semantisch richtig
    }


}