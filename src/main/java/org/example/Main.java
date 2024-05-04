package org.example;

public class Main {
    public static void main(String[] args) {

//        recur(0, 0, 10);
//        hanoi("A", "B", "C", 3);
//        fibonacci(0, 12, 0, 1);

        System.out.println("================ 메모이제이션 재귀 ===============");
        long beforeTime = System.currentTimeMillis();
        int rst = fibonacci(45);
        System.out.println("결과 : " + rst);
        System.out.println("호출 횟수 : " + cnt);
        long afterTime = System.currentTimeMillis();
        long secDiffTime = (afterTime - beforeTime);
        System.out.println("시간 차이 : "+secDiffTime);

        System.out.println("================ 꼬리 재귀 ===============");
        beforeTime = System.currentTimeMillis();
        int rst2 = fibonacciTail(0, 45, 0, 1);
        System.out.println("결과 : " + rst2);
        System.out.println("호출 횟수 : " + cnt2);
        afterTime = System.currentTimeMillis();
        System.out.println("시간 차이  : "+(afterTime - beforeTime));

        System.out.println("================ 일반 재귀 ===============");
        beforeTime = System.currentTimeMillis();
        int rst3 = fibonacci2(45);
        System.out.println("결과 : " + rst3);
        System.out.println("호출 횟수 : " + cnt3);
        afterTime = System.currentTimeMillis();
        System.out.println("시간 차이 : "+(afterTime - beforeTime));
    }

    // 0 1 1 2 3 5 8 13 21 34 55 89 144 ...

    static int cnt = 0;
    static int cnt2 = 0;
    static int cnt3 = 0;

    // tail
    static int fibonacciTail(int n, int limit, int prev, int current) {
        cnt2 += 1;
        if (n == limit-1) return current;
        return fibonacciTail(n + 1, limit, current, prev + current);
    }

    // normal
    static int fibonacci2(int n) {
        cnt3 += 1;

        if (n == 0) return 0;
        if (n == 1) return 1;

        return fibonacci2(n - 1) + fibonacci2(n - 2);
    }


    //memoization
    static boolean[] memo = new boolean[100];
    static int[] memo2 = new int[100];

    static int fibonacci(int n) {
        cnt += 1;
        if (n == 0) return 0;
        if (n == 1) return 1;

        if (memo[n] != true) {
            memo[n] = true;
            memo2[n] = fibonacci(n - 1) + fibonacci(n - 2);
        }
        return memo2[n];
    }

    void hanoi(String start, String tmp, String end, int n) {
        if (n == 1) {
            System.out.println(n + "번 원반을 " + start + "에서 " + end + "으로 옮깁니다.");
            return;
        }
        hanoi(start, end, tmp, n - 1);
        System.out.println(n + "번 원반을 " + start + "에서 " + end + "으로 옮깁니다.");
        hanoi(tmp, start, end, n - 1);
    }

    void recur(int n, int sum, int limit) {

        if (n > limit) {
            System.out.println(sum);
            return;
        }
        recur(n + 1, sum + n, limit);

    }
}