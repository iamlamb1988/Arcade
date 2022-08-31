package arcade;

public class Arcade{
	private String name;
	private double credits;

	//constructor
	public Arcade(String arcade_name){
		name=arcade_name;
	}

	public Arcade(String arcade_name, double starting_credits){
		name=arcade_name;
		credits=starting_credits;
	}

	public String getName(){return name;}
	public void printName(){System.out.println(name);}
}