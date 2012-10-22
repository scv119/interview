package facebook;

// print bytes of a Integer


public class PrintInteger {
    public static void printDec(int n) {
        StringBuffer sb = new StringBuffer();
        if(n < 0) {
            System.out.print("-");
            n = n * -1;
        }

        if(n == 0)
            sb.append("0");

        while(n != 0) {
            int rem = n % 2;
            n = n / 2;
            sb.append(rem);
        }

        for(int i = 0; i < sb.length(); i ++) {
            System.out.print(sb.charAt(sb.length() - 1 - i));
        }

        System.out.println();
        return;

    }

    public static void main(String args[]) {
        printDec(100);
        System.out.println(Integer.toBinaryString(100));
        printDec(0);
        System.out.println(Integer.toBinaryString(100));
        printDec(1234056);
        System.out.println(Integer.toBinaryString(1234056));
    }
}