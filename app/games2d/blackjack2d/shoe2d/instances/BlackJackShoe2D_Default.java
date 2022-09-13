package app.games2d.blackjack2d.shoe2d.instances;

import app.games2d.Drawable2D;

public class BlackJackShoe2D_Default extends BlackJackShoe_Default implements BlackJackShoe2D{
	public BlackJackShoe2D_Default(int width_px, int height_px){
		super();
		//Next: Type cast list to hold BlackJackShoe2D:
		//1. Establish a temporary animation factory.
		Card2DAnimationFactory aF = new Card2DAnimationFactory();
		aF.setActualSize(width_px,height_px);
		aF.setSpacing((int)(0.07*width_px),((int)(0.07*width_px)));
		aF.setSuitSize(20,30);
		aF.setFaceSize(20,30);
		aF.setBG(aF.genCardBorder(100, 125, 10)); //ARBITRARY NEEDS FIXED UPON 2D REFACTOR
		aF.setFaces();
		aF.setSuits();
		aF.setCards();

		//2. Set Background.
		aF.setBG(af.genShoeImg(width_px,height_px));

		//3. Assign images to 2D Cards.
		ArrayList<BlackJackShoe2D_Default> upgradeList = new ArrayList<BlackJackShoe2D_Default>();
		BlackJackCard2D_Default original;
		while(list.size()>0){
			original = list.remove(0);
			upgradeList.add(new BlackJackCard2D_Default(original,null,null));
		}
		list=upgradeList;

		//3. destruct animation factory.
		
	}

	//Drawable2D Overrides:
	public void drawTL(Graphics brush){}
	public void draw(Graphics brush, int xPos_px, int yPos_px){}
}