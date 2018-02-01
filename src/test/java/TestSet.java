/* @author - Oleksandr Ostapchuk
 *           email: oscomtom@gmail.com
 *           skype: alexander.ostapchuk
 */

import org.DonNU.mathCalc.Const;
import org.DonNU.mathCalc.binarOperations.Sum;
import org.DonNU.mathCalc.unarOperations.Cos;
import org.DonNU.mathCalc.Log;

public class TestSet {

    public static void main(String[] args) {

//      y = 2 + 4; => y = 6
        Sum sum1 = new Sum();
        sum1.setlNode(new Const(2));
        sum1.setrNode(new Const(4));
        sum1.execute();
        Log.info(sum1.toString());

//      y = Cos(x) + 12; x = 90; => y = 11
        Sum sum2 = new Sum();
        Cos cos = new Cos();
        cos.setArg(new Const(180));
        cos.execute();

        sum2.setlNode(cos);//-1
        sum2.setrNode(new Const(12));
        sum2.execute();
        Log.info(sum2.toString());

//      y = Cos(Cos(x)) + 5; x = 90; => y = 6
        Cos cos2 = new Cos();
        cos2.setArg(new Const(90));
        cos2.execute();

        Cos cos3 = new Cos();
        cos3.setArg(cos2);
        cos3.execute();

        Sum sum3 = new Sum();
        sum3.setlNode(cos3);//1
        sum3.setrNode(new Const(5));
        sum3.execute();
        Log.info(sum3.toString());
    }
}
