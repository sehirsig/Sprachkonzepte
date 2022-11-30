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

        lines.forEach(s -> lines.get(totalLineLengths(lines)));
        return 0;
    }

    private static void removeShortLines(LinkedList<String> lines) {
    }

    private static void removeEmptyLines(LinkedList<String> lines) {
    }

    private static void readLines(BufferedReader input, List<String> lines) throws IOException {
        String line;
        while ((line = input.readLine()) != null) {
            lines.add(line);
        }
    }

    // TODO: Klassenmethoden readLines, removeEmptyLines, removeShortLines, totalLineLengths
}

