package expression.generic;

import expression.generic.OperationsGenerics;

public abstract class Operation<T> implements TripleExpressionG<T> {
    final public TripleExpressionG<T> left;
    final public TripleExpressionG<T> right;
    protected final OperationsGenerics<T> operation;

    public Operation(TripleExpressionG<T> left, TripleExpressionG<T> right, OperationsGenerics<T> operation) {
        this.left = left;
        this.right = right;
        this.operation = operation;
    }

    public TripleExpressionG<T> getLeft() {
        return left;
    }

    public TripleExpressionG<T> getRight() {
        return right;
    }

    @Override
    public T evaluate(int value1, int value2, int value3) {
        return func(left.evaluate(value1, value2, value3), right.evaluate(value1, value2, value3));
    }
    public abstract T func(T left, T right);

}