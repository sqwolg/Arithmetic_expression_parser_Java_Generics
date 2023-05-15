package expression.generic;

import expression.generic.ExpressionParser;

import java.util.Arrays;
import java.util.Map;

public class GenericTabulator<T> implements Tabulator {

    @Override
    public Object[][][] tabulate(final String mode, final String expression, final int x1, final int x2, final int y1, final int y2, final int z1, final int z2) {
        Map<String, OperationsGenerics<?>> map = Map.of(
                "i", new OperationInt(),
                "d", new OperationDouble(),
                "bi", new OperationBigInt(),
                "u", new OperationIntWithoutCheck(),
                "f", new OperationFloat(),
                "s", new OperationShort());

        final ExpressionParser<?> myParser = new ExpressionParser<>(map.get(mode));
        final TripleExpressionG<?> myExpression = myParser.parse(expression);

        final Object[][][] result = new Object[x2 - x1 + 1][y2 - y1 + 1][z2 - z1 + 1];
        for (int i = 0; i <= x2 - x1; i++) {
            for (int j = 0; j <= y2 - y1; j++) {
                for (int k = 0; k <= z2 - z1; k++) {
                    try {
                        result[i][j][k] = myExpression.evaluate(x1 + i, y1 + j, z1 + k);
                    } catch (Exception exp) {
                        result[i][j][k] = null;
                    }
                }
            }
        }
        return result;
    }
}
