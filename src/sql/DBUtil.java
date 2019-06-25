package sql;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class DBUtil {
Connection conn=null;
PreparedStatement pstmt=null;
ResultSet rs=null; 
//连接
    public Connection getConnnection() {
    	 //驱动程序名
        String driver = "com.mysql.jdbc.Driver";
        //URL指向要访问的数据库名mydata
        String url = "jdbc:mysql://:3306/tafang";
        //MySQL配置时的用户名
        String user = "root";
        //MySQL配置时的密码
        String password = "123456";
         try {
			   //加载驱动程序
            Class.forName(driver);
            //1.getConnection()方法，连接MySQL数据库！！
            conn = DriverManager.getConnection(url ,user,password);
            
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("驱动错误或连接失败");
			e.printStackTrace();
		}
		return conn;
    }
    
//关闭
    public void  closeAll(){
    	if(rs!=null){
    		try {
				rs.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	if(pstmt!=null){
    		try {
				pstmt.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	if(conn!=null){
    		try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
    	}
    	
    	
    }
//查询
    public ResultSet excuteQuery(String  prepardSql,String[] parem){
    	try {
			pstmt=conn.prepareStatement(prepardSql);
			if(parem!=null){
				for(int i=0;i<parem.length;i++){
					pstmt.setString(i+1, parem[i]);
					
				}
			}
			rs=pstmt.executeQuery();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		return rs;
    	
    }
    public int excuteUpdate(String  prepardSql,String[] parem){
    	int num=0;
    	try {
			pstmt=conn.prepareStatement(prepardSql);
			if(parem!=null){
				for(int i=0;i<parem.length;i++){
					pstmt.setString(i+1, parem[i]);
					
				}
			}
			num=pstmt.executeUpdate();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
		return num;
    	
    }
    
}
