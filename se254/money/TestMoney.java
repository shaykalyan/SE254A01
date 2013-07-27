package se254.money;
/**
 * SOFTENG 254 2011 Assignment 1 submission
 *
 * Author: (Akshay Pravin Kalyan, akal881)
 **/

import junit.framework.TestCase;

public class TestMoney extends TestCase {
    private Money m;

    // Your tests here.
    protected void setUp() {
        m = new Money();
    }

    public void testNothing() {
        assertEquals(0,0);
    }

    /**
     * DO NOT DELETE THIS
     * This is needed for the automatic marking process.
     **/
//    public static void main(String[] args) {
//        junit.textui.TestRunner.run(TestInheritanceModel.class);
//    }

    public static void main(String[] args) {
        junit.textui.TestRunner.run(TestMoney.class);
    }
}


/*
shay@Zane ~/Dropbox/Uni/Semester II/SOFTENG 254/Assignments/Assignment 01/SE254A01 $ javac -cp junit.jar:badA.jar:. se254/money/TestMoney.java
shay@Zane ~/Dropbox/Uni/Semester II/SOFTENG 254/Assignments/Assignment 01/SE254A01 $ java -cp junit.jar:badA.jar:. se254/money/TestMoney
.
Time: 0.002

OK (1 test)
*/