import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "DatabaseTestServlet", urlPatterns = "/db")
public class DatabaseTestServlet extends HttpServlet {
    private final String DATABASE_URL = "jdbc:derby:";
    private final String USERNAME = "stacy";
    private final String PASSWORD = "stacy";

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        try {
            String path = getServletContext().getRealPath("/WEB-INF/lib/worldbible");

            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");
            Connection conn = DriverManager.getConnection(DATABASE_URL + path, USERNAME, PASSWORD);
            Statement stmt = conn.createStatement();
            ResultSet rset = stmt.executeQuery("SELECT * FROM category");

            StringBuilder sb = new StringBuilder();
            sb.append("<html><body><ul>");
            while (rset.next()) {
                String name = rset.getString(1);
                sb.append("<li>").append(name).append("</li>");
            }
            sb.append("</ul></body></html>");
            stmt.close();
            conn.close();

            response.getWriter().print(sb.toString());
        } catch (SQLException | ClassNotFoundException e) {
            response.getWriter().print(e.getMessage());
            e.printStackTrace();
        }
    }
}
