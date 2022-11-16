// DateTest.java
import java.util.Date;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.text.DateFormat;

// Java 8 time-Paket
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public final class DateTest {
    private DateTest() {}

    public static void main(String[] args) {
        // Reihenfolge der Paramter kann verwechselt werden, Monat ab 0 gezaehlt
        Date d = new GregorianCalendar(2021, 10, 9).getTime();

        // viel syntaktischer Ballast und ein Setter kann vergessen werden
        Calendar c = Calendar.getInstance();
        c.set(Calendar.YEAR, 2021);
        c.set(Calendar.MONTH, Calendar.NOVEMBER);
        c.set(Calendar.DAY_OF_MONTH, 9);
        Date dd = c.getTime();

        DateFormat df = DateFormat.getDateInstance();
        System.out.println(df.format(d));
        System.out.println(df.format(dd));

        // Java 8 time-Paket hat fluent Interfaces
        // LocalDate ddd = LocalDate.of(2021, Month.NOVEMBER, 9)
        LocalDate ddd
            = LocalDate.of(2021, Month.AUGUST, 6).plusMonths(3).plusDays(3);

        DateTimeFormatter dtf 
            = DateTimeFormatter.ofLocalizedDate(FormatStyle.MEDIUM);
        System.out.println(dtf.format(ddd));
    }
}
