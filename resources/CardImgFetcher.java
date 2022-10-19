package resources;

import java.awt.Image;
import java.awt.image.BufferedImage;
import java.awt.geom.AffineTransform;
import java.awt.Color;
import java.awt.Graphics2D;

public class CardImgFetcher extends ImgFetcher{
	private String[] fileName;
	private Image[] base;

	public CardImgFetcher(){
		super();
		fileName = new String[19];
		base = new Image[19];

		// fileName[0]="Zero.png";
		fileName[1]="One.png";
		fileName[2]="Two.png";
		fileName[3]="Three.png";
		fileName[4]="Four.png";
		fileName[5]="Five.png";
		fileName[6]="Six.png";
		fileName[7]="Seven.png";
		fileName[8]="Eight.png";
		fileName[9]="Nine.png";
		// fileName[10]=""; //NOTE: Watch this one!!
		fileName[11]="Jack.png";
		//fileName[12]="Queen.png";
		fileName[13]="King.png";
		fileName[14]="Ace.png";
		fileName[15]="Club.png";
		fileName[16]="Diamond.png";
		fileName[17]="Heart.png";
		fileName[18]="Spade.png";
	}

	public void fetchAll(){
		
		genZero();
		genOne();
		for(short i=2;i<10;++i){
			base[i]=genFileImage(fileName[i]);
		}
		genTen(base[1].getWidth(null),base[1].getHeight(null));
		base[11]=genFileImage(fileName[11]);
		genQueen();
		for(short i=13;i<fileName.length;++i){
			base[i]=genFileImage(fileName[i]);
		}
	}

	public void fetchAll(int width_px, int height_px){
		fetchAll();
		for(short i=0;i<base.length;++i){
			AffineTransform T=new AffineTransform();
			BufferedImage B = new BufferedImage(width_px,height_px,BufferedImage.TYPE_INT_ARGB);
			Graphics2D P = B.createGraphics();
			T.scale((double)width_px/base[i].getWidth(null),(double)height_px/base[i].getHeight(null));
			while(!P.drawImage(base[i],T,null)){}
			base[i]=B;
		}
	}

	public void genZero(){
		BufferedImage Z = new BufferedImage(500,500,BufferedImage.TYPE_INT_ARGB);

		Graphics2D p = Z.createGraphics();
		p.setColor(new Color(0,0,0,255));
		p.fillArc(0,0,500,500,0,360);
		p.setColor(new Color(255,0,255,255));
		p.fillArc(90,90,320,320,0,360);

		for(int x=0;x<Z.getWidth();++x){
			for(int y=0;y<Z.getHeight();++y){
				if(Z.getRGB(x,y)==0xffff00ff){
					Z.setRGB(x,y,0);
				}
			}
		}

		base[0]=Z;
	}

	public void genOne(){
		BufferedImage I = new BufferedImage(500,500,BufferedImage.TYPE_INT_ARGB);
		Graphics2D p = I.createGraphics();
		p.setColor(new Color(0,0,0,255));
		p.fillRect(45,410,410,90);
		p.fillArc(0,410,90,90,0,360);
		p.fillArc(410,410,90,90,0,360);
		p.fillRect(205,45,90,445);
		p.fillArc(205,0,90,90,0,360);
		p.fillRect(125,0,125,90);
		p.fillArc(80,0,90,90,0,360);
		base[1]=I;
	}

	public void genQueen(){
		if(base[0]==null)
			genZero();
		BufferedImage Q = new BufferedImage(base[0].getWidth(null),base[0].getHeight(null),BufferedImage.TYPE_INT_ARGB);
		Graphics2D p=Q.createGraphics();
		p.setColor(new Color(0,0,0,255));
		while(!p.drawImage(base[0],0,0,null)){}
		p.fillArc(205,205,90,90,0,360);
		p.fillArc(410,410,90,90,0,360);
		int[] x=new int[]{282,482,423,218};
		int[] y=new int[]{218,423,482,282};
		p.fillPolygon(x,y,4);
		base[12]=Q;
	}

	//require 0 and 1 to be generated
	public void genTen(int width_px, int height_px){
		Graphics2D P;
		double OldZeroW=base[0].getWidth(null),
			   OldZeroH=base[0].getWidth(null),
			   OldOneW=base[1].getWidth(null),
			   OldOneH=base[1].getHeight(null);

		BufferedImage R = new BufferedImage(width_px,height_px,BufferedImage.TYPE_INT_ARGB),
					  Z = new BufferedImage(width_px/2,height_px,BufferedImage.TYPE_INT_ARGB),
					  O = new BufferedImage(Z.getWidth(),height_px,BufferedImage.TYPE_INT_ARGB);

		AffineTransform ZeroT = new AffineTransform(),
						OneT = new AffineTransform();

		ZeroT.scale(Z.getWidth()/OldZeroW,height_px/OldZeroH);
		OneT.scale(O.getWidth()/OldOneW,height_px/OldOneH);

		P=O.createGraphics();
		while(!P.drawImage(base[1],OneT,null)){}

		P=Z.createGraphics();
		while(!P.drawImage(base[0],OneT,null)){}

		P=R.createGraphics();
		while(!P.drawImage(O,0,0,null)){}
		while(!P.drawImage(Z,Z.getWidth(),0,null)){}
		base[10]=R;
	}

	public Image getCardFace(char face){
		byte index;
		if(face=='T') index=(byte)10;
		else if(face=='J') index=(byte)11;
		else if(face=='Q') index=(byte)12;
		else if(face=='K') index=(byte)13;
		else if(face=='A') index=(byte)14;
		else{
			index = (byte)(face-'0');
			if(index < 2 || index > 9) return null;
		}

		if(base[index]==null) return super.genFileImage(fileName[index]);
		Image org = base[index];
		BufferedImage R = new BufferedImage(org.getWidth(null),org.getHeight(null),BufferedImage.TYPE_INT_ARGB);
		Graphics2D P = R.createGraphics();
		while(!P.drawImage(org,0,0,null)){}
		return R;
	}

	public Image getCardSuit(char suit){
		byte index;
		if(suit=='C'){index=(byte)15;}
		else if(suit=='D'){index=(byte)16;}
		else if(suit=='H'){index=(byte)17;}
		else if(suit=='S'){index=(byte)18;}
		else return null;

		Image org = base[index];
		BufferedImage R = new BufferedImage(org.getWidth(null),org.getHeight(null),BufferedImage.TYPE_INT_ARGB);
		Graphics2D P = R.createGraphics();
		while(!P.drawImage(org,0,0,null)){}
		return R;
	}
}