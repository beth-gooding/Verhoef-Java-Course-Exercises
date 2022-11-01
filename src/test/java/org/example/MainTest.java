package org.example;

// import this to fill in the package name so that you don't need to type in the package name yourself
import org.junit.jupiter.api.Test;

// The static import fills in the package name and the class name, so that you can call the methods directly
import static org.junit.jupiter.api.Assertions.*;
// Without any import you would have to use the full long name to use any methods from the packages

class MainTest {

    @Test
    void main() {
        // arrange - gather the objects you need for testing
        HumanInstructor humanInstructor = new HumanInstructor(); // create an object for your test
        String question = "Is this test going to work?"; // We also need a question to ask the instructor
        String expectedAnswer = "IS THIS TEST GOING TO WORK?"; // We know the expected behaviour so define that here

        // act - do operations to the objects you have gathered
        String actualAnswer = humanInstructor.askQuestion(question); // Ask the instructor the question and save output

        // assert - check that you get the desired outcomes
        assertEquals(expectedAnswer, actualAnswer); // this is a matcher from the assertion package
    }
}