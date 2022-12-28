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

         //接続の準備
         String url = "jdbc:derby:C:\\eclipse\\workspaceMyDB;create=true";
         String usr = "";
         String pw = "";

         //データベースへの接続
         Connection cn = DriverManager.getConnection(url, usr, pw);


         //問い合わせの準備
         DatabaseMetaData dm = cn.getMetaData();
         ResultSet tb = dm.getTables(null, null, "ユーザー", null);

         Statement st = cn.createStatement();

         String qry1 = "CREATE TABLE ユーザー(id varchar(10) not null primary key, pass varchar(10), name varchar(20), age int)";
         String[] qry2 = {"INSERT INTO ユーザー VALUES ('cgud0054', 's8wbCf48', '岡颯人', 21)",
                          "INSERT INTO ユーザー VALUES ('cgud0053', 's8wbCf47', '岡颯人', 20)",
                          "INSERT INTO ユーザー VALUES ('cgud0052', 's8wbCf46', '岡颯人', 19)"};
         String qry3 = "SELECT * FROM ユーザー";

         if(!tb.next()){
            st.executeUpdate(qry1);
            for(int i=0; i<qry2.length; i++){
               st.executeUpdate(qry2[i]);
            }
         }

         //問い合わせ
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
		 //接続の準備
	         String url = "jdbc:derby:C:\\eclipse\\workspaceMyDB;create=true";
	         String usr = "";
	         String pw = "";

	         //データベースへの接続
	         Connection cn = DriverManager.getConnection(url, usr, pw);

		     Statement st2 = cn.createStatement();

	         String qry4 = "SELECT * FROM ユーザー WHERE id='"+id+"' AND pass='"+password+"'";

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
