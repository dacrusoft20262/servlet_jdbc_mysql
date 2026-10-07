package servlet_jdbc_mysql;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.PreparedStatement;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class InsertDetails
 */
@WebServlet("/InsertDetails")
public class InsertDetails extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public InsertDetails() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		try {

			Connection con = DbUtil.initializeDatabase();

			PreparedStatement st = con.prepareStatement("insert into estudiante values(?, ?)");

			st.setInt(1, Integer.valueOf(request.getParameter("id")));

			st.setString(2, request.getParameter("nombre"));

			st.executeUpdate();

			st.close();
			con.close();

			PrintWriter out = response.getWriter();
			out.println("<html><body><b>Successfully Inserted" + "</b></body></html>");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
