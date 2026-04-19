package inc.lopsys.idk.homework3.task1;

//Калькулятор выражений. Напишите иерархию классов для вычисления
//математических выражений.
//Разбор строковых представлений выражений не требуется, достаточно чтобы работал код.
public class Main {
    public static void main(String[] args) {
        var two = new Expr.Constant(2);
        var four = new Expr.Constant(4);
        var negOne = new Expr.Negate(new Expr.Constant(1));
        var sumTwoFour = new Expr.Addition(two, four);
        var mult = new Expr.Multiplication(sumTwoFour, negOne);
        var exp = new Expr.Exponent(mult, new Expr.Constant(2));
        var res = new Expr.Addition(exp, new Expr.Constant(1));

        System.out.println(res + " = " + res.evaluate());
    }
}
