package org.solution;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class TextProcessorTest {

    @Test
    public void textProcessorTest1() {
        String input = "Patient presents today with several issues. Number one BMI has increased by 10% since their last visit number next patient reports experiencing dizziness several times in the last two weeks. Number next patient has a persistent cough that hasn’t improved for last 4 weeks Number next patient is taking drug number five several times a week";
        String expected = "Patient presents today with several issues." + System.lineSeparator()
                + "1. BMI has increased by 10% since their last visit" + System.lineSeparator()
                + "2. Patient reports experiencing dizziness several times in the last two weeks." + System.lineSeparator()
                + "3. Patient has a persistent cough that hasn’t improved for last 4 weeks" + System.lineSeparator()
                + "4. Patient is taking drug number five several times a week";
        String actual = new TextProcessor().transform(input);
        assertEquals(expected, actual);
    }

    @Test
    public void textProcessorTest2() {
        String input = "Number one hello";
        String expected = "1. Hello";
        String actual = new TextProcessor().transform(input);
        assertEquals(expected, actual);
    }

    @Test
    public void textProcessorTest3() {
        String input = "This sentence doesn't use a list, but it does have the word number.";
        String expected = "This sentence doesn't use a list, but it does have the word number.";
        String actual = new TextProcessor().transform(input);
        assertEquals(expected, actual);
    }

    @Test
    public void textProcessorTest4() {
        TextProcessor processor = new TextProcessor();
        String input = "Patient presents today with several issues. Number one BMI has increased by 10% since their last visit number next patient reports experiencing dizziness several times in the last two weeks.";
        String expected = "Patient presents today with several issues." + System.lineSeparator()
                + "1. BMI has increased by 10% since their last visit" + System.lineSeparator()
                + "2. Patient reports experiencing dizziness several times in the last two weeks.";
        String actual1 = processor.transform(input);
        assertEquals(expected, actual1);
        String actual2 = processor.transform(input);
        assertEquals(expected, actual2);
    }

}
