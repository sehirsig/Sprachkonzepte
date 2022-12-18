package Aufgabe4;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.io.BufferedReader;
import java.io.IOException;

import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;


public final class Functional {
    private Functional() { }

    private static final int MIN_LENGTH = 20;

    public static void main(String[] args) throws IOException {
        //$FileDir$/input.txt
        var input = Files.newBufferedReader(Paths.get(args[0]));

        long start = System.nanoTime();
/*
        LinkedList<String> l1 = readLines(input, lines);
        LinkedList<String> l2 = removeEmptyLines(l1);
        LinkedList<String> l3 = removeShortLines(l2);

        int n = totalLineLengths(l3);
*/
        int n = input.lines()
                .filter(line -> !line.isEmpty())
                .filter(line -> line.length() > MIN_LENGTH)
                .mapToInt(String::length).sum();

        long stop = System.nanoTime();

        System.out.printf("result = %d (%d microsec)%n", n, (stop - start) / 1000);
    }

    private static int totalLineLengths(LinkedList<String> lines) {
        // :: syntax um funktion anzuwenden ohne direkten Aufruf
        // kann auch durch lambda ausdruck l -> l.length() ersetzt werden
        return lines.stream().mapToInt(String::length).sum();
    }

    private static LinkedList<String> removeShortLines(LinkedList<String> lines) {
        // lines.removeIf(line -> line.length() < MIN_LENGTH);
        return lines.stream()
                .filter(line -> line.length() > MIN_LENGTH)
                .collect(Collectors.toCollection(LinkedList::new));
    }

    private static LinkedList<String> removeEmptyLines(LinkedList<String> lines) {
        //lines.removeIf(String::isEmpty);
        return lines.stream()
                .filter(line -> !line.isEmpty())
                .collect(Collectors.toCollection(LinkedList::new));
    }

    private static LinkedList<String> readLines(BufferedReader input, List<String> lines) throws IOException {
        return input.lines().collect(Collectors.toCollection(LinkedList::new));
    }

    // result = 187 (536 microsec) | PROCEDURAL
    // result = 187 (2470 microsec) | FUNCTIONAL
    /*
        Prozedural ist schneller als Funktional da Werte überschrieben werden nicht neu erstellt.
        Abstraktion (Immutability) hat die Kosten, dass es langsamer ist, da nicht referenziert wird sondern
        kopiert und neu erstellt. Jeder Kopiervorgang verbraucht zusätzliche Zeit.
     */

    // TODO: Klassenmethoden readLines, removeEmptyLines, removeShortLines, totalLineLengths
}


