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
	         //サーブレットコンテキストの取得
	         ServletContext sc = getServletContext();

	         //Beanの作成
	         CarDBBean cb = new CarDBBean();

	  

	         
	         //リクエストに設定
	         request.setAttribute("cb", cb);

	         //リクエストの転送
	         sc.getRequestDispatcher("/loginsuccess.jsp")
	           .forward(request, response);
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }
	   }
	}
