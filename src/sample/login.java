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

import mybeans.ShoppingDBBean;

/**
 * Servlet implementation class Sample4
 */
@WebServlet("/login")
public class login extends HttpServlet {

	   public void doGet(HttpServletRequest request,
	                     HttpServletResponse response)
	   throws ServletException
	   {

	      try{
	    	  String id=request.getParameter("id");
	    	  String password=request.getParameter("password");

	         //サーブレットコンテキストの取得
	         ServletContext sc = getServletContext();

	         //Beanの作成
	         ShoppingDBBean cb = new ShoppingDBBean();

	         boolean Authentication=cb.Authentication(id,password);


	         //リクエストに設定
	         request.setAttribute("cb", cb);


	         if(Authentication==true) {
	        	 sc.getRequestDispatcher("/loginSuccess.jsp")
		           .forward(request, response);
	         }
	         else if(Authentication==false) {
	        	 sc.getRequestDispatcher("/loginFailed.jsp")
		           .forward(request, response);
	         }
	      }
	      catch(Exception e){
	         e.printStackTrace();
	      }
	   }
	}
