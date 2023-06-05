public class Polynomial extends Function{
    private final double[] coefficients;

    public Polynomial(double ... coefficients){
        this.coefficients = coefficients;
    }

    @Override
    public String toString(){
        boolean[] positive = new boolean[coefficients.length];
        for (int i = 0; i < coefficients.length; i++){
            positive[i] = coefficients[i] >= 0;
        }
        String str = "";
        for (int i = 0; i < coefficients.length; i++){
            if (coefficients[i] == 0 && coefficients.length == 1){
                return "(0)";
            }
            if (coefficients[i] == 0){
                continue;
            }
            if (i == 0){
                if (coefficients[i] % 1 == 0){
                    str += (int)coefficients[i];
                    continue;
                }
                str += coefficients[i];
                continue;
            }
            if (i == 1){
                if (str == ""){
                    if (coefficients[i] == 1){
                        str += "x";
                        continue;
                    }
                    if (coefficients[i] % 1 == 0){
                        str += (int)coefficients[i]+"x";
                        continue;
                    }
                    str += coefficients[i]+"x";
                    continue;
                }
                //
                if (positive[i]){
                    if (coefficients[i] == 1){
                        str += " + " + "x";
                        continue;
                    }
                    if (coefficients[i] % 1 == 0){
                        str += " + " + (int)coefficients[i]+"x";
                        continue;
                    }
                    str += " + " + coefficients[i]+"x";
                    continue;
                }
                if (coefficients[i] == -1){
                    str += " - " + "x";
                    continue;
                }
                if (coefficients[i] % 1 == 0){
                    str += " - " + Math.abs((int)coefficients[i])+"x";
                    continue;
                }
                str += " - " + Math.abs(coefficients[i])+"x";
            }
            if (str == ""){
                if (coefficients[i] == 1){
                    str += "x^"+i;
                    continue;
                }
                if (coefficients[i] % 1 == 0){
                    str += (int)coefficients[i]+"x^"+i;
                    continue;
                }
                str += coefficients[i]+"x^"+i;
                continue;
            }
            if (positive[i]){
                if (coefficients[i] == 1){
                    str += " + " + "x^"+i;
                    continue;
                }
                if (coefficients[i] % 1 == 0){
                    str += " + " + (int)coefficients[i]+"x^"+i;
                    continue;
                }
                str += " + " + coefficients[i]+"x^"+i;
                continue;
            }
            if (coefficients[i] == -1){
                str += " - " + "x^"+i;
                continue;
            }
            if (coefficients[i] % 1 == 0){
                str += " - " + Math.abs((int)coefficients[i])+"x^"+i;
                continue;
            }
            str += " - " + Math.abs(coefficients[i])+"x^"+i;
        }
        if (str.length() == 0){
            str += "0";
        }
        str = "("+str+")";
        return str;
    }

    @Override
    public double valueAt(double point){
        double result = 0;
        for (int i = 0; i < coefficients.length; i++){
            result += Math.pow(point,i) * this.coefficients[i];
        }
        return result;
    }

    @Override
    public Function derivative(){
        if (this.coefficients.length <= 1){
            return new Constant(0);
        }
        double[] function = new double[coefficients.length - 1];
        for (int i = 1; i < coefficients.length; i++){
            function[i - 1] = coefficients[i] * i;
        }
        return new Polynomial(function);
    }
}
