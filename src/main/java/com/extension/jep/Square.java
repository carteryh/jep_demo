package main.java.com.extension.jep;

import com.singularsys.jep.functions.UnaryFunction;

public class Square extends UnaryFunction {
    public Object eval(Object l) {
        double x = ((Number) l).doubleValue();
        return x*x; // result is auto-boxed to return a Double.
    }
}