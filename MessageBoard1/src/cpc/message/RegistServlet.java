package cpc.message;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.JOptionPane;

@WebServlet("/RegistServlet")
public class RegistServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public RegistServlet() {
        super();
          }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name =  String.valueOf(request.getParameter("name"));
		String pwd1 =  String.valueOf(request.getParameter("password1"));
		
		System.out.println(name);
		System.out.println(pwd1);
		
		java.sql.Statement sql;//n
		ResultSet rs_1;//n
		int rs_2;//n

		
		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			String url = "jdbc:mysql://localhost:3306/messageboard?useUnicode=true&characterEncoding=utf-8&useSSL=false";
			String username = "root"; 
			String password = "wzq95617"; 
			Connection conn = DriverManager.getConnection(url, username,password); 
			/*String sql = null; 
			sql = "insert into person(name,password) values(?,?)";
			PreparedStatement pstmt = conn.prepareStatement(sql); // ��ȡPreparedStatement
			pstmt.setString(1, name); 
			pstmt.setString(2, pwd1); 			
			pstmt.executeUpdate();
		
			pstmt.close();
			conn.close(); */
			
			sql = conn.createStatement();
			rs_1= sql.executeQuery(" select name from person " + "where name = '" + name + "'");
			if(rs_1.next()){
				JOptionPane.showMessageDialog(null, "该用户名已存在，请更换用户名!","系统信息", JOptionPane.ERROR_MESSAGE);
				/*response.setContentType("text/html;charset=gb2312");
				PrintWriter out = response.getWriter();
				out.print("<script language='javascript'>window.open('/PR/jsp/PR/PR_MA_EMP_BAK_List.jsp?function=getlistpage&condition=1=1&componame=PR_MA_EMP_BAK&fieldvalue=PR_MA_EMP_BAK_E','导入人员信息确认','menubar=no,status=no,toolbar=no,resizable=yes,titlebar=yes,scrollbars=yes,height='+(screen.availHeight-30)+',width='+(screen.availWidth-10)+',top=0,left=0');</script>");*/
				//response.getWriter().print("<script> alert(\"该用户名已存在，请更换用户名!\"); </script>");
			}
			else{
				rs_2 = sql.executeUpdate(" insert into person (name,password)  " + "values ( '"+name+"','"+pwd1+"')");
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		 request.getRequestDispatcher("index.jsp").forward(request,response);
	}
	private void alert(String string) {
		// TODO Auto-generated method stub
		
	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doGet(request,response);
	}

}