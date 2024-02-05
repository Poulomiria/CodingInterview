package Queue;

public class FirstNonRepeatingCharacter {

    static char nonrepeatingCharacter(String S)
    {
        int[] count = new int[26];
        Arrays.fill(count, 0);
        char ans = '$';
        Queue<Character> q = new LinkedList();

        for(char c : S.toCharArray())
        {

            count[c-'a']++;
            q.offer(c);
        }
        while(!q.isEmpty())
        {
            if(count[q.peek()-'a'] > 1)
            {
                q.poll();
            }else{
                ans = q.poll();
                return ans;
            }
        }
        return ans;
    }
}