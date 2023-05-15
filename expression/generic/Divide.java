package expression.generic;

public class Divide<T> extends Operation<T> {

    public Divide(TripleExpressionG<T> left, TripleExpressionG<T> right, OperationsGenerics<T> operation){
        super(left, right, operation);
    }

    @Override
    public T func(T left, T right) {
        return operation.division(left, right);
    }
}
