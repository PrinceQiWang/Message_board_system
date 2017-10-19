package cpc.message;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet("/SearchServlet")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	
	public SearchServlet() {
		super();
		}

	
	protected void doGet(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
				doPost(request, response);
	}
	protected void doPost(HttpServletRequest request,
			HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.setCharacterEncoding("utf-8");
		
		String keyword =  String.valueOf(request.getParameter("keyword"));

		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url = "jdbc:mysql://localhost:3306/messageboard?useUnicode=true&characterEncoding=utf-8&useSSL=false";
			String username = "root";
			String password = "wzq95617";

			Connection conn = DriverManager.getConnection(url, username,password);
			String sql = "select id,title,author,content,reply from note where id like ? or title like ? or author like ? or content like ? or reply like ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql);
			
			pstmt.setString(1,"%"+keyword+"%") ;
			pstmt.setString(2,"%"+keyword+"%") ; 
			pstmt.setString(3,"%"+keyword+"%") ; 
			pstmt.setString(4,"%"+keyword+"%") ; 
			pstmt.setString(5,"%"+keyword+"%") ; 
			
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
			rs.close();
			pstmt.close();
			conn.close();
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}

		request.getRequestDispatcher("cpc_search.jsp").forward(request, response);
	}
}