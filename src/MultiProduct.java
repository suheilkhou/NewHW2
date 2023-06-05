public class MultiProduct extends Function{
    private Function[] functions;

    public MultiProduct(Function ... functions){
        this.functions = functions;
    }

    @Override
    public double valueAt(double point){
        double result = 1;
        for (Function function : this.functions) {
            result *= function.valueAt(point);
        }
        return result;
    }

    @Override
    public String toString(){
        StringBuilder str = new StringBuilder("(");
        for (int i = 0; i < this.functions.length; i++){
            str.append(this.functions[i].toString());
            if (i == this.functions.length - 1){
                continue;
            }
            str.append(" * ");
        }
        str.append(")");
        return str.toString();
    }

    @Override
    public Function derivative(){
        Function[] derivativeFunctions = new Function[this.functions.length];
        Function[] multiProduct = new Function[this.functions.length];
        for (int i = 0; i < this.functions.length; i++){
            derivativeFunctions[i] = this.functions[i].derivative();
        }
        for (int i = 0; i < this.functions.length; i++){
            Function[] copiedFunctions = new Function[this.functions.length];
            for (int j = 0; j < this.functions.length; j++) {
                copiedFunctions[j] = this.functions[j];
            }
            MultiProduct newProducts = new MultiProduct(copiedFunctions);


            //MultiProduct newProducts = new MultiProduct(this.functions);
            newProducts.functions[i] = derivativeFunctions[i];
            sortFunction(newProducts.functions, i);
            multiProduct[i] = newProducts;
        }
        return new MultiSum(multiProduct);
    }

    public void sortFunction(Function[] functions, int index){
        for (int i = index; i > 0; i--){
            Function temp = functions[i - 1];
            functions[i - 1] = functions[i];
            functions[i] = temp;
        }

    }


}
