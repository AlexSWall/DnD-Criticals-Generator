package main;

import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.SwingUtilities;

import generator.Generator;
import view.MainWindow;

/*
 * TODO:
 * 0. Add the rest of the criticals.
 * 1. Add details in effects within criticals.
 * 2. ?Make the criticals clickable?
 * 3. ?Improve design?
 */

public class App
{
	private final String	APPNAME	= "Criticals Generator v1.0";
	private final int[]		SIZE	= { 900, 270 };

	protected MainWindow	window;
	protected Generator		generator;

	public static void main ( String[] args )
	{
		// new App();
		SwingUtilities.invokeLater( new Runnable()
		{
			@Override
			public void run ()
			{
				new App();
			}
		} );

		// MigLayout layout = new MigLayout( "wrap 3" );
	}

	App()
	{
		window = new MainWindow( APPNAME );
		window.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );
		window.setSize( SIZE[ 0 ], SIZE[ 1 ] );
		window.setResizable( false );
		window.setLocation(
				( Toolkit.getDefaultToolkit().getScreenSize().width
						- SIZE[ 0 ] ) / 2,
				( Toolkit.getDefaultToolkit().getScreenSize().height
						- SIZE[ 1 ] ) / 2 );
		window.setVisible( true );

		generator = new Generator( window );

		window.addGenerationListener( generator );
		window.addClearResultsListener( generator );

	}
}
