package expression.generic;

public class OperationInt implements OperationsGenerics<Integer> {

    @Override
    public Integer unaryMinus(Integer first) {
        if (first == Integer.MIN_VALUE) {
            return  null;
        }
        return -first;
    }

    @Override
    public Integer multiplication(Integer first, Integer second) {
        final int res = first * second;
        if ((first != 0 && res / first != second) || (second != 0 && res / second != first)) {
            return null;
        }
        return first * second;
    }

    @Override
    public Integer division(Integer first, Integer second) {
        if (second == 0 || (first == Integer.MIN_VALUE && second == -1)) {
            return null;
        }
        return first / second;
    }

    @Override
    public Integer addition(Integer first, Integer second) {
        if (( first> 0 && second > 0 && first + second <= 0) || (first < 0 && second < 0 && first + second >= 0)) {
            return null;
        }
        return first + second;
    }

    @Override
    public Integer subtraction(Integer first, Integer second) {
        if ((first >= 0 && second < 0 && first - second <= 0) || (first < 0 && second > 0 && first - second >= 0) ||
                (first < 0 && second > 0 && first - second > 0) || (first > 0 && second < 0 && first - second < 0)) {
            return null;
        }
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
