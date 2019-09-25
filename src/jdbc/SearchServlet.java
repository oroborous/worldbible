package jdbc;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "SearchServlet",
        urlPatterns = "/search")
public class SearchServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String searchTerm = request.getParameter("searchTerm");

        StringBuilder sql = new StringBuilder();
        sql.append("SELECT npc.*, quest.* FROM npc, quest, npc_quest ");
        sql.append("WHERE npc.npc_id = npc_quest.npc_id AND quest.quest_id = npc_quest.quest_id ");
        sql.append("AND npc.first_name = ?");


        // Declare outside the try/catch so the variables are in scope in the finally block
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rset = null;

        // Load the driver
        try {
            Class.forName("org.apache.derby.jdbc.EmbeddedDriver");

            // Find the absolute path of the database folder
            String absPath = getServletContext().getRealPath(DatabaseUtils.DATABASE_PATH);

            // Create a connection
            conn = DriverManager.getConnection(DatabaseUtils.DRIVER_NAME + absPath, DatabaseUtils.USERNAME, DatabaseUtils.PASSWORD);
            // Create a statement to execute SQL
            pstmt = conn.prepareStatement(sql.toString());
            // Fill the parameter
            pstmt.setString(1, searchTerm);
            // Execute a SELECT query and get a result set
            rset = pstmt.executeQuery();

            // Create a StringBuilder for ease of appending strings
            StringBuilder output = new StringBuilder();
            // HTML to create a simple web page
            output.append("<html><body>");

            // Loop while the result set has more rows
            while (rset.next()) {
                output.append("<p>");
                output.append(rset.getString("first_name")).append("<br/>");
                output.append(rset.getString("last_name")).append("<br/>");
                output.append(rset.getString("nickname")).append("<br/>");
                output.append(rset.getString("occupation")).append("<br/>");
                output.append(rset.getString("sex")).append("<br/>");
                output.append(rset.getString("bio")).append("<br/>");
                output.append(rset.getString("description")).append("<br/>");
                output.append("</p>");
            }
            // Close all those opening tags
            output.append("</body></html>");

            // Send the HTML as the response
            response.getWriter().print(output.toString());

        } catch (SQLException | ClassNotFoundException e) {
            // If there's an exception locating the driver, send IT as the response
            response.getWriter().print(e.getMessage());
            // Print stack trace
            e.printStackTrace();
        } finally {
            // Close database objects
            DatabaseUtils.closeAll(conn, pstmt, rset);
        }
    }
}
