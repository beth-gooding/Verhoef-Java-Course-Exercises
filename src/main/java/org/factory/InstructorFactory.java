package org.factory;

public class InstructorFactory {
    static HumanInstructor humanInstructor = new HumanInstructor();
    public Instructor create() {
        return humanInstructor;
    }
}
