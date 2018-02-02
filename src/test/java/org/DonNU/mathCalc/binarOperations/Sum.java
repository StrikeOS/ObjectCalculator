package org.DonNU.mathCalc.binarOperations;

import org.DonNU.mathCalc.XMLsaver;

import java.util.UUID;

/* @author - Oleksandr Ostapchuk
 *           email: oscomtom@gmail.com
 *           skype: alexander.ostapchuk
 */
public class Sum extends BinarOperation {
    private String className = this.getClass().getSimpleName();
    private double value;

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public void execute() {
        this.value = this.getlNode().getValue() + this.getrNode().getValue();
    }

    @Override
    public String toString() {
        return this.className + "( " + this.getlNode().getValue() + " + " + this.getrNode().getValue() + " ) = " + String.valueOf(this.value);
    }

    public void resultToXML() {
        String random = UUID.randomUUID().toString();
        XMLsaver.resultToXML(className + "_" + random, this.toString());
    }
}
