# Arithmetic expression parser on Java


This Clojure script is an arithmetic expression parser that can evaluate mathematical expressions and supports variables.

------------
### Features
1. **Define and evaluate expressions:** Expressions can be defined using the `Const`, `Variable`, `Add`, `Subtract`, `Multiply`, and `Divide` classes. The evaluate method can be used to `evaluate` an expression with a specific variable value.

2. **String representations:** The `toString` method returns a full-bracket notation of the expression.

3. **Equality checking:** The `equals` method can be used to check if two expressions are identical.

4. **Expression parsing:** Expressions can be built from string notations with binary operations, unary minus, variables, integer constants, and parentheses.

5. **Different computation modes:** Expressions can be computed in `int`, `double`, `BigInteger`, `float` and `short` modes.

------------
### Usage

THere is a brief guide on how to use these features:

```java
Expression expr = new Subtract(
    new Multiply(
        new Const(2),
        new Variable("x")
    ),
    new Const(3)
);

int value = expr.evaluate(5);  // Returns: 7
String str = expr.toString();  // Returns: ((2 * x) - 3)
boolean isEqual = expr.equals(new Multiply(new Const(2), new Variable("x")));  // Returns: false
```
You can also parse an expression from a string:

```java
ExpressionParser parser = new ExpressionParser();
Expression expr = parser.parse("x * (x - 2)*x + 1");
```
The `GenericTabulator` class can be used to compute a table of values:
    
```java
GenericTabulator tabulator = new GenericTabulator();
Object[][][] values = tabulator.tabulate("i", "x * (x - 2)*x + 1", -2, 2, -2, 2, -2, 2);
```
------------

### Command Line Interface
The command line interface of this program accepts two arguments: the computation mode (`-i` for `int`, `-d` for `double`, `-bi` for `BigInteger`, `-f` for `float`, `-s` for `short`) and the expression to be computed. The program computes the values of the expression for all integer variable values from -2 to 2.

```bash
java -jar ArithmeticExpressionEvaluator.jar -i "x * (x - 2)*x + 1"
```
------------
### Notes

- The parser uses the recursive descent method, and the algorithm works in linear time.
- The project emphasizes the ease of adding new types and operations.
- The implementation contains no unchecked type conversions and does not use the @SuppressWarnings annotation.

