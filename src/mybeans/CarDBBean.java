package mybeans;
import java.io.Serializable;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;
import java.util.ArrayList;

public class CarDBBean implements Serializable
{
   private ArrayList<String> colname;
   private ArrayList<ArrayList> data;

   public CarDBBean()
   {
      try{
         //�ڑ��̏���
         String url = "jdbc:derby:C:/eclipse/workspace/Mydb4;create=true";
         String usr = "";
         String pw = "";

         //�f�[�^�x�[�X�ւ̐ڑ�
         Connection cn = DriverManager.getConnection(url, usr, pw);





         //�₢���킹�̏���
         DatabaseMetaData dm = cn.getMetaData();
         ResultSet tb = dm.getTables(null, null, "�F�؃f�[�^", null);

         Statement st = cn.createStatement();

         String qry1 = "CREATE TABLE �ԕ\(�ԍ� int, ���O varchar(50))";
         String[] qry2 = {"INSERT INTO �ԕ\ VALUES (2, '��p��')",
                          "INSERT INTO �ԕ\ VALUES (3, '�I�[�v���J�[')",
                          "INSERT INTO �ԕ\ VALUES (4, '�g���b�N')"};
         String qry3 = "SELECT * FROM �ԕ\";

         if(!tb.next()){
            st.executeUpdate(qry1);
            for(int i=0; i<qry2.length; i++){
               st.executeUpdate(qry2[i]);
            }
         }

         //�₢���킹
         ResultSet rs = st.executeQuery(qry3);



          //�ڑ��̃N���[�Y
          rs.close();
          st.close();

       }
       catch(Exception e){
          e.printStackTrace();
       }
   }
   public void InsertData(String carname) {
	   try{
	         //�ڑ��̏���
	         String url = "jdbc:derby:C:/eclipse/workspace/Mydb4;create=true";
	         String usr = "";
	         String pw = "";

	         //�f�[�^�x�[�X�ւ̐ڑ�
	         Connection cn = DriverManager.getConnection(url, usr, pw);





	         //�₢���킹�̏���
	         DatabaseMetaData dm = cn.getMetaData();
	         ResultSet tb = dm.getTables(null, null, "�ԕ\", null);

	         Statement st = cn.createStatement();

	         String qry1 = "SELECT COUNT(*) FROM �ԕ\";
	         String qry2 = "SELECT * FROM �ԕ\";




	         //�₢���킹
	         ResultSet rs = st.executeQuery(qry1);
	         int count=0;
	         while(rs.next()) {
	        	 count=rs.getInt(1);
	         }
	        System.out.println(carname);
	        String qry3="INSERT INTO �ԕ\�@VALUES("+Integer.toString(count+1)+","+carname+")";
	        System.out.println(qry3);
	        st.executeUpdate(qry3);

	        ResultSet rs2 = st.executeQuery(qry2);

	      //�񐔂̎擾
	         ResultSetMetaData rm = rs2.getMetaData();
	         int cnum = rm.getColumnCount();
	         colname = new ArrayList<String>(cnum);

	         //�񖼂̎擾
	         for(int i=1; i<=cnum; i++){
	        	System.out.print(i);
	            colname.add(rm.getColumnName(i).toString());
	         }

	         //�s�̎擾
	         data = new ArrayList<ArrayList>();
	         while(rs2.next()){
	            ArrayList<String> rowdata = new ArrayList<String>();
	            for(int i=1; i<=cnum; i++){
	                rowdata.add(rs2.getObject(i).toString());
	            }
	            data.add(rowdata);
	          }


	          //�ڑ��̃N���[�Y
	          rs2.close();
	          st.close();
	          cn.close();
	       }
	       catch(Exception e){
	          e.printStackTrace();
	       }
   }
   public ArrayList getData()
   {
      return data;
   }
   public ArrayList getColname()
   {
      return colname;
   }
}
