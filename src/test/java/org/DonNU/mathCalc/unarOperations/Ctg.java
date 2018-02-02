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

public class Ctg extends UnarOperation {
    private String className = this.getClass().getSimpleName();
    private double value;

    public Ctg() {}

    @Override
    public double getValue() {
        return this.value;
    }

    @Override
    public Function getDerivative() {
        // (ctg(x))' = - 1/sin^2(x)
        Div division = new Div();
        division.setlNode(new Const(-1));
        Sin sin = new Sin();
        sin.setArg(this.getArg());
//        sin.execute();
        Multi multiplication = new Multi();
        multiplication.setlNode(sin);
        multiplication.setrNode(sin);
//        multiplication.execute();
        division.setrNode(multiplication);
//        division.execute();
        return division;
    }

    @Override
    public void execute() {
        // ctg(x) = 1/tg(x)
        DecimalFormat df = new DecimalFormat("#.##");
        double radians = Math.toRadians(this.getArg().getValue());
        this.value = Double.valueOf(df.format((1 / Math.tan(radians))));
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
