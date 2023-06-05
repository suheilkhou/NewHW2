public class Power  extends Function{
    private final Function function;
    private final int pow;

    public Power(Function function, int pow) {
        this.function = function;
        this.pow = pow;
    }

    @Override
    public double valueAt(double point){
        return Math.pow(function.valueAt(point), pow);
    }

    @Override
    public String toString(){
        return "(" + function.toString()+"^"+ pow +")";
    }

    @Override
    public Function derivative(){
        Function innerDerivative = function.derivative();
        Function outerDerivative = new Power(this.function, pow - 1);
        return new MultiProduct(new Constant(pow),outerDerivative,innerDerivative);
//        return new Product(new Product(new Constant(pow),outerDerivative),insideDerivative);
    }
}
