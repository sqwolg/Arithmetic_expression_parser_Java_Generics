package expression;

import java.util.Objects;

public abstract class Operation implements Expressions {
    final public Expression left;
    final public Expression right;
    final public String sign;

    public Operation(Expression left, Expression right, String sign) {
        this.left = left;
        this.right = right;
        this.sign = sign;
    }

    @Override
    public String toString() {
        return "(" + left.toString() + " " + sign + " " + right.toString() + ")";
    }

    public Expression getLeft() {
        return left;
    }

    public Expression getRight() {
        return right;
    }

    public String getSign() {
        return sign;
    }

   @Override
    public boolean equals(Object obj) {
        if(obj != null && (this.getClass() == obj.getClass())) {
            Operation second= (Operation) obj;
            if(second.getLeft().equals(this.getLeft()) && second.getRight().equals(this.getRight()) && second.getSign().equals(this.getSign())){
                return true;
            }
        }
        return false;
    }

    @Override
    public double evaluate(double x) {
        return 0;
    }

    @Override
    public int hashCode(){
        return Objects.hash(left, right, sign);
    }
}