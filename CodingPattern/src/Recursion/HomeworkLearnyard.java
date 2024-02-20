package Recursion;

public class HomeworkLearnyard {

    //reverse a string
    void reverseRecursion(char[] ch, int start, int end)
    {
        if(start >= end)
            return;
        char temp = ch[start];
        ch[start] = ch[end];
        ch[end] = temp;
        reverseRecursion(ch, start + 1, end -1);
    }
    //Palindrome String
    int palinHelperInt(char[] ch, int i, int j, int res, int n)
    {
        if(i == n)
            return res;

        if(ch[i] == ch[j]){
            res *=  1;
        }else{
            res *= 0;
        }
        return palinHelperInt(ch, i+1, j-1, res, n);

    }

    int isPalindrome(String S) {
        char[] ch = S.toCharArray();
        int n = ch.length;
        int res = palinHelperInt(ch, 0, n-1, 1, n-1 );
        return res;
    }


    //Rectangles and square
    //https://practice.geeksforgeeks.org/contest/job-a-thon-11-hiring-challenge/problems
    public static int minimumMoves(int A, int B) {
        if(A==B) return 1;
        if(A<B){
            return 1+minimumMoves(A,B-A);
        }
        else{
            return 1+minimumMoves(A-B,B);
        }
    }
    //Even subarray Sum
    public static String solve(int N, int[] arr) {
        // code here
        return checkEvenLengthSumIsZero(1, N, arr);
    }

    static String checkEvenLengthSumIsZero(int i, int n, int[] arr){

        if(i==n){
            return "YES";
        }

        int sum = arr[i] + arr[i-1];

        if(sum != 0){
            return "NO";
        }

        return checkEvenLengthSumIsZero(i+1, n, arr);
    }

    //https://www.codechef.com/problems/SINS
    static int gcd(int a, int b) {
        if ( a % b == 0) return b;
        return gcd( b, a % b );
    }

    public static void main(String[] args) throws IOException{
        Scanner sc =new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        while ( T-- > 0 ) {
            String[] input = sc.nextLine().trim().split(" ");
            int equal = gcd( Integer.parseInt(input[0]), Integer.parseInt(input[1]) );
            System.out.println(equal * 2);
        }
    }
}