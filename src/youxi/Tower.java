package youxi;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.awt.image.ImageObserver;

public  class Tower {
	protected int leixing;
	protected int gouji;
	protected  int fangwei;
	protected  int x;
	protected  int y;
	protected  int money;
	protected  int zx=x+20;
	protected  int zy=y+9;
	protected int  log=111;
public void intofanwei (Foe a,Graphics g,int logi){
	if(log==111){
		log=logi;
	}
	if(log!=logi){
		return;
	}
		int r= (120+this.leixing*30);
		
		//System.out.println( "  -------"+a.getLeixing()+"µÚ"+logi +" ßMÈë");
	
		if((x-a.x)*(x-a.x)+(y-a.y)*(y-a.y)<=(r*r)/4&&a.xieliang>0){
			
			//System.out.println( "                 ----+-----------2");
		 Image image4=Toolkit.getDefaultToolkit().getImage(Tower.class.getResource("/img/ta1-a.png"));
		 
			Image image5=Toolkit.getDefaultToolkit().getImage(Tower.class.getResource("/img/boon.png"));		
			 Image image6=Toolkit.getDefaultToolkit().getImage(Tower.class.getResource("/img/ta2-a.png"));
			 Image image7=Toolkit.getDefaultToolkit().getImage(Tower.class.getResource("/img/ta3-a.png"));
			 Image image8=Toolkit.getDefaultToolkit().getImage(Tower.class.getResource("/img/ta4-a.png"));
			  if((zx-a.x)*(zx-a.x)+(zy-a.y)*(zy-a.y)>=25)
			  { 
				 if(this.leixing==1) { 
					 g.drawImage(image4, zx,zy, 15, 15, null);	
				 }
				 else if(this.leixing==2){
					 g.drawImage(image6, zx,zy, 15, 15, null);
				 }
				 else if(this.leixing==3){
					 g.drawImage(image7, zx,zy, 15, 15, null);
				 }
				 else if(this.leixing==4){
					 g.drawImage(image8, zx,zy, 15, 15, null);
				 }
				    
			    
				  if(zx-a.x>0){
			    	zx=zx-5;
			    }
			    else  if(zx-a.x<0){
			    	zx=zx+5;
			    }
				  if(zy-a.y>0){
			    	zy=zy-5;
			    }else  if(zy-a.y<0){
			    	zy=zy+5;
			    }}			
			  if((zx-a.x)*(zx-a.x)+(zy-a.y)*(zy-a.y)<25)
				 { 
			    	
				    g.drawImage(image5,a.x+10,a.y-23, 20, 20, null);	
				    g.drawImage(image5,a.x+30,a.y-23, 20, 20, null);	
				    g.drawImage(image5,a.x+10,a.y-3, 20, 20, null);	
				    g.drawImage(image5,a.x+30,a.y-3, 20, 20, null);	
					 a.xieliang=a.xieliang-this.gouji;	
					 if(a.xieliang<=0){
						 Usedate.setFengshu( Usedate.getFengshu()+a.leixing*10);
						 Usedate.setMoney(Usedate.getMoney()+a.leixing*5);
					 }
					 zx=x+20;
					 zy=y+9;
					 log=111;
				 }
			  				     
			}
		else{
			 zx=x+20;
			 zy=y+9;
			 log=111;
		}
			  
		}
	
	
	
	public void drawO(Graphics g ){
		int r= (120+this.fangwei*30);	
		 g.setColor(Color.red);
	
		if(leixing!=0){
			 g.drawOval(x+30-r/2, y+35-r/2,r,r);

		}
					 	           
		    }
	
	public void setlocation(int x,int y){
		this.setX(x);
		this.setY(y);
	}
	public int getFangwei() {
		return fangwei;
	}
	public void setFangwei(int fangwei) {
		this.fangwei = fangwei;
	}
	public int getGouji() {
		return gouji;
	}
	public void setGouji(int gouji) {
		this.gouji = gouji;
	}
	public int getLeixing() {
		return leixing;
	}
	public void setLeixing(int leixing) {
		this.leixing = leixing;
	}
	public int getX() {
		return x;
	}
	public void setX(int x) {
		this.x = x;
	}
	public int getY() {
		return y;
	}
	public void setY(int y) {
		this.y = y;
	}
	
 }
