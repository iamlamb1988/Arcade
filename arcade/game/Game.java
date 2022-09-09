package arcade.game;

import arcade.HonorCode;
import arcade.currency.Currency;
import java.util.List;

public interface Game extends HonorCode{
	public String getName();
	public boolean isHonest();

	//Generally will be one input and output credit
	public List<Currency> getInputCredits();
	public List<Currency> getOutputCredits();
}