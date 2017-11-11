package edu.jabs.survey.gui;

import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.TitledBorder;

/**
 * It is the panel that contains the buttons to execute the extension points
 */
public class ExtensionPanel extends JPanel implements ActionListener
{
    // -----------------------------------------------------------------
    // Constants
    // -----------------------------------------------------------------

    /**
     * The command for the button 1
     */
    private final String OPTION_1 = "OPTION_1";

    /**
     * The command for the button 2
     */
    private final String OPTION_2 = "OPTION_2";

    // -----------------------------------------------------------------
    // Attributes
    // -----------------------------------------------------------------

    /**
     * It is the reference to the interface of the application
     */
    private SurveyInterface mainWindow;

    // -----------------------------------------------------------------
    // Interface Attributes
    // -----------------------------------------------------------------

    /**
     * It is button 1
     */
    private JButton buttonOption1;

    /**
     * It is button 2
     */
    private JButton buttonOption2;

    // -----------------------------------------------------------------
    // Builders
    // -----------------------------------------------------------------

    /**
     * Builds the panel with a reference to the main window of the application. <br>
     * <b>post: </b> The panel was build.
     * @param ip Main window. ip != null.
     */
    public ExtensionPanel( SurveyInterface ip )
    {
        mainWindow = ip;

        setBorder( new TitledBorder( "Extension Points" ) );

        setLayout( new FlowLayout( ) );
        buttonOption1 = new JButton( "Option 1" );
        buttonOption1.setActionCommand( OPTION_1 );
        buttonOption1.addActionListener( this );

        buttonOption2 = new JButton( "Option 2" );
        buttonOption2.setActionCommand( OPTION_2 );
        buttonOption2.addActionListener( this );

        add( buttonOption1 );
        add( buttonOption2 );
    }

    // -----------------------------------------------------------------
    // Methods
    // -----------------------------------------------------------------

    /**
     * This method is called when pressing one of the buttons. <br>
     * <b>post: </b> The action corresponding to the pressed button was executed
     * @param event The event of clicking on the button. event != null.
     */
    public void actionPerformed( ActionEvent event )
    {
        String command = event.getActionCommand( );
        if( OPTION_1.equals( command ) )
        {
            mainWindow.reqFuncOption1( );
        }
        else if( OPTION_2.equals( command ) )
        {
            mainWindow.reqFuncOption2( );
        }
    }

}
