package window;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sql.Userserver;
import youxi.Tower;
import youxi.Tower4;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JPasswordField;
import javax.swing.DropMode;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

public class Register extends JFrame {

	private JPanel contentPane;
	private JPasswordField mima;
	private JTextField zhuanghu;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					
					
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 * @throws SQLException 
	 */
	public Register() throws SQLException {
		 final Userserver  s=new  Userserver();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(400, 200, 456, 351);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel tishi = new JLabel("");
		tishi.setHorizontalAlignment(SwingConstants.CENTER);
		tishi.setForeground(new Color(255, 0, 0));
		tishi.setFont(new Font("微软雅黑", Font.PLAIN, 17));
		tishi.setBounds(113, 209, 231, 29);
		contentPane.add(tishi);
		
		mima = new JPasswordField();
		mima.setEchoChar('*');
		mima.setFont(new Font("宋体", Font.PLAIN, 15));
		mima.setBounds(182, 162, 162, 29);
		contentPane.add(mima);
		
		zhuanghu = new JTextField(1);
		zhuanghu.setFont(new Font("黑体", Font.PLAIN, 20));
		zhuanghu.setBounds(182, 98, 162, 29);
		contentPane.add(zhuanghu);
		
		
		JLabel label = new JLabel("\u5BC6 \u7801:");
		label.setForeground(new Color(0, 0, 128));
		label.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		label.setBounds(113, 164, 60, 21);
		contentPane.add(label);
		
		JLabel lblNewLabel_1 = new JLabel("账户:");
		lblNewLabel_1.setForeground(new Color(0, 0, 128));
		lblNewLabel_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		lblNewLabel_1.setBounds(113, 100, 54, 21);
		contentPane.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("注册");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {			
				Enroll s= new Enroll();
				s.setVisible(true);
			}
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBackground(Color.BLUE);
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 15));
		btnNewButton.setBounds(305, 248, 79, 25);
		btnNewButton.setFocusPainted(false);//消除文字边框
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("登录");
		btnNewButton_1.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
						try {
					tishi.setText("");
					String pass=s.FindUserbyname(zhuanghu.getText() ) ;
						String sname=zhuanghu.getText();
						if(sname==null||sname.equals("")){
							//System.out.println("aaa");							
						  tishi.setText("     用户名不能为空！");			 
						   return;
						}
						String spass=new String(mima.getPassword());
						if( spass==null||spass.equals("")){
							//System.out.println("aaa");							
						  tishi.setText("     请输入密码！");			 
						   return;
						}
						
					
					
							System.out.println(new String(mima.getPassword())+s.FindUserbyname(zhuanghu.getText() ) );
							if(spass.equals(pass)){
								System.out.println("OK");
							
								new Mainwindow().setVisible(true);
							}
							else
							{
								  tishi.setText("     密码或用户名错误！");			 
							}
						} catch (SQLException e1)
						{
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						//System.out.println(textField.getText());
					}
				});
				
			
				
			
	
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBackground(Color.GREEN);
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 15));
		btnNewButton_1.setBounds(86, 248, 79, 25);
		btnNewButton_1.setFocusPainted(false);
		contentPane.add(btnNewButton_1);
		
		JButton button = new JButton("\u6E05 \u9664");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				mima.setText("");	
				zhuanghu.setText("");
				
			}
		});
		button.setForeground(Color.WHITE);
		button.setFont(new Font("宋体", Font.PLAIN, 15));
		button.setBackground(new Color(255, 0, 0));
		button.setBounds(201, 248, 79, 25);
		button.setFocusPainted(false);
		contentPane.add(button);
		
		JLabel lblNewLabel_2 = new JLabel("\u6218 \u4E89 \u5854 \u9632");
		lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel_2.setFont(new Font("黑体", Font.PLAIN, 22));
		lblNewLabel_2.setForeground(new Color(0, 0, 255));
		lblNewLabel_2.setBounds(101, 20, 283, 50);
		contentPane.add(lblNewLabel_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon(Register.class.getResource("/img/denlubeijin.jpg")));
		lblNewLabel.setBounds(0, 0, 440, 312);
		contentPane.add(lblNewLabel);
	}
}
