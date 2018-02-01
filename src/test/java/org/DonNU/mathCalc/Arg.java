package org.DonNU.mathCalc;
/* @author - Oleksandr Ostapchuk
 *           email: oscomtom@gmail.com
 *           skype: alexander.ostapchuk
 */
public class Arg extends Function {
    private Function arg;
    private double value;

    public Arg(double value) {
        this.value = value;
    }

    public void setArg(Function arg) {
        this.arg = arg;
    }

    public Function getArg() {
        return this.arg;
    }

}
