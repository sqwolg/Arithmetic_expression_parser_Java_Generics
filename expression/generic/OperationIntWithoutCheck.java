package expression.generic;

public class OperationIntWithoutCheck implements OperationsGenerics<Integer>{
    @Override
    public Integer unaryMinus(Integer first) {
        return -first;
    }

    @Override
    public Integer multiplication(Integer first, Integer second) {
        return first * second;
    }

    @Override
    public Integer division(Integer first, Integer second) {
        return first / second;
    }

    @Override
    public Integer addition(Integer first, Integer second) {
        return first + second;
    }

    @Override
    public Integer subtraction(Integer first, Integer second) {
        return first - second;
    }

    @Override
    public Integer cast(int first) {
        return first;
    }

    @Override
    public Integer cast(String first) {
        return Integer.parseInt(first);
    }
}
