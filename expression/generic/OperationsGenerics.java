package expression.generic;

public interface OperationsGenerics<T> {
    T unaryMinus(T first);
    T multiplication(T first, T second);
    T division(T first, T second);
    T addition(T first, T second);
    T subtraction(T first, T second);
    T cast (int first);
    T cast (String first);

}
