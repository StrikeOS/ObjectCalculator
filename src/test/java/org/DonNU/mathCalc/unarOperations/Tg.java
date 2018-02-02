package org.DonNU.mathCalc.unarOperations;
/* @author - Oleksandr Ostapchuk
 *           email: oscomtom@gmail.com
 *           skype: alexander.ostapchuk
 */

import org.DonNU.mathCalc.Const;
import org.DonNU.mathCalc.Function;
import org.DonNU.mathCalc.XMLsaver;
import org.DonNU.mathCalc.binarOperations.Div;
import org.DonNU.mathCalc.binarOperations.Multi;

import java.text.DecimalFormat;
import java.util.UUID;

public class Tg extends UnarOperation {
    private String className = this.getClass().getSimpleName();
    private double value;

    public Tg() {}

    @Override
    public double getValue() {
        return this.value;
    }

    @Override
    public Function getDerivative() {
        //(tg(x))' = 1/cos^2(x)
        Div division = new Div();
        division.setlNode(new Const(1));
        Cos cos = new Cos();
        cos.setArg(this.getArg());
        cos.execute();
        Multi multiplication = new Multi();
        multiplication.setlNode(cos);
        multiplication.setrNode(cos);
        multiplication.execute();
        division.setrNode(multiplication);
        division.execute();
        return division;
    }

    @Override
    public void execute() {
        DecimalFormat df = new DecimalFormat("#.##");
        double radians = Math.toRadians(this.getArg().getValue());
        this.value = Double.valueOf(df.format(Math.tan(radians)));
    }

    @Override
    public String toString() {
        return this.className + "(" + this.getArg().getValue() + ") = " + this.value;
    }

    public String getDerivativeToString() {
        return "Derivative of " + this.className + "(" + this.getArg().getValue() + ") = " + this.getDerivative().toString();
    }

    public void resultToXML() {
        String random = UUID.randomUUID().toString();
        XMLsaver.resultToXML(className + "_" + random, this.toString());
    }
}
