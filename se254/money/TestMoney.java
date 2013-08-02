package se254.money;
/**
 * SOFTENG 254 2011 Assignment 1 submission
 *
 * Author: (Akshay Pravin Kalyan, akal881)
 **/


/* NOTES
add messages to fails
exception e.getmessage(ADD MESSAGE TO BE SPECIFIC TO EXCEPTIION!!!)
constructor asserts
try tests with null inputs

remove tests which use both constructors - not neccessary as you are already testing constructors seperately??1!

 */
import junit.framework.TestCase;

import java.lang.IllegalArgumentException;

public class TestMoney extends TestCase {
    private Money m;

    // Your tests here.
    protected void setUp() {
        m = new Money();
    }

//-------------------------------------------------------------------------------       /* CONSTRUCTORS */

    /* DEFAULT */

    /**
     * This is a simple test to ensure that the default (zero argument) constructor creates and returns a Money
     * object with the value of zero dollars only
     */
    public void testConstructorDefault() {
        assertEquals("$0.00", (new Money()).toString());
    }

    /* TWO PARAMETERS */

    /**
     * This is a simple test to ensure that the two argument constructor creates and returns a Money
     * object with the value of zero dollars only when passed in two zero
     */
    public void testConstructorTwoPara_ZeroDollars() {
        assertEquals("$0.00", (new Money(0,0)).toString());

    }

    public void testConstructorTwoPara_NegativeZeroDollars() {
        assertEquals("$0.00", (new Money(-0,0)).toString());
    }

    public void testConstructorTwoPara_PositiveAmount() {
        assertEquals("$1.50", (new Money(1,50).toString()));
    }

    public void testConstructorTwoPara_NegativeAfterNonZero() {
        try {
            Money c = new Money(1,-50);
            fail("IllegalArgumentException ");
        } catch (IllegalArgumentException e) {

        }
    }

    public void testConstructorTwoPara_NegativeAfterZero() {
            Money a = new Money(0,-50);
    }

    public void testConstructorTwoPara_NonNegativeAfterNegativeZero() {
        assertEquals("$0.50", (new Money(-0,50)).toString());
    }

    public void testConstructorTwoPara_MoreThanOneNegative() {
        try {
            Money d = new Money(-1,-50);
            fail();
        } catch (IllegalArgumentException e) {}
    }

    public void testConstructorTwoPara_InputValueRange_InvalidBounds() {
        try {
            Money d = new Money(1,100);
            fail();
        } catch (IllegalArgumentException e) {}
    }

    public void testConstructorTwoPara_InputValueRange_ValidBounds() {
        assertEquals("$0.00", (new Money(0, 0)).toString());
        assertEquals("-$0.99", (new Money(0, -99)).toString());
        assertEquals("$0.99", (new Money(0, 99)).toString());
    }

    /* CONSTRUCTORS - THREE PARAMETERS */
    public void testConstructorThreePara_ZeroDollars() {
        assertEquals("$0.00", (new Money(0,0,0)).toString());
    }

    public void testConstructorThreePara_NegativeZeroDollars() {
        assertEquals("$0.00", (new Money(-0,0,0)).toString());
    }

    public void testConstructorThreePara_PositiveAmount() {
        assertEquals("$1.0203", (new Money(1,2,3)).toString());
     }

    public void testConstructorThreePara_NonNegativeAfterNegativeZero_NegativeZeroDollars() {
        assertEquals("$0.505", (new Money(-0,50,50)).toString());
    }

    public void testConstructorThreePara_NonNegativeAfterNegativeZero_NegativeZeroCents() {
        assertEquals("$0.005", (new Money(0,-0,50)).toString());
    }

    public void testConstructorThreePara_NegativeAfterNonZero_CentsHasNeg_TrailingZero() {
        try {
            Money a = new Money(1,-2,0);
            fail();
        } catch (IllegalArgumentException e) {}
    }

    public void testConstructorThreePara_NegativeAfterNonZero_CentsHasNeg_TrailingNonZero() {
        try {
            Money a = new Money(1,-2,3);
            fail();
        } catch (IllegalArgumentException e) {}
    }

    public void testConstructorThreePara_NegativeAfterNonZero_HundrethsHasNeg_LeadingZeroDollars() {
        try {
            Money a = new Money(0,1,-2);
            fail();
        } catch (IllegalArgumentException e) {}
    }

    public void testConstructorThreePara_NegativeAfterNonZero_HundrethsHasNeg_LeadingZeroDollarsAndCents() {
        assertEquals("-$0.0002", (new Money(0,0,-2)).toString());
    }

    public void testConstructorThreePara_NegativeAfterNonZero_HundrethsHasNeg_NonZeroDollarsAndZeroCents() {
        try {
            Money a = new Money(1,0,-2);
            fail();
        } catch (IllegalArgumentException e) {}
    }


    public void testConstructorThreePara_InputValueRange_ValidBounds()  {
        assertEquals("$0.00", (new Money(0, 0,0)).toString());
        assertEquals("-$0.9999", (new Money(0, -99,99)).toString());
        assertEquals("$0.9999", (new Money(0, 99,99)).toString());

    }

    public void testConstructorThreePara_InputValueRange_InvalidBounds_Cents() {
        try {
            Money c = new Money(1,100,0);
            fail();
        } catch (IllegalArgumentException e) {}
    }

    public void testConstructorThreePara_InputValueRange_InvalidBounds_Hundreths() {
        try {
            Money c = new Money(1,1,100);
            fail();
        } catch (IllegalArgumentException e) {}
    }

    public void testConstructorThreePara_InputValueRange_InvalidBounds_CentsAndHundreths() {
        try {
            Money c = new Money(1,1,100);
            fail();
        } catch (IllegalArgumentException e) {}
    }


//-------------------------------------------------------------------------------       /* TO STRING */



    public void testToString_ZeroDollars() {
        assertEquals("$0.00", (new Money()).toString());
        assertEquals("$0.00", (new Money(0,0)).toString());
        assertEquals("$0.00", (new Money(0,0,0)).toString());
    }

    public void testToString_NegativeSign() {
        assertEquals("-$1.50", (new Money(-1,50)).toString());
        assertEquals("-$0.50", (new Money(0,-50,0)).toString());
        assertEquals("-$0.0005", (new Money(0,0,-5)).toString());
    }

    public void testToString_TrailingZeros() {
        assertEquals("$19.345", (new Money(19,34,50)).toString());
        assertEquals("$19.30", (new Money(19,30,00)).toString());
        assertEquals("$20.0005", (new Money(20,0,5)).toString());
    }


//------------------------------------------------------------------------------- /* EQUALS */


    public void testEquals_ZeroDollars() {
        assertTrue((new Money()).equals(new Money(0,0)));
        assertTrue((new Money()).equals(new Money(0,0,0)));
    }

    public void testEquals_InvalidParameter() {
        assertFalse((new Money()).equals(null));
    }

    public void testEquals_EqualMoneyObjects() {
        assertTrue((new Money(12,34,56)).equals(new Money(12,34,56)));

        assertTrue((new Money(55,0)).equals(new Money(55,0)));
        assertTrue((new Money(0,55)).equals(new Money(0,55)));

        assertTrue((new Money(55,0,0)).equals(new Money(55,0,0)));
        assertTrue((new Money(0,55,0)).equals(new Money(0,55,0)));
        assertTrue((new Money(0,0,55)).equals(new Money(0,0,55)));
    }

    public void testEquals_NonEqualMoneyObjects_VariousCombinations() {
        assertFalse((new Money(10,55,55)).equals(new Money(20,55,55)));
        assertFalse((new Money(55,10,55)).equals(new Money(55,20,55)));
        assertFalse((new Money(55,55,10)).equals(new Money(55,55,20)));
    }

    public void testEquals_NonEqualMoneyObjects_EqualButOppositeSigns() {
        assertFalse((new Money(-1,50)).equals(new Money(1,50)));
        assertFalse((new Money(1,50)).equals(new Money(-1,50)));

        assertFalse((new Money(12,34,56)).equals(new Money(-12,34,56)));
        assertFalse((new Money(-12,34,56)).equals(new Money(12,34,56)));
    }

//-------------------------------------------------------------------------------

    /* COMPARE TO */
    // -1 less than | 0 equals | 1 greater than

    public void testCompareTo_EqualObjects() {
        assertEquals(0, (new Money()).compareTo(new Money(0,0,0)));
        assertEquals(0, (new Money(0,0)).compareTo(new Money(0,0,0)));
        assertEquals(0, (new Money(1,2,3)).compareTo(new Money(1,2,3)));

    }

    public void testCompareTo_GreaterThan_Positives() {
        assertEquals(1, (new Money(1,50)).compareTo(new Money(1,49,99)));
        assertEquals(1, (new Money(0,1,00)).compareTo(new Money(0,0,99)));
    }

    public void testCompareTo_GreaterThan_PosAndNeg() {
        assertEquals(1, (new Money(1,50)).compareTo(new Money(-1,50)));
        assertEquals(1, (new Money(1,50)).compareTo(new Money(-2,50,99)));
    }

    public void testCompareTo_GreaterThan_Negative() {
        assertEquals(1, (new Money(-15,00)).compareTo(new Money(-30,00)));
        assertEquals(1, (new Money(0,-40,0)).compareTo(new Money(0,-50,0)));
        assertEquals(1, (new Money(0, 0,-40)).compareTo(new Money(0,0,-50)));
    }

    public void testCompareTo_LessThan_Positive() {
        assertEquals(-1, (new Money(1,49,99)).compareTo(new Money(1,50)));
        assertEquals(-1, (new Money(0,0,99)).compareTo(new Money(0,1,00)));
    }

    public void testCompareTo_LessThan_PosAndNeg() {
        assertEquals(-1, (new Money(-1,50)).compareTo(new Money(1,50)));
        assertEquals(-1, (new Money(-2,50,99)).compareTo(new Money(1,50)));
    }

    public void testCompareTo_LessThan_Negative() {
        assertEquals(-1, (new Money(-30,00)).compareTo(new Money(-15,00)));
        assertEquals(-1, (new Money(0,-50,0)).compareTo(new Money(0,-40,0)));
        assertEquals(-1, (new Money(0, 0,-50)).compareTo(new Money(0,0,-40)));
    }


//-------------------------------------------------------------------------------

    /* ADD */

    public void testAdd_Zero_ZeroToMoneyObject() {
        assertEquals("$0.00", ((new Money(0,0,0)).add(new Money(0,0,0))).toString());
        assertEquals("$0.00", ((new Money(0,0)).add(new Money(0,0))).toString());

        assertEquals("$12.3456", ((new Money(12,34,56)).add(new Money(0,0,0))).toString());
        assertEquals("$12.34", ((new Money(12,34)).add(new Money(0,0,0))).toString());

    }

    public void testAdd_Zero_MoneyObjectToZero() {
        assertEquals("$12.3456", ((new Money(0,0,0)).add(new Money(12,34,56))).toString());
        assertEquals("$12.34", ((new Money(0,0,0)).add(new Money(12,34))).toString());
    }

    public void testAdd_PositivePlusPositive() {
        assertEquals("$20.00", ((new Money(10,00)).add(new Money(10,00))).toString());
        assertEquals("$0.20", ((new Money(0,10)).add(new Money(0,10))).toString());

        assertEquals("$110.00", ((new Money(55,0,0)).add(new Money(55,0,0))).toString());
        assertEquals("$1.10", ((new Money(0,55,0)).add(new Money(0,55,0))).toString());
        assertEquals("$0.011", ((new Money(0,0,55)).add(new Money(0,0,55))).toString());

        assertEquals("$24.6912", ((new Money(12,34,56)).add(new Money(12,34,56))).toString());
        assertEquals("$0.6912", ((new Money(0,34,56)).add(new Money(0,34,56))).toString());
        assertEquals("$24.0112", ((new Money(12,0,56)).add(new Money(12,0,56))).toString());
        assertEquals("$24.68", ((new Money(12,34,0)).add(new Money(12,34,0))).toString());
    }

    public void testAdd_PositivePlusNegative() {
        // different ordering of negative values
        assertEquals("-$20.00", ((new Money(10,00)).add(new Money(-30,00))).toString());
        assertEquals("-$20.00", ((new Money(-30,00)).add(new Money(10,00))).toString());

        assertEquals("-$0.20", ((new Money(0,10)).add(new Money(0,-30))).toString());
        assertEquals("-$0.20", ((new Money(0,-30)).add(new Money(0,10))).toString());

        assertEquals("$0.0044", ((new Money(0,0,-55)).add(new Money(0,0,99))).toString());
        assertEquals("-$0.0044", ((new Money(0,0,55)).add(new Money(0,0,-99))).toString());


        assertEquals("-$66.5645", ((new Money(12,34,56)).add(new Money(-78,91,01))).toString());
        assertEquals("$0.00", ((new Money(0,-34,56)).add(new Money(0,34,56))).toString());
        assertEquals("$98.9898", ((new Money(99,99,99)).add(new Money(-1,1,1))).toString());
        assertEquals("-$99.9999", ((new Money(-100,0,0)).add(new Money(0,0,1))).toString());
    }

    public void testAdd_NegativePlusNegative() {
        assertEquals("-$20.00", ((new Money(-10,00)).add(new Money(-10,00))).toString());
        assertEquals("-$0.20", ((new Money(0,-10)).add(new Money(0,-10))).toString());

        assertEquals("-$110.00", ((new Money(-55,0,0)).add(new Money(-55,0,0))).toString());
        assertEquals("-$1.10", ((new Money(0,-55,0)).add(new Money(0,-55,0))).toString());
        assertEquals("-$0.011", ((new Money(0,0,-55)).add(new Money(0,0,-55))).toString());


        assertEquals("-$24.6912", ((new Money(-12,34,56)).add(new Money(-12,34,56))).toString());
        assertEquals("-$0.6912", ((new Money(0,-34,56)).add(new Money(0,-34,56))).toString());
        assertEquals("-$24.0112", ((new Money(-12,0,56)).add(new Money(-12,0,56))).toString());
        assertEquals("-$24.68", ((new Money(-12,34,0)).add(new Money(-12,34,0))).toString());
    }

//-------------------------------------------------------------------------------

    /* MULTIPLY */

    public void testMultiply_ByZero() {
        assertEquals("$0.00", ((new Money(0,0,0)).multiply(0.0)).toString());
        assertEquals("$0.00", ((new Money(55,55,55)).multiply(0.0)).toString());
        assertEquals("$0.00", ((new Money(55,0,0)).multiply(0.0)).toString());
        assertEquals("$0.00", ((new Money(0,55,0)).multiply(0.0)).toString());
        assertEquals("$0.00", ((new Money(0,0,55)).multiply(0.0)).toString());
    }

    public void testMultiply_PositiveFactors_MultiplyPositiveMoneyObject() {
        assertEquals("$4.0815", ((new Money(4,8,15)).multiply(1.0)).toString());
        assertEquals("$40.815", ((new Money(4,8,15)).multiply(10.0)).toString());
    }

    public void testMultiply_PositiveFactors_MultiplyNegativeMoneyObject() {
        assertEquals("-$65.304", ((new Money(-4,8,15)).multiply(16.0)).toString());
        assertEquals("-$67.3448", ((new Money(-4,8,15)).multiply(16.5)).toString());
    }

    public void testMultiply_NegativeFactors_MultiplyPositiveMoneyObject() {
        assertEquals("-$4.0815", ((new Money(4,8,15)).multiply(-1.0)).toString());
        assertEquals("-$40.815", ((new Money(4,8,15)).multiply(-10.0)).toString());
    }

    public void testMultiply_NegativeFactors_MultiplyNegativeMoney() {
        assertEquals("$65.304", ((new Money(-4,8,15)).multiply(-16.0)).toString());
        assertEquals("$67.3447", ((new Money(-4,8,15)).multiply(-16.5)).toString());
    }


    public void testMultiply_RoundingToNearestHundreth() {
        //0.00055
        assertEquals("$0.0006", ((new Money(0,0,55)).multiply(0.1)).toString());
        //0.00025
        assertEquals("$0.0003", ((new Money(0,0,50)).multiply(0.05)).toString());
        //0.000025
        assertEquals("$0.00", ((new Money(0,0,50)).multiply(0.005)).toString());

        //0.000050
        assertEquals("$0.0001", ((new Money(0,0,50)).multiply(0.01)).toString());

        assertEquals("$0.00", ((new Money(49,99,99)).multiply(0.000001)).toString());
        assertEquals("$0.0001", ((new Money(99,99,99)).multiply(0.000001)).toString());
    }

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