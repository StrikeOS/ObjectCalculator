/* @author - Oleksandr Ostapchuk
 *           email: oscomtom@gmail.com
 *           skype: alexander.ostapchuk
 */

import org.DonNU.mathCalc.Arg;
import org.DonNU.mathCalc.Const;
import org.DonNU.mathCalc.binarOperations.Diff;
import org.DonNU.mathCalc.Polynom;
import org.DonNU.mathCalc.binarOperations.Sum;
import org.DonNU.mathCalc.unarOperations.Cos;
import org.DonNU.mathCalc.Log;
import org.DonNU.mathCalc.unarOperations.Ctg;
import org.DonNU.mathCalc.unarOperations.Sin;
import org.DonNU.mathCalc.unarOperations.Tg;

public class TestSet {

    public static void main(String[] args) {

//      y = 2 + 4; => y = 6;
        Sum sum1 = new Sum();
        sum1.setlNode(new Const(2));
        sum1.setrNode(new Const(4));
        sum1.execute();
        Log.info(sum1.toString());
        sum1.resultToXML();

//      y = Cos(x) + 12; x = 180; => y = 11;
        Sum sum2 = new Sum();
        Cos cos = new Cos();
        cos.setArg(new Arg(new Const(180)));//-1
        cos.execute();

        sum2.setlNode(cos);//-1
        sum2.setrNode(new Const(12));
        sum2.execute();
        Log.info(sum2.toString());
        sum2.resultToXML();

//      y = Cos(Cos(x)) + 5; x = 90; => y = 6;
        Cos cos2 = new Cos();
        cos2.setArg(new Arg(new Const(90)));//0
        cos2.execute();

        Cos cos3 = new Cos();
        cos3.setArg(new Arg(new Const(cos2.getValue())));//1
        cos3.execute();

        Sum sum3 = new Sum();
        sum3.setlNode(cos3);//1
        sum3.setrNode(new Const(5));
        sum3.execute();
        Log.info(sum3.toString());
        sum3.resultToXML();

//      y = 5 - 3; => y = 2;
        Diff diff1 = new Diff();
        diff1.setlNode(new Const(5));
        diff1.setrNode(new Const(3));
        diff1.execute();
        Log.info(diff1.toString());
        diff1.resultToXML();

//      (c)' = 0
        Const constanta = new Const(5);
        Log.info("Derivative of " + constanta.getValue() + " is " + constanta.getDerivative());
        constanta.resultToXML();

//      (cos(x))' = -sin(x)
        Cos cos4 = new Cos();
        cos4.setArg(new Arg(new Const(90))); //cos(90)=0;sin(90)=1;(cos(90))' = -sin(90) = -1
        Log.info(cos4.getDerivativeToString());
        cos4.resultToXML();

//      (sin(x))' = cos(x)
        Sin sin1 = new Sin();
        sin1.setArg(new Arg(new Const(180)));//sin(180) = 0 => cos(180) = -1
        Log.info(sin1.getDerivativeToString());
        sin1.resultToXML();

//      (tg(x))' = 1/cos^2(x)
        Tg tangens = new Tg();
        tangens.setArg(new Arg(new Const(180)));//0
        Log.info(tangens.getDerivativeToString());
        tangens.resultToXML();

//      (ctg(x))' = - 1/sin^2(x)
        Ctg cotangens = new Ctg();
        cotangens.setArg(new Arg(new Const(90)));//0
        Log.info(cotangens.getDerivativeToString());
        cotangens.resultToXML();

//      polynomial => 1.0*x^2 + 6.0*x + 3.0 => x = 2 => 4 + 12 + 3 = 19
        Polynom pol = new Polynom();
        pol.setArg(new Const(2));
        pol.setKof_1(new Const(1));
        pol.setKof_2(new Const(6));
        pol.setKof_3(new Const(3));
        pol.execute();
        Log.info(pol.toString());
        pol.resultToXML();
    }
}
