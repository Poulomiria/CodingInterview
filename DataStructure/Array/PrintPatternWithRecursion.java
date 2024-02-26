package Array;
/*
https://www.geeksforgeeks.org/problems/print-pattern3549/1
 */
public class PrintPatternWithRecursion {

    static List<Integer> result;
    int printPattern(int sum, int N, List<Integer> aList){
        //base case
        if(sum <= 0)
            return sum;
        aList.add(sum);
        return printPattern(sum-5, N, aList);
    }
    List<Integer> printPatternAfterZero(int sum, int N, List<Integer> aList){
        //base case
        if(sum > N)
            return aList;

        aList.add(sum);
        printPatternAfterZero(sum+5, N, aList);

        return aList;
    }
    public List<Integer> pattern(int N){
        result = new ArrayList();
        int ans =0;
        if(N > 0){
            ans = printPattern(N,N,result);
            printPatternAfterZero(ans,N,result);
        }
        else{
            result.add(N);
        }
        return result;

    }

}