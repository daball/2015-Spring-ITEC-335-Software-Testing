import static org.junit.Assert.*;
import org.junit.Test;

/**
 * This is a simulation of testing audit logic for DegreeWorks
 * audits for minors.
 * 
 * Contains tests of audit logic for calculations of:
 * 
 *   * MATHEMATICS MINOR
 *   * STATISTICS MINOR
 *   * MEDIA STUDIES MINOR 
 * 
 * testMathMinor is an instructor-provided example.
 * 
 * Per the assignment specification, both testStatMinor() and
 * testMediaStudiesMinor() require testing, and testStatMinor()
 * must be developed in a white-box testing environment and
 * testMediaStudiesMinor() must be developed in a black-box
 * testing environment.
 * 
 * To achieve a black-box testing environment, only a method
 * stub is created for the AuditMinor.mediaStudiesMinor() method.
 * In the case of black-box testing the audit logic, we are only
 * provided the specification in the form of documentation from the
 * catalog requirements.
 * 
 * All tests presume that each course counts as 3 credit hours, per
 * the assignment (for the sake of simplicity).
 * 
 * @author David A. Ball <daball@email.radford.edu>
 * @version 20150228131200
 */
public class AuditMinorTest
{
    @Test
    /**
     * Instructor-provided test example.
     * 
     * Test for:
     * 
     * MATHEMATICS MINOR
     * (18 semester hours)
     * MATH 151, MATH 152, MATH 251 and MATH 260 and at least two
     * courses chosen from among MATH 252, MATH 300, MATH 321,
     * any 400-level mathematics course, or any 300 or 400-level
     * statistics course.
     * 
     * @see boolean AuditMinor.mathMinor(int[], int[]) for class implementation.
     */
    public void testMathMinor()
    {
        AuditMinor minor = new AuditMinor();
        int[] m0  = { };
        int[] m1  = { 151 };
        int[] m7  = { 151,152,251,260,252,300,321 };
        int[] m6a = {     152,251,260,252,300,321 };
        int[] m6b = { 151,    251,260,252,300,321 };
        int[] m6c = { 151,152,    260,252,300,321 };
        int[] m6d = { 151,152,251,    252,300,321 };
        int[] m6e = { 151,152,251,260,    300,321 };
        int[] m6f = { 151,152,251,260,252,    321 };
        int[] m6g = { 151,152,251,260,252,300     };
        int[] m6h = { 151,152,251,260,        403,412 };
        int[] m6i = { 138,137,140,142,112,151 };
        int[] m4  = { 151,152,251,260 };
        int[] s0  = { };
        int[] s1  = { 301 };
        int[] s2  = { 302,301 };
        int[] s5  = { 200,301,302,421,420 };
        assertEquals(false, minor.mathMinor(m1,  s1));
        assertEquals(true,  minor.mathMinor(m7,  s1));
        assertEquals(true,  minor.mathMinor(m7,  s0));
        assertEquals(false, minor.mathMinor(m6a, s1));
        assertEquals(false, minor.mathMinor(m6b, s1));
        assertEquals(false, minor.mathMinor(m6c, s1));
        assertEquals(false, minor.mathMinor(m6d, s1));
        assertEquals(true,  minor.mathMinor(m6e, s1));
        assertEquals(true,  minor.mathMinor(m6f, s1));
        assertEquals(true,  minor.mathMinor(m6g, s1));
        assertEquals(true,  minor.mathMinor(m6h, s0));
        assertEquals(false, minor.mathMinor(m6i, s0));
        assertEquals(false, minor.mathMinor(m4,  s0));
        assertEquals(false, minor.mathMinor(m4,  s1));
        assertEquals(true,  minor.mathMinor(m4,  s2));
        assertEquals(false, minor.mathMinor(m0,  s0));
        assertEquals(false, minor.mathMinor(m1,  s5));
    }

    @Test
    /**
     * Student developed white-box test in response to Homework6 assignment.
     * 
     * White-box test for:
     * 
     * STATISTICS MINOR  
     * (18 semester hours)
     * Eighteen semester hours are required in mathematics or
     * statistics, including at least three semester hours in a
     * calculus course (MATH 126 or 151). At least 12 of the 18
     * hours must be in statistics.
     * 
     * @see boolean AuditMinor.statMinor(int[], int[]) for class implementation.
     */
    public void testStatMinor()
    {
        AuditMinor minor = new AuditMinor();
        
        //using instructor-provided test case values from testMathMinor() test method
        int[] m0  = { };
        int[] m1  = { 151 };
        int[] m7  = { 151,152,251,260,252,300,321 };
        int[] m6a = {     152,251,260,252,300,321 };
        int[] m6b = { 151,    251,260,252,300,321 };
        int[] m6c = { 151,152,    260,252,300,321 };
        int[] m6d = { 151,152,251,    252,300,321 };
        int[] m6e = { 151,152,251,260,    300,321 };
        int[] m6f = { 151,152,251,260,252,    321 };
        int[] m6g = { 151,152,251,260,252,300     };
        int[] m6h = { 151,152,251,260,        403,412 };
        int[] m6i = { 138,137,140,142,112,151 };
        int[] m4  = { 151,152,251,260 };
        int[] s0  = { };
        int[] s1  = { 301 };
        int[] s2  = { 302,301 };
        int[] s5  = { 200,301,302,421,420 };
        
        //additional statistics test case values
        int[] s3     = { 200,301,302 };
        int[] s4     = { 200,301,302,421 };

        //these test case values must not include a Calculus course
        //(any of 126 or 151) in order to validate TEST REQUIREMENT 3 
        int[] bad_m2 = { 152, 251 };
        int[] bad_m3 = { 152, 251, 260 };
        
        //prior test case values only checked for MATH 151, but we need
        //to also test for MATH 126 and both MATH 126 and 151
        int[] m1a = { 126 };
        int[] m2  = { 126, 151 };

        /* TEST REQUIREMENT 1: Student does not meet required semester hours (18) */
        
        //false value is required for these tests to pass for the reason
        //semester hours less than 18
        
        assertFalse(minor.statMinor(m0, s0)); //0 semester hours
        assertFalse(minor.statMinor(m1, s0)); //3 semester hours
        assertFalse(minor.statMinor(m1, s1)); //6 semester hours
        assertFalse(minor.statMinor(m1, s2)); //9 semester hours
        assertFalse(minor.statMinor(m4, s0)); //12 semester hours
        assertFalse(minor.statMinor(m0, s5)); //15 semester hours
        
        /* TEST REQUIREMENT 2: Student must meet required semester hours (18), but not
         * have the required statistics hours (12).
         */
        
        //false value is required for these tests to pass for the reason
        //statistics hours less than 12
        
        assertFalse(minor.statMinor(m6a, s0)); //0 statistics hours
        assertFalse(minor.statMinor(m6b, s0)); //0 statistics hours
        assertFalse(minor.statMinor(m6c, s0)); //0 statistics hours
        assertFalse(minor.statMinor(m6d, s0)); //0 statistics hours
        assertFalse(minor.statMinor(m6e, s0)); //0 statistics hours
        assertFalse(minor.statMinor(m6f, s0)); //0 statistics hours
        assertFalse(minor.statMinor(m6g, s0)); //0 statistics hours
        assertFalse(minor.statMinor(m6h, s0)); //0 statistics hours
        assertFalse(minor.statMinor(m6i, s0)); //0 statistics hours
        assertFalse(minor.statMinor(m7, s0));  //0 statistics hours
        
        assertFalse(minor.statMinor(m6a, s1)); //3 statistics hours
        assertFalse(minor.statMinor(m6b, s1)); //3 statistics hours
        assertFalse(minor.statMinor(m6c, s1)); //3 statistics hours
        assertFalse(minor.statMinor(m6d, s1)); //3 statistics hours
        assertFalse(minor.statMinor(m6e, s1)); //3 statistics hours
        assertFalse(minor.statMinor(m6f, s1)); //3 statistics hours
        assertFalse(minor.statMinor(m6g, s1)); //3 statistics hours
        assertFalse(minor.statMinor(m6h, s1)); //3 statistics hours
        assertFalse(minor.statMinor(m6i, s1)); //3 statistics hours
        assertFalse(minor.statMinor(m7, s1));  //3 statistics hours
        
        assertFalse(minor.statMinor(m6a, s2)); //6 statistics hours
        assertFalse(minor.statMinor(m6b, s2)); //6 statistics hours
        assertFalse(minor.statMinor(m6c, s2)); //6 statistics hours
        assertFalse(minor.statMinor(m6d, s2)); //6 statistics hours
        assertFalse(minor.statMinor(m6e, s2)); //6 statistics hours
        assertFalse(minor.statMinor(m6f, s2)); //6 statistics hours
        assertFalse(minor.statMinor(m6g, s2)); //6 statistics hours
        assertFalse(minor.statMinor(m6h, s2)); //6 statistics hours
        assertFalse(minor.statMinor(m6i, s2)); //6 statistics hours
        assertFalse(minor.statMinor(m7, s2));  //6 statistics hours

        assertFalse(minor.statMinor(m6a, s3)); //9 statistics hours
        assertFalse(minor.statMinor(m6b, s3)); //9 statistics hours
        assertFalse(minor.statMinor(m6c, s3)); //9 statistics hours
        assertFalse(minor.statMinor(m6d, s3)); //9 statistics hours
        assertFalse(minor.statMinor(m6e, s3)); //9 statistics hours
        assertFalse(minor.statMinor(m6f, s3)); //9 statistics hours
        assertFalse(minor.statMinor(m6g, s3)); //9 statistics hours
        assertFalse(minor.statMinor(m6h, s3)); //9 statistics hours
        assertFalse(minor.statMinor(m6i, s3)); //9 statistics hours
        assertFalse(minor.statMinor(m7, s3));  //9 statistics hours
        
        /* TEST REQUIREMENT 3: Student must meet required semester hours (18) and
         * have the required statistics hours (12) and not have completed any of
         * the required math courses.
         */
        assertFalse(minor.statMinor(bad_m2, s4)); //0 calculus courses
        assertFalse(minor.statMinor(bad_m3, s4)); //0 calculus courses
        assertFalse(minor.statMinor(m6a, s4));    //0 calculus courses
        assertFalse(minor.statMinor(m6a, s5));    //0 calculus courses
        
        /* TEST REQUIREMENT 4: When all prior assertions have passed, which are
         * such that the student has not met the requirements of the
         * STATISTICS MINOR, then in the case that the student has met all of the
         * requirements of the STATISTICS MINOR the assertion must be a true
         * predicate.  
         */        
        assertTrue(minor.statMinor(m2, s4)); //requirements met
        assertTrue(minor.statMinor(m7, s4)); //requirements met
        assertTrue(minor.statMinor(m6b, s4)); //requirements met
        assertTrue(minor.statMinor(m6c, s4)); //requirements met
        assertTrue(minor.statMinor(m6d, s4)); //requirements met
        assertTrue(minor.statMinor(m6e, s4)); //requirements met
        assertTrue(minor.statMinor(m6f, s4)); //requirements met
        assertTrue(minor.statMinor(m6g, s4)); //requirements met
        assertTrue(minor.statMinor(m6h, s4)); //requirements met
        assertTrue(minor.statMinor(m6i, s4)); //requirements met
        assertTrue(minor.statMinor(m4, s4)); //requirements met
        
        assertTrue(minor.statMinor(m1, s5)); //requirements met
        assertTrue(minor.statMinor(m1a, s5)); //requirements met
        assertTrue(minor.statMinor(m2, s5)); //requirements met
        assertTrue(minor.statMinor(m7, s5)); //requirements met
        assertTrue(minor.statMinor(m6b, s5)); //requirements met
        assertTrue(minor.statMinor(m6c, s5)); //requirements met
        assertTrue(minor.statMinor(m6d, s5)); //requirements met
        assertTrue(minor.statMinor(m6e, s5)); //requirements met
        assertTrue(minor.statMinor(m6f, s5)); //requirements met
        assertTrue(minor.statMinor(m6g, s5)); //requirements met
        assertTrue(minor.statMinor(m6h, s5)); //requirements met
        assertTrue(minor.statMinor(m6i, s5)); //requirements met
        assertTrue(minor.statMinor(m4, s5)); //requirements met
    }
    
    @Test
    /**
     * Student developed black-box test in response to Homework6 assignment.
     * 
     * Black-box test for:
     * 
     * MEDIA STUDIES MINOR
     * The minor in Media Studies consists of 18 semester hours
     * and includes the following nine semester hours of core
     * courses: COMS 130, COMS 335 and COMS 400. The remaining
     * nine semester hours may be chosen from any other COMS
     * courses offered.
     * 
     * @see boolean AuditMinor.mediaStudiesMinor(int[]) for class implementation.
     */
    public void testMediaStudiesMinor()
    {
        AuditMinor minor = new AuditMinor();
        
        //invalid test case values (not enough semester hours)
        int[] coms0 = { };
        int[] coms1 = { 130 };
        int[] coms2 = { 130, 335 };
        int[] coms3 = { 130, 335, 400 };
        int[] coms4 = { 130, 335, 400, 330 };
        int[] coms5 = { 130, 335, 400, 330, 314 };
        
        //invalid test case values (correct semester hours, doesn't meet
        //core requirements)
        int[] bad6a = {      335, 400, 330, 314, 408, 430 };
        int[] bad6b = { 130,      400, 330, 314, 408, 430 };
        int[] bad6c = { 130, 335,      330, 314, 408, 430 };
        
        //valid test case values (meets all requirements)
        int[] coms6 = { 130, 335, 400, 330, 314, 408, 430 };
        int[] coms7 = { 130, 335, 400, 330, 314, 408, 430, 451 };
        int[] coms8 = { 130, 335, 400, 330, 314, 408, 430, 451, 452 };
        int[] mixd6 = { 400, 408, 430, 130, 335, 314, 451 };
        
        /* TEST REQUIREMENT 1: Student does not meet required semester hours (18) */
        assertFalse(minor.mediaStudiesMinor(coms0));
        assertFalse(minor.mediaStudiesMinor(coms1));
        assertFalse(minor.mediaStudiesMinor(coms2));
        assertFalse(minor.mediaStudiesMinor(coms3));
        assertFalse(minor.mediaStudiesMinor(coms4));
        assertFalse(minor.mediaStudiesMinor(coms5));
        
        /* TEST REQUIREMENT 2: Student meets required semester hours (18), but does
         * not complete the core requirements. */
        assertFalse(minor.mediaStudiesMinor(bad6a));
        assertFalse(minor.mediaStudiesMinor(bad6b));
        assertFalse(minor.mediaStudiesMinor(bad6c));
        
        /* TEST REQUIREMENT 3: When all prior assertions have passed, which are
         * such that the student has not met the requirements of the
         * MEDIA STUDIES MINOR, then in the case that the student has met all of
         * the requirements of the MEDIA STUDIES MINOR the assertion must be a true
         * predicate.  
         */
        assertTrue(minor.mediaStudiesMinor(coms6));
        assertTrue(minor.mediaStudiesMinor(mixd6));
        assertTrue(minor.mediaStudiesMinor(coms7));
        assertTrue(minor.mediaStudiesMinor(coms8));
    }
}