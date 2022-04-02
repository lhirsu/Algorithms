package problems.interview;

public class Armstrong {

    int order(int x) {
        int n = 0;
        while (x != 0) {
            n++;
            x = x / 10;
        }
        return n;
    }

    boolean isArmstrong(int x) {
        // Calling order function
        int n = order(x);
        int temp = x, sum = 0;
        while (temp != 0) {
            int r = temp % 10;
            sum = sum + (int) Math.pow(r, n);
            temp = temp / 10;
        }

        // If satisfies Armstrong condition
        return (sum == x);
    }

    public static void main(String[] args) {
        Armstrong ob = new Armstrong();
        int x = 153;
        System.out.println(ob.isArmstrong(x));
        x = 1253;
        System.out.println(ob.isArmstrong(x));
    }
}