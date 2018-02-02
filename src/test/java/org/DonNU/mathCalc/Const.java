package org.DonNU.mathCalc;

import java.util.UUID;

/* @author - Oleksandr Ostapchuk
 *           email: oscomtom@gmail.com
 *           skype: alexander.ostapchuk
 */
public class Const extends Function {
    private String className = this.getClass().getSimpleName();
    private double value;

    @Override
    public double getValue() {
        return this.value;
    }

    public Const(double value) {
        this.value = value;
    }

    @Override
    public Function getDerivative() {
        return new Const(0);
    }

    @Override
    public String toString() {
        return this.className + " = " + this.value;
    }

    public void resultToXML() {
        String random = UUID.randomUUID().toString();
        XMLsaver.resultToXML(className + "_" + random, this.toString());
    }
}
