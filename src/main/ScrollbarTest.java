package main;

import static org.junit.Assert.assertTrue;

import javax.swing.SwingUtilities;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import data.Critical;

public class ScrollbarTest
{
	private App app;

	@Before
	public void setup ()
	{
		app = new App();
	}

	@After
	public void close ()
	{
		app.window.dispose();
	}

	@Test
	public void scrollbarTest ()
	{
		Critical[] criticals = new Critical[ 3 ];

		for ( int i = 0; i < criticals.length; i++ )
		{
			criticals[ i ] = Critical.BLOWBACK;
		}

		app.window.getRightPanel().generationEventOccurred( criticals );

		SwingUtilities.invokeLater( new Runnable()
		{
			@Override
			public void run ()
			{
				assertTrue( app.window.getRightPanel().getListScroller()
						.getVerticalScrollBar().getValue() == 0 );
			}
		} );

	}

}
