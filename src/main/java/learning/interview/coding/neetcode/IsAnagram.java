package learning.interview.coding.neetcode;

import java.util.Arrays;
import java.util.HashMap;

public class IsAnagram {

    static class Solution1 {
        public boolean isAnagram(String s, String t) {
            char[] sArray = s.toCharArray();
            Arrays.sort(sArray);
            char[] tArray = t.toCharArray();
            Arrays.sort(tArray);
            return Arrays.equals(sArray, tArray);
        }
    }

    static class Solution2 {
        public boolean isAnagram(String s, String t) {
            if (s.length() != t.length()) {
                return false;
            }
            int stringsLength = s.length();
            var sMap = new HashMap<Character, Integer>(stringsLength);
            var tMap = new HashMap<Character, Integer>(stringsLength);
            for (int i=0; i<stringsLength; i++) {
                char sKey = s.charAt(i);
                char tKey = t.charAt(i);
                sMap.put(sKey, sMap.getOrDefault(sKey, 0) + 1);
                tMap.put(tKey, tMap.getOrDefault(tKey, 0) + 1);
            }
            return sMap.equals(tMap);
        }
    }
}
