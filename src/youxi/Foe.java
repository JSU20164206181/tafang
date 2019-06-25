package youxi;

import java.awt.Color;
import java.awt.Graphics;

import window.Picture;

public class Foe {
protected int leixing;
protected int xieliang;
protected int gonji;

protected int speed;
protected int num;

protected int x;
protected int y;
protected int fangxiang;


public int getFangxiang() {
	return fangxiang;
}
public int getSpeed() {
	return speed;
}
public void setSpeed(int speed) {
	this.speed = speed;
}
public int getNum() {
	return num;
}
public void setNum(int num) {
	this.num = num;
}

public void setlocation(int x,int y) {
	this.x = x;
	this.y = y;
}
public int getX() {
	return x;
}
public int getY() {
	return y;
}

public int next(int ax,  int ay){
	int i;
	for( i = 0;i<Xianlu.getlX().length;i++){
		if(Xianlu.lY[i]==0&&Xianlu.lX[i]==0){continue;}
		
		
	if(ax>=(Xianlu.lY[i]*60+120)&&ay>=(Xianlu.lX[i]*70+146)&&ax<(Xianlu.lY[i]*60+120+60)&&ay<(Xianlu.lX[i]*70+146+70))
	{	
		//System.out.println("daole "+Xianlu.lY[i]+"   "+Xianlu.lX[i]);
		break ;
		}
		
	}
	return i ;
}

public void move(){	
	
	if(x<=120&&y==391){
		
			fangxiang=1;
			x=x+this.speed;	
			
			return;
		}
	 if(x>=120+60*11&&y>146+2*70&&y<146+4*70){
			
			if(x>=(850)){
				fangxiang=0;
				if(	this.xieliang>0){
				Usedate.setPeopel(Usedate.getPeopel()-this.gonji);
				this.gonji=0;
				}
			
				return;
			}
			
			
			if(y<146+3*70-10)
			{	fangxiang=3;
				y=y+this.speed;}
			else if(y>146+3*70+10)
			{	fangxiang=2;
				y=y-this.speed;}
			else 
			{
				fangxiang=1;
				x=x+this.speed;}
			return;
		}
//	System.out.println("daole2");
	
	int i= next(x,y);
	//System.out.println("daole1- "+i+Xianlu.lY[i]+"   "+Xianlu.lX[i]);
	if(i==Xianlu.lX.length){return;}
	int nx=(Xianlu.lY[i+1]*60+120);
	int ny=(Xianlu.lX[i+1]*70+146);
	if(nx>x){
			fangxiang=1;
			x=x+this.speed;	
			
			return;	
	}
	
	 if(ny>y){
			fangxiang=3;
			y=y+this.speed;	
			return;	
	}	
	 else  if(ny<y){
		fangxiang=2;
		y=y-this.speed;	
		return;	
}		
	}

public void paitfoe(Graphics g){
	
	if(fangxiang!=0&&xieliang>0)
	{  g.setColor(Color.red);
	   g.drawRect(x+8,y-30,20+(leixing-1)*5+1, 5);
	       g.setColor(Color.green);
	   g. fillRect(x+9,y-29, xieliang, 4); }
    if(fangxiang==1&&xieliang>0){  
    	if(leixing==1){
        g.drawImage(Picture.g11, x,y-23, 40, 46, null);}
    	else if (leixing==2){
    		 g.drawImage(Picture.g21, x,y-23, 40, 46, null);
    	}
    	else if (leixing==3){
   		 g.drawImage(Picture.g31, x,y-23, 40, 46, null);
   	}
     }
    else if(fangxiang==2&&xieliang>0){   	  
    	if(leixing==1){
            g.drawImage(Picture.g12, x,y-23, 40, 46, null);}
        	else if (leixing==2){
         g.drawImage(Picture.g22, x,y-23, 40, 46, null);
        	}
        	else if (leixing==3){
       		 g.drawImage(Picture.g32, x,y-23, 40, 46, null);
       	}  }
    else if(fangxiang==3&&xieliang>0){   	 
    	if(leixing==1){
            g.drawImage(Picture.g13, x,y-23, 30, 45, null);}
        	else if (leixing==2){
        		 g.drawImage(Picture.g23, x,y-23, 40, 46, null);
        	}
        	else if (leixing==3){
       		 g.drawImage(Picture.g33, x,y-23, 40, 46, null);
       	}
    }
}
public int getXieliang() {
	return xieliang;
}
public int getLeixing() {
	return leixing;
}
public void setLeixing(int leixing) {
	this.leixing = leixing;
}


}

