package expression.generic;

public class Subtract<T> extends Operation<T> {
    public Subtract(TripleExpressionG<T> left, TripleExpressionG<T> right, OperationsGenerics<T> operation){
        super(left, right, operation);
    }

    @Override
    public T func(T left, T right) {
        return operation.subtraction(left, right);
    }
}
