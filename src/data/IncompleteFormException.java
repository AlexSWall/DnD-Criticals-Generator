package data;

public class IncompleteFormException extends Exception
{
	private static final long serialVersionUID = 1L;

	String incompleteField;

	public IncompleteFormException( String incompleteField )
	{
		this.incompleteField = incompleteField;
	}

	@Override
	public String getMessage ()
	{
		return "Pleased choose an option for the " + incompleteField
				+ " field.";
	}
}
