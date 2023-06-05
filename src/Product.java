public class Product extends MultiProduct {
    public final Function function1;
    public final Function function2;

    public Product(Function f1, Function f2){
        super(f1,f2);
        this.function1 = f1;
        this.function2 = f2;
    }

    @Override
    public Function derivative(){
        Function derivative1 = function1.derivative();
        Function derivative2 = function2.derivative();
        return new Sum(new Product(derivative1,function2),new Product(derivative2,function1));
    }
}
