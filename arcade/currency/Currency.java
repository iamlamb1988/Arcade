package arcade.currency;

//An item that implements this can be used as compatible currency if applicable
//Should NOT be directly implemented outside of CurrencyInteger and/or CurrencyDecimal
public interface Currency{
	public String getName();
}
