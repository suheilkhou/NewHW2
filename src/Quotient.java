public class Quotient extends Function{
    private final Function function1;
    private final Function function2;

    public Quotient(Function function1, Function function2) {
        this.function1 = function1;
        this.function2 = function2;
    }

    @Override
    public double valueAt(double point){
        return function1.valueAt(point) / function2.valueAt(point);
    }

    public String toString(){
        return "("+function1.toString() + " / " + function2.toString() + ")";
    }

    public Function derivative(){
        Function derivative1 = function1.derivative();
        Function derivative2 = function2.derivative();
        return new Quotient(new Difference(new Product(derivative1,function2),new Product(derivative2,function1)),new Power(function2,2));
    }

}
