package test;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class DeleteProductDAO {
    public int delete(ProductBean pb) {
        int k = 0;
        try {
            Connection con = DBConnection.getCon();
            PreparedStatement ps = con.prepareStatement("DELETE FROM PRODUCTT60 WHERE code=?");
            ps.setString(1, pb.getCode());
            k = ps.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return k;
    }
}
