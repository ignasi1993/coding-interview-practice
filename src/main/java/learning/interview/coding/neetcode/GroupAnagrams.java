package learning.interview.coding.neetcode;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class GroupAnagrams {

    static class Solution1 {
        public List<List<String>> groupAnagrams(String[] strs) {
            var anagramsListsMap = new HashMap<Map<Character, Integer>, List<String>>(strs.length);
            for (String s : strs) {
                var anagramMap = buildAnagramMap(s);
                List<String> anagramList = anagramsListsMap.getOrDefault(anagramMap, new ArrayList<>(strs.length));
                anagramList.add(s);
                anagramsListsMap.put(anagramMap, anagramList);
            }
            return anagramsListsMap.values().stream().toList();
        }

        private Map<Character, Integer> buildAnagramMap(String s) {
            var map = new HashMap<Character, Integer>(s.length());
            for (int i=0; i<s.length(); i++) {
                char sKey = s.charAt(i);
                map.put(sKey, map.getOrDefault(sKey, 0) + 1);
            }
            return map;
        }
    }
}
