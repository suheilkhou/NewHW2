public class MultiSum extends Function{
    private final Function[] functions;

    public MultiSum(Function ... functions){
        this.functions = functions;
    }

    @Override
    public double valueAt(double point){
        double result = 0;
        for (Function function : this.functions) {
            result += function.valueAt(point);
        }

        return result;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        for (int i = 0; i < this.functions.length; i++){
            str.append(this.functions[i].toString());
            if (i == this.functions.length - 1){
                continue;
            }
            str.append(" + ");
        }
        return "("+str.toString()+")";
    }

    @Override
    public Function derivative(){
        Function[] derivativeFunctions = new Function[this.functions.length];
        for (int i = 0; i < this.functions.length; i++){
            derivativeFunctions[i] = this.functions[i].derivative();
        }
        return new MultiSum(derivativeFunctions);
    }
}
