package org.factory;

// import this to fill in the package name so that you don't need to type in the package name yourself
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

// The static import fills in the package name and the class name, so that you can call the methods directly
import static org.junit.jupiter.api.Assertions.*;
// Without any import you would have to use the full long name to use any methods from the packages

class FactoryTests {
    // You can give the test method a descriptive name and/or a display name (junit)
    @Test
    @DisplayName(" A human  instructor returns an uppercase version of a question")
    void humanInstructorAskQuestion() {
        // arrange - gather the objects you need for testing
        HumanInstructor humanInstructor = new HumanInstructor(); // create an object for your test
        String question = "Is this test going to work?"; // We also need a question to ask the instructor
        String expectedAnswer = "IS THIS TEST GOING TO WORK?"; // We know the expected behaviour so define that here

        // act - do operations to the objects you have gathered
        String actualAnswer = humanInstructor.askQuestion(question); // Ask the instructor the question and save output

        // assert - check that you get the desired outcomes
        assertEquals(expectedAnswer, actualAnswer); // this is a matcher from the assertion package
    }

    @Test
    @DisplayName(" A human instructor implements the Instructor interface")
    void humanInstructorInterface() {
        // arrange
        HumanInstructor humanInstructor = new HumanInstructor();

        // act
        Instructor instructor = humanInstructor;

        // assert - not needed here as the compiler will fail if the human instructor doesn't implement Instructor

    }

    // Write the InstructorFactory class and test
    @Test
    @DisplayName( "The InstructorFactory creates an instructor")
    void instructorFactoryCreate() {
        // arrange
        InstructorFactory instructorFactory = new InstructorFactory();

        // act
        Instructor instructorFromFactory = instructorFactory.create();

        // assert
        assertInstanceOf(Instructor.class, instructorFromFactory);

    }
}