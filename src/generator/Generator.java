package generator;

import java.util.Random;

import data.AttackType;
import data.Critical;
import data.GenerationData;
import data.MagicDamageType;
import view.ClearResultsListener;
import view.GenerationEvent;
import view.GenerationListener;
import view.MainWindow;

public class Generator
		implements GenerationListener, ClearResultsListener
{
	private MainWindow mainWindow;

	public Generator( MainWindow mainWindow )
	{
		this.mainWindow = mainWindow;
	}

	public static Critical[] generateRandomCriticals ( AttackType attackType,
			MagicDamageType[] magicDamageTypes, int numberOfChoices )
	{
		Critical[] potentialCriticals = Critical.getCriticalsOfType( attackType,
				magicDamageTypes );

		if ( potentialCriticals.length < numberOfChoices )
		{
			numberOfChoices = potentialCriticals.length;
		}

		Critical[] criticalsToOffer = new Critical[ numberOfChoices ];

		final int[] generatedCriticalEntries = new Random()
				.ints( 0, potentialCriticals.length ).distinct()
				.limit( numberOfChoices ).toArray();

		for ( int i = 0; i < numberOfChoices; i++ )
		{
			criticalsToOffer[ i ] = potentialCriticals[ generatedCriticalEntries[ i ] ];
		}

		return criticalsToOffer;
	}

	@Override
	public void generationEventOccurred ( GenerationEvent event )
	{
		GenerationData data = event.getData();
		int numberOfChoices = data.multiplier - 1;

		Critical[] criticalsToOffer = generateRandomCriticals( data.attackType,
				data.magicDamageTypes, numberOfChoices );

		mainWindow.getRightPanel().generationEventOccurred( criticalsToOffer );
	}

	@Override
	public void clearResultsEventOccured ()
	{
		mainWindow.getRightPanel().clearEventOccurred();
	}
}
