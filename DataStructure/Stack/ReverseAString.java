package Stack;

public class ReverseAString {

    public String reverse(String S){
        //Take a character stack
        Stack<Character> s = new Stack();
        //Push all the elements in the stack
        for(char ch : S.toCharArray())
        {
            s.push(ch);
        }
        //Take a character array with size of the input string
        char[] charArray = new char[S.length()];
        int i =0;
        while(!s.isEmpty())
        {
            charArray[i++] = s.pop();
        }
        //convert character array to String
        return String.valueOf(charArray);
    }

}
