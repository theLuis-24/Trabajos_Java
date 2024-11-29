public class Main {
    public static void main(String[] args) {
        System.out.println(mayorDeTres(10, 20, 30)); 
        System.out.println(mayorDeTres(50, 40, 30)); 
        System.out.println(mayorDeTres(10, 10, 10)); 
    }

    public static int mayorDeTres(int a, int b, int c) {
        if (a >= b && a >= c) {
            return a;
        } else if (b >= a && b >= c) {
            return b;
        } else {
            return c;
        }
    }
}