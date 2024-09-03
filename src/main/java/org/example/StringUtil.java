package org.example;

public class StringUtil {
    public StringActions actions;

    public StringUtil () {
        this.actions = new StringActions() {
            @Override
            public String concate(String s1, String s2) {
                return s1 + s2;
            }

            @Override
            public int countChars(String st) {
                return st.length();
            }

            @Override
            public char findChars(String c, int b) {
                return c.charAt(b);
            }
        };
    }
}
