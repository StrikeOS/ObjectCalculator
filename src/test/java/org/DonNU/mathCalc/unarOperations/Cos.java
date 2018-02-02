package org.DonNU.mathCalc.unarOperations;
/* @author - Oleksandr Ostapchuk
 *           email: oscomtom@gmail.com
 *           skype: alexander.ostapchuk
 */

import org.DonNU.mathCalc.Const;
import org.DonNU.mathCalc.Function;
import org.DonNU.mathCalc.XMLsaver;
import org.DonNU.mathCalc.binarOperations.Multi;

import java.text.DecimalFormat;
import java.util.UUID;

public class Cos extends UnarOperation {
    private String className = this.getClass().getSimpleName();
    private double value;

    public Cos() {
    }

    @Override
    public double getValue() {
        return this.value;
    }

    @Override
    public Function getDerivative() {
        //(cos(x))' = -sin(x)
        Multi multiplication = new Multi();
        multiplication.setlNode(new Const(-1));
        Sin sin = new Sin();
        sin.setArg(this.getArg());
        sin.execute();
        multiplication.setrNode(sin);
        multiplication.execute();
        return multiplication;
    }

    @Override
    public void execute() {
        DecimalFormat df = new DecimalFormat("#.##");
        double radians = Math.toRadians(this.getArg().getValue());
        this.value = Double.valueOf(df.format(Math.cos(radians)));
    }

    @Override
    public String toString() {
        return this.className + "(" + this.getArg().toString() + ") = " + this.value;
    }

    public String getDerivativeToString() {
        return "Derivative of " + this.className + "(" + this.getArg().toString() + ") = " + this.getDerivative().toString();
    }

    public void resultToXML() {
        String random = UUID.randomUUID().toString();
        XMLsaver.resultToXML(className + "_" + random, this.toString());
    }
}
