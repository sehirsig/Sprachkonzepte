package Aufgabe4;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.LinkedList;
import java.util.List;




public final class Procedural {
    private Procedural() { }

    private static final int MIN_LENGTH = 20;

    public static void main(String[] args) throws IOException {
        var input = Files.newBufferedReader(Paths.get(args[0]));
        var lines = new LinkedList<String>();

        long start = System.nanoTime();

        readLines(input, lines);
        removeEmptyLines(lines);
        removeShortLines(lines);
        int n = totalLineLengths(lines);

        long stop = System.nanoTime();

        System.out.printf("result = %d (%d microsec)%n", n, (stop - start) / 1000);
    }

    private static int totalLineLengths(LinkedList<String> lines) {
        int size = 0;
        for (var line : lines) {
            size += line.length();
        }
        return size;
    }

    private static void removeShortLines(LinkedList<String> lines) {
        // lines.removeIf(line -> line.length() < MIN_LENGTH);
        LinkedList<String> tempLines = (LinkedList<String>) lines.clone();
        for (var line : tempLines) {
            if (line.length() < MIN_LENGTH) {
                lines.remove(line);
            }
        }
    }

    private static void removeEmptyLines(LinkedList<String> lines) {
        // var macht den typ automatisch
        //  lines.removeIf(String::isEmpty);
        LinkedList<String> tempLines = (LinkedList<String>) lines.clone();
        for (var line : tempLines) {
           if (line.isEmpty()) {
                lines.remove(line);
           }
        }
    }

    private static void readLines(BufferedReader input, List<String> lines) throws IOException {
        String line;
        while ((line = input.readLine()) != null) {
            lines.add(line);
        }
    }

    // result = 187 (536 microsec) | PROCEDURAL
    /*
        Was an dem Java-Programm ist eindeutig prozeduraler Stil?
        A:
        -   Die Schleifen (For) sind eindeutig prozedural, da schrittweise die Liste durchgegangen wird und via
        aufgerufene Funktion die selbe Veränderung durchgeführt wird.
        -   While Schleife bei input.readline()

     */

    // TODO: Klassenmethoden readLines, removeEmptyLines, removeShortLines, totalLineLengths
}

