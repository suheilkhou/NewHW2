public class Power  extends Function{
    private final Function function;
    private final int pow;

    public Power(Function function, int pow) {
        this.function = function;
        this.pow = pow;
    }

    @Override
    public double valueAt(double point){
        if (this.pow == 0){
            return 1;
        }
        return Math.pow(function.valueAt(point), this.pow);
    }

    @Override
    public String toString(){
        return "(" + function.toString()+"^"+ pow +")";
    }

    @Override
    public Function derivative(){
        Function outerDerivative;
        Function innerDerivative = function.derivative();
        if (pow != 0){
            outerDerivative = new Power(this.function, pow - 1);
        }else {
            outerDerivative = new Constant(0);
        }
        return new MultiProduct(new Constant(pow),outerDerivative,innerDerivative);
//        return new Product(new Product(new Constant(pow),outerDerivative),insideDerivative);
    }
}
