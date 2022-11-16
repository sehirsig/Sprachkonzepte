package Aufgabe2;


// Sentence.java
public final class Sentence extends OUR {
    public final String separator;
    public final OUR value;
    public final OUR right;
    public final String rightString;

    // multisentence next
    public Sentence(String separator, OUR value, OUR right) {
        this.separator = separator;
        this.value = value;
        this.right = right;
        this.rightString = "";
    }

    // last multisentemnce eol
    public Sentence(String separator, OUR value, String rightString) {
        this.separator = separator;
        this.value = value;
        this.rightString = rightString;
        this.right = null;
    }

    public String getSentence() {
        System.out.printf("here sentence");
        return this.value.toString();
    }

    @Override
    public String toString() {
        if (right == null) {
            return this.separator + this.value + this.rightString;
        } else {
            return this.separator + this.value + this.right;
        }
    }
}

