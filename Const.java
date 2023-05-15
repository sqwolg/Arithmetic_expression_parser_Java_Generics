package expression;

import java.util.Objects;

public class Const implements Expressions {
    final public int value;

    public Const(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return Integer.toString(this.value);
    }

    @Override
    public int evaluate(int value) {
        return this.value;
    }

    public int getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj.getClass() == this.getClass()) {
            return ((Const) obj).getValue() == this.value;
        }
        return false;
    }

    public int evaluate(int value1, int value2, int value3) {
        return this.value;
    }

    @Override
    public double evaluate(double x) {
        return 0;
    }

    @Override
    public int hashCode(){
        return Objects.hash(value);
    }
}
