package Aufgabe2;


// Sentence.java
public final class Sentence extends OUR {
    public final OUR left;
    public final String sep;
    public final OUR right;

    public Sentence(OUR left, String sep, OUR right) {
        this.left = left;
        this.sep = sep;
        this.right = right;
    }

    public String getSentence() {
        return this.sep;
    }

    @Override
    public String toString() {
        return "(" + this.left + this.sep + this.right + ")";
    }
}

