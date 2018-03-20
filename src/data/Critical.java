package data;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

public enum Critical
{
	NOTTHEFACE ( "Not The Face!",
			"Normal damage to the target and the target takes 2 Charisma drain as their face is made permanently disfigured (DC 15 Reflex negates disfigurement).",
			AttackType.BLUDGEONING, AttackType.PIERCING, AttackType.SLASHING,
			AttackType.MAGIC ),
	KNOCKBACK ( "Knockback",
			"Douuble damage and the target is pushed 1d6 squares directly away, provoking attacks of opportunity if appropriate (DC 20 Tumble negates).",
			AttackType.BLUDGEONING, AttackType.PIERCING, AttackType.MAGIC ),
	SPUNAROUND ( "Spun Around",
			"Normal damage and the target is flat-footed for 1 round (DC 20 Balance negates).",
			AttackType.BLUDGEONING, AttackType.PIERCING, AttackType.SLASHING ),
	RINGINGFINGER ( "Ringing Finger",
			"Normal damage but the target loses the use of one hand for 1d6 rounds, dropping any item held (DC 15 Fortitude negates).",
			AttackType.BLUDGEONING, AttackType.PIERCING, AttackType.SLASHING ),
	LEANINTOTHEBLOW ( "Lean Into The Blow",
			"Triple damage and the target is flat-footed until their next turn but you drop your weapon.",
			AttackType.BLUDGEONING, AttackType.PIERCING, AttackType.SLASHING ),
	PERFECTSTRIKE ( "Perfect Strike", "Triple damage", AttackType.BLUDGEONING,
			AttackType.PIERCING, AttackType.SLASHING ),
	LEGENDARYSTRIKE ( "Epic Strike", "Quadruple damage", AttackType.BLUDGEONING,
			AttackType.PIERCING, AttackType.SLASHING ),
	SHATTEREDJAW ( "Shattered Jaw",
			"Normal damage and 1 Constitution damage. The target cannot speak coherently, bite, or otherwise use their jaw until healed.",
			AttackType.BLUDGEONING, AttackType.SLASHING ),
	TWOFORONE ( "Two For One",
			"Double damage to the target and normal damage to one adjacent target (if desired).",
			AttackType.BLUDGEONING, AttackType.SLASHING ),
	ARMOURDAMAGE ( "Armour Damage",
			"Double damage and normal damage to non-metal armour.",
			AttackType.SLASHING, AttackType.PIERCING ),

	ARMOURDENT ( "Armour Dent",
			"Double damage and normal damage to metal armour.",
			AttackType.BLUDGEONING ),
	BACKBREAKER ( "Back Breaker", "Double damage and 1d6 Dexterity damage.",
			AttackType.BLUDGEONING ),
	BELLRINGER ( "Bell Ringer",
			"Normal damage and 1d2 Intelligence damage, and the target is sickened for 1d4 rounds.",
			AttackType.BLUDGEONING ),
	BREATHLESS ( "Breathless",
			"Normal damage but the target is exhausted for 1d4 rounds.",
			AttackType.BLUDGEONING ),
	BROKENRIBS ( "Broken Ribs",
			"Double damage and the target cannot heal naturally for 1d4 days unless healed magically of at least 10 points of damage in a single healing (DC 15 Fortitude negates).",
			AttackType.BLUDGEONING ),
	BROKENNOSE ( "Broken Nose",
			"Normal damage but 1 Charisma damage and 1 bleed damage.",
			AttackType.BLUDGEONING ),
	CRACKEDKNEE ( "Cracked Knee",
			"Normal damage but 1d2 Dexterity damage and the target's base land speed is reduced to 10 ft. until magically healed.",
			AttackType.BLUDGEONING ),
	CRUMPLINGBLOW ( "Crumpling Blow",
			"Double damage and the target is knocked prone.",
			AttackType.BLUDGEONING ),
	CRUSHEDTRACHEA ( "Crushed Trachea",
			"Normal damage and the target cannot breathe or speak. A DC 20 Heal check ends the condition.",
			AttackType.BLUDGEONING ),
	EARTHRUMBLE ( "Earth Rumble",
			"Normal damage but you may make a free trip attempt verses the target and all other adjacent opponents.",
			AttackType.BLUDGEONING ),
	FEEBLEPARRY ( "Feeble Parry",
			"Double damage and the target is disarmed of one item.",
			AttackType.BLUDGEONING ),
	FLATFOOT ( "Flat Foot",
			"Double damage and 1 Dexterity damage, and the target's speeds are reduced by 5 ft. until magically healed.",
			AttackType.BLUDGEONING ),
	HEMORRHAGE ( "Hemorrhage",
			"Normal damage but the target takes 1d4+1 rounds of 1d4 points of internal bleed damage that cannot be identified.",
			AttackType.BLUDGEONING ),
	LOWBLOW ( "Low Blow",
			"Normal damage but the target is sickened for 1d6 rounds.",
			AttackType.BLUDGEONING ),
	MINDBLOWN ( "Mind Blown",
			"Double damage and the target is dazed for 1d3 rounds.",
			AttackType.BLUDGEONING ),
	NUMBINGBLOW ( "Numbing Blow",
			"Normal damage but the target receives 1d4 Dex damage and is disarmed of one item (DC 15 Reflex negates being disarmed).",
			AttackType.BLUDGEONING ),
	RATTLED ( "Rattled",
			"Normal damage but the target is confused for 1d3 rounds (DC 15 Fortitude negates).",
			AttackType.BLUDGEONING ),
	SMASHEDOPEN ( "Smashed Open", "Double damage and 1d4 bleed damage.",
			AttackType.BLUDGEONING ),
	SORRYWHAT ( "Sorry, What!?",
			"Double damage and the target is deafened for 1d6 rounds or minutes, based on a corresponding 1d2 roll (DC 15 Fortitude negates).",
			AttackType.BLUDGEONING ),
	SWEETDREAMS ( "Sweet Dreams",
			"Normal damage but the target is knocked unconscious for 1d4 rounds (DC 15 Fortitude negates)" ),
	TERRIBLEBRUISE ( "Terrible Bruise",
			"Double damage and 2d6 nonlethal damage", AttackType.BLUDGEONING ),
	WHATJUSTHAPPENED ( "What Just Happened?",
			"Double damage and target has no recollection of the last 1d6 rounds (DC 17 Will negates).",
			AttackType.BLUDGEONING ),
	WHATSGOINGON ( "What's Going On?",
			"Double damage and 1d4 hours of the target's memory erased. (DC 15 Fortitude negates).",
			AttackType.BLUDGEONING ),
	WHEREAMI ( "Where Am I?",
			"Normal damage and the target is stunned for 1 round.",
			AttackType.BLUDGEONING ),
	WINDED ( "Winded",
			"Double damage and the target is fatigued for 1d3 rounds (DC 15 Fortitude negates).",
			AttackType.BLUDGEONING ),

	ACHILLESHEEL ( "Achilles' Heel",
			"Normal damage but additionally deal 1d2 Dex damage. The target's landspeed is reduced by half until magically healed.",
			AttackType.PIERCING ),
	CALFHOLE ( "Calf Hole", "Normal damage and 1d4 Dexterity damage.",
			AttackType.PIERCING ),
	CHEEKPIERCED ( "Cheek Pierced",
			"Normal damage and 1d4 bleed damage. The target gains 50% spell failure chance for verbal spells until healed.",
			AttackType.PIERCING ),
	DEEPWOUND ( "Deep Wound",
			"Double damage and the target is nauseated for 1 round (DC 15 Fortitude negates).",
			AttackType.PIERCING ),
	EYEPATCH ( "Eye Patch For You",
			"Triple damage and 1d2 Con drain, and -4 on ranged attacks, Spot checks, and Search checks until healed.",
			AttackType.PIERCING ),
	ELBOWPIERCED ( "Elbow Pierced",
			"Double damage and the target drops one item being held (of your choice)." ),
	GUARDEDSTRIKE ( "Guarded Strike",
			"Double damage and +4 to your AC for 1 round.",
			AttackType.PIERCING ),
	LEFTREELING ( "Left Reeling",
			"Double damage and the target takes a -2 penalty to AC for 1d4 rounds.",
			AttackType.PIERCING ),
	INAROW ( "In A Row",
			"Double damage to the target and normal damage to one target adjacent to the target and in your reach (if desired).",
			AttackType.PIERCING ),
	ORGANSCRAMBLE ( "Scrambled Organs",
			"Double damage and 1d6 Constitution damage.", AttackType.PIERCING ),
	PAINFULPOKE ( "Painful Poke",
			"Double damage and the target can take only one move or standard action next round.",
			AttackType.PIERCING ),
	PIERCED ( "Pierced", "Double damage and the target is dazed for 1 round.",
			AttackType.PIERCING ),
	PINNEDARM ( "Pinned Arm",
			"Double damage and one arm cannot move (DC 20 Strength or Heal check to be freed).",
			AttackType.PIERCING ),
	PUNCTURE ( "Puncture",
			"Double damage and the target takes 1d4 bleed damage for 1d6 rounds.",
			AttackType.PIERCING ),
	SHOULDERWOUND ( "Should Wound",
			"Double damage and 1d2 Strength and 1d2 Dexterity damage.",
			AttackType.PIERCING ),
	SPINALTAP ( "Spinal Tap",
			"Normal damage and -4 penalty on attack rolls, skill checks, and ability checks for 1d4 rounds.",
			AttackType.PIERCING ),
	STINGER ( "Stinger",
			"Normal damage but the target is sickened for 1d6 rounds.",
			AttackType.PIERCING ),
	SUCKINGCHESTWOUND ( "Sucking Chest Wound",
			"Double damage and the target is exhausted (DC 15 Fortitude negates).",
			AttackType.PIERCING ),
	SURPRISEOPENING ( "Surprise Opening",
			"Double damage and one free attack against the target with a -5 penalty.",
			AttackType.PIERCING ),
	VULNERABLESPOT ( "Vulnerable Spot",
			"Normal damage and the target takes 1d4 ability damage of your choice.",
			AttackType.PIERCING ),
	WITHATWIST ( "With a Twist",
			"Normal damage but the target takes 1d4 bleed damage for 1d12 rounds until healed magically or passing a Heal check (DC 10 + damage originally received) as a full-round action.",
			AttackType.PIERCING ),

	ACROSSTHEEYES ( "Across The Eyes",
			"Normal damage and the target is permanently blinded (Reflex DC 10 negates).",
			AttackType.SLASHING ),
	BADPARRY ( "Bad Parry",
			"Double damage and the target is disarmed of one item.",
			AttackType.SLASHING ),
	BROWCUT ( "Brow Cut",
			"Normal damage but 1d4 bleed damage. The target is blinded while bleeding.",
			AttackType.SLASHING ),
	CARVEYOURINITIALS ( "Carve Your Initials",
			"Normal damage but the target suffers from humiliation and may only attack you (when possible) (Will negates).",
			AttackType.SLASHING ),
	CUTSTRAPS ( "Cut The Straps",
			"Double damage and double armour check penalty until fixed (DC 15 Craft check).",
			AttackType.SLASHING ),
	FLATBLADETHWACK ( "Flat Blade Thwack",
			"Double damage but all damage is nonlethal and bludgeoning.",
			AttackType.SLASHING ),
	FLAY ( "Flay",
			"Normal damage but the target takes 1d4 bleed damage for 1d12 rounds until healed magically or passing a Heal check (DC 10 + damage originally received) as a full-round action.",
			AttackType.SLASHING ),
	GUTWRENCHING ( "Gut-Wrenching",
			"Double damage and the target takes 1d3 Constitution drain from a deep cut in their torso.",
			AttackType.SLASHING ),
	HAMSTRING ( "Hamstring",
			"Normal damage and 1d2 Dexterity damage, and the target is knocked prone.",
			AttackType.SLASHING ),
	HEARHEAR ( "Hear Hear",
			"Normal damage but the target takes 1 Charisma drain and suffers a -4 penalty on Listen checks until magically healed.",
			AttackType.SLASHING ),
	LONGGASH ( "Long Gash",
			"Normal damage and 8 bleed damage. A successful Heal check cuts the bleeding in half, rather than ending it.",
			AttackType.SLASHING ),
	MOMENTUM ( "Momentum",
			"Double damage and +2 on all of your attack rolls for 1 round.",
			AttackType.SLASHING ),
	NERVESLICE ( "Nerve Slice",
			"Double damage and the target can take only one move or standard action next round.",
			AttackType.SLASHING ),
	OVERHANDCHOP ( "Overhand Chop",
			"Double damage and the target takes 1d4 bleed damage.",
			AttackType.SLASHING ),
	SAPPINGSLASH ( "Sapping Slash", "Double damage and the target is fatigued.",
			AttackType.SLASHING ),
	SEVEREDTENDON ( "Severed Tendon",
			"Normal damage but the target takes 1d6 Dexterity damage.",
			AttackType.SLASHING ),
	SHIELDCLEAVE ( "Shield Cleave",
			"Double damage and normal damage to the target's shield.",
			AttackType.SLASHING ),
	SLICEANARTERY ( "Deeply Cut",
			"Double damage and the target takes 1d4 Constitution damage and 1d4 bleed for 1d6 rounds.",
			AttackType.SLASHING ),
	THROATSLASH ( "Throat Slash",
			"Normal damage but 2d6 bleed damage. The target cannot talk or breath while bleeding.",
			AttackType.SLASHING ),
	UGLYWOUND ( "Ugly Wound",
			"Normal damage but 1d3 Charisma damage and 1 Charisma drain (DC 15 Fortitude negates the drain)",
			AttackType.SLASHING ),
	WEVEGOTABLEEDER ( "We've Got A Bleeder",
			"Normal damage but 2d6 bleed damage.", AttackType.SLASHING ),
	WINGTEAR ( "Wing Tear",
			"Double damage and the target loses flight if it uses wings.",
			AttackType.SLASHING ),

	ARCANEBLACK ( "Arcane Blast",
			"Double damage and 2d6 random energy damage (DC 15 Reflex halves energy damage)",
			AttackType.MAGIC ),
	ARCANEGLOW ( "Arcane Glow",
			"Double damage and the target glows like faerie fire for 1d6 rounds.",
			AttackType.MAGIC ),
	ARCANEGOO ( "Arcane Goo",
			"Normal damage but the target is entangled (DC 20 Strength or Escape Artist check to be freed).",
			AttackType.MAGIC ),
	AURAOFPROTECTION ( "Aura Of Protection",
			"Double damage and +4 to your AC for 1 round.", AttackType.MAGIC ),
	CUTOFFFROMMAGIC ( "Cut Off From Magic",
			"Normal damage but the target cannot cast spells or use spell-like abilities for 1d4 rounds",
			AttackType.MAGIC ),
	DISPELLINGAURA ( "Dispelling Aura",
			"Normal damage and you dispel magic on the target.",
			AttackType.MAGIC ),
	DISTRACTION ( "Distraction",
			"Double damage and an illusion appears to attack your target, flanking them for you for 1d6 rounds.",
			AttackType.MAGIC ),
	DRAININGSPELL ( "Draining Spell",
			"Double damage and the target randomly loses one spell or one use of a spell-like ability",
			AttackType.MAGIC ),
	ELEMENTALCALL ( "Elemental Call",
			"Normal damage. If you are casting an elemental spell, a Medium elemental appears to serve for 1d4 rounds.",
			AttackType.MAGIC ),
	LEGENDARYMAGICALCHANNELING ( "Epic Surge", "Quadruple damage.",
			AttackType.MAGIC ),
	LIFELEECH ( "Life Leech",
			"Normal damage but 1 negative level for 1 day (DC 17 Fort negates).",
			AttackType.MAGIC ),
	LIGHTBLASH ( "Light Blash",
			"Double damage and the target is blinded for 1 round.",
			AttackType.MAGIC ),
	MINDCLOUD ( "Mind Cloud",
			"Double damage and the target is dazed for 1 round.",
			AttackType.MAGIC ),
	NERVEDAMAGE ( "Nerve Damage",
			"Normal damage but the target is slowed for 1d6 rounds.",
			AttackType.MAGIC ),
	PETRIFIED ( "Petrified",
			"Normal damage and the target is petrified for 1d4 hours (DC 15 Fortitude negates)",
			AttackType.MAGIC ),
	POWERSURGE ( "Power Surge", "Triple damage.", AttackType.MAGIC ),
	SIDEAFFECT ( "Side Affect",
			"Double damage to the target and a different adjacent target to you becomes invisible for 1d4 rounds (as the Invisibility spell).",
			AttackType.MAGIC ),
	SIDEEFFECT ( "Side Effect",
			"Double damage and you become invisible for 1d4 rounds (as the Invisibility spell).",
			AttackType.MAGIC ),
	SIRENSONG ( "Siren Song",
			"Double damage, except to giants, humanoids, and monstrous humanoids, to which you deal triple damage.",
			AttackType.MAGIC ),
	TURNEDAROUND ( "Turned Around",
			"Double damage and the target can only take one standard (or move) action next round.",
			AttackType.MAGIC ),
	WHENSOMETHINGTICKLESYOU ( "When Something Tickles You",
			"Double damage and the target uncontrollably laughs for 1 round (as the Hideous Laughter spell) (Will negates).",
			AttackType.MAGIC ),
	WILDSURGE ( "Wild Surge",
			"Normal damage and normal damage of a random energy type.",
			AttackType.MAGIC ),

	FLASHBANG ( "Flashbang",
			"Double damage and the target is dazed for 1d4 rounds.",
			AttackType.MAGIC, MagicDamageType.LIGHTNING ),

	VULNERABILITY ( "Vulnerability",
			"Double damage and the target is vulnerable to one element which they took damage from in the attack.",
			MagicDamageType.FIRE, MagicDamageType.FROST,
			MagicDamageType.LIGHTNING ),
	ELEMENTALSURGE ( "Elemental Surge",
			"Normal damage but the elemental damage is tripled.",
			MagicDamageType.FIRE, MagicDamageType.FROST,
			MagicDamageType.LIGHTNING ),

	COMBUSTION ( "Combustion",
			"Double damage and the target catches fire, taking 2d6 fire damage per round until extinguished (requiring a move action).",
			MagicDamageType.FIRE ),

	FREEZE ( "Freeze!",
			"Normal damage but the target feels frozen and is unable to move for 1d3 rounds.",
			MagicDamageType.FROST ),
	FROSTBITE ( "Frostbite", "Normal damage, loses 1d4 fingers.",
			MagicDamageType.FROST ),

	ELECTROCUTED ( "Electrocuted",
			"Double damage and the target is stunned for 1d4 rounds.",
			MagicDamageType.LIGHTNING ),
	SHOCKED ( "Shocked",
			"Normal damage but the target is frozen other than minor spasms for 1d3 round.",
			MagicDamageType.LIGHTNING ),

	BLOWBACK ( "Blowback!",
			"Instead of normal damage, the target receives and extra 1d6 sonic damage and is pushed back 15ft and knocked prone. Any other creature in the target's path is also blown back",
			MagicDamageType.SONIC );

	public String				name;
	public String				description;
	public AttackType[]			attackTypes;
	public MagicDamageType[]	magicDamageTypes;

	Critical( String name, String description )
	{
		this.name = name;
		this.description = description;
		this.attackTypes = new AttackType[ 0 ];
		this.magicDamageTypes = new MagicDamageType[ 0 ];
	}

	Critical( String name, String description,
			MagicDamageType... magicDamageTypes )
	{
		this.name = name;
		this.description = description;
		this.attackTypes = new AttackType[ 0 ];
		this.magicDamageTypes = magicDamageTypes;
	}

	Critical( String name, String description, AttackType attackType,
			MagicDamageType... magicDamageTypes )
	{
		this.name = name;
		this.description = description;
		this.attackTypes = new AttackType[ 1 ];
		this.attackTypes[ 0 ] = attackType;
		this.magicDamageTypes = magicDamageTypes;
	}

	Critical( String name, String description, AttackType attackType0,
			AttackType attackType1, MagicDamageType... magicDamageTypes )
	{
		this.name = name;
		this.description = description;
		this.attackTypes = new AttackType[ 2 ];
		this.attackTypes[ 0 ] = attackType0;
		this.attackTypes[ 1 ] = attackType1;
		this.magicDamageTypes = magicDamageTypes;
	}

	Critical( String name, String description, AttackType attackType0,
			AttackType attackType1, AttackType attackType2,
			MagicDamageType... magicDamageTypes )
	{
		this.name = name;
		this.description = description;
		this.attackTypes = new AttackType[ 3 ];
		this.attackTypes[ 0 ] = attackType0;
		this.attackTypes[ 1 ] = attackType1;
		this.attackTypes[ 2 ] = attackType2;
		this.magicDamageTypes = magicDamageTypes;
	}

	Critical( String name, String description, AttackType attackType0,
			AttackType attackType1, AttackType attackType2,
			AttackType attackType3, MagicDamageType... magicDamageTypes )
	{
		this.name = name;
		this.description = description;
		this.attackTypes = new AttackType[ 4 ];
		this.attackTypes[ 0 ] = attackType0;
		this.attackTypes[ 1 ] = attackType1;
		this.attackTypes[ 2 ] = attackType2;
		this.attackTypes[ 3 ] = attackType3;
		this.magicDamageTypes = magicDamageTypes;
	}

	public static Critical[] getCriticalsOfType ( AttackType attackType,
			MagicDamageType... magicDamageTypes )
	{
		List<Critical> validCriticals = new LinkedList<Critical>();

		List<MagicDamageType> magicDamageTypesList = Arrays
				.asList( magicDamageTypes );

		for ( Critical critical : Critical.values() )
		{
			if ( arrayContains( critical.attackTypes, attackType )
					|| !disjoint( magicDamageTypesList,
							critical.magicDamageTypes ) )
			{
				validCriticals.add( critical );
			}
		}

		return validCriticals.toArray( new Critical[ validCriticals.size() ] );
	}

	private static boolean disjoint ( List<?> list, Object[] objs )
	{
		for ( Object obj : objs )
		{
			if ( list.contains( obj ) )
				return false;
		}
		return true;
	}

	private static boolean arrayContains ( Object[] objs, Object target )
	{
		for ( Object obj : objs )
			if ( obj.equals( target ) )
				return true;

		return false;
	}
}
