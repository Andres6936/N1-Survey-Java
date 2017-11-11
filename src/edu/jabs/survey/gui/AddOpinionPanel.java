package edu.jabs.survey.gui;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.TitledBorder;

/**
 * Panel to add an opinion
 */
public class AddOpinionPanel extends JPanel implements ActionListener
{

    // -----------------------------------------------------------
    // Constants
    // -----------------------------------------------------------

    private static final String ADD_OPINION = "ADD_OPINION";

    // -----------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------

    /**
     * Principal window
     */
    private SurveyInterface mainWindow;

    // -----------------------------------------------------------
    // Interface Attributes
    // -----------------------------------------------------------

    /**
     * Question label
     */
    private JLabel questionLabel;

    /**
     * Range label
     */
    private JLabel rangeLabel;

    /**
     * Opinion label
     */
    private JLabel opinionLabel;

    /**
     * Marital status label
     */
    private JLabel maritalStatusLabel;

    /**
     * Add opinion button
     */
    private JButton buttonAddOpinion;

    /**
     * Combo range
     */
    private JComboBox comboRange;

    /**
     * Combo opinion
     */
    private JComboBox comboOpinion;

    /**
     * Combo marital status
     */
    private JComboBox comboMaritalStatus;

    // -----------------------------------------------------------
    // Builders
    // -----------------------------------------------------------

    /**
     * Builds the panel.
     * @param main Main window. main != null.
     */
    public AddOpinionPanel( SurveyInterface main )
    {
        mainWindow = main;
        setLayout( new GridLayout( 3, 1 ) );
        TitledBorder tittle = BorderFactory.createTitledBorder( "ADD OPINION TO SURVEY" );
        tittle.setTitleJustification( TitledBorder.CENTER );
        tittle.setTitleColor( new Color( 16, 78, 139 ) );
        setBorder( tittle );

        questionLabel = new JLabel( "What is your opinion about this course? Rate of 0-10" );
        rangeLabel = new JLabel( "Age range" );
        opinionLabel = new JLabel( "Opinion" );
        maritalStatusLabel = new JLabel( "Marital status" );

        buttonAddOpinion = new JButton( "Add opinion" );
        buttonAddOpinion.addActionListener( this );
        buttonAddOpinion.setActionCommand( ADD_OPINION );

        String[] rangesList = { "0-17 years", "18-55 years", "56 or more years" };
        comboRange = new JComboBox( rangesList );
        comboRange.addActionListener( this );

        String[] statusList = { "Maried", "Single" };
        comboMaritalStatus = new JComboBox( statusList );
        comboMaritalStatus.addActionListener( this );

        String[] opinionsList = { "0", "1", "2", "3", "4", "5", "6", "7", "8", "9", "10" };
        comboOpinion = new JComboBox( opinionsList );
        comboOpinion.addActionListener( this );

        JPanel internalPanel1 = new JPanel( );
        internalPanel1.setLayout( new FlowLayout( ) );
        internalPanel1.setBackground( new Color( 198, 226, 255 ) );
        JPanel internalPanel2 = new JPanel( );
        internalPanel2.setLayout( new FlowLayout( ) );
        JPanel internalPanel3 = new JPanel( );
        internalPanel3.setLayout( new FlowLayout( ) );

        internalPanel1.add( questionLabel );

        Border borde = BorderFactory.createEtchedBorder( );
        internalPanel1.setBorder( borde );

        internalPanel2.add( rangeLabel );
        internalPanel2.add( comboRange );
        internalPanel2.add( maritalStatusLabel );
        internalPanel2.add( comboMaritalStatus );
        internalPanel2.add( opinionLabel );
        internalPanel2.add( comboOpinion );

        internalPanel3.add( buttonAddOpinion );

        add( internalPanel1 );
        add( internalPanel2 );
        add( internalPanel3 );

    }

    // -----------------------------------------------------------
    // Methods
    // -----------------------------------------------------------

    /**
     * Method that responds to the actions in the panel
     * @param e Event the generated the action. e != null.
     */
    public void actionPerformed( ActionEvent e )
    {
        if( e.getActionCommand( ) == ADD_OPINION )
        {
            int opinion = comboOpinion.getSelectedIndex( );
            int range = comboRange.getSelectedIndex( ) + 1;
            boolean isMarried = ( comboMaritalStatus.getSelectedIndex( ) == 0 ? true : false );
            getToolkit( ).beep( );
            mainWindow.addOpinion( range, isMarried, opinion );
            mainWindow.updateResults( );
        }

    }
}