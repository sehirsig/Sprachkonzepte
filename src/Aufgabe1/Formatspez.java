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

        String formatString = "Wochentag: %tA Uhrzeit: %tT";//args[0];

        //% + ARGUMENT_INDEX + FLAGS + WIDTH + PRECISION + CONVERSION
        // %[argument_index$][flags][width][.precision]conversion
        // '%' + argument_index + flags + width + precision + conversion

        String text = "([a-zA-Z: ]*)";

        String argument_index = "([1-9]\\d*\\$)*";
        String flags = "[-#\\+ 0,\\(]*";
        String width = "([1-9]\\d*)?";
        String precision = "(\\.\\d*)?";
        String conversion = "[bBhHsScCdoxXeEfgGaAtT%n]";
        String time = "[AT]?";
        String PATTERN = "(%" + argument_index + flags + width + precision + conversion + time + ")|" + text;

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

/*

%c	character
%d	decimal (integer) number (base 10)
%e	exponential floating-point number
%f	floating-point number
%i	integer (base 10)
%o	octal number (base 8)
%s	a string of characters
%u	unsigned decimal (integer) number
%x	number in hexadecimal (base 16)
%%	print a percent sign
\%	print a percent sign
\a	audible alert
\b	backspace
\f	form feed
\n	newline, or linefeed
\r	carriage return
\t	tab
\v	vertical tab
\\	backslash

Time Conversions

'H'	Hour of the day for the 24-hour clock, formatted as two digits with a leading zero as necessary i.e. 00 - 23.
'I'	Hour for the 12-hour clock, formatted as two digits with a leading zero as necessary, i.e. 01 - 12.
'k'	Hour of the day for the 24-hour clock, i.e. 0 - 23.
'l'	Hour for the 12-hour clock, i.e. 1 - 12.
'M'	Minute within the hour formatted as two digits with a leading zero as necessary, i.e. 00 - 59.
'S'	Seconds within the minute, formatted as two digits with a leading zero as necessary, i.e. 00 - 60 ("60" is a special value required to support leap seconds).
'L'	Millisecond within the second formatted as three digits with leading zeros as necessary, i.e. 000 - 999.
'N'	Nanosecond within the second, formatted as nine digits with leading zeros as necessary, i.e. 000000000 - 999999999.
'p'	Locale-specific morning or afternoon marker in lower case, e.g."am" or "pm". Use of the conversion prefix 'T' forces this output to upper case.
'z'	RFC 822 style numeric time zone offset from GMT, e.g. -0800. This value will be adjusted as necessary for Daylight Saving Time. For long, Long, and Date the time zone used is the default time zone for this instance of the Java virtual machine.
'Z'	A string representing the abbreviation for the time zone. This value will be adjusted as necessary for Daylight Saving Time. For long, Long, and Date the time zone used is the default time zone for this instance of the Java virtual machine. The Formatter's locale will supersede the locale of the argument (if any).
's'	Seconds since the beginning of the epoch starting at 1 January 1970 00:00:00 UTC, i.e. Long.MIN_VALUE/1000 to Long.MAX_VALUE/1000.
'Q'	Milliseconds since the beginning of the epoch starting at 1 January 1970 00:00:00 UTC, i.e. Long.MIN_VALUE to Long.MAX_VALUE.

Date Conversions
'B'	Locale-specific full month name, e.g. "January", "February".
'b'	Locale-specific abbreviated month name, e.g. "Jan", "Feb".
'h'	Same as 'b'.
'A'	Locale-specific full name of the day of the week, e.g. "Sunday", "Monday"
'a'	Locale-specific short name of the day of the week, e.g. "Sun", "Mon"
'C'	Four-digit year divided by 100, formatted as two digits with leading zero as necessary, i.e. 00 - 99
'Y'	Year, formatted as at least four digits with leading zeros as necessary, e.g. 0092 equals 92 CE for the Gregorian calendar.
'y'	Last two digits of the year, formatted with leading zeros as necessary, i.e. 00 - 99.
'j'	Day of year, formatted as three digits with leading zeros as necessary, e.g. 001 - 366 for the Gregorian calendar.
'm'	Month, formatted as two digits with leading zeros as necessary, i.e. 01 - 13.
'd'	Day of month, formatted as two digits with leading zeros as necessary, i.e. 01 - 31
'e'	Day of month, formatted as two digits, i.e. 1 - 31.




printf("%03d", 0);	000 -> Fill with zeros
At least five wide	printf("'%5d'", 10);	'   10'  -> width right (default)
At least five wide	printf("'%-5d'", 10);	'10   '  -> width left
Print one position after the decimal	printf("'%.1f'", 10.3456);	'10.3' -> precision
Take third value argument  printf("'%3$s'", "a", "b", "c", "d");	'c' -> argument_index
 */

