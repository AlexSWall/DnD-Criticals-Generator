package data;

public enum AttackType
{
	BLUDGEONING, SLASHING, PIERCING, MAGIC;

	public static AttackType fromString ( String text )
	{
		for ( AttackType e : AttackType.values() )
		{
			if ( e.name().equalsIgnoreCase( text ) )
				return e;
		}

		throw new IllegalArgumentException(
				"No constant with text '" + text + "' found." );
	}
}
