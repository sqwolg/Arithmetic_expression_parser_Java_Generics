package expression.generic;

import expression.generic.Opers;

public class elementOperation {
    final private Opers meaning;
    final private String value;

    public elementOperation(Opers meaning, Character value) {
        this.value = value.toString();
        this.meaning = meaning;
    }

    public elementOperation(Opers meaning, String value) {
        this.value = value;
        this.meaning = meaning;
    }

    public String getValue() {
        return value;
    }

    public Opers getMeaning() {
        return meaning;
    }

    @Override
    public String toString() {
        return "Value = " + getValue() + "  Meaning = " + getMeaning() + '\n';
    }
}
