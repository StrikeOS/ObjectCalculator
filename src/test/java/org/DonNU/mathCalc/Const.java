package org.DonNU.mathCalc;

/* @author - Oleksandr Ostapchuk
 *           email: oscomtom@gmail.com
 *           skype: alexander.ostapchuk
 */
public class Const extends Function {
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
        return "Const = " + this.value;
    }
}
