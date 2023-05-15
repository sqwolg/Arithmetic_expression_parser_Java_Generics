package expression.generic;

public class Multiply<T> extends Operation<T> {
    public Multiply(TripleExpressionG<T> left, TripleExpressionG<T> right, OperationsGenerics<T> operation){
        super(left, right, operation);
    }

    @Override
    public T func(T left, T right) {
        return operation.multiplication(left, right);
    }
}
