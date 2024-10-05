package learning.interview.coding.neetcode.arraysandhashing;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

@SuppressWarnings("unused")
public class ValidSudoku {

    static class Solution {

        public static final int BOARD_LENGTH = 9;
        public static final char EMPTY = '.';

        public boolean isValidSudoku(char[][] board) {
            Map<Integer, Set<Character>> rowsMap = new HashMap<>(BOARD_LENGTH);
            Map<Integer, Set<Character>> columnsMap = new HashMap<>(BOARD_LENGTH);
            Map<Integer, Set<Character>> subBoxesMap = new HashMap<>(BOARD_LENGTH);
            for (int i=0; i<BOARD_LENGTH; i++) {
                for (int j=0; j<BOARD_LENGTH; j++) {
                    if (saveValueAndCheckDuplicate(board[i][j], rowsMap, i)) {
                        return false;
                    }
                    if (saveValueAndCheckDuplicate(board[i][j], columnsMap, j)) {
                        return false;
                    }
                    if (saveValueAndCheckDuplicate(board[i][j], subBoxesMap, resolveSubBoxIndex(i, j))) {
                        return false;
                    }
                }
            }

            return true;
        }

        private boolean saveValueAndCheckDuplicate(char value, Map<Integer, Set<Character>> map, int index) {
            if (value == EMPTY) {
                return false;
            } else if (!map.containsKey(index)) {
                Set<Character> set = new HashSet<>(BOARD_LENGTH);
                set.add(value);
                map.put(index, set);
            } else if (!map.get(index).contains(value)) {
                map.get(index).add(value);
            } else {
                return true;
            }
            return false;
        }

        private int resolveSubBoxIndex(int i, int j) {
            int rowIndex = i / 3;
            int columnIndex = j / 3;
            return rowIndex*3 + columnIndex;
        }
    }
}
