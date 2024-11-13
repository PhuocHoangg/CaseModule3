package Repository.PhuongThuc;

import Repository.BaseRepository;
import com.example.demo5.PhuongThuc;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class PhuongThucRepo implements IPhuongThuc {
 private final String FIND_BY_ID="select * from phuong_thuc where id=?";
 private final String FIND_ALL="select * from phuong_thuc";
    @Override
    public PhuongThuc findById(int id) {
    PhuongThuc phuongThuc = null;
        BaseRepository baseRepository = new BaseRepository();
      Connection connection = baseRepository.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(FIND_BY_ID);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
              String name = resultSet.getString("name");
              phuongThuc=new PhuongThuc(id,name);
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return phuongThuc;
    }

    @Override
    public List<PhuongThuc> findAll() {
         List<PhuongThuc> phuongthuc=new ArrayList<>();
BaseRepository baseRepository = new BaseRepository();
Connection connection = baseRepository.getConnection();
        try {
            Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(FIND_ALL);
             while (resultSet.next()) {
int id = resultSet.getInt("id");
String name = resultSet.getString("name");
phuongthuc.add(new PhuongThuc(id,name));
             }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return phuongthuc;
    }
}
