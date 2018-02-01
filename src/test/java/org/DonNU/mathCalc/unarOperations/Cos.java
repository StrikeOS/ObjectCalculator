package org.DonNU.mathCalc.unarOperations;
/* @author - Oleksandr Ostapchuk
 *           email: oscomtom@gmail.com
 *           skype: alexander.ostapchuk
 */
import java.text.DecimalFormat;

public class Cos extends UnarOperation {

    private double value;

    public Cos() {
    }

    @Override
    public double getValue() {
        return this.value;
    }

    @Override
    public void execute() {
        double radians = Math.toRadians(this.getArg().getValue());
        this.value = Math.cos(radians);
    }

    @Override
    public String toString() {
        DecimalFormat df = new DecimalFormat("#.##");
        return "Cos(" + this.getArg().getValue() + ") = " + Double.valueOf(df.format(this.value));
    }
}
