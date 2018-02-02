package org.DonNU.mathCalc.unarOperations;
/* @author - Oleksandr Ostapchuk
 *           email: oscomtom@gmail.com
 *           skype: alexander.ostapchuk
 */

import org.DonNU.mathCalc.Function;
import org.DonNU.mathCalc.XMLsaver;

import java.text.DecimalFormat;
import java.util.UUID;

public class Sin extends UnarOperation {
    private String className = this.getClass().getSimpleName();
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
//        cos.execute();
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
        return this.className + "(" + this.getArg().toString() + ")";
    }

    public String getDerivativeToString() {
        return "Derivative of " + this.className + "(" + this.getArg().toString() + ") = " + this.getDerivative().toString();
    }

    public void resultToXML() {
        String random = UUID.randomUUID().toString();
        XMLsaver.resultToXML(className + "_" + random, this.toString());
    }
}
