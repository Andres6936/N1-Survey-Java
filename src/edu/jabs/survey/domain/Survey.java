package edu.jabs.survey.domain;


/**
 * It is the class that represents the domain of the survey
 */
public class Survey
{

    // -----------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------

    /**
     * Models the range of the survey: 0 < years < 18 for married people
     */
    private SurveyRange surveyRange1;

    /**
     * Models the range of the survey: 18 < years <= 55 for married people
     */
    private SurveyRange surveyRange2;

    /**
     * Models the range of the survey: 55 < years for married people
     */
    private SurveyRange surveyRange3;

    // -----------------------------------------------------------
    // Methods
    // -----------------------------------------------------------

    /**
     * Initializes the survey
     */
    public void initialize( )
    {
        surveyRange1 = new SurveyRange( );
        surveyRange1.initialize( );
        surveyRange2 = new SurveyRange( );
        surveyRange2.initialize( );
        surveyRange3 = new SurveyRange( );
        surveyRange3.initialize( );
    }

    // -------------------------------------------------
    // Methods that add opinions of single people
    // -------------------------------------------------

    /**
     * Agrega una opinión de alguien entre 0 y 17 años de gente soltera. <br>
     * <b>post: </b>se agregó la opinión a la encuesta.
     * @param opinion la opinión que se va a agregar a la encuesta. opinión está entre 0 y 10.
     */
    public void addOpinionRange1Single( int opinion )
    {
        surveyRange1.addOpinionSingle( opinion );
    }

    /**
     * Agrega una opinión de alguien entre 18 y 55 años de gente soltera. <br>
     * <b>post: </b>se agregó la opinión a la encuesta.
     * @param opinion la opinión que se va a agregar a la encuesta. opinión está entre 0 y 10.
     */
    public void addOpinionRange2Single( int opinion )
    {
        surveyRange2.addOpinionSingle( opinion );
    }

    /**
     * Agrega una opinión de alguien con más de 55 años que sea soltero. <br>
     * <b>post: </b>se agregó la opinión a la encuesta.
     * @param opinion la opinión que se va a agregar a la encuesta. opinión está entre 0 y 10.
     */
    public void addOpinionRange3Single( int opinion )
    {
        surveyRange3.addOpinionSingle( opinion );
    }

    // -------------------------------------------------
    // Métodos que agregan opiniones de gente casada
    // -------------------------------------------------

    /**
     * Agrega una opinión de alguien entre 0 y 17 años de gente casada. <br>
     * <b>post: </b>se agregó la opinión a la encuesta.
     * @param opinion la opinión que se va a agregar a la encuesta. opinión está entre 0 y 10.
     */
    public void addOpinionRange1Married( int opinion )
    {
        surveyRange1.addOpinionMarried( opinion );
    }

    /**
     * Agrega una opinión de alguien entre 18 y 55 años de gente casada. <br>
     * <b>post: </b>se agregó la opinión a la encuesta.
     * @param opinion la opinión que se va a agregar a la encuesta. opinión está entre 0 y 10.
     */
    public void addOpinionRange2Married( int opinion )
    {
        surveyRange2.addOpinionMarried( opinion );
    }

    /**
     * Agrega una opinión de alguien con más de 55 años que sea casado. <br>
     * <b>post: </b>se agregó la opinión a la encuesta.
     * @param opinion la opinión que se va a agregar a la encuesta. opinión está entre 0 y 10.
     */
    public void addOpinionRange3Married( int opinion )
    {
        surveyRange3.addOpinionMarried( opinion );
    }

    // --------------------------------------------------
    // Métodos que devuelven resultados de gente casada
    // --------------------------------------------------

    /**
     * Da el promedio de opiniones de gente entre 0 y 17 años que sea casada.
     * @return El promedio de opiniones.
     */
    public double getResultsRange1Married( )
    {
        return surveyRange1.getMarriedAverage( );
    }

    /**
     * Da el promedio de opiniones de gente entre 18 y 55 años que sea casada.
     * @return El promedio de opiniones.
     */
    public double getResultsRange2Married( )
    {
        return surveyRange2.getMarriedAverage( );
    }

    /**
     * Da el promedio de opiniones de gente con más de 55 años que sea casada.
     * @return El promedio de opiniones.
     */
    public double getResultsRange3Married( )
    {
        return surveyRange3.getMarriedAverage( );
    }

    // --------------------------------------------------
    // Métodos que devuelven resultados de gente soltera
    // --------------------------------------------------

    /**
     * Gives the average of opinions of people between 0 and 17 years who are single.
     * @return The average of opinions.
     */
    public double getResultsRange1Single( )
    {
        return surveyRange1.getSingleAverage( );
    }

    /**
     * Gives the average of opinions of people between 18 and 55 years who are single.
     * @return The average of opinions.
     */
    public double getResultsRange2Single( )
    {
        return surveyRange2.getSingleAverage( );
    }

    /**
     * Gives the average of opinions of people with more than 55 years who are single.
     * @return The average of opinions.
     */
    public double getResultsRange3Single( )
    {
        return surveyRange3.getSingleAverage( );
    }

    /**
     * Gives the total number of opinions made in the survey.
     * @return The total number of opinions.
     */
    public int getTotalNumberOfOpinions( )
    {
        int totalNumberOfOpinions;

        totalNumberOfOpinions = surveyRange1.getNumberOfOpinions( ) + surveyRange2.getNumberOfOpinions( ) + surveyRange3.getNumberOfOpinions( );

        return totalNumberOfOpinions;
    }

    /**
     * Gives the total number of married people who responded the survey.
     * @return The total number of opinions of married people.
     */
    private int getMarriedTotalNumberOfOpinions( )
    {
        int marriedTotalNumberOfOpinions;

        marriedTotalNumberOfOpinions = surveyRange1.getMarriedNumber( ) + surveyRange2.getMarriedNumber( ) + surveyRange3.getMarriedNumber( );

        return marriedTotalNumberOfOpinions;
    }

    /**
     * Gives the total number of single people who responded the survey.
     * @return The total number of opinions of single people.
     */
    private int getSingleTotalNumberOfOpinions( )
    {
        int singleTotalNumberOfOpinions;

        singleTotalNumberOfOpinions = surveyRange1.getSingleNumber( ) + surveyRange2.getSingleNumber( ) + surveyRange3.getSingleNumber( );

        return singleTotalNumberOfOpinions;
    }

    /**
     * Returns the average of the survey in all the age ranges. For this, it sum all the opinions and divide them by the total number of people who answered the survey. <br>
     * <b>pre: </b> there must be at least one opinion in each cathegory
     * @return The average of the survey in every age range
     */
    public double getAverage( )
    {
        double surveyTotal;
        double surveyAverage;

        surveyTotal = surveyRange1.getTotalOfOpinions( ) + surveyRange2.getTotalOfOpinions( ) + surveyRange3.getTotalOfOpinions( );

        surveyAverage = surveyTotal / getTotalNumberOfOpinions( );

        return surveyAverage;
    }

    /**
     * Returns the average of the survey in all the age ranges. For this, it sum all the married opinions and divide them by the total number of them.<br>
     * <b>pre: </b> there must be at least one opinion in the married cathegory.
     * @return The average of the survey in every age range, considering only the married people.
     */
    public double getMarriedAverage( )
    {
        double surveyTotalMarried;
        double surveyAverage;

        surveyTotalMarried = surveyRange1.getMarriedTotalOpinion( ) + surveyRange2.getMarriedTotalOpinion( ) + surveyRange3.getMarriedTotalOpinion( );

        surveyAverage = surveyTotalMarried / getMarriedTotalNumberOfOpinions( );

        return surveyAverage;
    }

    /**
     * Returns the average of the survey in all the age ranges. For this, it sum all the single opinions and divide them by the total number of them.<br>
     * <b>pre: </b> there must be at least one opinion in the single cathegory.
     * @return The average of the survey in every age range, considering only the single people
     */
    public double getSingleAverage( )
    {
        double surveyTotalSingle;
        double surveyAverage;

        surveyTotalSingle = surveyRange1.getSingleTotalOpinion( ) + surveyRange2.getSingleTotalOpinion( ) + surveyRange3.getSingleTotalOpinion( );

        surveyAverage = surveyTotalSingle / getSingleTotalNumberOfOpinions( );

        return surveyAverage;
    }

    // -----------------------------------------------------------
    // Extension Points
    // -----------------------------------------------------------

    /**
     * Method 1 of the extension for the example
     * @return message
     */
    public String method1( )
    {
        return "Answer 1";
    }

    /**
     * Method 2 of the extension for the example
     * @return message
     */
    public String method2( )
    {
        return "Answer 2";
    }

}