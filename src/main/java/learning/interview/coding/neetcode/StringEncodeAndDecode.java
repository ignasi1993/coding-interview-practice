package learning.interview.coding.neetcode;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class StringEncodeAndDecode {

    static class Solution {

        private static final String DELIMITER_CHARACTER = ",";

        public String encode(List<String> stringsList) {
            return stringsList.stream()
                    .map(Token::ofDecodedString)
                    .map(Token::getEncodedToken)
                    .collect(Collectors.joining(DELIMITER_CHARACTER));
        }

        public List<String> decode(String str) {
            if (str.isEmpty()) {
                return List.of();
            }
            return split(str).stream()
                    .map(Token::ofEncodedString)
                    .map(Token::getDecodedToken)
                    .toList();
        }

        private static List<String> split(String string) {
            var list = new ArrayList<String>();
            var splitString = string.split(DELIMITER_CHARACTER, 2);
            if (splitString.length == 1) {
                return List.of(string);
            }
            while (!Token.isToken(splitString[0])) {
                var splitString2 = splitString[1].split(DELIMITER_CHARACTER, 2);
                if (splitString2.length == 1) {
                    return List.of(string);
                }
                splitString = new String[]{splitString[0] + splitString2[0], splitString2[1]};
            }
            list.add(splitString[0]);
            list.addAll(split(splitString[1]));
            return list;
        }

        private static class Token {

            private static final String ENCLOSING_CHARACTER = "\"";
            private static final String DOUBLE_ENCLOSING_CHARACTER = "\"\"";

            private final String decodedToken;
            private final String encodedToken;

            private Token(String decodedToken, String encodedToken) {
                this.decodedToken = decodedToken;
                this.encodedToken = encodedToken;
            }

            public static Token ofEncodedString(String s) {
                return new Token(decode(s), s);
            }

            public static Token ofDecodedString(String s) {
                return new Token(s, encode(s));
            }

            public String getDecodedToken() {
                return decodedToken;
            }

            public String getEncodedToken() {
                return encodedToken;
            }

            public static String encode(String token) {
                String unEnclosedEncodedToken = token.replace(ENCLOSING_CHARACTER, DOUBLE_ENCLOSING_CHARACTER);
                return String.format("%s%s%s", ENCLOSING_CHARACTER, unEnclosedEncodedToken, ENCLOSING_CHARACTER);
            }

            public static String decode(String token) {
                String unEnclosedEncodedToken = token.substring(1, token.length() - 1);
                return unEnclosedEncodedToken.replace(DOUBLE_ENCLOSING_CHARACTER, ENCLOSING_CHARACTER);
            }

            public static boolean isToken(String s) {
                int count = 0;
                for (int i=0; i<s.length() && s.charAt(i) == DELIMITER_CHARACTER.charAt(0); i++) {
                    count++;
                }
                if (count % 2 == 0) {
                    return false;
                }
                count = 0;
                for (int i=s.length()-1; i>=0 && s.charAt(i) == DELIMITER_CHARACTER.charAt(0); i--) {
                    count++;
                }
                return count % 2 != 0;
            }
        }
    }
}
