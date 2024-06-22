package learning.interview.coding.neetcode.twopointers;

import java.util.ArrayList;

public class IsPalindrome {

    static class Solution {
        public boolean isPalindrome(String s) {
            var list = new ArrayList<>(s.length());
            for (int i = 0; i<s.length(); i++) {
                if (Character.isAlphabetic(s.codePointAt(i)) || Character.isDigit(s.codePointAt(i))) {
                    list.add(Character.toLowerCase(s.charAt(i)));
                }
            }
            int halfLength = list.size()/2;
            for (int i = 0; i<halfLength; i++) {
                if (list.get(i) != list.get(list.size() - 1 - i)) {
                    return false;
                }
            }
            return true;
        }
    }
}
