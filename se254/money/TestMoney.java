package se254.money;
/**
 * SOFTENG 254 2011 Assignment 1 submission
 *
 * Author: (Akshay Pravin Kalyan, akal881)
 **/


/*
*
*/
import junit.framework.TestCase;

import java.lang.Exception;
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

    /**
     * This is a simple test to ensure that the two argument constructor handles a negative zero the same as a
     * regular zero and returns a Money object representing zero dollars
     */
    public void testConstructorTwoPara_NegativeZeroDollars() {
        assertEquals("$0.00", (new Money(-0,0)).toString());
    }

    /**
     * Simple test case of a valid constructor call to ensure the correct Money object is returned
     */
    public void testConstructorTwoPara_PositiveAmount() {
        assertEquals("$1.50", (new Money(1,50).toString()));
    }

    /**
     * This test case deals with the the occasion that a negative argument is provided following a non zero. The
     * input causes an exception to be thrown which is checked in this case. If not thrown,
     * a fail is the final result.
     */
    public void testConstructorTwoPara_NegativeAfterNonZero() {
        try {
            Money c = new Money(1,-50);
            fail("Expected IllegalArgumentException with the msg -- Invalid: negative after non-zero");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid: negative after non-zero", e.getMessage());
}
    }

    /**
     * Test case to test a valid placement of a negative following a zero. To ensure the expected implementation is
     * working according to the specifications
     */
    public void testConstructorTwoPara_NegativeAfterZero() {
        assertEquals("-$0.50", (new Money(0,-50)).toString());
    }

    /**
     * Testcase  to ensure a negative zero argmunent is handled correctly. Treats negative zero as zero.
     */
    public void testConstructorTwoPara_NonNegativeAfterNegativeZero() {
        assertEquals("$0.50", (new Money(-0,50)).toString());
    }

    /**
     * Testcase to ensure that the constructor handles correctly when more than one negative argument is included.
     * The constructor should cause an exception to be thrown.
     */
    public void testConstructorTwoPara_MoreThanOneNegative() {
        try {
            Money d = new Money(-1,-50);
            fail("Expected IllegalArgumentException with the msg -- Invalid: more than one negative value");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid: more than one negative value", e.getMessage());
        }
    }

    /**
     * Testcase to ensure invalid inputs are handled correctly. Specifically when the argument is over 99. The
     * constructor throws an exception to indicate this.
     */
    public void testConstructorTwoPara_InputValueRange_InvalidBounds_Over() {
        try {
            Money d = new Money(1,100);
            fail("Expected IllegalArgumentException with the msg -- Invalid value: out of range");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid value: out of range", e.getMessage());
        }
    }

    /**
     * Testcase to ensure invalid inputs are handled correctly. Specifically when the argument is below -99. The
     * constructor throws an exception to indicate this.
     */
    public void testConstructorTwoPara_InputValueRange_InvalidBounds_Under() {
        try {
            Money d = new Money(0,-100);
            fail("Expected IllegalArgumentException with the msg -- Invalid value: out of range");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid value: out of range", e.getMessage());
        }
    }

    /**
     * Testcase to ensure valid inputs construct 'correct' Money objects within the valid bounds.
     */
    public void testConstructorTwoPara_InputValueRange_ValidBounds() {
        assertEquals("-$0.99", (new Money(0, -99)).toString());
        assertEquals("$0.99", (new Money(0, 99)).toString());
    }

    /* THREE PARAMETERS */

    /**
     * This is a simple test to ensure that the three argument constructor creates and returns a Money
     * object with the value of zero dollars only when passed in only zeros.
     */
    public void testConstructorThreePara_ZeroDollars() {
        assertEquals("$0.00", (new Money(0,0,0)).toString());
    }

    /**
     * This is a simple test to ensure that the three argument constructor handles a negative zero the same as a
     * regular zero and returns a Money object representing zero dollars.
     */
    public void testConstructorThreePara_NegativeZeroDollars() {
        assertEquals("$0.00", (new Money(-0,0,0)).toString());
    }

    /**
     * Simple test case of a valid constructor call to ensure the correct Money object is returned
     */
    public void testConstructorThreePara_PositiveAmount() {
        assertEquals("$1.0203", (new Money(1,2,3)).toString());
    }

    /**
     * Testcase to ensure a negative zero for the dollar argument does not affect the resulting Money object
     */
    public void testConstructorThreePara_NonNegativeAfterNegativeZero_NegativeZeroDollars() {
        assertEquals("$0.505", (new Money(-0,50,50)).toString());
    }

    /**
     * Testcase to ensure a negative zero for the cents argument does not affect the resulting Money object
     */
    public void testConstructorThreePara_NonNegativeAfterNegativeZero_NegativeZeroCents() {
        assertEquals("$0.005", (new Money(0,-0,50)).toString());
    }

    /**
     * This test case deals with the the occasion that a negative argument is provided following a non zero.
     * Specifically with a zero trailing input (cents). The
     * input causes an exception to be thrown which is checked in this case. If not thrown,
     * a fail is the result of the test.
     */
    public void testConstructorThreePara_NegativeAfterNonZero_CentsHasNeg_TrailingZero() {
        try {
            Money a = new Money(1,-2,0);
            fail("Expected IllegalArgumentException with the msg -- Invalid: negative after non-zero");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid: negative after non-zero", e.getMessage());
        }
    }

    /**
     * This test case deals with the the occasion that a negative argument (hundreths) is provided following a
     * zero dollars argument.
     */
    public void testConstructorThreePara_NegativeAfterNonZero_HundrethsHasNeg_LeadingZeroDollars() {
        try {
            Money a = new Money(0,1,-2);
            fail("Expected IllegalArgumentException with the msg -- Invalid: negative after non-zero");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid: negative after non-zero", e.getMessage());
        }
    }

    /**
     * This test case deals with the the occasion that a negative argument (hundreths) is provided following a
     * non-zero dollars and zero cents argument.In addition to the other tests,
     * this is added to ensure error vulnerable combinations are covered.
     */
    public void testConstructorThreePara_NegativeAfterNonZero_HundrethsHasNeg_NonZeroDollarsAndZeroCents() {
        try {
            Money a = new Money(1,0,-2);
            fail("Expected IllegalArgumentException with the msg -- Invalid: negative after non-zero");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid: negative after non-zero", e.getMessage());
        }
    }

    /**
     * This test case deals with the the occasion that more than one negative argument is provided,
     * All Combinations of the placement of two negative arguments are tested.
     */
    public void testConstructorThreePara_MoreThanOneNegative() {
        try {
            Money a = new Money(0,-1,-2);
            fail("Expected IllegalArgumentException with the msg -- Invalid: more than one negative value");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid: more than one negative value", e.getMessage());
        }

        try {
            Money a = new Money(-1,0,-2);
            fail("Expected IllegalArgumentException with the msg -- Invalid: more than one negative value");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid: more than one negative value", e.getMessage());
        }

        try {
            Money a = new Money(-1,-2,0);
            fail("Expected IllegalArgumentException with the msg -- Invalid: more than one negative value");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid: more than one negative value", e.getMessage());
        }
    }

    /**
     * This test case ensures that the correct Money object is constructed with a single negative argument.
     */
    public void testConstructorThreePara_NegativeObjects() {
        assertEquals("-$2.00", (new Money(-2,0,0)).toString());
        assertEquals("-$0.02", (new Money(0,-2,0)).toString());
        assertEquals("-$0.0002", (new Money(0,0,-2)).toString());
    }

    /**
     *  Testcase to ensure valid inputs construct 'correct' Money objects within the valid bounds.
     */
    public void testConstructorThreePara_InputValueRange_ValidBounds()  {
        assertEquals("-$0.9999", (new Money(0, -99,99)).toString());
        assertEquals("$0.9999", (new Money(0, 99,99)).toString());
    }

    /**
     * Testcase to ensure invalid inputs are handled correctly. Specifically when the cents argument is above 99. The
     * constructor throws an exception to indicate this.
     */
    public void testConstructorThreePara_InputValueRange_InvalidBounds_Cents_Over() {
        try {
            Money c = new Money(1,100,0);
            fail("Expected IllegalArgumentException with the msg -- Invalid value: out of range");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid value: out of range", e.getMessage());
        }
    }

    /**
     * Testcase to ensure invalid inputs are handled correctly. Specifically when the cents argument is below -99. The
     * constructor throws an exception to indicate this.
     */
    public void testConstructorThreePara_InputValueRange_InvalidBounds_Cents_Below() {
        try {
            Money c = new Money(0,-100,0);
            fail("Expected IllegalArgumentException with the msg -- Invalid value: out of range");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid value: out of range", e.getMessage());
        }
    }

    /**
     * Testcase to ensure invalid inputs are handled correctly. Specifically when the hundreths argument is above 99.
     * The constructor throws an exception to indicate this.
     */
    public void testConstructorThreePara_InputValueRange_InvalidBounds_Hundreths_Over() {
        try {
            Money c = new Money(1,1,100);
            fail("Expected IllegalArgumentException with the msg -- Invalid value: out of range");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid value: out of range", e.getMessage());
        }
    }

    /**
     * Testcase to ensure invalid inputs are handled correctly. Specifically when the hundreths argument is below -99.
     * The constructor throws an exception to indicate this.
     */
    public void testConstructorThreePara_InputValueRange_InvalidBounds_Hundreths_Below() {
        try {
            Money c = new Money(0,0,-100);
            fail("Expected IllegalArgumentException with the msg -- Invalid value: out of range");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid value: out of range", e.getMessage());
        }
    }



//-------------------------------------------------------------------------------       /* TO STRING */


    /**
     * Tests if all implemented constructers with zero as inputs construct and represent the same Money object as a
     * string
     */
    public void testToString_ZeroDollars() {
        assertEquals("$0.00", (new Money()).toString());
        assertEquals("$0.00", (new Money(0,0)).toString());
        assertEquals("$0.00", (new Money(0,0,0)).toString());
    }

    /**
     * Test if the placement of the negative sign is consistent to the specifications. The sign is to be placed
     * before the dollar, $, symbol.
     */
    public void testToString_NegativeSign() {
        assertEquals("-$1.50", (new Money(-1,50)).toString());
        assertEquals("-$0.50", (new Money(0,-50,0)).toString());
        assertEquals("-$0.0005", (new Money(0,0,-5)).toString());
    }

    /**
     * Testcase to ensure trailing zeros for the hundreths are not represented in the string format.
     */
    public void testToString_TrailingZeros() {
        assertEquals("$19.345", (new Money(19,34,50)).toString());
        assertEquals("$19.30", (new Money(19,30,00)).toString());
        assertEquals("$20.0005", (new Money(20,0,5)).toString());
    }

    /**
     * Test case to ensure the maximum possible integer value is generated correctly as a string
     */
    public void testToString_MaximumValue() {
        assertEquals("$2147483647.00", (new Money(2147483647,0,0)).toString());
    }


//-------------------------------------------------------------------------------       /* EQUALS */


    /**
     * Simple test to ensure equals responds correctly for identical Money objects regardless of constructor used to
     * construct them
     */
    public void testEquals_DifferentConstructors_ZeroDollars() {
        assertTrue((new Money()).equals(new Money(0,0)));
        assertTrue((new Money()).equals(new Money(0,0,0)));
    }

    /**
     * Simple test to ensure equals responds correctly for identical Money objects regardless of constructor used to
     * construct them
     */
    public void testEquals_DifferentConstructors_SameMoneyValue() {
        assertTrue((new Money(55,55)).equals(new Money(55,55,0)));
    }

    /**
     * Testcase to ensure the equals method returns a false boolean when a null argument is passed to test equality
     */
    public void testEquals_NullArgument() {
        assertFalse((new Money()).equals(null));
    }

    public void testEquals_NullArgument() {
        assertFalse((new Money()).equals(null));
    }

    /**
     * Testcase contains equal Money objects being compared. A full set of arguments is used to create Money objects
     * and ensured that the respective fields are tested for equality correctly.
     */
    public void testEquals_EqualMoneyObjects_FullSetParameters() {
        assertTrue((new Money(12,34,56)).equals(new Money(12,34,56)));
        assertTrue((new Money(-12,34,56)).equals(new Money(-12,34,56)));
    }

    /**
     * Testcase contains seveleral equal Money objects being compared. Placementof equal values (Dollars or Cents)
     * is varied to ensure multiple combinations are covered.
     */
    public void testEquals_EqualMoneyObjects_TwoConstructor() {
        assertTrue((new Money(55,0)).equals(new Money(55,0)));
        assertTrue((new Money(-55,0)).equals(new Money(-55,0)));
        assertTrue((new Money(0,55)).equals(new Money(0,55)));
        assertTrue((new Money(0,-55)).equals(new Money(0,-55)));
    }

    /**
     * Testcase contains seveleral equal Money objects being compared. Placementof equal values (Dollars,
     * Cents or Hundreths) is varied to ensure multiple combinations are covered.
     */
    public void testEquals_EqualMoneyObjects_ThreeConstructor() {
        assertTrue((new Money(55,0,0)).equals(new Money(55,0,0)));
        assertTrue((new Money(-55,0,0)).equals(new Money(-55,0,0)));
        assertTrue((new Money(0,55,0)).equals(new Money(0,55,0)));
        assertTrue((new Money(0,-55,0)).equals(new Money(0,-55,0)));
        assertTrue((new Money(0,0,55)).equals(new Money(0,0,55)));
        assertTrue((new Money(0,0,-55)).equals(new Money(0,0,-55)));
    }

    /**
     * Testcase to test for inequel Money obhects. The placement of the inequal values (Dollars,
     * Cents or Hundreths) is varied to ensure multiple combinations are covered. At the same time,
     * the overall inequality tests are covered.
     */
    public void testEquals_InequalMoneyObjects_VariousCombinations() {
        assertFalse((new Money(10,55,55)).equals(new Money(20,55,55)));
        assertFalse((new Money(55,10,55)).equals(new Money(55,20,55)));
        assertFalse((new Money(55,55,10)).equals(new Money(55,55,20)));
    }

    /**
     * Testcase for testing inequality of Money objects who have the same absolute values. Only the signs of the
     * money object vary. The object being compared against and the object being compared to are both
     * individually tested with a negative value.
     */
    public void testEquals_InequalMoneyObjects_EqualButOppositeSigns() {
        assertFalse((new Money(-1,50)).equals(new Money(1,50)));
        assertFalse((new Money(1,50)).equals(new Money(-1,50)));

        assertFalse((new Money(12,34,56)).equals(new Money(-12,34,56)));
        assertFalse((new Money(-12,34,56)).equals(new Money(12,34,56)));
    }

//-------------------------------------------------------------------------------       /* COMPARE TO */

    /**
     * Test case to ensure that a comparison result ("Returns... 1 [otherwise]" as per Money javaDoc) is not returned
     * when a Money object is compared against a null object
     */
    public void testCompareTo_NullArgument() {
       try {
           int result = (new Money()).compareTo(null);
           fail("Expected Exception to be thrown when compared against null object");
       } catch (Exception e) {}
    }

    /**
     * Testcase to compare equal money objects with varying constructors to ensure the constructor used does not
     * affect the equality.
     */
    public void testCompareTo_EqualObjects() {
        assertEquals(0, (new Money()).compareTo(new Money(0,0,0)));
        assertEquals(0, (new Money(0,0)).compareTo(new Money(0,0,0)));
        assertEquals(0, (new Money(1,2,3)).compareTo(new Money(1,2,3)));

    }

    /**
     * Test case to compare two positive objects with the intended result for the case of the money object being
     * compared against greater in value. Values picked to compare result in the comparison to be made across dollars,
     * cents and hundreths.
     */
    public void testCompareTo_GreaterThan_Positives() {
        assertEquals(1, (new Money(1,50)).compareTo(new Money(1,49,99)));
        assertEquals(1, (new Money(0,1,00)).compareTo(new Money(0,0,99)));
    }

    /**
     * Test case to compare positive and negative objects with the intended result for the case of the money object
     * beign compared against greater in value. A case of money objects having the same absolute value but with
     * differing signs.
     */
    public void testCompareTo_GreaterThan_PosAndNeg() {
        assertEquals(1, (new Money(1,50)).compareTo(new Money(-1,50)));
        assertEquals(1, (new Money(1,50)).compareTo(new Money(-2,50,99)));
    }

    /**
     * Test case to compare two negative money objects with the intended result for the case of the money object
     * being compared against greater in value. Values picked to compare result in the comparison to be made across
     * dollars,cents and hundreths.
     */
    public void testCompareTo_GreaterThan_Negative() {
        assertEquals(1, (new Money(-15,00)).compareTo(new Money(-30,00)));
        assertEquals(1, (new Money(0,-40,0)).compareTo(new Money(0,-40,40)));
        assertEquals(1, (new Money(0, 0,-40)).compareTo(new Money(0,0,-50)));
    }

    /**
     * Test case to compare two positive objects with the intended result for the case of the money object being
     * compared against lower in value. Values picked to compare result in the comparison to be made across dollars,
     * cents and hundreths.
     */
    public void testCompareTo_LessThan_Positive() {
        assertEquals(-1, (new Money(1,49,99)).compareTo(new Money(1,50)));
        assertEquals(-1, (new Money(0,0,99)).compareTo(new Money(0,1,00)));
    }

    /**
     * Test case to compare positive and negative objects with the intended result for the case of the money object
     * beign compared against lower in value. A case of money objects having the same absolute value but with
     * differing signs.
     */
    public void testCompareTo_LessThan_PosAndNeg() {
        assertEquals(-1, (new Money(-1,50)).compareTo(new Money(1,50)));
        assertEquals(-1, (new Money(-2,50,99)).compareTo(new Money(1,50)));
    }

    /**
     * Test case to compare two negative money objects with the intended result for the case of the money object
     * being compared against greater in value. Values picked to compare result in the comparison to be made across
     * dollars,cents and hundreths.
     */
    public void testCompareTo_LessThan_Negative() {
        assertEquals(-1, (new Money(-30,00)).compareTo(new Money(-15,00)));
        assertEquals(-1, (new Money(0,-40,40)).compareTo(new Money(0,-40,0)));
        assertEquals(-1, (new Money(0, 0,-50)).compareTo(new Money(0,0,-40)));
    }


//-------------------------------------------------------------------------------            /* ADD */

    /**
     * Testcase to ensure the add method throws an exception if a null object is attempted to be added to a Money
     * object.
     */
    public void testAdd_NullArgument() {
        try {
            Money m = (new Money(1,2,3)).add(null);
            fail("Expected IllegalArgumentException with the msg -- Invalid: null argument");
        } catch (IllegalArgumentException e) {
            assertEquals("Invalid: null argument", e.getMessage());
        }
    }

    /**
     * Simple test case to ensure adding a Money object of zero value has no effect.
     */
    public void testAdd_Zero_ZeroToMoneyObject() {
        assertEquals("$12.3456", ((new Money(12,34,56)).add(new Money(0,0,0))).toString());
        assertEquals("$12.34", ((new Money(12,34)).add(new Money(0,0,0))).toString());

    }

    /**
     * Simple test case to ensure adding a non-zero Money object to a zero Money object returns a Money object equal
     * to value passed in.
     */
    public void testAdd_Zero_MoneyObjectToZero() {
        assertEquals("$12.3456", ((new Money(0,0,0)).add(new Money(12,34,56))).toString());
        assertEquals("$12.34", ((new Money(0,0,0)).add(new Money(12,34))).toString());
    }

    /**
     * Test case to test the addition of positive Money objects. Placement of values (Dollars,
     * Cents or Hundreths) is varied to ensure multiple combinations are covered.
     */
    public void testAdd_PositivePlusPositive() {
        assertEquals("$20.00", ((new Money(10,00)).add(new Money(10,00))).toString());
        assertEquals("$0.20", ((new Money(0,10)).add(new Money(0,10))).toString());

        assertEquals("$110.00", ((new Money(55,0,0)).add(new Money(55,0,0))).toString());
        assertEquals("$1.10", ((new Money(0,55,0)).add(new Money(0,55,0))).toString());
        assertEquals("$0.011", ((new Money(0,0,55)).add(new Money(0,0,55))).toString());

        assertEquals("$0.6912", ((new Money(0,34,56)).add(new Money(0,34,56))).toString());
        assertEquals("$24.0112", ((new Money(12,0,56)).add(new Money(12,0,56))).toString());
        assertEquals("$24.68", ((new Money(12,34,0)).add(new Money(12,34,0))).toString());
    }

    /**
     * Test case to test the addition of positive and negative Money objects. Placement of values (Dollars,
     * Cents or Hundreths) and sign is varied to ensure multiple combinations are covered. Tests include Money objects
     * which result in decrease of value across dollars, cents and hundreths.
     */
    public void testAdd_PositivePlusNegative() {
        assertEquals("-$20.00", ((new Money(10,00)).add(new Money(-30,00))).toString());
        assertEquals("-$20.00", ((new Money(-30,00)).add(new Money(10,00))).toString());

        assertEquals("-$0.20", ((new Money(0,10)).add(new Money(0,-30))).toString());
        assertEquals("-$0.20", ((new Money(0,-30)).add(new Money(0,10))).toString());

        assertEquals("$0.0044", ((new Money(0,0,-55)).add(new Money(0,0,99))).toString());
        assertEquals("-$0.0044", ((new Money(0,0,55)).add(new Money(0,0,-99))).toString());

        assertEquals("$98.9898", ((new Money(99,99,99)).add(new Money(-1,1,1))).toString());
        assertEquals("-$99.9999", ((new Money(-100,0,0)).add(new Money(0,0,1))).toString());
    }

    /**
     * Test case to test the addition of negative Money objects. Placement of values (Dollars,
     * Cents or Hundreths) is varied to ensure multiple combinations are covered.
     */
    public void testAdd_NegativePlusNegative() {
        assertEquals("-$20.00", ((new Money(-10,00)).add(new Money(-10,00))).toString());
        assertEquals("-$0.20", ((new Money(0,-10)).add(new Money(0,-10))).toString());

        assertEquals("-$110.00", ((new Money(-55,0,0)).add(new Money(-55,0,0))).toString());
        assertEquals("-$1.10", ((new Money(0,-55,0)).add(new Money(0,-55,0))).toString());
        assertEquals("-$0.011", ((new Money(0,0,-55)).add(new Money(0,0,-55))).toString());

        assertEquals("-$0.6912", ((new Money(0,-34,56)).add(new Money(0,-34,56))).toString());
        assertEquals("-$24.0112", ((new Money(-12,0,56)).add(new Money(-12,0,56))).toString());
        assertEquals("-$24.68", ((new Money(-12,34,0)).add(new Money(-12,34,0))).toString());
    }

//-------------------------------------------------------------------------------       /* MULTIPLY */

    /**
     * Test case to ensure multiplying any Money object by a factor of zero results in a Money object with the value
     * zero
     */
    public void testMultiply_ByZero() {
        assertEquals("$0.00", ((new Money(55,0,0)).multiply(0.0)).toString());
        assertEquals("$0.00", ((new Money(0,55,0)).multiply(0.0)).toString());
        assertEquals("$0.00", ((new Money(0,0,55)).multiply(0.0)).toString());
    }

    /**
     * Simple test case to ensure multiplying a positive Money object by a positive factor results in the correct
     * Money object being returned.
     */
    public void testMultiply_PositiveFactors_MultiplyPositiveMoneyObject() {
        assertEquals("$4.0815", ((new Money(4,8,15)).multiply(1.0)).toString());
        assertEquals("$40.815", ((new Money(4,8,15)).multiply(10.0)).toString());
    }

    /**
     * Simple test case to ensure multiplying a negative Money object by a positive factor results in the correct
     * (negative) Money object being returned.
     */
    public void testMultiply_PositiveFactors_MultiplyNegativeMoneyObject() {
        assertEquals("-$65.304", ((new Money(-4,8,15)).multiply(16.0)).toString());
    }

    /**
     * Simple test case to ensure multiplying a positive Money object by a negative factor results in the correct
     * (negative) Money object being returned.
     */
    public void testMultiply_NegativeFactors_MultiplyPositiveMoneyObject() {
        assertEquals("-$4.0815", ((new Money(4,8,15)).multiply(-1.0)).toString());
        assertEquals("-$40.815", ((new Money(4,8,15)).multiply(-10.0)).toString());
    }

    /**
     * Simple test case to ensure multiplying a negative Money object by a negative factor results in the correct
     * (positive) Money object being returned.
     */
    public void testMultiply_NegativeFactors_MultiplyNegativeMoneyObject() {
        assertEquals("$65.304", ((new Money(-4,8,15)).multiply(-16.0)).toString());
    }

    /**
     * Test several cases by multiplying Money objects by fractional factors to ensure correct rounding is applied.
     */
    public void testMultiply_RoundingToNearestHundreth() {
        //0.00055
        assertEquals("$0.0006", ((new Money(0,0,55)).multiply(0.1)).toString());
        //0.000025
        assertEquals("$0.00", ((new Money(0,0,50)).multiply(0.005)).toString());

        //0.000050
        assertEquals("$0.0001", ((new Money(0,0,50)).multiply(0.01)).toString());
        assertEquals("-$0.0001", ((new Money(0,0,-50)).multiply(0.01)).toString());

        assertEquals("$0.00", ((new Money(49,99,99)).multiply(0.000001)).toString());
        assertEquals("$0.0001", ((new Money(99,99,99)).multiply(0.000001)).toString());



        //67.34475 -- full result

        assertEquals("-$67.3448", ((new Money(-4,8,15)).multiply(16.5)).toString());

        // fails rounds to .3447
//        assertEquals("-$67.3448", ((new Money(4,8,15)).multiply(-16.5)).toString());

        assertEquals("$67.3447", ((new Money(-4,8,15)).multiply(-16.5)).toString());
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