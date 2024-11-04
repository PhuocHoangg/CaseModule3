package Repository.PhoneRepo;

import Repository.BaseRepository;
import com.example.demo5.Android;
import com.example.demo5.Iphone;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class PhoneRepository implements InPhoneRepository{
    private final String SELECT_ALL = "select * from Android";
    private final BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<Android> findAll() {
        Connection c = baseRepository.getConnection();
        List<Android> android = new ArrayList<>();
        try {
            Statement stmt = c.createStatement();
            ResultSet rs = stmt.executeQuery(SELECT_ALL);
            while (rs.next()) {
                String brand = rs.getString("brand");
                String name = rs.getString("model");
                String color=rs.getString("color");
                int price = rs.getInt("price");
                int quantity = rs.getInt("quality");
                android.add(new Android(brand,name,color,price,quantity));
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return android;
    }
}

