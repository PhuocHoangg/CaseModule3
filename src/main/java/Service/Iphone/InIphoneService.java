package Service.Iphone;

import com.example.demo5.Iphone;

import java.util.List;

public interface InIphoneService {
    List<Iphone> findAll();
    void add(Iphone phone);
    Iphone findById(int id);
    void delete(int id);
    void update(Iphone phone);
}
