package view;

import java.util.EventObject;

import data.GenerationData;

public class GenerationEvent extends EventObject
{
	private static final long serialVersionUID = 1L;

	private GenerationData data;

	public GenerationEvent( Object source, GenerationData data )
	{
		super( source );
		this.data = data;
	}

	public GenerationData getData ()
	{
		return data;
	}
}
