package org.DonNU.mathCalc.binarOperations;
/* @author - Oleksandr Ostapchuk
 *           email: oscomtom@gmail.com
 *           skype: alexander.ostapchuk
 */
public class Diff extends BinarOperation {

    private double value;

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public void execute() {
        this.value = this.getlNode().getValue() - this.getrNode().getValue();
    }

    @Override
    public String toString() {
        return "Diff( " + this.getlNode().getValue() + " - " + this.getrNode().getValue() + " ) = " + String.valueOf(this.value);
    }
}
