package arcade.game;

import arcade.currency.Currency;
import java.util.List;

public interface Game{
	public String getName();

	//Generally will be one input and output credit
	public List<Currency> getInputCredits();
	public List<Currency> getOutputCredits();

	
}