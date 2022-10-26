package Aufgabe2;


// Sentence.java
public final class StartSentence extends OUR {
    public final String value;
    public final OUR right;

    public StartSentence(String value, OUR right) {
        this.value = value;
        this.right = right;
    }

    public String getStartSentence() {
        return this.value;
    }

    @Override
    public String toString() {
        return this.value + this.right;
    }
}

