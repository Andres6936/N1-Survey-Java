package edu.jabs.survey.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.DecimalFormat;
import java.text.NumberFormat;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * Panel with the results of the survey
 */
public class ResultsPanel extends JPanel implements ActionListener
{

    // -----------------------------------------------------------
    // Constants
    // -----------------------------------------------------------

    private static final String CONSULT = "CONSULT";

    // -----------------------------------------------------------
    // Interface attributes
    // -----------------------------------------------------------

    /**
     * Main window
     */
    private SurveyInterface mainWindow;

    /**
     * Average label
     */
    private JLabel averageLabel;

    /**
     * Number of opinions label
     */
    private JLabel numberOfOpinionsLabel;

    /**
     * Total average label
     */
    private JLabel totalAverageLabel;

    /**
     * Number of opinions result
     */
    private JLabel numberOfOpinions;

    /**
     * Range label
     */
    private JLabel rangeLabel;

    /**
     * Marital status label
     */
    private JLabel maritalStatusLabel;

    /**
     * Consult button
     */
    private JButton buttonConsult;

    /**
     * Combo with the ranges
     */
    private JComboBox comboRange;

    /**
     * Combo marital status
     */
    private JComboBox comboMaritalStatus;

    // -----------------------------------------------------------
    // Builders
    // -----------------------------------------------------------

    /**
     * Builder of the panel.
     * @param main Main window. main != null.
     */
    public ResultsPanel( SurveyInterface main )
    {
        mainWindow = main;
        setLayout( new GridLayout( 2, 1 ) );

        TitledBorder title = BorderFactory.createTitledBorder( "SURVEY RESULTS" );
        title.setTitleJustification( TitledBorder.CENTER );
        title.setTitleColor( new Color( 16, 78, 139 ) );
        setBorder( title );

        averageLabel = new JLabel( "Suvey total average: " );
        numberOfOpinionsLabel = new JLabel( "Number of opinions: " );
        totalAverageLabel = new JLabel( );
        numberOfOpinions = new JLabel( );
        rangeLabel = new JLabel( "Age range" );
        maritalStatusLabel = new JLabel( "Marital Status" );

        buttonConsult = new JButton( "Consult" );
        buttonConsult.addActionListener( this );
        buttonConsult.setActionCommand( CONSULT );

        String[] rangesList = { "0-17 years", "18-55 years", "56 or more years" };
        comboRange = new JComboBox( rangesList );

        String[] statusList = { "Married", "Single" };
        comboMaritalStatus = new JComboBox( statusList );

        JPanel internalPanel1 = new JPanel( );
        JPanel internalPanel2 = new JPanel( );
        internalPanel1.setLayout( new FlowLayout( ) );
        internalPanel2.setLayout( new FlowLayout( ) );

        internalPanel1.add( averageLabel );
        internalPanel1.add( totalAverageLabel );
        internalPanel1.add( numberOfOpinionsLabel );
        internalPanel1.add( numberOfOpinions );

        internalPanel2.add( rangeLabel );
        internalPanel2.add( comboRange );
        internalPanel2.add( maritalStatusLabel );
        internalPanel2.add( comboMaritalStatus );
        internalPanel2.add( buttonConsult );

        add( internalPanel1 );
        add( internalPanel2 );
    }

    // -----------------------------------------------------------
    // Methods
    // -----------------------------------------------------------

    /**
     * Updates the total results shown in the panel
     */
    public void updateResults( )
    {
        double average = mainWindow.getTotalAverage( );

        if( !Double.isNaN( average ) )
        {
            totalAverageLabel.setText( Double.toString( Math.floor( average ) ) );
        }
        else
        {
            totalAverageLabel.setText( "Not available" );
            totalAverageLabel.setForeground( Color.RED );
        }

        numberOfOpinions.setText( Integer.toString( mainWindow.getTotalNumberOfOpinions( ) ) );

    }

    /**
     * Shows results of the survey in a window.
     * @param result, it is the partial result of the survey according to the range and marital status.
     * @param range of age of the people for this group of results
     * @param isMarried, marital status of the people for this group of results
     */
    private void showResults( double result, int range, boolean isMarried )
    {
        String maritalStatus = ( isMarried == true ? "married" : "single" );
        String rangeInWords = ( range == 1 ? "0-18 years" : ( range == 2 ? "19-60 years" : "61 or more years" ) );
        String message;

        DecimalFormat df = ( DecimalFormat )NumberFormat.getInstance( );
        df.applyPattern( "###.##" );

        if( !Double.isNaN( result ) )
        {
            message = "The participants" + maritalStatus.toUpperCase( ) + " in the range of age " + "(" + rangeInWords + ")\n" + "gave a note to the course: " + df.format( result ) + " points ";
        }
        else
        {
            message = "The participants " + maritalStatus.toUpperCase( ) + " in the range of age " + "(" + rangeInWords + ")\n" + "have not given any note to the course";
        }

        JOptionPane.showMessageDialog( this, message, "Resultados", JOptionPane.INFORMATION_MESSAGE );
    }

    /**
     * Answers to the actions on the panel.
     * @param e Event that generated the action.
     */
    public void actionPerformed( ActionEvent e )
    {
        if( e.getActionCommand( ) == CONSULT )
        {
            boolean irMarried = ( comboMaritalStatus.getSelectedIndex( ) == 0 ? true : false );
            int range = comboRange.getSelectedIndex( ) + 1;

            double result = mainWindow.getPartialResults( range, irMarried );
            showResults( result, range, irMarried );
        }
    }
}