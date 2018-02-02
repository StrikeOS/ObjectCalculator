package org.DonNU.mathCalc;

import org.DonNU.mathCalc.binarOperations.Multi;
import org.DonNU.mathCalc.binarOperations.Sum;

import java.util.UUID;

/* @author - Oleksandr Ostapchuk
 *           email: oscomtom@gmail.com
 *           skype: alexander.ostapchuk
 */
public class Polynom extends Function {
    private String className = this.getClass().getSimpleName();
    private double value;
    private Function arg;
    private Function kof_1;
    private Function kof_2;
    private Function kof_3;

    public void setValue(double value) {
        this.value = value;
    }

    public Function getArg() {
        return arg;
    }

    public void setArg(Function arg) {
        this.arg = arg;
    }

    public void setKof_1(Function kof_1) {
        this.kof_1 = kof_1;
    }

    public void setKof_2(Function kof_2) {
        this.kof_2 = kof_2;
    }

    public void setKof_3(Function kof_3) {
        this.kof_3 = kof_3;
    }

    @Override
    public double getValue() {
        return value;
    }

    @Override
    public void execute() {
        Multi mul_x_2 = new Multi();
        mul_x_2.setlNode(arg);
        mul_x_2.setrNode(arg);
        mul_x_2.execute();

        Multi mul_first = new Multi();
        mul_first.setlNode(kof_1);
        mul_first.setrNode(mul_x_2);
        mul_first.execute();

        Multi mul_middle = new Multi();
        mul_middle.setlNode(kof_2);
        mul_middle.setrNode(arg);
        mul_middle.execute();

        Sum sum_first_two = new Sum();
        sum_first_two.setlNode(mul_first);
        sum_first_two.setrNode(mul_middle);
        sum_first_two.execute();

        Sum sum_pol = new Sum();
        sum_pol.setlNode(sum_first_two);
        sum_pol.setrNode(kof_3);
        sum_pol.execute();

        this.value = sum_pol.getValue();
    }

    @Override
    public String toString() {
        return this.className + "(" + kof_1.getValue() + "*x^2 + " + kof_2.getValue() + "*x + " + kof_3.getValue() + ") where x = " + this.getArg().getValue() + " = " + this.value;
    }

    public void resultToXML() {
        String random = UUID.randomUUID().toString();
        XMLsaver.resultToXML(className + "_" + random, this.toString());
    }
}
