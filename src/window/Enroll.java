package window;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import sql.Userserver;
import youxi.Usedate;

import javax.swing.JPasswordField;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JLabel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.SQLException;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.ImageIcon;

@SuppressWarnings("serial")
public class Enroll extends JFrame {

	private JPanel contentPane;
	private JPasswordField pass1;
	private JTextField name;
	private JPasswordField pass2;
	private JLabel tishi;

	/**
	 * Launch the application.
	 */
/*	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Enroll frame = new Enroll();
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
	public Enroll() {
		
		 final Userserver  s1=new  Userserver();
		setBounds(400+70, 200+80, 318, 236);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		tishi = new JLabel("");
		tishi.setHorizontalAlignment(SwingConstants.CENTER);
		tishi.setFont(new Font("黑体", Font.PLAIN, 15));
		tishi.setForeground(new Color(255, 0, 0));
		tishi.setBounds(57, 122, 191, 28);
		
		  contentPane.add(tishi);
		  
		pass1 = new JPasswordField(1);
		pass1.setFont(new Font("宋体", Font.PLAIN, 15));
		pass1.setEchoChar('*');
		pass1.setBounds(123, 60, 162, 23);
		contentPane.add(pass1);
		
		name = new JTextField(1);
		name.setFont(new Font("宋体", Font.PLAIN, 15));
		name.setBounds(123, 29, 162, 23);
		contentPane.add(name);
		
		JLabel label = new JLabel("\u8D26     \u6237:");
		label.setForeground(new Color(0, 0, 255));
		label.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		label.setBounds(21, 29, 75, 21);
		contentPane.add(label);
		
		JLabel label_1 = new JLabel("\u5BC6     \u7801:");
		label_1.setForeground(new Color(0, 0, 255));
		label_1.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		label_1.setBounds(21, 60, 75, 21);
		contentPane.add(label_1);
		
		JLabel label_2 = new JLabel("\u786E\u8BA4\u5BC6\u7801:");
		label_2.setForeground(new Color(0, 0, 255));
		label_2.setFont(new Font("微软雅黑", Font.PLAIN, 18));
		label_2.setBounds(21, 91, 81, 21);
		contentPane.add(label_2);
		
		pass2 = new JPasswordField(1);
		pass2.setFont(new Font("宋体", Font.PLAIN, 15));
		pass2.setEchoChar('*');
		pass2.setBounds(123, 93, 162, 23);
		contentPane.add(pass2);
		
		JButton btnNewButton = new JButton("确认");
		btnNewButton.setBackground(new Color(0, 0, 255));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
			tishi.setText("");
			
				String sname=name.getText();
				if(sname==null||sname.equals("")){
					//System.out.println("aaa");							
				  tishi.setText("     用户名不能为空！");			 
				   return;
				}
				try {
					if(s1.Findname(sname)==1){
						tishi.setText("     用户已存在！");			 
						   return;
						
					}
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				String spass1=new String(pass1.getPassword());
				if( spass1==null||spass1.equals("")){
					//System.out.println("aaa");							
				  tishi.setText("     请输入密码！");			 
				   return;
				}
				String spass2=new String(pass2.getPassword());
				if( spass2==null||spass2.equals("")){
					//System.out.println("aaa");							
				  tishi.setText("    请输入确认密码！");			 
				   return;
				}
				if(!spass1.equals(spass2)){
					
					 tishi.setText("确认密码必须与密码相同！");			 
					  return;					
				}
				try {
					s1.InSert(sname, spass1);
					tishi.setForeground(Color.BLUE);
					 tishi.setText("注册成功！");	
					 Usedate.setSname(sname);
					 tishi.setForeground(new Color(255, 0, 0));
					  return;		
				} catch (SQLException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		
		
		btnNewButton.setForeground(new Color(240, 255, 240));
		btnNewButton.setFont(new Font("宋体", Font.PLAIN, 15));
		btnNewButton.setBounds(42, 160, 75, 23);
		btnNewButton.setFocusPainted(false);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("清除");
		btnNewButton_1.setBackground(new Color(255, 0, 0));
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				name.setText("");
				pass1.setText("");
				pass2.setText("");
			}
		});
		btnNewButton_1.setFont(new Font("宋体", Font.PLAIN, 15));
		btnNewButton_1.setForeground(new Color(240, 255, 240));
		btnNewButton_1.setBounds(173, 160, 75, 23);
		btnNewButton_1.setFocusPainted(false);
		contentPane.add(btnNewButton_1);
		
		JLabel beijin = new JLabel("");
		beijin.setIcon(new ImageIcon(Enroll.class.getResource("/img/zhuchebeijin.jpg")));
		beijin.setBounds(0, 0, 312, 197);
		contentPane.add(beijin);
		

		 
	}
}
