package expression.generic;

public class OperationDouble implements OperationsGenerics<Double> {

    @Override
    public Double unaryMinus(Double first) {
        return first * -1;
    }

    @Override
    public Double multiplication(Double first, Double second) {
        return first * second;
    }

    @Override
    public Double division(Double first, Double second) {
        return first / second;
    }

    @Override
    public Double addition(Double first, Double second) {
        return first + second;
    }

    @Override
    public Double subtraction(Double first, Double second) {
        return first - second;
    }

    @Override
    public Double cast(int first) {
        return (double) first;
    }

    @Override
    public Double cast(String first) {
        return Double.parseDouble(first);
    }
}
