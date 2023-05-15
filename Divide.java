package expression;

public class Divide extends Operation{
    final private Expressions left;
    final private Expressions right;
    public Divide(Expressions left, Expressions right){
        super(left, right, "/");
        this.left = left;
        this.right = right;
    }
    @Override
    public int evaluate(int value){
        return left.evaluate(value) / right.evaluate(value);
    }

    @Override
    public int evaluate(int value1, int value2, int value3){
        return left.evaluate(value1, value2, value3) / right.evaluate(value1, value2, value3);
    }



}
