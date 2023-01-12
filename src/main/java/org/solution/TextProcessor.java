package org.solution;

import java.util.HashMap;
import java.util.Map;

public class TextProcessor {

    private static class ProcessorState {

        private Integer current = 1;

        private Boolean nextEncountered = false;

    }

    private ProcessorState state = new ProcessorState();

    private final Map<String, Integer> numberMap = new HashMap<>(Map.of(
            "one", 1,
            "two", 2,
            "three", 3,
            "four", 4,
            "five", 5,
            "six", 6,
            "seven", 7,
            "eight", 8,
            "nine", 9
    ));

    public static void main(String[] args) {
        TextProcessor tp = new TextProcessor();
        String actual = tp.transform("Patient presents today with several issues. Number one BMI has increased by 10% since their last visit number next patient reports experiencing dizziness several times in the last two weeks. Number next patient has a persistent cough that hasn’t improved for last 4 weeks Number next patient is taking drug number five several times a week");
        System.out.print(actual);
    }

    private void resetState() {
        state = new ProcessorState();
    }

    public String transform(String input) {
        if (input == null) { return ""; }

        String[] split = input.split("(?i)(?=\\b(number)\\s)");

        String first = split[0].split("\\s+", 2)[0];
        if (split.length == 1 && !first.equalsIgnoreCase("number")) {
            return input;
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < split.length; i++) {
            builder.append(convertLeadingNumber(split[i], i == 0));
        }
        resetState();

        return builder.toString();
    }

    private String convertLeadingNumber(String input, Boolean isFirstLine) {
        String result = input.trim();
        String[] split = result.split("\\s+", 3);
        if (split.length == 3 && numberMap.containsKey(split[1]) && !state.nextEncountered) {
            Integer value = numberMap.get(split[1]);
            state.current = value;
            result = isFirstLine ? "" : System.lineSeparator();
            return result + value.toString() + ". " + capitalizeFirstLetter(split[2]);
        } else if (split.length == 3 && split[1].equalsIgnoreCase("next")) {
            state.nextEncountered = true;
            result = isFirstLine ? "" : System.lineSeparator();
            return result + (++state.current) + ". " + capitalizeFirstLetter(split[2]);
        } else if (split[0].equalsIgnoreCase("number")) {
            return " " + result;
        }
        return result;
    }

    private String capitalizeFirstLetter(String input) {
        if (input.length() == 0) { return input; }
        String first = input.substring(0, 1).toUpperCase();
        if (input.length() == 1) { return first; }
        return input.substring(0, 1).toUpperCase() + input.substring(1);
    }

}
