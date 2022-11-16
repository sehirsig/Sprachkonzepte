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

    public String getStartSentence()  {
        return this.value;
    }

    @Override
    public String toString() {
        return this.value + this.right;
    }
}

