package sql;

import java.sql.ResultSet;
import java.sql.SQLException;
public class Userserver{
	
	public String FindUserbyname(String user) throws SQLException{
		DBUtil db=new DBUtil();
		String pass=null;
		 db.getConnnection();
		 ResultSet  rs=db.excuteQuery("select pass from denlu where zhanghao="+"'"+user+"'", null);
		 while(rs.next()){
		pass=rs.getString("pass");
		 }
		 db.closeAll();
		return pass;	
	}
	public int Findname(String name) throws SQLException{
		DBUtil db=new DBUtil();
		int rsuit=0;
		String name1=null;
		 db.getConnnection();
		 ResultSet  rs=db.excuteQuery("select name from denlu", null);
		 while(rs.next()){
		name1=rs.getString("name");
		if(name1.equals(name)){
			rsuit=1;
			db.closeAll();
			break;
		}
		 }
		return rsuit;	
	}
	public int InSert(String name,String pass) throws SQLException{
		DBUtil db=new DBUtil();
	
		
		 db.getConnnection();
		
		int count=db.excuteUpdate("INSERT into  denlu VALUES (?,?)",new String[] { name,pass});
	
		 
		return count;	
	}
	public static void main(String[] args) throws SQLException{
		 Userserver  s=new  Userserver();
		 System.out.println(s.FindUserbyname("test1"));
		 System.out.println(s.Findname("test1"));
		 System.out.println(s.InSert("a","123456"));
		 
	}
	
}
/*public class User {
public static void main(String[] args) throws SQLException {
		 String select="select * from denlu";
			String update="update denlu set pass=? Where name=?";
			String delete="delete from denlu Where name=?";
			String insert="INSERT into  denlu VALUES (?,?)";
			
			
		 DBUtil db=new DBUtil();
		 db.getConnnection();
		 ResultSet  rs=db.excuteQuery(select, null);
		 while(rs.next()){
			 System.out.println(rs.getString("name")+ "\t" + rs.getString("pass"));
			 
		 }
		 
		 
		
		 
		 
	 }
}
*/