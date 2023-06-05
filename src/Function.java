public abstract class Function {
    public abstract double valueAt(double x);
    @Override
    public abstract String toString();
    public abstract Function derivative();
    public double bisectionMethod(double a, double b, double epsilon){
        double left = a;
        double right = b;
        while(right - left > epsilon){
            double mid = (left+right) / 2;
            if (valueAt(mid*left) > 0){
                left = mid;
            }else {
                right = mid;
            }
        }
        return (right + left)/2;
    }
    public double bisectionMethod(double a, double b) {return bisectionMethod(a, b, Math.pow(10,-5));}
    public double newtonRaphsonMethod(double a, double epsilon){
        double value = a;
        while(Math.abs(value - valueAt(value) / derivative().valueAt(value)) < epsilon){
            value = value - valueAt(value) / derivative().valueAt(value);
        }
        return value;
    }
    public double newtonRaphsonMethod(double a) {return newtonRaphsonMethod(a, Math.pow(10,-5));}

    public Polynomial taylorPolynomial1(int n){
        double[] factorial = new double[n+1];
        double[] functions = new double[n+1];
        Function derivative = this.derivative();
        for (int i = 0; i <= n; i++){
            factorial[i] = 1/(factorial(i));
            functions[i] = derivative.valueAt(0);
            derivative = derivative.derivative();
        }
        double[] coefficient = new double[n+1];
        for (int i = 0; i <= n; i++){
            coefficient[i] = factorial[i] * functions[i];
        }
        return new Polynomial(coefficient);
    }

    public Polynomial taylorPolynomial(int n){
        double[] factorial = new double[n+1];
        double[] values = new double[n+1];
        Function[] derivative = new Function[n+1];
        for (int i = 0; i < n+1 ; i++){
            factorial[i] = 1 / factorial(i);
            if (i == 0){
                values[i] = this.valueAt(0);
                derivative[i] = this;
                continue;
            }
            derivative[i] = derivative[i-1].derivative();
            values[i] = derivative[i].valueAt(0);
        }
        double[] coefficients = new double[n+1];
        for (int i = 0; i < n+1; i++){
            coefficients[i] = factorial[i]*values[i];
        }
        return new Polynomial(coefficients);

    }

    public double factorial(int a){
        if (a == 0 || a == 1){
            return 1;
        }
        return a*factorial(a-1);
    }}
