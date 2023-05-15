package expression.generic;

public class Unary<T> implements TripleExpressionG<T> {

    final public TripleExpressionG<T> value;
    OperationsGenerics<T> operationsGenerics;
    public Unary(TripleExpressionG<T> value, OperationsGenerics<T> operationsGenerics) {
        this.value = value;
        this.operationsGenerics = operationsGenerics;
    }

    public T evaluate(int name1, int name2, int name3) {
        return switch (this.value.toString()) {
            case "x" -> operationsGenerics.cast(-name1);
            case "y" -> operationsGenerics.cast(-name2);
            case "z" -> operationsGenerics.cast(-name3);
            default -> operationsGenerics.unaryMinus(value.evaluate(name1, name2, name3));
        };
    }
}
