package survey.domain;


/**
 * It is the class that represents an age range for the survey in the domain
 */
public class SurveyRange
{

    // -----------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------

    /**
     * Models the number of opinions made by single people in this age range
     */
    private int numberOfSingles;

    /**
     * Models the number of opinions made by married people in this age range
     */
    private int numberOfMarried;

    /**
     * Models the sum of the opinions made by single people in this age range
     */
    private int totalSingleOpinion;

    /**
     * Models the sum of the opinions made by married people in this age range
     */
    private int totalMarriedOpinion;

    // -----------------------------------------------------------
    // Methods
    // -----------------------------------------------------------

    /**
     * Initialized the range of the survey.
     */
    public void initialize( )
    {
        numberOfMarried = 0;
        numberOfSingles = 0;
        totalSingleOpinion = 0;
        totalMarriedOpinion = 0;
    }

    /**
     * Adds the opinion of a single person in the age range that represents the class. <br>
     * <b>post: </b> a new opinion will be added.
     * @param opinion of the person who is answering the survey, value: from 0 to 10.
     */
    public void addOpinionSingle( int opinion )
    {
        numberOfSingles = numberOfSingles + 1;
        totalSingleOpinion = totalSingleOpinion + opinion;
    }

    /**
     * Adds the opinion of a married person in the age range that represents the class. <br>
     * <b>post: </b> a new opinion will be added.
     * @param opinion of the person who is answering the survey, value: from 0 to 10.
     */
    public void addOpinionMarried( int opinion )
    {
        numberOfMarried = numberOfMarried + 1;
        totalMarriedOpinion = totalMarriedOpinion + opinion;
    }

    /**
     * Returns the survey average in the age range of the class. For this effect, all the opinions are added and divided by the total number of people that respond the survey. <br>
     * <b>pre: </b> the number of opinions must be greater than or equal to 1.
     * @return The average of the survey in the age range of the class.
     */
    public double getAverage( )
    {
        return ( double )getTotalOfOpinions( ) / getNumberOfOpinions( );
    }

    /**
     * Returns the average of the opinions of married people in this range. <br>
     * <b>pre: </b> the number of opinions of married people must be greater than or equal to 1.
     * @return The average of the survey in the age range of the class considering only the married people
     */
    public double getMarriedAverage( )
    {
        return ( double )totalMarriedOpinion / numberOfMarried;
    }

    /**
     * Returns the average of the opinions of single people in this range. <br>
     * <b>pre: </b> the number of opinions of single people must be greater than or equal to 1.
     * @return The average of the survey in the age range of the class considering only the single people.
     */
    public double getSingleAverage( )
    {
        return ( double )totalSingleOpinion / numberOfSingles;
    }

    /**
     * Reports the number of opinions made for this range.
     * @return The number of opinions.
     */
    public int getNumberOfOpinions( )
    {
        return numberOfMarried + numberOfSingles;
    }

    /**
     * Reports the sum of opinions made for this range.
     * @return The sum of opinions.
     */
    public int getTotalOfOpinions( )
    {
        return totalMarriedOpinion + totalSingleOpinion;
    }

    /**
     * Returns the number of married people who responded the survey, in the age range of the class.
     * @return The number of married people who responded the survey, in the age range of the class.
     */
    public int getMarriedNumber( )
    {
        return numberOfMarried;
    }

    /**
     * Returns the number of single people who responded the survey, in the age range of the class.
     * @return The number of single people who responded the survey, in the age range of the class.
     */
    public int getSingleNumber( )
    {
        return numberOfSingles;
    }

    /**
     * Returns the sum of all the opinions of the married people in the age range of the class.
     * @return The sum of all the opinions of the married people in the age range of the class.
     */
    public int getMarriedTotalOpinion( )
    {
        return totalMarriedOpinion;
    }

    /**
     * Returns the sum of all the opinions of the single people in the age range of the class.
     * @return The sum of all the opinions of the single people in the age range of the class.
     */
    public int getSingleTotalOpinion( )
    {
        return totalSingleOpinion;
    }

}