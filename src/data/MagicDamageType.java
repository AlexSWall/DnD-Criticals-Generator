package data;

public enum MagicDamageType
{
	ARCANE, ACID, FIRE, FORCE, FROST, LIGHTNING, SONIC;

	public static MagicDamageType fromString ( String text )
	{
		for ( MagicDamageType e : MagicDamageType.values() )
		{
			if ( e.name().equalsIgnoreCase( text ) )
				return e;
		}

		throw new IllegalArgumentException(
				"No constant with text '" + text + "' found." );
	}
}
