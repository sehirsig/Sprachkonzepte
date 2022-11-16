package Aufgabe2;
import java.lang.Math;

import static java.lang.System.exit;

// Sentence.java
public final class StartSentence extends OUR {
    public final String value;
    public final OUR right;

    public StartSentence(String value, OUR right) {
        this.value = value;
        this.right = right;
    }

    /**
    public String getStartSentence() {
        return this.value;
    }
    */

    // numbr = 0
    // string = 1
    // wedernoch = throw semantik error
    public String getStartSentence()  {
        System.out.printf("here startsentence\n");
        if (this.right == null)
            return this.value;

        Sentence curr = (Sentence) this.right;
        Sentence next = (Sentence) curr.right;
        System.out.println("Curr: " + curr);
        System.out.println("Next: " + next);

        int curr_bin = 5;
        int next_bin = 5;

        // {}=String []=Number
        if (curr.value.toString().startsWith("[")) {
            curr_bin = 0b0;
        }

        if (curr.value.toString().startsWith("{")) {
            curr_bin = 0b1;
        }

        // here if [22]%[22].
        if (next == null) {
            System.out.printf("here null");
            return this.value;
        }

        if (next.value.toString().startsWith("[")) {
            next_bin = 0b0;
        }

        if (next.value.toString().startsWith("{")) {
            next_bin = 0b1;
        }

        // [22]%{hi}%[22].
        // [22]%[22]%[22].
        // [22]%{hi}%[22]%{hi}%[22]%{hi}%[22]%{hi}%{hi}%{hi}.
        // 0 == gleich -> semantisch falsch
        // 1 == ungleich -> semantisch richtig
        int check_sum = (curr_bin + next_bin) % 2;

        while(next != null) {
            if(check_sum == 0) {
                System.out.printf("Statisch semantischer Fehler: %s darf nicht vom selben Typ sein wie %s !\n", curr.value , next.value);
                exit(1);
            } else {
                curr = next;
                next = (Sentence) next.right;
            }
        }
        return this.value;
    }



    @Override
    public String toString() {
        getStartSentence();
        return this.value + this.right;
    }
}

