import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;
import java.sql.ResultSet;
import java.io.*;
import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.http.HttpSession;
@WebServlet("/Servlet2")
public class Servlet2 extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


        try{
            String userid = request.getParameter("uname");
            String pwd = request.getParameter("pass");
            Class.forName("com.mysql.jdbc.Driver");
            Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/cs",
                    "root", "rootroot");
            Statement st = con.createStatement();
            ResultSet rs;
            rs = st.executeQuery("select * from cs.members where uname='" + userid + "' and pass='" + pwd + "'");
            if (rs.next()) {
                HttpSession session=request.getSession();
                session.setAttribute("userid", userid);
                //out.println("welcome " + userid);
                //out.println("<a href='logout.jsp'>Log out</a>");
                response.sendRedirect("success.jsp");
            } else {
                System.out.println("Invalid password <a href='index.jsp'>try again</a>");
            }
        }catch (Exception exp){
            System.out.println(exp);
        }

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {


    }
}
