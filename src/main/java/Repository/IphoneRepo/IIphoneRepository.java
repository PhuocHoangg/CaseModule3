package Repository.IphoneRepo;
import com.example.demo5.Iphone;

import java.util.List;

public interface    IIphoneRepository {
    List<Iphone> findAll();
    void add(Iphone phone);
    Iphone findById(int id);
    void delete(int id);
    void update(Iphone phone);
}
