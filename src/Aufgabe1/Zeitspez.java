package Aufgabe1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Zeitspez {

    public static void main(String[] args) {
        if (args.length != 0) {
            System.err.println("java RegexTest <format-string>");
            System.exit(1);
        }


        String formatString = "Wochentag: %tA Uhrzeit: %tT";//args[0];


        String PATTERN = "(" +  ")|";

        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(formatString);

        while (matcher.find()) {
            System.out.print(matcher.group());
        }
    }
}