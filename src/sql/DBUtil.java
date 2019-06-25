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
//����
    public Connection getConnnection() {
    	 //����������
        String driver = "com.mysql.jdbc.Driver";
        //URLָ��Ҫ���ʵ����ݿ���mydata
        String url = "jdbc:mysql://:3306/tafang";
        //MySQL����ʱ���û���
        String user = "root";
        //MySQL����ʱ������
        String password = "123456";
         try {
			   //������������
            Class.forName(driver);
            //1.getConnection()����������MySQL���ݿ⣡��
            conn = DriverManager.getConnection(url ,user,password);
            
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			System.out.println("�������������ʧ��");
			e.printStackTrace();
		}
		return conn;
    }
    
//�ر�
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
//��ѯ
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
