package expression.generic;

import java.util.ArrayList;
import java.util.HashMap;

public class ExpressionParser<T> implements TripleParserG<T> {
    final OperationsGenerics<T> OP;
    static HashMap<Character, Opers> allOperations = new HashMap<>();
    static {
        allOperations.put('*', Opers.multiplyOperation);
        allOperations.put('+', Opers.addOperation);
        allOperations.put('/', Opers.divisionOperation);
        allOperations.put('(', Opers.leftBracket);
        allOperations.put(')', Opers.rightBracket);
        allOperations.put('x', Opers.variable);
        allOperations.put('y', Opers.variable);
        allOperations.put('z', Opers.variable);
    }

    public ExpressionParser(OperationsGenerics<T> op) {
        this.OP = op;
    }

    public ArrayList<elementOperation> divToPath(String string) {
        ArrayList<elementOperation> allParts = new ArrayList<>();
        char element;

        for (int i = 0; i < string.length(); i++) {
            element = string.charAt(i);

            if (allOperations.containsKey(element)) {
                allParts.add(new elementOperation(allOperations.get(element), element));
            } else if (element == '-') {
                if (!allParts.isEmpty()
                        && (allParts.get(allParts.size() - 1).getMeaning() != Opers.divisionOperation
                        && allParts.get(allParts.size() - 1).getMeaning() != Opers.addOperation
                        && allParts.get(allParts.size() - 1).getMeaning() != Opers.multiplyOperation
                        && allParts.get(allParts.size() - 1).getMeaning() != Opers.subtractionOperation
                        && allParts.get(allParts.size() - 1).getMeaning() != Opers.leftBracket
                        && allParts.get(allParts.size() - 1).getMeaning() != Opers.unaryMinus)) {
                    allParts.add(new elementOperation(Opers.subtractionOperation, '-'));
                } else {
                    allParts.add(new elementOperation(Opers.unaryMinus, '-'));
                }
            } else if (element >= '0' && element <= '9') {
                StringBuilder stringBuilder = new StringBuilder();
                while ((element >= '0' && element <= '9') || (element == '.')) {
                    i++;
                    stringBuilder.append(element);
                    if (i >= string.length()) {
                        break;
                    }
                    element = string.charAt(i);
                }
                allParts.add(new elementOperation(Opers.number, stringBuilder.toString()));
                i--;
            }
        }
        allParts.add(new elementOperation(Opers.lastSymbol, ""));
        return allParts;
    }

    public TripleExpressionG<T> unaryAndBracket(ourBuffer buffer) {
        elementOperation element = buffer.next();
        switch (element.getMeaning()) {
            case unaryMinus:
                element = buffer.next();
                switch (element.getMeaning()){
                    case number: return new Const<>(OP.cast(Integer.parseInt("-".concat(element.getValue()))));
                    case variable: return new Variable<>("-" + element.getValue(), OP);
                    case leftBracket:
                        TripleExpressionG<T> exp = addAndSubtract(buffer);
                        buffer.next();
                        return new Unary<>(exp, OP);
                    case unaryMinus:
                        buffer.previous();
                        return new Unary<>(unaryAndBracket(buffer), OP);
                }
            case number:
                return new Const<>(OP.cast(Integer.parseInt(element.getValue())));
            case variable:
                return new Variable<>(element.getValue(), OP);
            case leftBracket:
                TripleExpressionG<T> exp = addAndSubtract(buffer);
                buffer.next();
                return exp;

        }
        return null;
    }

    public TripleExpressionG<T> multiplyAndDivide(ourBuffer buffer) {
        TripleExpressionG<T> left = unaryAndBracket(buffer);
        for (;;) {
            elementOperation element = buffer.next();
            switch (element.getMeaning()) {
                case multiplyOperation -> left = new Multiply<>(left, unaryAndBracket(buffer), OP);
                case divisionOperation -> left = new Divide<>(left, unaryAndBracket(buffer), OP);
                default -> {
                    buffer.previous();
                    return left;
                }
            }
        }
    }

    public TripleExpressionG<T> addAndSubtract(ourBuffer buffer) {
        TripleExpressionG<T> left = multiplyAndDivide(buffer);
        for (;;) {
            elementOperation element = buffer.next();
            switch (element.getMeaning()) {
                case addOperation -> left = new Add<>(left, multiplyAndDivide(buffer), OP);
                case subtractionOperation -> left = new Subtract<>(left, multiplyAndDivide(buffer), OP);
                default -> {
                    buffer.previous();
                    return left;
                }
            }
        }
    }

    public TripleExpressionG<T> zeroPriority(ourBuffer buffer) {
        elementOperation left = buffer.next();
        if (left.getMeaning() == Opers.lastSymbol) {
            return new Const<>(OP.cast(0));
        } else {
            buffer.previous();
            return addAndSubtract(buffer);
        }
    }

    @Override
    public TripleExpressionG<T> parse(String expression) {
        ArrayList<elementOperation> buffer = divToPath(expression);
        ourBuffer outBuffer = new ourBuffer(buffer);
        return zeroPriority(outBuffer);
    }

    /*public static void main(String[] args) {
        String txt = "Write your expression here, if you want to check method <parse>";
        ArrayList<expression.generic.elementOperation> buffer = divToPath(txt);
        expression.generic.ourBuffer outBuffer = new expression.generic.ourBuffer(buffer);
        System.out.println(zeroPriority(outBuffer).evaluate(3, 2, 3));
    }*/

}
