package jdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "ListServlet", urlPatterns = "/list")
public class ListServlet extends HttpServlet {



    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // Declare outside the try/catch so the variables are in scope in the finally block
        Connection conn = null;
        Statement stmt = null;
        ResultSet rset = null;

        // Load the driver
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            // Find the absolute path of the database folder
            String absPath = getServletContext().getRealPath(DatabaseUtils.DATABASE_PATH);

            // Create a connection
            conn = DriverManager.getConnection(DatabaseUtils.DRIVER_NAME + absPath, DatabaseUtils.USERNAME, DatabaseUtils.PASSWORD);
            // Create a statement to execute SQL
            stmt = conn.createStatement();
            // Execute a SELECT query and get a result set
            rset = stmt.executeQuery("SELECT * FROM category");

            // Create a StringBuilder for ease of appending strings
            StringBuilder output = new StringBuilder();
            // HTML to create a simple web page
            output.append("<html><body><ul>");

            // Loop while the result set has more rows
            while (rset.next()) {
                // Get the first string from each record
                String name = rset.getString("category_nm");
                // Append it as a list item
                output.append("<li>").append(name).append("</li>");
            }
            // Close all those opening tags
            output.append("</ul></body></html>");

            // Send the HTML as the response
            response.getWriter().print(output.toString());

        } catch (SQLException | ClassNotFoundException e) {
            // If there's an exception locating the driver, send IT as the response
            response.getWriter().print(e.getMessage());
            // Print stack trace
            e.printStackTrace();
        } finally {
            // Close database objects
            DatabaseUtils.closeAll(conn, stmt, rset);
        }
    }
}
