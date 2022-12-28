package mybeans;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

public class ShoppingDBBean implements Serializable
{

   private String name1;

   public ShoppingDBBean()
   {
      try{

         //�ڑ��̏���
         String url = "jdbc:derby:C:\\eclipse\\workspaceMyDB;create=true";
         String usr = "";
         String pw = "";

         //�f�[�^�x�[�X�ւ̐ڑ�
         Connection cn = DriverManager.getConnection(url, usr, pw);


         //�₢���킹�̏���
         DatabaseMetaData dm = cn.getMetaData();
         ResultSet tb = dm.getTables(null, null, "���[�U�[", null);

         Statement st = cn.createStatement();

         String qry1 = "CREATE TABLE ���[�U�[(id varchar(10) not null primary key, pass varchar(10), name varchar(20), age int)";
         String[] qry2 = {"INSERT INTO ���[�U�[ VALUES ('cgud0054', 's8wbCf48', '���D�l', 21)",
                          "INSERT INTO ���[�U�[ VALUES ('cgud0053', 's8wbCf47', '���D�l', 20)",
                          "INSERT INTO ���[�U�[ VALUES ('cgud0052', 's8wbCf46', '���D�l', 19)"};
         String qry3 = "SELECT * FROM ���[�U�[";

         if(!tb.next()){
            st.executeUpdate(qry1);
            for(int i=0; i<qry2.length; i++){
               st.executeUpdate(qry2[i]);
            }
         }

         //�₢���킹
         ResultSet rs = st.executeQuery(qry3);


          rs.close();
          st.close();
          cn.close();
       }
       catch(Exception e){
          e.printStackTrace();
       }
   }

   public boolean Authentication(String id,String password) {
	   try{
		 //�ڑ��̏���
	         String url = "jdbc:derby:C:\\eclipse\\workspaceMyDB;create=true";
	         String usr = "";
	         String pw = "";

	         //�f�[�^�x�[�X�ւ̐ڑ�
	         Connection cn = DriverManager.getConnection(url, usr, pw);

		     Statement st2 = cn.createStatement();

	         String qry4 = "SELECT * FROM ���[�U�[ WHERE id='"+id+"' AND pass='"+password+"'";

	         ResultSet rs2 = st2.executeQuery(qry4);

	         
	         if(rs2.next()) {
	        	 name1=rs2.getString("name");
	        	 return true;
	         }
	         else {
	        	 return false;
	         }
	   }catch(Exception e) {
		   e.printStackTrace();
	   }
	return false;
   }
   public String getname()
   {
      return name1;
   }

}
