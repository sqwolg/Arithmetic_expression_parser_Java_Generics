package expression.generic;

public class Const<T> implements TripleExpressionG<T> {
    final public T value;

    public Const(T value) {
        this.value = value;
    }

    public T evaluate(int value1, int value2, int value3) {
        return this.value;
    }

}
