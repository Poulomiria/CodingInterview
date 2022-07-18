package Medium;

/*
 * https://leetcode.com/problems/reverse-words-in-a-string/
 * Given an input string s, reverse the order of the words.

A word is defined as a sequence of non-space characters. The words in s will be separated by at least one space.

Return a string of the words in reverse order concatenated by a single space.

Note that s may contain leading or trailing spaces or multiple spaces between two words. The returned string should only have a single space separating the words. Do not include any extra spaces.

 

Example 1:

Input: s = "the sky is blue"
Output: "blue is sky the"
 */


class ReverseWordsinaString {
	  public StringBuilder trimSpaces(String s) {
	    int left = 0, right = s.length() - 1;
	    // remove leading spaces
	    while (left <= right && s.charAt(left) == ' ') ++left;

	    // remove trailing spaces
	    while (left <= right && s.charAt(right) == ' ') --right;

	    // reduce multiple spaces to single one
	    StringBuilder sb = new StringBuilder();
	    while (left <= right) {
	      char c = s.charAt(left);

	      if (c != ' ') sb.append(c);
	      else if (sb.charAt(sb.length() - 1) != ' ') sb.append(c);

	      ++left;
	    }
	    return sb;
	  }

	  public void reverse(StringBuilder sb, int left, int right) {
	    while (left < right) {
	      char tmp = sb.charAt(left);
	      sb.setCharAt(left++, sb.charAt(right));
	      sb.setCharAt(right--, tmp);
	    }
	  }

	  public void reverseEachWord(StringBuilder sb) {
	    int n = sb.length();
	    int start = 0, end = 0;

	    while (start < n) {
	      // go to the end of the word
	      while (end < n && sb.charAt(end) != ' ') ++end;
	      // reverse the word
	      reverse(sb, start, end - 1);
	      // move to the next word
	      start = end + 1;
	      ++end;
	    }
	  }

	  public String reverseWords(String s) {
	    // converst string to string builder 
	    // and trim spaces at the same time
	    StringBuilder sb = trimSpaces(s);

	    // reverse the whole string
	    reverse(sb, 0, sb.length() - 1);

	    // reverse each word
	    reverseEachWord(sb);

	    return sb.toString();
	  }
	  public String reverseWordscharArray(String s) {
		    if (s == null) return null;
		    
		    char[] a = s.toCharArray();
		    int n = a.length;
		    
		    // step 1. reverse the whole string
		    reverse(a, 0, n - 1);
		    // step 2. reverse each word
		    reverseWords(a, n);
		    // step 3. clean up spaces
		    return cleanSpaces(a, n);
		  }
		  
		  void reverseWords(char[] a, int n) {
		    int i = 0, j = 0;
		      
		    while (i < n) {
		      while (i < j || i < n && a[i] == ' ') i++; // skip spaces
		      while (j < i || j < n && a[j] != ' ') j++; // skip non spaces
		      reverse(a, i, j - 1);                      // reverse the word
		    }
		  }
		  
		  // trim leading, trailing and multiple spaces
		  String cleanSpaces(char[] a, int n) {
		    int i = 0, j = 0;
		      
		    while (j < n) {
		      while (j < n && a[j] == ' ') j++;             // skip spaces
		      while (j < n && a[j] != ' ') a[i++] = a[j++]; // keep non spaces
		      while (j < n && a[j] == ' ') j++;             // skip spaces
		      if (j < n) a[i++] = ' ';                      // keep only one space
		    }
		  
		    return new String(a).substring(0, i);
		  }
		  
		  // reverse a[] from a[i] to a[j]
		  private void reverse(char[] a, int i, int j) {
		    while (i < j) {
		      char t = a[i];
		      a[i++] = a[j];
		      a[j--] = t;
		    }
		  }
		  
		
	}
	  
	 