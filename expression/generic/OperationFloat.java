package expression.generic;

public class OperationFloat implements OperationsGenerics<Float>{
    @Override
    public Float unaryMinus(Float first) {
        return -first;
    }

    @Override
    public Float multiplication(Float first, Float second) {
        return first * second;
    }

    @Override
    public Float division(Float first, Float second) {
        return first / second;
    }

    @Override
    public Float addition(Float first, Float second) {
        return first + second;
    }

    @Override
    public Float subtraction(Float first, Float second) {
        return first - second;
    }

    @Override
    public Float cast(int first) {
        return (float) first;
    }

    @Override
    public Float cast(String first) {
        return Float.parseFloat(first);
    }
}
