package test;
import java.io.*;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.MultipartConfig;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.Part;

import java.sql.*;

@SuppressWarnings("serial")
@WebServlet("/UploadImage")
@MultipartConfig
public class UploadImage extends HttpServlet 
{
    protected void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException 
    {
        String connectionURL = "jdbc:oracle:thin:@localhost:1521:orcl"; // Replace with your Oracle connection URL
        String username = "system"; // Replace with your Oracle username
        String password = "root"; // Replace with your Oracle password

        Connection conn = null;
        PreparedStatement ps = null;
        ResultSet rs = null;

        try {
            Class.forName("oracle.jdbc.driver.OracleDriver");
            conn = DriverManager.getConnection(connectionURL, username, password);
            
            if(request.getParameter("upload")!=null) 
            {
            	String sql = "INSERT INTO images (id, image_data) VALUES (?,?)";
                ps = conn.prepareStatement(sql);
                int prodId = Integer.parseInt(request.getParameter("product"));
                Part filePart = request.getPart("image");
                InputStream inputStream = filePart.getInputStream();
                ps.setInt(1, prodId);
                ps.setBlob(2, inputStream);

                int k = ps.executeUpdate();
                if (k > 0) 
                {
                	response.getWriter().println("Success ");
                }
                else
                {
                	response.getWriter().println("unable to upload image ");
                }
            }
            else 
            {
            	String sql = "SELECT image_data FROM images WHERE id = ?"; // Assuming you're fetching by image ID
                ps = conn.prepareStatement(sql);
                int imageId = Integer.parseInt(request.getParameter("product")); // Assuming you're passing image ID as a parameter
                ps.setInt(1, imageId);

                rs = ps.executeQuery();

                if (rs.next()) 
                {
                    Blob blob = rs.getBlob("image_data");
                    byte[] imageData = blob.getBytes(1, (int) blob.length());

                    response.setContentType("image/jpeg");
                    OutputStream outputStream = response.getOutputStream();
                    outputStream.write(imageData);
                    outputStream.close();
                }
            }    
        	} 
        catch (SQLException | ClassNotFoundException e) 
        {
            e.printStackTrace();
        }
        finally 
        {
            try 
            {
            	if (rs != null) 
            	{
                    rs.close();
                }
                if (ps != null) 
                {
                    ps.close();
                }
                if (conn != null) 
                {
                    conn.close();
                }
            }
            catch (SQLException e) 
            {
                e.printStackTrace();
            }
        }
    }
}
