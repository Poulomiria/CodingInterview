package Stack;

public class ParenthesisChecker{

    static boolean ispar(String x)
    {
        Stack<Character> s = new Stack();
        for(char ch : x.toCharArray())
        {
            switch(ch){

                case '(':
                    s.push(')');
                    break;
                case '{':
                    s.push('}');
                    break;
                case '[':
                    s.push(']');
                    break;
                default:
                    if(s.isEmpty() || s.pop() != ch)
                        return false;

            }
        }
        return s.isEmpty();
    }
}