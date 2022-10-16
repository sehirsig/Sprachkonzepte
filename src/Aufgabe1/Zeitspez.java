package Aufgabe1;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Zeitspez {

    public static void main(String[] args) {
        if (args.length != 0) {
            System.err.println("java RegexTest <format-string>");
            System.exit(1);
        }


        String formatString = "11:00 a. m.";//args[0];
        /* 12 Hour Clock

            12:00 a.m.
            12 midnight
            12 noon
            12:01 p.m.

            (((0[1-9])|(1[1-2])):([0-5][0-9]) ((a. m.)|(p. m.)))|(12:00 (noon|midnight))


         */
        String PATTERN = "(((0[1-9])|(1[1-2])):([0-5][0-9]) ((a. m.)|(p. m.)))|(12:00 (noon|midnight))";

        Pattern pattern = Pattern.compile(PATTERN);
        Matcher matcher = pattern.matcher(formatString);

        while (matcher.find()) {
            System.out.print("Found: " + matcher.group());
        }
    }
}