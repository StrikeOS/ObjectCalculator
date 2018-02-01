package org.DonNU.mathCalc.unarOperations;
/* @author - Oleksandr Ostapchuk
 *           email: oscomtom@gmail.com
 *           skype: alexander.ostapchuk
 */
import org.DonNU.mathCalc.Function;

import java.text.DecimalFormat;

public class Sin extends UnarOperation {

    private double value;
    private Function derivative = new Cos();//correct

    public Sin() {
    }

    @Override
    public double getValue() {
        return this.value;
    }

    @Override
    public Function getDerivative() {
        return this.derivative;
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
}
