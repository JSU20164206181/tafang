	package youxi;

import java.awt.Color;
import java.awt.Graphics;

public class Map  {
	
		private static int[][] maplog=new int[][]{ 
			 {0,0,0,0,0,0,0,1,0,0,0,0},
			 {0,0,1,0,0,0,2,0,0,0,0,0},
			 {10,0,2,0,0,0,0,0,0,0,0,10},
			 {10,0,0,0,4,1,1,1,0,0,0,10},
			 {0,0,1,2,0,0,0,0,1,0,0,0},
			 {0,0,0,1,0,0,1,0,0,0,0,0}};
			 //1žéËþÒ»
			 //0žé¿Õ
			 //10
			 
			 
			 private 	 Tower[][]  tower=new Tower[6][12];
			 private 	 Foe[][]    f=new Foe[3][10];
					
					
			 public void drawjuxing(Graphics g){
				 g.setColor(Color.GREEN);
				for(int i=0;i<6;i++){		
					    for (int j=0;j<12;j++){    		   
					    if((i==2||i==3)&&(j==0||j==11))
					    {}
					    else{
			     	    g.drawRect(120+j*60,            146+i*70,            60,            70);}
						}
					}
				}
			public static void printmap(){
				
				for(int i=0; i<6; i++)
			    {
					System.out.println();
			        for(int j=0; j<12; j++)
			        {
			        	System.out.print("   "+Map.maplog[i][j]);
			        
			        }
			        }
			}
			 public  Foe[][] createFoe(){
					
				 for(int i=0;i<10;i++){
					 f[0][i]=new Foe1();
					 f[1][i]=new Foe2();
					 f[2][i]=new Foe3(); 
				 }
				 	
				 	 
				return f;
				
				 }
			public Tower[][]    newtower(){  
				
						  for(int i=0; i<6; i++)
						    {
						        for(int j=0; j<12; j++)
						        {
						          
						                if(Map.maplog[i][j]!=10&&Map.maplog[i][j]!=0&&tower[i][j]==null)
						                {	 
						                	if(maplog[i][j]==1){			
											tower[i][j]=new Tower1();		
										
											
											System.out.println(" new Ëþ1 at :  "+i+"   "+j);
											}
										else if(maplog[i][j]==2){
											tower[i][j]=new Tower2();
											 System.out.println("new Ëþ2 at :   "+i+"   "+j);
											}
										else if(maplog[i][j]==3){
											tower[i][j]=new Tower3();	
											System.out.println("new Ëþ3 at£º "+i+"   "+j);
											}
										else if(maplog[i][j]==4){
											tower[i][j]=new Tower4();	
											System.out.println("new Ëþ4 at£º "+i+"   "+j);
											}
						                	 tower[i][j].setlocation(120+60*j, 146+i*70);
										}
						             
						            
						        
						        }}
							return this.tower;}
		public static int[][] getMaplog() {
			
			return maplog;
		}
		public void setMaplog(int[][] maplog) {
			Map.maplog = maplog;
		}
		
		public int changemap(int X,int Y,int talog){	
			
		    for(int i=0; i<6; i++)
		    { 
		        for(int j=0; j<12; j++)
		        {
		            if(X>=120+60*j&&X<=120+(j+1)*60&&
		                    Y>=146+i*70&&Y<=146+(i+1)*70)
		            {
		                if(Map.maplog[i][j]==0)
		                {
		                	if(Usedate.getMoney()- (10+talog*5)>0)
		                	{Map.maplog[i][j]=talog;
		               	 Usedate.setMoney(Usedate.getMoney()- (10+talog*5));
		                //System.out.println(this.maplog[i][j]);
		               	 talog=0;}
		               
		                }
		              
		            }
		        
		        }}
			return talog;
		   
		
		};	
		
		public static  int getmaplog(int X,int Y){	
			
			int result=0;
		    for(int i=0; i<6; i++)
		    {
		        for(int j=0; j<12; j++)
		        {
		            if(X>=120+60*j&&X<=120+(j+1)*60&&
		                    Y>=146+i*70&&Y<=146+(i+1)*70)
		            {
		            	 
		               result= Map.maplog[i][j];
		                //System.out.println(this.maplog[i][j]);	             
		            }
		        
		        }}
			return result;
		};	
		public  int[] getmaplocation(int X,int Y){	
			int[] location=new int[2];
		    for(int i=0; i<6; i++)
		    {
		        for(int j=0; j<12; j++)
		        {
		            if(X>=120+60*j&&X<=120+(j+1)*60&&
		                    Y>=146+i*70&&Y<=146+(i+1)*70)
		            {
		            	 
		                 location[0]=i;
		                 location[1]=j;
		            }
		        
		        }}
			return location;
		};	
	
		
	}
