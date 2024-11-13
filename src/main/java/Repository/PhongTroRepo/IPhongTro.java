package Repository.PhongTroRepo;
import com.example.demo5.PhongTro;

import java.util.List;
public interface IPhongTro {
     List<PhongTro> findAll();
    void save(PhongTro p);
    void delete(int id);
}
