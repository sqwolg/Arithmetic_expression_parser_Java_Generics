package expression;

import java.util.Objects;

public class Unary implements Expressions{

    final public Expressions value;

    public Unary(Expressions value) {
        this.value = value;
    }

    @Override
    public String toString(){
        return "-(" + value.toString()  + ")";
    }
    @Override
    public int evaluate(int value){
        return value;
    }

    public Expressions getValue() {
        return value;
    }

    @Override
    public boolean equals(Object obj) {
        if(obj != null && obj.getClass() == this.getClass()) {
            return ((Unary) obj).getValue().equals(this.getValue());
        }
        return false;
    }

    public int evaluate(int name1, int name2, int name3) {
        if(this.value.equals("x")){
            return -name1;
        } else if(this.value.equals("y")){
            return -name2;
        } else if (this.value.equals("z")) {
            return -name3;
        } else {
            return -value.evaluate(name1, name2, name3);
        }
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
