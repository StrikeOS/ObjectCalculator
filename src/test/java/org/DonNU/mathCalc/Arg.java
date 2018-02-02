package org.DonNU.mathCalc;

/* @author - Oleksandr Ostapchuk
 *           email: oscomtom@gmail.com
 *           skype: alexander.ostapchuk
 */
public class Arg extends Function {
    private Function arg;

    public Arg(Function value) {
        this.arg = value;
    }

    @Override
    public String toString() {
        return "x";
    }

    @Override
    public double getValue() {
        return this.arg.getValue();
    }

}
