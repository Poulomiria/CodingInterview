package Trie;

public class LongestCommonPrefix {

    static  final int ALPHABET_SIZE = 26;


    static class TrieNode{
        boolean isTerminal;
        TrieNode children[];
        TrieNode(){
            children = new TrieNode[ALPHABET_SIZE];
            isTerminal = false;
        }
    };
    //create a root node
    static TrieNode root;
    int indexes;

    //insert a word in Iterative way
    static void insertToTrie(String word)
    {
        int len = word.length();
        int index;

        TrieNode child = root;
        for(int i =0; i < len; i++){
            index = word.charAt(i) - 'a';
            if(child.children[index] == null)
                child.children[index] = new TrieNode();

            child = child.children[index];

        }
        //make the last node as leaf or end node
        isTerminal = true;
    }
    static int countChildren(TrieNode node){
        int count = 0;

        for(int i = 0; i < ALPHABET_SIZE; i++)
        {
            if(node.children[i] != null)
            {
                count++;
                indexes = i;
            }
        }

        return count;
    }
    static String walkTrie()
    {
        TrieNode pCrawl = root;
        indexs = 0;
        String prefix = "";

        while (countChildren(pCrawl) == 1 &&
                pCrawl.isLeaf == false)
        {
            pCrawl = pCrawl.children[indexs];
            prefix += (char)('a' + indexs);
        }
        return prefix;
    }

    // A Function to construct trie
    static void constructTrie(String arr[], int n)
    {
        for (int i = 0; i < n; i++)
            insert (arr[i]);
        return;
    }

    // A Function that returns the longest common prefix
    // from the array of strings
    static String commonPrefix(String arr[], int n)
    {
        root = new TrieNode();
        constructTrie(arr, n);

        // Perform a walk on the trie
        return walkTrie();
    }
    public static void Main(String []args)
    {
        String []arr = {"geeksforgeeks", "geeks",
                "geek", "geezer"};
        int n = arr.Length;

        String ans = commonPrefix(arr, n);

        if (ans.Length != 0)
            Console.WriteLine("The longest common prefix is "+ans);
        else
            Console.WriteLine("There is no common prefix");
    }

}