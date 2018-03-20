package view;

import java.util.EventListener;

public interface GenerationListener
		extends EventListener
{
	public void generationEventOccurred ( GenerationEvent event );
}
