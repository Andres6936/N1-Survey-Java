package main.java.survey.gui;


import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import main.java.survey.domain.Survey;

/**
 * Main window of the application
 */
public class SurveyInterface extends JFrame
{

    // -----------------------------------------------------------
    // Interface attributes
    // -----------------------------------------------------------

    /**
     * Panel where the results are shown
     */
    private ResultsPanel resultsPanel;

    /**
     * Panel to add an opinion
     */
    private AddOpinionPanel panelAddOpinion;

    /**
     * Panel with the extensions
     */
    private ExtensionPanel extensionPanel;

    /**
     * Survey
     */
    private Survey survey;

    // -----------------------------------------------------------
    // Builders
    // -----------------------------------------------------------

    /**
     * Interface builder
     */
    public SurveyInterface( )
    {

        setDefaultCloseOperation( JFrame.DISPOSE_ON_CLOSE );
        setVisible( true );
        setResizable( false );
        setTitle( "Survey 1.0" );
        getContentPane( ).setLayout( new BorderLayout( ) );

        survey = new Survey( );
        survey.initialize( );
        resultsPanel = new ResultsPanel( this );
        panelAddOpinion = new AddOpinionPanel( this );
        extensionPanel = new ExtensionPanel( this );

        JPanel centralPanel = new JPanel( new GridLayout( 2, 1 ) );
        centralPanel.add( panelAddOpinion );
        centralPanel.add( resultsPanel );

        getContentPane( ).add( centralPanel, BorderLayout.CENTER );
        getContentPane( ).add( extensionPanel, BorderLayout.SOUTH );

        pack( );

        centerFrame( );
    }

    // -----------------------------------------------------------
    // Methods
    // -----------------------------------------------------------

    /**
     * Centers the frame on the screen according to resolution
     */
    private void centerFrame( )
    {
        Dimension screenSize = getToolkit( ).getScreenSize( );

        int screenWidth = ( int )screenSize.getWidth( );
        int screenHeight = ( int )screenSize.getHeight( );
        setLocation( ( ( screenWidth / 2 ) - ( getWidth( ) / 2 ) ), ( ( screenHeight / 2 ) - ( getHeight( ) / 2 ) ) );
    }

    /**
     * Adds an opinion to the survey in the group according to the age range value and whether he/she is married or not.
     * @param range range of the person who opined. The possible values of range: 1,2 or 3.
     * @param isMarried marital status of the person who opined.
     * @param opinion the value of opinion to be added.
     */
    public void addOpinion( int range, boolean isMarried, int opinion )
    {
        if( isMarried )
        {
            switch( range )
            {
                case 1:
                    survey.addOpinionRange1Married( opinion );
                    break;
                case 2:
                    survey.addOpinionRange2Married( opinion );
                    break;
                case 3:
                    survey.addOpinionRange3Married( opinion );
                    break;
            }
        }
        else
        {
            switch( range )
            {
                case 1:
                    survey.addOpinionRange1Single( opinion );
                    break;
                case 2:
                    survey.addOpinionRange2Single( opinion );
                    break;
                case 3:
                    survey.addOpinionRange3Single( opinion );
                    break;
            }
        }
    }

    /**
     * Reports partial results of a specific group.
     * @param range of age for the group which the average will be consulted. The possible range values are: 1,2 or 3.
     * @param isMarried marital status for the group which the average will be consulted
     * @return the average for the specific group.
     */
    public double getPartialResults( int range, boolean isMarried )
    {
        double results = 0d;

        if( isMarried )
        {
            switch( range )
            {
                case 1:
                    results = survey.getResultsRange1Married( );
                    break;
                case 2:
                    results = survey.getResultsRange2Married( );
                    break;
                case 3:
                    results = survey.getResultsRange3Married( );
                    break;
            }
        }
        else
        {
            switch( range )
            {
                case 1:
                    results = survey.getResultsRange1Single( );
                    break;
                case 2:
                    results = survey.getResultsRange2Single( );
                    break;
                case 3:
                    results = survey.getResultsRange3Single( );
                    break;
            }
        }
        return results;
    }

    /**
     * Gives the total number of opinions recolected
     * @return total number of opinions recolected
     */
    public int getTotalNumberOfOpinions( )
    {
        return survey.getTotalNumberOfOpinions( );
    }

    /**
     * Gives the total average of the survey
     * @return the total average of the survey
     */
    public double getTotalAverage( )
    {
        return survey.getAverage( );
    }

    /**
     * Updates the total results shown in the interface
     */
    public void updateResults( )
    {
        resultsPanel.updateResults( );
    }

    // -----------------------------------------------------------------
    // Extension Points
    // -----------------------------------------------------------------

    /**
     * Executes the extension point 1
     */
    public void reqFuncOption1( )
    {
        String result = survey.method1( );
        JOptionPane.showMessageDialog( this, result, "Answer", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Executes the extension point 2
     */
    public void reqFuncOption2( )
    {
        String result = survey.method2( );
        JOptionPane.showMessageDialog( this, result, "Answer", JOptionPane.INFORMATION_MESSAGE );
    }

    // -----------------------------------------------------------------
    // Main
    // -----------------------------------------------------------------

    /**
     * Executes the application
     * @param args Are the parameters of the commands line. They are not used.
     */
    public static void main( String[] args )
    {
        SurveyInterface anInterface = new SurveyInterface( );
        anInterface.setVisible( true );

    }
}