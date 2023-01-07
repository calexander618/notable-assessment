package org.solution;

public class TextProcessor {
    public static void main(String[] args) {
        String actual = transform("wtf");
        System.out.print(actual);
    }

    public static String transform(String input) {
        // bad cases (null, empty, etc)

        StringBuilder builder = new StringBuilder();

        for (int i=0; i<input.length(); i++) {
            builder.append(input.charAt(i));
        }

        return builder.toString();
    }

}
