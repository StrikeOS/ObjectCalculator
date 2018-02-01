package org.DonNU.mathCalc.unarOperations;
/* @author - Oleksandr Ostapchuk
 *           email: oscomtom@gmail.com
 *           skype: alexander.ostapchuk
 */

import org.DonNU.mathCalc.Function;

import java.text.DecimalFormat;

public class Sin extends UnarOperation {

    private double value;

    public Sin() {
    }

    @Override
    public double getValue() {
        return this.value;
    }

    @Override
    public Function getDerivative() {
        //(sin(x))' = cos(x)
        Cos cos = new Cos();
        cos.setArg(this.getArg());
        cos.execute();
        return cos;
    }

    @Override
    public void execute() {
        DecimalFormat df = new DecimalFormat("#.##");
        double radians = Math.toRadians(this.getArg().getValue());
        this.value = Double.valueOf(df.format(Math.sin(radians)));
    }

    @Override
    public String toString() {
        return "Sin(" + this.getArg().getValue() + ") = " + this.value;
    }

    public String getDerivativeToString() {
        return "Derivative of Sin(" + this.getArg().getValue() + ") = " + this.getDerivative().toString();
    }
}
