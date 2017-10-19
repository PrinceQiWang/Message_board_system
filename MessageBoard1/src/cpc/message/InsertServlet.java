package cpc.message;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


@WebServlet("/InsertServlet")
public class InsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	public InsertServlet() {
		super();
		}

	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
				doPost(request, response);
	}

	
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
				request.setCharacterEncoding("utf-8");
				
		String title =  String.valueOf(request.getParameter("title"));
		String author = String.valueOf(request.getParameter("author"));
		String content = String.valueOf(request.getParameter("content"));
		String value1=request.getParameter("value1");
		//String value3 = request.getAttribute("value3").toString();
		//System.out.println(value3);
		//request.setAttribute("value4",value3);
		//request.getRequestDispatcher("ReplyServlet2").forward(request, response);

		try {
			Class.forName("com.mysql.jdbc.Driver"); 
			String url = "jdbc:mysql://localhost:3306/messageboard?useUnicode=true&characterEncoding=utf-8&useSSL=false";
			String username = "root"; 
			String password = "wzq95617"; 
			Connection conn = DriverManager.getConnection(url, username,password); 			String sql = null; 
			sql = "insert into note(title,author,content) values(?,?,?)";
			
			PreparedStatement pstmt = conn.prepareStatement(sql); 			
			pstmt.setString(1, title);
			pstmt.setString(2, author);
			pstmt.setString(3, content); 			
			pstmt.execute();
			//pstmt.executeQuery();
			sql = "select * from note";
			pstmt = conn.prepareStatement(sql);
			ResultSet rs = pstmt.executeQuery();
			
			List<ListNoteBean> list = new ArrayList<>();
			while (rs.next()) {
				ListNoteBean note = new ListNoteBean();
				note.setId(rs.getInt("id"));
				note.setTitle(rs.getString("title"));
				note.setAuthor(rs.getString("author"));
				note.setContent(rs.getString("content"));
				note.setReply(rs.getString("reply"));
			
				list.add(note);
			}
			request.setAttribute("list", list);
			
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		//System.out.println(value1);
		if(value1.equals("1")){
			request.setAttribute("value1",value1);RequestDispatcher rd=request.getRequestDispatcher("cpc_listnoteadmin.jsp");rd.forward(request,response);
			//request.getRequestDispatcher("cpc_listnoteadmin.jsp").forward(request, response);
		}else{
			request.setAttribute("value1",value1);RequestDispatcher rd=request.getRequestDispatcher("cpc_listnote.jsp");rd.forward(request,response);
			//request.getRequestDispatcher("cpc_listnote.jsp").forward(request, response);
		}
	}
}