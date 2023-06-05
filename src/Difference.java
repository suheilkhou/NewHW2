public class Difference extends Function {
    private final Function function1;
    private final Function function2;
    public Difference(Function function1, Function function2) {
        this.function1 = function1;
        this.function2 = function2;
    }
    @Override
    public double valueAt(double point){
        return function1.valueAt(point) - function2.valueAt(point);
    }
    @Override
    public String toString(){
        return "("+function1.toString() + " - " + function2.toString() + ")";
    }
    @Override
    public Function derivative(){
        Function derivative1 = function1.derivative();
        Function derivative2 = function2.derivative();
        return new Difference(derivative1,derivative2);
    }
}
