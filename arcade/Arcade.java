package arcade;

public class Arcade{
	private String name;

	//constructor
	public Arcade(String arcade_name){
		name=arcade_name;
	}

	public Arcade(String arcade_name, double starting_credits){
		name=arcade_name;
	}

	public String getName(){return name;}
	public void printName(){System.out.println(name);}
}