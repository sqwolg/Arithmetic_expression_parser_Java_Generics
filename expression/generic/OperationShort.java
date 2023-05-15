package expression.generic;

public class OperationShort implements OperationsGenerics<Short>{

    @Override
    public Short unaryMinus(Short first) {
        return (short) -first;
    }

    @Override
    public Short multiplication(Short first, Short second) {
        return (short) (first * second);
    }

    @Override
    public Short division(Short first, Short second) {
        return (short) (first / second);
    }

    @Override
    public Short addition(Short first, Short second) {
        return (short) (first + second);
    }

    @Override
    public Short subtraction(Short first, Short second) {
        return (short) (first - second);
    }

    @Override
    public Short cast(int first) {
        return (short) first;
    }

    @Override
    public Short cast(String first) {
        return Short.parseShort(first);
    }
}
