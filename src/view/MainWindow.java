package view;

import java.awt.BorderLayout;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.JFrame;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

public class MainWindow extends JFrame
{
	private static final long serialVersionUID = 1L;

	private LeftPanel	leftPanel;
	private RightPanel	rightPanel;
	private Container	container;

	public MainWindow( String appName )
	{
		super( appName );

		createPanels();

		setLayout( new BorderLayout() );

		container = getContentPane();

		container.add( Box.createRigidArea( new Dimension( 10, 5 ) ),
				BorderLayout.NORTH );
		container.add( leftPanel, BorderLayout.WEST );
		container.add( rightPanel, BorderLayout.CENTER );
	}

	public void createPanels ()
	{
		leftPanel = new LeftPanel();
		rightPanel = new RightPanel();

		Font bold16ptTahoma = new Font( "Tahoma", Font.PLAIN, 16 );

		TitledBorder leftBorder = BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder( EtchedBorder.RAISED ),
				"Generator", TitledBorder.CENTER, TitledBorder.TOP,
				bold16ptTahoma );

		leftPanel.setBorder( leftBorder );

		TitledBorder rightBorder = BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder( EtchedBorder.RAISED ),
				"Generation Results", TitledBorder.CENTER, TitledBorder.TOP,
				bold16ptTahoma );

		rightPanel.setBorder( rightBorder );
	}

	public void addGenerationListener ( GenerationListener listener )
	{
		leftPanel.addGenerationListener( listener );
	}

	public void addClearResultsListener ( ClearResultsListener listener )
	{
		leftPanel.addClearResultsListener( listener );
	}

	public LeftPanel getLeftPanel ()
	{
		return leftPanel;
	}

	public RightPanel getRightPanel ()
	{
		return rightPanel;
	}
}
