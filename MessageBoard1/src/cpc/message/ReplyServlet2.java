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

@WebServlet("/ReplyServlet2")
public class ReplyServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public ReplyServlet2() {
        super();
           }
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				
		request.setCharacterEncoding("utf-8");
		int id = Integer.parseInt(request.getParameter("id"));
		String reply = String.valueOf(request.getParameter("reply"));
		String value1=request.getParameter("value1");
		//String value4 = request.getAttribute("value4").toString();
		//System.out.println(value4);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			String url="jdbc:mysql://localhost:3306/messageboard?useUnicode=true&characterEncoding=utf-8&useSSL=false";
			String username="root";
			String password="wzq95617";
			Connection conn = DriverManager.getConnection(url, username, password);
			String sql = null;
			sql = "update note set reply = ? where id = ?";
			
			PreparedStatement pstmt = conn.prepareStatement(sql); // ��ȡPreparedStatement
			
			pstmt.setString(1, reply); // ��SQL����еĵ�3��������ֵ 
			pstmt.setInt(2, id); 
			
			pstmt.execute();
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
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
				doGet(request,response);

	}
}