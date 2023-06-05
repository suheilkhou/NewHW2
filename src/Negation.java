public class Negation extends Function {
    private final Function function;

    public Negation(Function function){
        this.function = function;
    }

    public double valueAt(double point){
        return -1*function.valueAt(point);
    }

    public String toString(){
        return "(-"+function.toString()+")";
    }

    public Function derivative(){
        Function derivative = function.derivative();
        return new Negation(derivative);
    }


}
