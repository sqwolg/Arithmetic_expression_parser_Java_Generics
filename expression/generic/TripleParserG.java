package expression.generic;

public interface TripleParserG<T> {
    TripleExpressionG<T> parse(String expression);
}
