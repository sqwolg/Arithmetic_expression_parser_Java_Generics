package expression.generic;

public class Add<T> extends Operation<T> {

    public Add(TripleExpressionG<T> left, TripleExpressionG<T> right, OperationsGenerics<T> operation) {
        super(left, right, operation);
    }

    @Override
    public T func(T left, T right) {
        return operation.addition(left, right);
    }
}
