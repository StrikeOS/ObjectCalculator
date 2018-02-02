package org.DonNU.mathCalc.binarOperations;
/* @author - Oleksandr Ostapchuk
 *           email: oscomtom@gmail.com
 *           skype: alexander.ostapchuk
 */
import org.DonNU.mathCalc.Function;

public class BinarOperation extends Function {
    private Function lNode;
    private Function rNode;

    public Function getlNode() {
        return lNode;
    }

    public void setlNode(Function lNode) {
        this.lNode = lNode;
    }

    public Function getrNode() {
        return rNode;
    }

    public void setrNode(Function rNode) {
        this.rNode = rNode;
    }

    @Override
    public double getValue() {
        try {
            throw new Exception("Not inited getValue()");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

}
