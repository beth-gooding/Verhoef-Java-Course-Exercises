package org.factory;

public class HumanInstructor implements Instructor {
    public String askQuestion(String question) {
        return question.toUpperCase();
    }
}
