package Easy;

public class LengthofLastWord {
	
	 public static int lengthOfLastWord(String s) {
	        
	        String[] strArr = s.split(" ");
	        
	        String val = "";
	        int result = 0;
	        System.out.println("Value is:" + strArr.length);
	        for(int i = strArr.length - 1; i >= 0; --i)
	        {
	            val = strArr[i];
	            
	            if(!val.isEmpty())
	            {
	                result = val.length();
	                break;
	            }
	        }
	        return result;        
	        
	    }
	 public static void main(String args[])
	 {
		 int len = lengthOfLastWord("a");
		 System.out.println("length is:" + len);
	 }

}
