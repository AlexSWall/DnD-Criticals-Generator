package data;

public class GenerationData
{
	public AttackType			attackType;
	public MagicDamageType[]	magicDamageTypes;
	public int					multiplier;

	public GenerationData( AttackType attackType, MagicDamageType[] damageType,
			int multiplier )
	{
		this.attackType = attackType;
		this.magicDamageTypes = damageType;
		this.multiplier = multiplier;
	}
}
