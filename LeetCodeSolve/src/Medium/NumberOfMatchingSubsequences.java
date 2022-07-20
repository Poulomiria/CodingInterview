package Medium;
/*
 * https://leetcode.com/problems/number-of-matching-subsequences/
 */

import java.util.ArrayList;
import java.util.List;

class NumberOfMatchingSubsequences {
	/*
	public int numMatchingSubseqDifferent(String S, String[] words) {
	    List<Integer[]>[] waiting = new List[128];
	    for (int c = 0; c <= 'z'; c++)
	        waiting[c] = new ArrayList<Object>();
	    for (int i = 0; i < words.length; i++)
	        waiting[words[i].charAt(0)].add(new Integer[]{i, 1});
	    for (char c : S.toCharArray()) {
	        List<Integer[]> advance = new ArrayList(waiting[c]);
	        waiting[c].clear();
	        for (Integer[] a : advance)
	            waiting[a[1] < words[a[0]].length() ? words[a[0]].charAt(a[1]++) : 0].add(a);
	    }
	    return waiting[0].size();
	}
	*/
    public int numMatchingSubseq(String S, String[] words) {
        int ans = 0;
        ArrayList<Node>[] heads = new ArrayList[26];
        for (int i = 0; i < 26; ++i)
            heads[i] = new ArrayList<Node>();

        for (String word: words)
            heads[word.charAt(0) - 'a'].add(new Node(word, 0));

        for (char c: S.toCharArray()) {
            ArrayList<Node> old_bucket = heads[c - 'a'];
            heads[c - 'a'] = new ArrayList<Node>();

            for (Node node: old_bucket) {
                node.index++;
                if (node.index == node.word.length()) {
                    ans++;
                } else {
                    heads[node.word.charAt(node.index) - 'a'].add(node);
                }
            }
            old_bucket.clear();
        }
        return ans;
    }

}

class Node {
    String word;
    int index;
    public Node(String w, int i) {
        word = w;
        index = i;
    }
}