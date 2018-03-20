package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;

import data.Critical;

public class RightPanel extends JPanel
{
	private static final long serialVersionUID = 1L;

	private JPanel		scrollBoxPanel;
	private JScrollPane	listScroller;

	private JPanel[]	criticalOptionPanels;
	private Component[]	rigidAreas;

	RightPanel()
	{
		super();
		setLayout( new BoxLayout( this, BoxLayout.Y_AXIS ) );

		criticalOptionPanels = new JPanel[ 0 ];
		createAndPlaceBaseComponents();
		placeCriticalOptions();
	}

	public JScrollPane getListScroller ()
	{
		return listScroller;
	}

	private void createAndPlaceBaseComponents ()
	{
		scrollBoxPanel = new JPanel();
		scrollBoxPanel
				.setLayout( new BoxLayout( scrollBoxPanel, BoxLayout.Y_AXIS ) );
		scrollBoxPanel.setMaximumSize( new Dimension( 300, 500 ) );

		listScroller = new JScrollPane( scrollBoxPanel );
		listScroller.setBorder( this.getBorder() );
		listScroller.setHorizontalScrollBarPolicy(
				ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER );
		listScroller.setVerticalScrollBarPolicy(
				ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );

		add( listScroller );

		refresh();
	}

	private void refresh ()
	{
		listScroller.revalidate();
		listScroller.repaint();
	}

	public void generationEventOccurred ( Critical[] criticalsToOffer )
	{
		removeCriticalOptions();
		createCriticalOptions( criticalsToOffer );
		placeCriticalOptions();
	}

	private void createCriticalOptions ( Critical[] criticalsToOffer )
	{
		criticalOptionPanels = new JPanel[ criticalsToOffer.length ];
		Critical critical;
		JPanel criticalPanel;
		JTextArea textArea;

		for ( int i = 0; i < criticalOptionPanels.length; i++ )
		{
			critical = criticalsToOffer[ i ];
			criticalPanel = new JPanel();
			criticalPanel.setLayout( new BorderLayout() );

			TitledBorder criticalPanelBorder = BorderFactory.createTitledBorder(
					BorderFactory.createEtchedBorder( EtchedBorder.RAISED ),
					critical.name, TitledBorder.LEFT, TitledBorder.TOP,
					new Font( null, Font.BOLD, 14 ) );
			criticalPanel.setBorder( new CompoundBorder( criticalPanelBorder,
					new EmptyBorder( 5, 5, 5, 5 ) ) );

			textArea = new JTextArea( critical.description );
			textArea.setEditable( false );
			textArea.setLineWrap( true );
			textArea.setWrapStyleWord( true );
			textArea.setBackground( Color.getHSBColor( 0, 0, 0.93f ) );

			criticalPanel.add( textArea );

			criticalOptionPanels[ i ] = criticalPanel;
		}
	}

	private void placeCriticalOptions ()
	{
		if ( criticalOptionPanels.length > 0 )
		{
			scrollBoxPanel.add( criticalOptionPanels[ 0 ] );
		}

		rigidAreas = new Component[ criticalOptionPanels.length > 0
			? criticalOptionPanels.length - 1
			: 0 ];

		for ( int i = 0; i < rigidAreas.length; i++ )
		{
			rigidAreas[ i ] = Box.createRigidArea( new Dimension( 5, 5 ) );
		}

		for ( int i = 1; i < criticalOptionPanels.length; i++ )
		{
			scrollBoxPanel.add( rigidAreas[ i - 1 ] );
			scrollBoxPanel.add( criticalOptionPanels[ i ] );
		}

		SwingUtilities.invokeLater( new Runnable()
		{
			@Override
			public void run ()
			{
				listScroller.getVerticalScrollBar().setValue( 0 );
			}
		} );

		refresh();
	}

	private void removeCriticalOptions ()
	{
		for ( int i = 0; i < criticalOptionPanels.length; i++ )
		{
			scrollBoxPanel.remove( criticalOptionPanels[ i ] );
		}

		for ( int i = 0; i < rigidAreas.length; i++ )
		{
			scrollBoxPanel.remove( rigidAreas[ i ] );
		}

		criticalOptionPanels = new JPanel[ 0 ];

		refresh();
	}

	public void clearEventOccurred ()
	{
		removeCriticalOptions();
	}
}
