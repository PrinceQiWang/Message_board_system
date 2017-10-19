package cpc.message;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.sql.*;

@WebServlet("/LoginServlet")

public class LoginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
    public LoginServlet() {
        // TODO Auto-generated constructor stub
    }
    
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String name =  String.valueOf(request.getParameter("name"));
		String pwd =  String.valueOf(request.getParameter("password"));
		//System.out.println(id);
		try{
		Class.forName("com.mysql.jdbc.Driver");
		String url="jdbc:mysql://localhost:3306/messageboard?useUnicode=true&characterEncoding=utf-8&useSSL=false";
		String username="root";
		String password="wzq95617";
		Connection myconn=DriverManager.getConnection(url,username,password);
		if(myconn!=null){
			System.out.println("数据库连接成功");
			
			}else{
			System.out.println("数据库连接失败");
			}
		String sql="select * from person where name='"+name+"'and password='"+pwd+"'";//password='"+pwd+"'
		Statement stmt=myconn.createStatement();
		ResultSet rs=stmt.executeQuery(sql);
		if(rs.next()){
			String id=rs.getString("id");
			request.setAttribute("value1",id);
			request.getRequestDispatcher("/ListNoteServlet").forward(request, response);
			// response.sendRedirect("ListNoteServlet");
			System.out.println("登陆成功");
		}else{
			 if(request.getAttribute("name") == null){
				 request.setAttribute("error","没有该账号或密码错误");
			       request.getRequestDispatcher("index.jsp").forward(request,response);
			    }
		}
		myconn.close();
	}catch(Exception e){
		e.printStackTrace();
	}
	}
	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request,response);
	}
}