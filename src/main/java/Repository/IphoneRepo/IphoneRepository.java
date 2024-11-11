package Repository.IphoneRepo;

import Repository.BaseRepository;
import com.example.demo5.Iphone;

import java.sql.*;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IphoneRepository implements IIphoneRepository {
    private final String SELECT_ALL = "SELECT * FROM Iphone";
    private final String ADD_PHONE = "INSERT INTO Iphone (brand_id, model, color, price, quality) VALUES (?, ?, ?, ?, ?)";
    private final String FIND_PHONE = "SELECT * FROM Iphone WHERE id=?";
    private final String DELETE_PHONE = "DELETE FROM Iphone WHERE id = ?";
    private final String UPDATE_PHONE = "UPDATE Iphone SET brand_id = ?, model = ?, color = ?, price = ?, quality = ? WHERE id = ?";
    private final String FIND_PHONE2= "SELECT * FROM Iphone WHERE model LIKE ? AND color LIKE ?";
    private final BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Iphone> findAll() {
        Connection c = baseRepository.getConnection();
        List<Iphone> iphones = new ArrayList<>();
        try {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL);
            while (rs.next()) {
                int id = rs.getInt("id");
                int brandId = rs.getInt("brand_id");
                String model = rs.getString("model");
                String color = rs.getString("color");
                double price = rs.getDouble("price");
                int quality = rs.getInt("quality");
                iphones.add(new Iphone(id, brandId, model, color, price, quality));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return iphones;
    }

    @Override
    public void add(Iphone iphone) {
        Connection c = baseRepository.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement(ADD_PHONE);
            ps.setInt(1, iphone.getBrandId());
            ps.setString(2, iphone.getModel());
            ps.setString(3, iphone.getColor());
            ps.setDouble(4, iphone.getPrice());
            ps.setInt(5, iphone.getQuality());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Iphone findById(int id) {
        Iphone iphone = null;
        Connection c = baseRepository.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement(FIND_PHONE);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                int brandId = rs.getInt("brand_id");
                String model = rs.getString("model");
                String color = rs.getString("color");
                double price = rs.getDouble("price");
                int quality = rs.getInt("quality");
                iphone = new Iphone(id, brandId, model, color, price, quality);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return iphone;
    }

    @Override
    public void delete(int id) {
        Connection c = baseRepository.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement(DELETE_PHONE);
            ps.setInt(1, id);
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public void update(Iphone iphone) {
        Connection c = baseRepository.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement(UPDATE_PHONE);
            ps.setInt(1, iphone.getBrandId());
            ps.setString(2, iphone.getModel());
            ps.setString(3, iphone.getColor());
            ps.setDouble(4, iphone.getPrice());
            ps.setInt(5, iphone.getQuality());
            ps.setInt(6, iphone.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

}







