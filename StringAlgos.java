package DS.Test;

import javafx.util.Pair;

public class StringAlgos {
    public static void main(String[] args)
    {
        StringAlgos algo = new StringAlgos();
        int res = algo.longestPalindrome("forgeeksskeegfor");
        System.out.println(res);
    }

    public int longestPalindrome(String str)
    {
        Pair<Integer, Integer> maxP = new Pair<>(Integer.MIN_VALUE, Integer.MIN_VALUE);
        for(int i=1; i<str.length(); i++)
        {
            Pair<Integer, Integer> p1 = isPalin(i-1, i,str);
            Pair<Integer, Integer> p2 = isPalin(i-1, i+1,str);

            if((p1.getValue() - p1.getKey()) > (p2.getKey() - p2.getValue()))
            {
                if((p1.getValue() - p1.getKey()) > (maxP.getValue() - maxP.getKey()))
                {
                    maxP = p1;
                }
            }
            else
            {
                if((p2.getValue() - p2.getKey()) > (maxP.getValue() - maxP.getKey()))
                {
                    maxP = p2;
                }
            }
        }

        return (maxP.getValue() - maxP.getKey() + 1);
    }

    public Pair<Integer, Integer> isPalin(int start, int end, String str)
    {
        int cnt = 0;
        //for(int i = start; i<=end; i++)
        while((start < end) && (start >=0) && (end < str.length()))
        {
            if(str.charAt(start) != str.charAt(end))
                break;

            cnt++;
            start--;
            end++;
        }

        return new Pair<>(start+1,end-1);
    }
}
