package BinarySearch;
/*
https://leetcode.com/problems/guess-number-higher-or-lower/description/


 */
public class GuessNumberHigherOrLower {

    public int guessNumber(int n) {

        int left = 1;
        int right = n ;
        while(left <= right)
        {
            int mid = left + (right - left)/2;
            int pick = guess(mid);
            if(pick == 0)
                return mid;
            else if(pick < 0)
            {
                right = mid - 1;
            }else{
                left = mid+1;
            }
        }
        return -1;

    }
}