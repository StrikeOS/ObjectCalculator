package org.DonNU.mathCalc.unarOperations;
/* @author - Oleksandr Ostapchuk
 *           email: oscomtom@gmail.com
 *           skype: alexander.ostapchuk
 */
import org.DonNU.mathCalc.Arg;
import org.DonNU.mathCalc.Function;

public class UnarOperation extends Function {
    private Arg arg;

    public Arg getArg() {
        return this.arg;
    }

    public void setArg(Arg arg) {
        this.arg = arg;
    }

    @Override
    public double getValue() {
        return this.arg.getValue();
    }

    @Override
    public Function getDerivative() {
        return null;
    }
}