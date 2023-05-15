package expression;

import java.util.Objects;

public class Variable implements Expressions{
    final public String value;

    public Variable(String value) {
        this.value = value;
    }

    @Override
    public String toString(){
        return this.value;
    }
    @Override
    public int evaluate(int value){
        return value;
    }

    public String getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj.getClass() == this.getClass()) {
            return ((Variable) obj).getValue().equals(this.getValue());
        }
        return false;
    }

    public int evaluate(int name1, int name2, int name3) {
        return switch (this.value) {
            case "x" -> name1;
            case "y" -> name2;
            case "z" -> name3;
            case "-x" -> -name1;
            case "-y" -> -name2;
            case "-z" -> -name3;
            default -> 0;
        };
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
