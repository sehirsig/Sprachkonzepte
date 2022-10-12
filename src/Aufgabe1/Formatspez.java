package Aufgabe1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

//    %[argument_index$][flags][width][.precision]conversion
//    https://developer.android.com/reference/java/util/Formatter
//    https://docs.oracle.com/javase/7/docs/api/java/util/Formatter.html

//Format fängt mit % an und hört mit d auf

public class Formatspez {

    public static void main(String[] args) {
        if (args.length != 0) {
            System.err.println("java RegexTest <format-string>");
            System.exit(1);
        }


        /*
        xxx %d yyy%n
        TEXT("xxx ")FORMAT("%d")TEXT(" yyy")FORMAT("%n")
        xxx%1$d yyy
        TEXT("xxx")FORMAT("%1$d")TEXT(" yyy")
        %1$-02.3dyyy
        FORMAT("%1$-02.3d")TEXT("yyy")
         */
        String formatString = "%1$-02.3dyyy";//args[0];

        //% + ARGUMENT_INDEX + FLAGS + WIDTH + PRECISION + CONVERSION
        // %[argument_index$][flags][width][.precision]conversion
        // '%' + argument_index + flags + width + precision + conversion

        String text = "([a-zA-Z ]*)";

        String argument_index = "([1-9]\\d*\\$)*";
        String flags = "[-#\\+ 0,\\(]*";
        String width = "([1-9]\\d*)?";
        String precision = "(\\.\\d*)?";
        String conversion = "[bBhHsScCdoxXeEfgGaAtT%n]";
        String PATTERN = "(%" + argument_index + flags + width + precision + conversion + ")|" + text;

        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(formatString);

        while (matcher.find()) {
            //System.out.print(matcher.group());

            if (matcher.group().startsWith("%")) {
                System.out.printf("FORMAT(\"%s\")", matcher.group());
            } else {
                if (!matcher.group().equals("")) {
                System.out.printf("TEXT(\"%s\")", matcher.group());
                }
            }
        }
    }
}