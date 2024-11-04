package Repository.IphoneRepo;

import Repository.BaseRepository;
import com.example.demo5.Iphone;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class IphoneRepository implements IIphoneRepository {
    private final String SELECT_ALL = "select * from Iphone";
    private final BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<Iphone> findAll() {
        Connection c = baseRepository.getConnection();
        List<Iphone> iphone = new ArrayList<>();
        try {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL);
            while (rs.next()) {
                String brand = rs.getString("brand");
                String name = rs.getString("model");
                String color=rs.getString("color");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quality");
                String nation=rs.getString("nation");
                iphone.add(new Iphone(brand,name,color,price,quantity,nation));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return iphone;
        }
    }

