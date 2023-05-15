package expression.generic;

import java.math.BigInteger;

public class OperationBigInt implements OperationsGenerics<BigInteger> {

    @Override
    public BigInteger unaryMinus(BigInteger first) {
        return first.negate();
    }

    @Override
    public BigInteger multiplication(BigInteger first, BigInteger second) {
        return first.multiply(second);
    }

    @Override
    public BigInteger division(BigInteger first, BigInteger second) {
        return first.divide(second);
    }

    @Override
    public BigInteger addition(BigInteger first, BigInteger second) {
        return first.add(second);
    }

    @Override
    public BigInteger subtraction(BigInteger first, BigInteger second) {
        return first.subtract(second);
    }

    @Override
    public BigInteger cast(int first) {
        return BigInteger.valueOf(first);
    }

    @Override
    public BigInteger cast(String first) {
        return new BigInteger(first);
    }
}
