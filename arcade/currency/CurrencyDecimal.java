package arcade.currency;

//holds a double type amount
public interface CurrencyDecimal extends Currency{
	public double getDecAmnt();
	public void changeDecAmnt(double changeAmount);
}
