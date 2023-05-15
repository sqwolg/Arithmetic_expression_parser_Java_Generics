package expression.generic;

public class Variable<T> implements TripleExpressionG<T> {
    final public String value;
    final public OperationsGenerics<T> operationsGenerics;

    public Variable(String value, OperationsGenerics<T> operationsGenerics) {
        this.value = value;
        this.operationsGenerics = operationsGenerics;
    }

    public String getValue() {
        return value;
    }

    public T evaluate(int name1, int name2, int name3) {
        return switch (this.value) {
            case "x" -> operationsGenerics.cast(name1);
            case "y" -> operationsGenerics.cast(name2);
            case "z" -> operationsGenerics.cast(name3);
            case "-x" -> operationsGenerics.cast(-name1);
            case "-y" -> operationsGenerics.cast(-name2);
            case "-z" -> operationsGenerics.cast(-name3);
            default -> operationsGenerics.cast(0);
        };
    }

}
