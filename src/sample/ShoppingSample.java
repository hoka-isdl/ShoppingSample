package sample;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.Statement;

import mybeans.CarDBBean;

/**
 * Servlet implementation class Sample4
 */
@WebServlet("/ShoppingSample")
public class ShoppingSample extends HttpServlet {

	   public void doGet(HttpServletRequest request,
	                     HttpServletResponse response)
	   throws ServletException
	   {
	      try{
	         //�T�[�u���b�g�R���e�L�X�g�̎擾
	         ServletContext sc = getServletContext();

	         //Bean�̍쐬
	         CarDBBean cb = new CarDBBean();

	  

	         
	         //���N�G�X�g�ɐݒ�
	         request.setAttribute("cb", cb);

	         //���N�G�X�g�̓]��
	         sc.getRequestDispatcher("/loginsuccess.jsp")
	           .forward(request, response);
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }
	   }
	}
