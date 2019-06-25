package window;

import java.sql.SQLException;
/*
 * admin
   123
   */
public class Test  {
	public static void main(String[] args) {
		Register frame;
		try {
			frame = new Register();
			frame.setVisible(true);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}}
