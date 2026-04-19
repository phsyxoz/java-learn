package inc.lopsys.idk.homework3.task1;

public sealed interface Expr {
    double evaluate();

    record Constant(double value) implements Expr {
        @Override
        public double evaluate() {
            return value;
        }
    }

    record Negate(Expr negate) implements Expr {
        @Override
        public double evaluate() {
            return -negate.evaluate();
        }
    }

    record Exponent(Expr value, Expr exponent) implements Expr {
        @Override
        public double evaluate() {
            return Math.pow(value.evaluate(), exponent.evaluate());
        }
    }

    record Addition(Expr first, Expr second) implements Expr {
        @Override
        public double evaluate() {
            return first.evaluate() + second.evaluate();
        }
    }

    record Multiplication(Expr first, Expr second) implements Expr {
        @Override
        public double evaluate() {
            return first.evaluate() * second.evaluate();
        }
    }
}
