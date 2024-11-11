package Repository.BrandRepo;


import Repository.BaseRepository;
import com.example.demo5.Brand;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class BrandRepository implements IBrandRepository {
    private final String SELECT_ALL = "SELECT * FROM Brand";
    private final String ADD_BRAND = "INSERT INTO Brand (name) VALUES (?)";
    private final String FIND_BRAND = "SELECT * FROM Brand WHERE id = ?";
    private final BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<Brand> findAll() {
        Connection connection = baseRepository.getConnection();
        List<Brand> brands = new ArrayList<>();
        try {
            Statement stmt = connection.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL);
            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                brands.add(new Brand(id, name));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return brands;
    }

    @Override
    public void add(Brand brand) {
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(ADD_BRAND);
            ps.setString(1, brand.getName());
            ps.executeUpdate();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Brand findById(int id) {
        Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement ps = connection.prepareStatement(FIND_BRAND);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            if (rs.next()) {
                String name = rs.getString("name");
                return new Brand(id, name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return null;
    }


}

