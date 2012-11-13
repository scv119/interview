package mitbbs;

/**
 * Created with IntelliJ IDEA.
 * User: shenchen
 * Date: 11/13/12
 * Time: 7:56 PM
 * To change this template use File | Settings | File Templates.
 */
public class Prob {

    int[] arr;

    private boolean random() {
        if (Math.random() < 0.5)
            return true;
        return false;
    }

    public void init(double p) {
        arr = new int[10];
        double value = 0.5;
        for (int i = 0; i < 10; i ++) {
            if (p >= value) {
                p = p - value;
                arr[i] = 1;
            } else {
                arr[i] = 0;
            }
            value = value/2;
        }
    }

    public boolean getRandom() {
        for (int i = 0; i < 10; i ++) {
            boolean tmp = random();
            if (arr[i] == 0 && tmp)
                return false;
            if (arr[i] == 1 && !tmp)
                return true;
        }
        return random();
    }

    public static void main(String args[]) {
        Prob prob = new Prob();
        prob.init(0.69);

        int count = 0;
        for (int i = 0; i < 100000; i ++) {
            if (prob.getRandom())
                count ++;
        }

        System.out.println(1.0f * count / 100000);
    }

}
