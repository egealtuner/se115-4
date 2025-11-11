//lab05
public class se1153 {
    static long factorial(int n) {
        if (n == 0) return 1L;
        return n * factorial(n - 1);
    }
    static long power(long base, int exp) {
        if (exp == 0) return 1L;
        return base * power(base, exp - 1);
    }
    static int sumDigits(int n) {
        n = Math.abs(n);
        if (n < 10) return n;
        return (n % 10) + sumDigits(n / 10);
    }

    static long fib(int n) {
        if (n == 0) return 0L;
        if (n == 1) return 1L;
        return fib(n - 1) + fib(n - 2);
    }

    public static void main(String[] args) {
        System.out.println("A) factorial and power");
        System.out.println("factorial(0) = " + factorial(0));  // 1
        System.out.println("factorial(5) = " + factorial(5));  // 120
        System.out.println("power(3, 0) = " + power(3, 0));    // 1
        System.out.println("power(2, 6) = " + power(2, 6));    // 64

        System.out.println("\nB) sumDigits");
        System.out.println("sumDigits(0) = " + sumDigits(0));        // 0
        System.out.println("sumDigits(305) = " + sumDigits(305));    // 8
        System.out.println("sumDigits(-9421) = " + sumDigits(-9421));// 16

        System.out.println("\nBONUS) Fibonacci");
        System.out.println("fib(0) = " + fib(0));    // 0
        System.out.println("fib(1) = " + fib(1));    // 1
        System.out.println("fib(10) = " + fib(10));  // 55
    }
}