package Recursion;

public class RecursionBasics {

    static int factorial(int n){
        //base case
        if(n == 0)
            return 1;
        return n * factorial(n-1);

    }
    static void printNums(int n)
    {
        if(n == 0)
            return;
        System.out.println(n);
        printNum(n-1);
    }
    static void print1ToN(int n)
    {
        if(n ==0)
            return;
        print1ToN(n-1);
        System.out.println(n);
    }
    static int fibo(int n)
    {
        //base case
        if(n == 0 || n == 1) return n;

        return fibo(n-1) + fibo(n-2);
    }

    public static void main(String args[]){

    }
}