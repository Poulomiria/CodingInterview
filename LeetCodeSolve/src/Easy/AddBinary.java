package Easy;

/*
 * https://leetcode.com/problems/add-binary/
 * 
 */
class AddBinary {
	  public String addBinaryLeetCode(String a, String b) {
	    int n = a.length(), m = b.length();
	    if (n < m) return addBinary(b, a);
	    int L = Math.max(n, m);

	    StringBuilder sb = new StringBuilder();
	    int carry = 0, j = m - 1;
	    for(int i = L - 1; i > -1; --i) {
	      if (a.charAt(i) == '1') ++carry;
	      if (j > -1 && b.charAt(j--) == '1') ++carry;

	      if (carry % 2 == 1) sb.append('1');
	      else sb.append('0');

	      carry /= 2;
	    }
	    if (carry == 1) sb.append('1');
	    sb.reverse();

	    return sb.toString();
	  }
	    
	    public String addBinary(String a, String b) {
	        StringBuilder sb = new StringBuilder();
	        int i = a.length() - 1, j = b.length() -1, carry = 0;
	        while (i >= 0 || j >= 0) {
	            int sum = carry;
	            if (j >= 0) sum += b.charAt(j--) - '0';
	            if (i >= 0) sum += a.charAt(i--) - '0';
	            sb.append(sum % 2);
	            carry = sum / 2;
	        }
	        if (carry != 0) sb.append(carry);
	        return sb.reverse().toString();   
	}
	}