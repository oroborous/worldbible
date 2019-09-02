import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.*;

@WebServlet(name = "DatabaseTestServlet", urlPatterns = "/db")
public class DatabaseTestServlet extends HttpServlet {
    private final String DRIVER_NAME = "jdbc:derby:";
    private final String DATABASE_PATH = "/WEB-INF/lib/worldbible";
    private final String USERNAME = "stacy";
    private final String PASSWORD = "stacy";


    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Load the driver
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            // Find the absolute path of the database folder
            String absPath = getServletContext().getRealPath(DATABASE_PATH);

            try (
                    // Create a connection
                    Connection conn = DriverManager.getConnection(DRIVER_NAME + absPath, USERNAME, PASSWORD);
                    // Create a statement to execute SQL
                    Statement stmt = conn.createStatement();
                    // Execute a SELECT query and get a result set
                    ResultSet rset = stmt.executeQuery("SELECT * FROM category");
            ) {
                // Create a StringBuilder for ease of appending strings
                StringBuilder sb = new StringBuilder();
                // HTML to create a simple web page
                sb.append("<html><body><ul>");

                // Loop while the result set has more rows
                while (rset.next()) {
                    // Get the first string from each record
                    String name = rset.getString("category_nm");
                    // Append it as a list item
                    sb.append("<li>").append(name).append("</li>");
                }
                // Close all those opening tags
                sb.append("</ul></body></html>");

                // Send the HTML as the response
                response.getWriter().print(sb.toString());
            } catch (SQLException e) {
                // If there's an exception closing any resources, send IT as the response
                response.getWriter().print(e.getMessage());
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            // If there's an exception locating the driver, send IT as the response
            response.getWriter().print(e.getMessage());
            e.printStackTrace();
        }
    }
}
