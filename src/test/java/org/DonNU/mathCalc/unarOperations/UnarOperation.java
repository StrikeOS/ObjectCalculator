package org.DonNU.mathCalc.unarOperations;
/* @author - Oleksandr Ostapchuk
 *           email: oscomtom@gmail.com
 *           skype: alexander.ostapchuk
 */
import org.DonNU.mathCalc.Function;

public class UnarOperation extends Function {
    private Function arg;

    public Function getArg() {
        return this.arg;
    }

    public void setArg(Function arg) {
        this.arg = arg;
    }

    @Override
    public Function getDerivative() {
        return null;
    }
}