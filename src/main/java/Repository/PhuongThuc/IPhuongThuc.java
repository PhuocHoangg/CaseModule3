package Repository.PhuongThuc;

import com.example.demo5.PhuongThuc;

import java.util.List;

public interface IPhuongThuc {
    PhuongThuc findById(int id);
    List<PhuongThuc> findAll();
}
