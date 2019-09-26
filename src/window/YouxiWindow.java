package window;

import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRootPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import youxi.Foe;
import youxi.Map;
import youxi.Tower;
import youxi.Usedate;
import youxi.Xianlu;

@SuppressWarnings("serial")
public class YouxiWindow  {

	Map map = new Map();
	Tower[][] tower = map.newtower();
	JLabel[][] talabel = new JLabel[6][12];
	JLabel movepicture;
	static int X, Y;
	static int talog = 0;
	JLabel ta1;
	JLabel ta2;
	JLabel ta3;
	JLabel ta4;
	JLabel jieshu;
	JLabel beijin ;
	private MyPanel contentPane;
	Component lblNewLabel_2;
/*
	*//**
	 * Launch the application.
	 *//*
	public static void main(String[] args) {
		YouxiWindow frame = new YouxiWindow();

	}
*/
	public void createta() {

		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 12; j++) {
				if (talabel[i][j] == null) {
					talabel[i][j] = new JLabel("");

				}
				if (tower[i][j] != null) {
					talabel[i][j].setBounds(tower[i][j].getX(), tower[i][j].getY(), 60, 70);
					switch (tower[i][j].getLeixing()) {
					case 1:
						talabel[i][j].setIcon((Picture.imgta1));

						break;
					case 2:
						talabel[i][j].setIcon((Picture.imgta2));

						break;
					case 3:
						talabel[i][j].setIcon((Picture.imgta3));

						break;
					case 4:
						talabel[i][j].setIcon((Picture.imgta4));

						break;
					}
				}
			}

		}

	}

	/**
	 * Create the frame.
	 */
	public YouxiWindow() {
		 JFrame f=new JFrame();
		f.setBounds(200, 30, 921, 691);
		f.setUndecorated(true);
	//	this.getRootPane().setWindowDecorationStyle(JRootPane.PLAIN_DIALOG);
		f.setVisible(true);
	
		

		contentPane = new MyPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		f.setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.getTower(tower);
	//	Usedate.setPeopel(10);

		Thread t1 = new Thread(contentPane);
		t1.start();

		Toolkit kit = Toolkit.getDefaultToolkit();
		Image image = kit.getImage("");
		Cursor cu = kit.createCustomCursor(image, new Point(20, 40), "stick");
		f.setCursor(cu);
		JLabel mymouse = new JLabel("");
		mymouse.setBounds(0, 0, Picture.ms.getIconHeight(), Picture.ms.getIconWidth());
		contentPane.add(mymouse);

		movepicture = new JLabel("");
		movepicture.setForeground(Color.RED);
		movepicture.setBackground(Color.RED);
		movepicture.setBounds(639, 471, Picture.yd.getIconWidth(), Picture.yd.getIconHeight());
		contentPane.add(movepicture);

		createta();
		for (int i = 0; i < 6; i++) {
			for (int j = 0; j < 12; j++) {
				if (talabel[i][j] != null) {
					contentPane.add(talabel[i][j]);
				}
			}
		}

		ta1 = new JLabel("");
		ta1.setBackground(new Color(30, 144, 255));
		ta1.setOpaque(true);
		ta1.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 255, 0), new Color(0, 255, 0),
				new Color(0, 255, 0), Color.GREEN));
		ta1.setBounds(672, 612, 60, 70);
		ta1.setIcon(Picture.imgta1);
		contentPane.add(ta1);

		ta2 = new JLabel("");
		ta2.setBackground(new Color(30, 144, 255));
		ta2.setOpaque(true);
		ta2.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 255, 0), new Color(0, 255, 0),
				new Color(0, 255, 0), Color.GREEN));
		ta2.setIcon((Picture.imgta2));
		ta2.setBounds(732, 612, 60, 70);
		contentPane.add(ta2);

		ta3 = new JLabel("");
		ta3.setBackground(new Color(30, 144, 255));
		ta3.setOpaque(true);
		ta3.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 255, 0), new Color(0, 255, 0),
				new Color(0, 255, 0), Color.GREEN));
		ta3.setIcon((Picture.imgta3));
		ta3.setBounds(792, 612, 60, 70);
		contentPane.add(ta3);

		ta4 = new JLabel("");
		ta4.setBackground(new Color(30, 144, 255));
		ta4.setOpaque(true);
		ta4.setBorder(new BevelBorder(BevelBorder.RAISED, new Color(0, 255, 0), new Color(0, 255, 0),
				new Color(0, 255, 0), Color.GREEN));
		ta4.setIcon((Picture.imgta4));
		ta4.setBounds(852, 612, 60, 70);
		
		contentPane.add(ta4);
		
		
		beijin = new JLabel(Picture.imgditu);
		Xianlu.luxian();
		beijin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {

				// genxinta
				System.out.println("test("+e.getX()+","+e.getY()+")");
				
				if(Usedate.getPeopel()<=0){
					//System.exit(0);
					
					 if( e.getX()>=543&&e.getX()<=723&&e.getY()>=343&&e.getY()<=396){
							
						 f.dispose(); 
					
						}
					 if( e.getX()>=281&&e.getX()<=336&&e.getY()>=343&&e.getY()<=396){
					
						Usedate.setPeopel(Usedate.getPeopel()+5);
					
					}
					
			
					
					//
				}
				talog = map.changemap(e.getX(), e.getY(), talog);

				tower = map.newtower();

				createta();
				
				Xianlu.luxian();

				contentPane.getlocation(map.getmaplocation(e.getX(), e.getY()));
				if (e.getX() >= 0 || e.getX() <= 100 || e.getY() >= 0 || e.getY() <= 40) {
					contentPane.setLog(1);
				} 
				 if( e.getX()>=20&&e.getX()<=70&&e.getY()>=630&&e.getY()<=680){
					 contentPane.setztlog(10);
					// System.out.println("zb11-----------");
				 }
				 if( e.getX()>=20&&e.getX()<=70&&e.getY()>=630&&e.getY()<=680){
					 contentPane.setztlog(10);
					// System.out.println("zb11-----------");
				 }
				 else if( e.getX()>=20+50&&e.getX()<=70+50&&e.getY()>=630&&e.getY()<=680){
					 contentPane.setztlog(0);
					// System.out.println("zb11-----------");
				 }
				 else if( e.getX()>=20+2*50&&e.getX()<=70+2*50&&e.getY()>=630&&e.getY()<=680){
					 contentPane.setztlog(1);
					 //System.out.println("zb11-----------");
				 }
				contentPane.getTower(tower);

				// 選擇塔
				if (e.getX() >= 672 && e.getX() <= (672 + 60) && e.getY() >= 612 && e.getY() <= (612 + 70)) {
					movepicture.setLocation(0, 0);
					movepicture.setBorder(null);
					movepicture.setIcon(null);
					if (talog == 1) {
						talog = 0;
					} else if (talog != 1) {
						talog = 1;
					}
				}

				else if (e.getX() >= 732 && e.getX() <= (732 + 60) && e.getY() >= 612 && e.getY() <= (612 + 70)) {
					movepicture.setLocation(0, 0);
					movepicture.setBorder(null);
					movepicture.setIcon(null);
					if (talog == 2) {
						talog = 0;
					} else if (talog != 2) {
						talog = 2;
					}
				} else if (e.getX() >= 792 && e.getX() <= (792 + 60) && e.getY() >= 612 && e.getY() <= (612 + 70)) {
					movepicture.setLocation(0, 0);
					movepicture.setBorder(null);
					movepicture.setIcon(null);
					if (talog == 3) {
						talog = 0;
					} else if (talog != 3) {
						talog = 3;
					}
				} else if (e.getX() >= 852 && e.getX() <= (852 + 60) && e.getY() >= 612 && e.getY() <= (612 + 70)) {
					movepicture.setLocation(0, 0);
					movepicture.setBorder(null);
					movepicture.setIcon(null);
					if (talog == 4) {
						talog = 0;
					} else if (talog != 4) {
						talog = 4;
					}
				}

			}
		});

		beijin.addMouseMotionListener(new MouseMotionAdapter() {
			@Override
			public void mouseMoved(MouseEvent e) {
				X = e.getX();
				Y = e.getY();
				// new drawyuang();
			
				
				mymouse.setLocation(e.getX() - 8, e.getY() - 8);
				mymouse.setIcon(Picture.ms);
				if (X <= 120 || X >= 840 || Y <= 146 || Y >= 146 + 70 * 6) {
					//contentPane.setLog(0);
					//contentPane.repaint();
					movepicture.setBorder(new LineBorder(Color.RED));
				} else if (map.getmaplog(X, Y) != 0) {

					movepicture.setBorder(new LineBorder(Color.RED));
				} else if (map.getmaplog(X, Y) == 0) {
					if (Usedate.getMoney() - (10 + talog * 5) >= 0) {
						movepicture.setBorder(new LineBorder(Color.GREEN));
					} else
						movepicture.setBorder(new LineBorder(Color.red));
				}

				if (e.getX() >= 672 && e.getX() <= (852 + 60) && e.getY() >= 612 && e.getY() <= (612 + 70)) {
					movepicture.setLocation(0, 0);
					movepicture.setBorder(null);
					movepicture.setIcon(null);
				} else if (talog == 1) {
					contentPane.setLog(2);
					contentPane.repaint();
					movepicture.setLocation(e.getX() - 30, e.getY() - 35);
					movepicture.setIcon(Picture.imgta1);
				} else if (talog == 2) {
					contentPane.setLog(2);
					contentPane.repaint();

					movepicture.setLocation(e.getX() - 30, e.getY() - 35);
					movepicture.setIcon(Picture.imgta2);
				} else if (talog == 3) {
					contentPane.setLog(2);
					contentPane.repaint();
					movepicture.setLocation(e.getX() - 30, e.getY() - 35);
					movepicture.setIcon(Picture.imgta3);
				} else if (talog == 4) {
					contentPane.setLog(2);
					contentPane.repaint();
					movepicture.setLocation(e.getX() - 30, e.getY() - 35);
					movepicture.setIcon(Picture.imgta4);
				} else if (talog == 0) {
					movepicture.setLocation(0, 0);
					movepicture.setIcon(null);
					movepicture.setBorder(null);
				}

			}
		});

	   

		beijin.setForeground(Color.WHITE);
		beijin.setBackground(Color.WHITE);
		beijin.setBounds(0, 0, Picture.imgditu.getIconWidth(), Picture.imgditu.getIconHeight());
		beijin.setIcon(Picture.imgditu);
		contentPane.add(beijin);

	}

}

@SuppressWarnings("serial")
class MyPanel extends JPanel implements Runnable {

	private int log = 0;
	private int ztlog = 0;

	Map m = new Map();
	Foe[][] f = m.createFoe();
	int[] location;

	int leixinglog;
	Tower tower[][];
	public void setztlog(int ztlog) {
		this.ztlog = ztlog;
	}
	public void getlocation(int[] t) {
		this.location = t;
	}

	public void getTower(Tower t[][]) {
		this.tower = t;
	}

	public int getLeixinglog() {
		return leixinglog;
	}

	public void setLeixinglog(int leixinglog) {
		this.leixinglog = leixinglog;
	}

	public int getLog() {
		return log;
	}

	public void setLog(int log) {
		this.log = log;
	}

	public void run() {

		// TODO Auto-generated method stub
		while (true) {

			try {
				if(ztlog==1){
					Thread.sleep(10);
				}
				
				else
					{Thread.sleep(60);}

			} catch (Exception e) {
				// TODO: handle exception
			}

			this.repaint();
		}

	}

	public void paint(Graphics g) {
		super.paint(g);
for (int j = 0; j < 3; j++) {
			for (int k = 0; k < 10; k++) {
				{
					if (k == 0) {
						if (j == 0) {
							if(ztlog!=10)
							{f[0][0].move();}
							f[0][0].paitfoe(g);
							for (int i = 0; i < 6; i++) {
								for (int l = 0; l < 12; l++) {
									// System.out.println("---test----"+f[0][0].getXieliang());
									if (f[0][0].getXieliang() > 0 && tower[i][l] != null) {
										if(ztlog!=10)
										{tower[i][l].intofanwei(f[0][0], g, 0);}
									}
								}
							}
						}
						if (j == 1 && f[0][9].getX() >= 850) {
							if(ztlog!=10)
							{f[1][0].move();}
							f[1][0].paitfoe(g);
							for (int i = 0; i < 6; i++) {
								for (int l = 0; l < 12; l++) {

									if (f[1][0].getXieliang() > 0 && tower[i][l] != null) {
										if(ztlog!=10)
										{tower[i][l].intofanwei(f[1][0], g, 0);}
									}
								}
							}
						}

						if (j == 2 && f[1][9].getX() >= 850) {
							if(ztlog!=10)
							{f[2][0].move();}
							f[2][0].paitfoe(g);
							for (int i = 0; i < 6; i++) {
								for (int l = 0; l < 12; l++) {

									if (f[2][0].getXieliang() > 0 && tower[i][l] != null) {
										if(ztlog!=10)
										{tower[i][l].intofanwei(f[2][0], g, 0);}
									}
								}
							}
						}

					}
				}

				if (k > 0 && f[j][k - 1].getX() > 120) {
					if(ztlog!=10)
					{f[j][k].move();}
					f[j][k].paitfoe(g);
					for (int i = 0; i < 6; i++) {
						for (int l = 0; l < 12; l++) {
							if (f[j][k].getXieliang() > 0 && tower[i][l] != null) {
								if(ztlog!=10)
								{tower[i][l].intofanwei(f[j][k], g, k);}
							}
						}
					}
				}

			}
		}
		if(Usedate.getPeopel()<=0){
		 g.drawImage(Picture.jx,83, 58, 787, 479, null);
		 this.setztlog(10);}
		if (log == 1) {

			if (tower[location[0]][location[1]] != null) {

				tower[location[0]][location[1]].drawO(g);// 范围
			}

		}
		if (log == 2) {
			m.drawjuxing(g);// 方框
		}
	
		 g.drawImage(Picture.zantin,20, 630, 50, 50, null);
		 g.drawImage(Picture.zta,70, 630, 50, 50, null);
		 g.drawImage(Picture.js,120, 630, 50, 50, null);
		
		
		Font font = new Font("", Font.BOLD, 30);
		Font font1 = new Font("", Font.BOLD, 20);
		String money = "金 币: " + Usedate.getMoney();
		String jifeng = "积 分：" + Usedate.getFengshu();
		String renko = " 人 口：" + Usedate.getPeopel();

		g.setFont(font);
		g.setColor(Color.green);
		g.fillRect(0, 0, 100, 40);
		g.setColor(Color.black);
		 g.drawString("退 出", 10, 30);
		g.setColor(Color.green);
		g.drawString(money, 600, 30);
		g.drawString(jifeng, 760, 30);
		g.setFont(font);
		g.setColor(Color.red);
		g.drawString(renko, 400, 30);
		g.setFont(font1);
		g.setColor(Color.yellow);
		g.drawString("15$", 685, 688);
		g.drawString("20$", 745, 688);
		g.drawString("25$", 805, 688);
		g.drawString("30$", 865, 688);

	}
}
