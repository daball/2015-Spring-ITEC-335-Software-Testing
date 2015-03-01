/**
 * This is a simulation of DegreeWorks audits for minors.
 * 
 * Contains audit logic for calculations of:
 * 
 *   * MATHEMATICS MINOR
 *   * STATISTICS MINOR
 *   * MEDIA STUDIES MINOR 
 * 
 * Per the assignment specification, only mathMinor and statMinor
 * contain implementations (for white box testing), and only
 * mediaStudiesMinor contain method stubs (for black box testing).
 * 
 * @author David A. Ball <daball@email.radford.edu>
 * @version 20150228131200
 */
public class AuditMinor
{
    /**
     * Also, for simplicity for these homework problems,
     * you may assume that each course is 3 credit hours. 
     */
    protected final int CREDIT_HOURS_PER_COURSE = 3;
    
    /**
     * Instructor-provided example.
     * 
     * MATHEMATICS MINOR
     * (18 semester hours)
     * MATH 151, MATH 152, MATH 251 and MATH 260 and at least two
     * courses chosen from among MATH 252, MATH 300, MATH 321,
     * any 400-level mathematics course, or any 300 or 400-level
     * statistics course.
     * 
     * @param mathCourses An array of math courses the student has completed.
     * @param statCourses An array of statistic courses the student has completed.
     * @return Returns true if MATHEMATICS MINOR audit verifies
     * student has completed curriculum requirements, otherwise false.
     * @see void AuditMinorTest.testMathMinor() for instructor-provided
     * test example. 
     */
    public boolean mathMinor(int[] mathCourses, int[] statCourses)
    {
        boolean minorSatisfied = false;
        boolean math151 = false;
        boolean math152 = false;
        boolean math251 = false;
        boolean math260 = false;
        int electives = 0;
        for (int c = 0; c < mathCourses.length; c++)
        {
            if (mathCourses[c] == 151)
                math151 = true;
            else if (mathCourses[c] == 152)
                math152 = true;
            else if (mathCourses[c] == 251)
                math251 = true;
            else if (mathCourses[c] == 260)
                math260 = true;
            else if (mathCourses[c] == 252)
                electives++;
            else if (mathCourses[c] == 300)
                electives++;
            else if (mathCourses[c] == 321)
                electives++;
            else if (mathCourses[c] >= 400)
                electives++;
        }
        for (int c = 0; c < statCourses.length; c++)
        {
            if (statCourses[c] >= 300)
                electives++;
        }
        if (   math151
            && math152
            && math251
            && math260
            && (electives >= 2) )
            minorSatisfied = true;
        return minorSatisfied;
    }
    
    /**
     * Student developed method in response to Homework6 assignment.
     * 
     * STATISTICS MINOR  
     * (18 semester hours)
     * Eighteen semester hours are required in mathematics or
     * statistics, including at least three semester hours in a
     * calculus course (MATH 126 or 151). At least 12 of the 18
     * hours must be in statistics.
     * 
     * @param mathCourses An array of math courses the student has completed.
     * @param statCourses An array of statistic courses the student has completed.
     * @return Returns true if STATISTICS MINOR audit verifies
     * student has completed curriculum requirements, otherwise false. 
     * @see void AuditMinorTest.testStatMinor() for white box test.
     */
    public boolean statMinor(int[] mathCourses, int[] statCourses)
    {
        /* SET UP TESTS */
        
        //in order to satisfy the minor requirements, there is a minimum number
        //of required math and/or statistics credit hours
        final int requiredSemesterHours = 18;
        
        //in order to satisfy the minor requirements, at least 12 of the 18+
        //credits must be in statistics
        final int requiredStatisticsHours = 12;
        
        //in order to satisfy the minor requirements, the student must complete
        //any calculus course (MATH 126 or 151)
        final int[] anyOfRequiredMathCourses = { 126, 151 };

        /* TEST 1: Required semester hours */
        
        //calculate semester hours based only on the assumption that
        //credit hours per course is a constant value
        int mathHours = (mathCourses.length * CREDIT_HOURS_PER_COURSE);
        int statisticsHours = (statCourses.length * CREDIT_HOURS_PER_COURSE); 
        int semesterHours = mathHours + statisticsHours;
        
        //test semester hours are satisfied
        boolean semesterHoursSatisfied = semesterHours >= requiredSemesterHours;
        
        //if semester hours are not satisfied, return false
        if (!semesterHoursSatisfied)
            return false;
        
        /* TEST 2: Required statistics hours */
        
        //statistics hours were previously calculated for TEST 1
        
        //test statistics hours are satisfied
        boolean statisticsHoursSatisfied = statisticsHours >= requiredStatisticsHours;

        //if statistics hours are not satisfied, return false
        if (!statisticsHoursSatisfied)
            return false;
        
        /* TEST 3: Required math courses */
        
        //initially, the math course has not been found
        boolean anyRequiredMathCoursesFound = false;
        
        //walk through the array of mathCourses (outer loop), searching for
        //anyOfRequiredMathCourses values (inner loop). additional logic stops
        //looping once anyOfRequiredMathCourses value is located in the
        //mathCourses array
        for (int m = 0; m < mathCourses.length &&
                        !anyRequiredMathCoursesFound; m++)
            for (int a = 0; a < anyOfRequiredMathCourses.length &&
                            !anyRequiredMathCoursesFound; a++)
                if (mathCourses[m] == anyOfRequiredMathCourses[a])
                    anyRequiredMathCoursesFound = true;
        
        //if any of the required math courses have not been found, return false
        if (!anyRequiredMathCoursesFound)
            return false;

        /* ALL TESTS COMPLETE */
        
        //if no tests have failed, the student meets the requirements for the
        //STATISTICS MINOR per the catalog requirements
        return true;
    }
 
    /**
     * TODO: Implement mediaStudiesMinor method.
     * 
     * Student developed method stub in response to Homework6 assignment.
     * 
     * MEDIA STUDIES MINOR
     * The minor in Media Studies consists of 18 semester hours
     * and includes the following nine semester hours of core
     * courses: COMS 130, COMS 335 and COMS 400. The remaining
     * nine semester hours may be chosen from any other COMS
     * courses offered.
     * 
     * @param comsCourses An array of communications courses the student has completed.
     * @return Throws an UnsupportedOperationException instance. Upon successful
     * implementation, will return true if MEDIA STUDIES MINOR audit
     * verifies student has completed curriculum requirements, otherwise
     * will return false.
     * @see void AuditMinorTest.testMediaStudiesMinor() for black box test.
     */
    public boolean mediaStudiesMinor(int[] comsCourses)
    {
        throw new UnsupportedOperationException("mediaStudiesMinor method stub: method not implemented.");
    }
}