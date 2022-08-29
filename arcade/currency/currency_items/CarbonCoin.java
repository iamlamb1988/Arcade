package arcade.currency.currency_items;

import arcade.currency.*;

public class CarbonCoin implements CurrencyDecimal{
	private double amount;

	public CarbonCoin(){amount=0;}
	public CarbonCoin(double initialAmount){amount=initialAmount;}

	//Currency Overrides
	@Override
	public String getName(){return "CarbonCoin";}

	//CurrencyDecimal Overrides
	@Override
	public double getDecAmnt(){return amount;}

	@Override
	public void changeDecAmnt(double changeAmount){amount+=changeAmount;}
}