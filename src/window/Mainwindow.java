package window;

import java.applet.AudioClip;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;

import javax.sound.sampled.AudioFormat;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.DataLine;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.SourceDataLine;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.Font;
import java.awt.Image;
import java.awt.Point;
import java.awt.Toolkit;
import java.awt.Color;
import java.awt.Cursor;

import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;

public class Mainwindow extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	static int x,y;
	static int log=0;
	Music music=new Music();
	 private  JLabel beijin ;
	 private  JButton tuichu;
	 private  JButton bangzhu;
	 private  JButton xuanxiang;
	 private  JButton defeng;
	 private  JButton jixu;
	 private JButton fou;
	 private JButton shi;
	 private JButton kaishiyouxi;
	 private JLabel yinyue ;
	 
	 private JLabel jifeng;
	 private JButton jifengtuichu;
	 private JLabel bz;
	 private JButton bz1;
	 private JButton bz2;
	/**
	 * Launch the application.
	 */
	/*public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Mainwindow frame = new Mainwindow();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}*/

	/**
	 * Create the frame.
	 */
	public Mainwindow() {
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(200, 30, 921, 691);
		getContentPane().setLayout(null);
		this.setUndecorated(true);
		setVisible(true);
		
		
		
		
		
		kaishiyouxi = new JButton("");
		kaishiyouxi.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(log==0)
				{kaishiyouxi.setIcon(Picture.img1);}
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				kaishiyouxi.setIcon(null);
			}
		});
		kaishiyouxi.setBackground(UIManager.getColor("Button.light"));
		kaishiyouxi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				if(log==0){
             YouxiWindow frame = new YouxiWindow();
				//frame.setVisible(true);
				//setVisible(false);
				}
			}
		});		
	
		shi = new JButton("");
		shi.setFont(new Font("ËÎÌå", Font.BOLD, 42));
		shi.setForeground(new Color(255, 215, 0));
		shi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {		
				if(log==4){
				music.star();
				try {					
					Thread.sleep(1000);
					
				} catch (Exception e1) {
					// TODO: handle exception
				}
				yinyue.setIcon(null);		
			}
				log=0;}
		});
		shi.setBounds(227, 367, 97, 73);
		shi.setBorderPainted(false);
		shi.setContentAreaFilled(false);	
		getContentPane().add(shi);

		fou = new JButton("");
		fou.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(log==4)
				{music.stop();
				try {					
					Thread.sleep(1000);
					
				} catch (Exception e) {
					// TODO: handle exception
				}
				log=0;
				yinyue.setIcon(null);
			}}
		});
		
		fou.setForeground(new Color(255, 215, 0));
		fou.setFont(new Font("ËÎÌå", Font.BOLD, 42));
		fou.setContentAreaFilled(false);
		fou.setBorderPainted(false);
		fou.setBounds(584, 367, 97, 73);
		getContentPane().add(fou);
		
		 yinyue = new JLabel("");
		yinyue.setIcon(null);
		yinyue.setForeground(new Color(255, 255, 0));
		yinyue.setHorizontalAlignment(SwingConstants.CENTER);
		yinyue.setFont(new Font("ËÎÌå", Font.BOLD, 42));
		
		yinyue.setBounds(138, 146, 690, 340);
		getContentPane().add(yinyue);
		kaishiyouxi.setBorderPainted(false);
		kaishiyouxi.setContentAreaFilled(false);
		kaishiyouxi.setBounds(23+1, 580-5, 164, 73);
		getContentPane().add(kaishiyouxi);
	
		
        jixu = new JButton("");
		jixu.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(log==0){
				jixu.setIcon(Picture.img2);}
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				jixu.setIcon(null);
			}
		});
		jixu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
			}
		});
		jixu.setBorderPainted(false);
		jixu.setContentAreaFilled(false);	
		jixu.setBounds(193+1, 597-3, 176, 73);
		getContentPane().add(jixu);
		
		defeng = new JButton("");
		 defeng.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(log==0){
				 defeng.setIcon(Picture.img3);}
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				 defeng.setIcon(null);
			}
		});
		defeng.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				log=3;
				jifeng.setIcon(new ImageIcon(Mainwindow.class.getResource("/img/gaofen.png")));
			}
		});
		defeng.setBorderPainted(false);
		defeng.setContentAreaFilled(false);	
		defeng.setBounds(373+1, 583-5, 164, 73);
		getContentPane().add(defeng);
		xuanxiang = new JButton("");
		xuanxiang .addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(log==0){
				xuanxiang .setIcon(Picture.img4);}
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				xuanxiang .setIcon(null);
			
			}
		});
		
		xuanxiang.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				log=4;
				yinyue .setIcon(new ImageIcon(Mainwindow.class.getResource("/img/yinyue.png")));
				
			}
		});
		xuanxiang.setBorderPainted(false);
		xuanxiang.setContentAreaFilled(false);	
		xuanxiang.setBounds(546, 597, 164, 73);
		getContentPane().add(xuanxiang);
		
		
		
		 bangzhu = new JButton("");	
		bangzhu .addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				if(log==0){
				bangzhu .setIcon(Picture.img5);}
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				bangzhu .setIcon(null);
			}
		});
		bangzhu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				bz.setIcon(new ImageIcon(Mainwindow.class.getResource("/img/bangzhu1.png")));
				log=51;
			}
		});
		 bangzhu.setBorderPainted(false);
		 bangzhu.setContentAreaFilled(false);	
		bangzhu.setBounds(746+1, 598-5, 155, 73);
		getContentPane().add(bangzhu);
		
	 tuichu = new JButton();
		tuichu .addMouseListener(new MouseAdapter() {
			@Override
			public void mouseEntered(MouseEvent arg0) {
				{
				tuichu .setIcon(Picture.img6);}
			}
			@Override
			public void mouseExited(MouseEvent arg0) {
				tuichu .setIcon(null);
			}
		});
		
		tuichu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(log==0){
				System.exit(0);}
				
			}
		});
		tuichu.setContentAreaFilled(false);	//±³¾°Í¸Ã÷
		tuichu.setBorderPainted(false);//Í¼Æ¬Í¸Ã÷	
		tuichu.setBounds(10+1, 20-5, 97, 63);
		getContentPane().add(tuichu);
	
		
		 beijin = new JLabel("");
		beijin.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				
				x=e.getX();
				y=e.getY();
				System.out.println("X="+x+"  Y="+y);
				//kaishiyouxi.setIcon(null);
			//	jixu.setIcon(null);
			
			}
		});
		
		jifengtuichu = new JButton("");
		jifengtuichu.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(log==3){
				jifeng.setIcon(null);
				log=0;}
		
			if(log==51||log==52||log==53){
				bz.setIcon(null);
				log=0;
			}	
			}
		});
		
		bz2 = new JButton("");
		bz2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(log==51){
					bz.setIcon(new ImageIcon(Mainwindow.class.getResource("/img/bangzhu2.png")));
					log=52;
				}
				else if(log==52){
					bz.setIcon(new ImageIcon(Mainwindow.class.getResource("/img/bangzhu3.png")));
					log=53;
				}
				else if(log==53){
					bz.setIcon(null);
					log=0;
				}
			}
		});
		bz2.setContentAreaFilled(false);
		bz2.setBorderPainted(false);
		bz2.setBounds(815, 278, 75, 182);
		getContentPane().add(bz2);
		
		bz1 = new JButton("");
		bz1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(log==52){
					bz.setIcon(new ImageIcon(Mainwindow.class.getResource("/img/bangzhu1.png")));
					log=51;
				}
				else if(log==53){
					bz.setIcon(new ImageIcon(Mainwindow.class.getResource("/img/bangzhu2.png")));
					log=52;
				}
				else if(log==51){
					bz.setIcon(null);
					log=0;
				}
			}
		});
		bz1.setContentAreaFilled(false);
		bz1.setBorderPainted(false);
		bz1.setBounds(32, 278, 75, 182);
		getContentPane().add(bz1);
		
		bz = new JLabel("");
		
		bz.setBounds(-1, 0, 921, 691);
		getContentPane().add(bz);
		jifengtuichu.setBounds(815, 20, 75, 63);
		jifengtuichu.setContentAreaFilled(false);	//±³¾°Í¸Ã÷
		jifengtuichu.setBorderPainted(false);//Í¼Æ¬Í¸Ã÷	
		getContentPane().add(jifengtuichu);
		
		jifeng = new JLabel("");
	//jifeng.setIcon(new ImageIcon(Mainwindow.class.getResource("/img/gaofen.png")));
		jifeng.setBounds(-1, 5, 921, 691);
		getContentPane().add(jifeng);
		
		beijin.setLabelFor(this);
		beijin.setBounds(0, 0, 921, 691);
		beijin.setIcon(Picture.mainwindow);
		getContentPane().add(beijin);
		
	}
}
