package view;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.util.ArrayList;
import java.util.List;

import javax.swing.BorderFactory;
import javax.swing.Box;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JCheckBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.event.EventListenerList;

import data.AttackType;
import data.GenerationData;
import data.IncompleteFormException;
import data.MagicDamageType;

public class LeftPanel extends JPanel
{
	private static final long serialVersionUID = 1L;

	private EventListenerList	generationListenerList		= new EventListenerList();
	private EventListenerList	clearResultsListenerList	= new EventListenerList();

	GridBagConstraints constraints;

	private JPanel	attackTypePanel;
	private JPanel	magicDamagePanel;
	private JPanel	criticalMultiplerPanel;
	private JPanel	actionButtonPanel;

	private ButtonGroup		attackTypes;
	private JRadioButton	bludgeoning;
	private JRadioButton	magic;
	private JRadioButton	piercing;
	private JRadioButton	slashing;

	private JCheckBox[] magicDamageCheckBoxes;

	private ButtonGroup		criticalMultipliers;
	private JRadioButton	timesTwo;
	private JRadioButton	timesThree;
	private JRadioButton	timesFour;

	private JButton	generateButton;
	private JButton	clearButton;

	LeftPanel()
	{
		super( new GridBagLayout() );

		constraints = new GridBagConstraints();

		createComponents();
		placeComponents();
	}

	private void createComponents ()
	{
		createMainPanels();
		createAttackTypeButtons();
		createMagicTypeCheckBoxes();
		createCriticalMultiplierButtons();
		createActionButtons();
	}

	private void createMainPanels ()
	{
		attackTypePanel = new JPanel();
		magicDamagePanel = new JPanel();
		criticalMultiplerPanel = new JPanel();
		actionButtonPanel = new JPanel();

		TitledBorder attackTypePanelBorder = BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder( EtchedBorder.RAISED ),
				"Attack Type" );
		TitledBorder magicDamagePanelBorder = BorderFactory.createTitledBorder(
				BorderFactory.createEtchedBorder( EtchedBorder.RAISED ),
				"Magic Damage Types" );
		TitledBorder criticalMultiplerPanelBorder = BorderFactory
				.createTitledBorder(
						BorderFactory.createEtchedBorder( EtchedBorder.RAISED ),
						"Critical Hit Multiplier" );

		attackTypePanelBorder.setTitleJustification( TitledBorder.CENTER );
		magicDamagePanelBorder.setTitleJustification( TitledBorder.CENTER );
		criticalMultiplerPanelBorder
				.setTitleJustification( TitledBorder.CENTER );

		attackTypePanel.setBorder( attackTypePanelBorder );
		magicDamagePanel.setBorder( magicDamagePanelBorder );
		criticalMultiplerPanel.setBorder( criticalMultiplerPanelBorder );
	}

	private void createAttackTypeButtons ()
	{
		bludgeoning = new JRadioButton( "Bludgeoning" );
		bludgeoning.setMnemonic( KeyEvent.VK_B );
		bludgeoning.setActionCommand( "Bludgeoning" );

		magic = new JRadioButton( "Magic" );
		magic.setMnemonic( KeyEvent.VK_M );
		magic.setActionCommand( "Magic" );

		piercing = new JRadioButton( "Piercing" );
		piercing.setMnemonic( KeyEvent.VK_P );
		piercing.setActionCommand( "Piercing" );

		slashing = new JRadioButton( "Slashing" );
		slashing.setMnemonic( KeyEvent.VK_S );
		slashing.setActionCommand( "Slashing" );

		attackTypes = new ButtonGroup();

		attackTypes.add( bludgeoning );
		attackTypes.add( magic );
		attackTypes.add( piercing );
		attackTypes.add( slashing );
	}

	private void createMagicTypeCheckBoxes ()
	{
		magicDamageCheckBoxes = new JCheckBox[ 7 ];
		magicDamageCheckBoxes[ 0 ] = new JCheckBox( "Arcane" );
		magicDamageCheckBoxes[ 1 ] = new JCheckBox( "Acid" );
		magicDamageCheckBoxes[ 2 ] = new JCheckBox( "Fire" );
		magicDamageCheckBoxes[ 3 ] = new JCheckBox( "Force" );
		magicDamageCheckBoxes[ 4 ] = new JCheckBox( "Frost" );
		magicDamageCheckBoxes[ 5 ] = new JCheckBox( "Lightning" );
		magicDamageCheckBoxes[ 6 ] = new JCheckBox( "Sonic" );
	}

	private void createCriticalMultiplierButtons ()
	{
		timesTwo = new JRadioButton( "x2" );
		timesTwo.setMnemonic( KeyEvent.VK_2 );

		timesThree = new JRadioButton( "x3" );
		timesThree.setMnemonic( KeyEvent.VK_3 );

		timesFour = new JRadioButton( "x4" );
		timesFour.setMnemonic( KeyEvent.VK_4 );

		criticalMultipliers = new ButtonGroup();

		criticalMultipliers.add( timesTwo );
		criticalMultipliers.add( timesThree );
		criticalMultipliers.add( timesFour );

		timesTwo.setEnabled( true );
	}

	private void createActionButtons ()
	{
		generateButton = new JButton( "Generate" );
		generateButton.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed ( ActionEvent e )
			{
				try
				{
					createGenerationEvent();
				}
				catch ( IncompleteFormException iFException )
				{
					incompleteFormExceptionOccured( iFException );
				}
			}
		} );

		clearButton = new JButton( "Clear" );
		clearButton.addActionListener( new ActionListener()
		{
			@Override
			public void actionPerformed ( ActionEvent e )
			{
				fireClearResultsEvent();
			}
		} );
	}

	private void placeComponents ()
	{
		constraints.anchor = GridBagConstraints.LINE_START;
		constraints.gridx = 0;
		constraints.gridy = 0;
		constraints.weightx = 0.5;
		constraints.weighty = 3.5;
		constraints.ipadx = 0;
		constraints.ipady = 0;
		constraints.insets.set( 0, 0, 50, 0 );

		attackTypePanel.add( bludgeoning, constraints );

		constraints.gridx = 1;
		attackTypePanel.add( piercing, constraints );

		constraints.gridx = 2;
		attackTypePanel.add( slashing, constraints );

		constraints.gridx = 3;
		attackTypePanel.add( magic, constraints );

		for ( int i = 0; i < magicDamageCheckBoxes.length; i++ )
		{
			constraints.gridy = i / 2;
			constraints.gridx = i % 2;
			magicDamagePanel.add( magicDamageCheckBoxes[ i ], constraints );
		}

		constraints.gridy = 0;

		constraints.gridx = 0;
		criticalMultiplerPanel.add( timesTwo, constraints );
		constraints.gridx = 1;
		criticalMultiplerPanel.add( timesThree, constraints );
		constraints.gridx = 2;
		criticalMultiplerPanel.add( timesFour, constraints );

		actionButtonPanel.setLayout( new BorderLayout() );
		actionButtonPanel.add( generateButton, BorderLayout.WEST );
		actionButtonPanel.add( clearButton, BorderLayout.EAST );

		constraints.gridy = 0;
		constraints.gridx = 0;
		constraints.gridwidth = 1;
		constraints.insets.set( 0, 0, 0, 0 );
		constraints.anchor = GridBagConstraints.CENTER;

		add( Box.createRigidArea( new Dimension( 0, 5 ) ) );
		add( attackTypePanel, constraints );
		constraints.gridy = 1;
		add( magicDamagePanel, constraints );
		constraints.gridy = 2;
		add( criticalMultiplerPanel, constraints );
		constraints.gridy = 3;
		add( actionButtonPanel, constraints );
	}

	private void createGenerationEvent () throws IncompleteFormException
	{
		checkForValidFormSubmission();

		AttackType attackType = AttackType
				.fromString( attackTypes.getSelection().getActionCommand() );

		List<MagicDamageType> magicDamageTypesChecked = new ArrayList<MagicDamageType>();

		for ( JCheckBox box : magicDamageCheckBoxes )
		{
			if ( box.isSelected() )
			{
				magicDamageTypesChecked
						.add( MagicDamageType.fromString( box.getText() ) );
			}
		}

		MagicDamageType[] magicDamageTypesCheckedArray = magicDamageTypesChecked
				.toArray(
						new MagicDamageType[ magicDamageTypesChecked.size() ] );

		int criticalMultiplierValue = criticalMultipliers.getSelection()
				.getMnemonic() - KeyEvent.VK_2 + 2;

		GenerationData data = new GenerationData( attackType,
				magicDamageTypesCheckedArray, criticalMultiplierValue );

		fireGenerationEvent( new GenerationEvent( this, data ) );
	}

	private void checkForValidFormSubmission () throws IncompleteFormException
	{
		if ( attackTypes.getSelection() == null )
			throw new IncompleteFormException( "Attack Type" );

		if ( criticalMultipliers.getSelection() == null )
			throw new IncompleteFormException( "Critical Hit Multiplier" );

	}

	private void fireGenerationEvent ( GenerationEvent event )
	{
		Object[] listeners = generationListenerList.getListenerList();

		for ( int i = 0; i < listeners.length; i += 2 )
			if ( listeners[ i ] == GenerationListener.class )
			{
				( (GenerationListener) listeners[ i + 1 ] )
						.generationEventOccurred( event );
			}
	}

	public void addGenerationListener ( GenerationListener listener )
	{
		generationListenerList.add( GenerationListener.class, listener );
	}

	public void removeGenerationListener ( GenerationListener listener )
	{
		generationListenerList.remove( GenerationListener.class, listener );
	}

	private void fireClearResultsEvent ()
	{
		Object[] listeners = clearResultsListenerList.getListenerList();

		for ( int i = 0; i < listeners.length; i += 2 )
		{
			if ( listeners[ i ] == ClearResultsListener.class )
			{
				( (ClearResultsListener) listeners[ i + 1 ] )
						.clearResultsEventOccured();
			}
		}
	}

	public void addClearResultsListener ( ClearResultsListener listener )
	{
		clearResultsListenerList.add( ClearResultsListener.class, listener );
	}

	public void removeClearButtonListener ( ClearResultsListener listener )
	{
		clearResultsListenerList.remove( ClearResultsListener.class, listener );
	}

	protected void incompleteFormExceptionOccured (
			IncompleteFormException iFException )
	{
		JOptionPane.showMessageDialog( this, iFException.getMessage(),
				"Incomplete Form", JOptionPane.PLAIN_MESSAGE );
	}
}
