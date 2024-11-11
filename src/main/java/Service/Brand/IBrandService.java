package Service.Brand;

import com.example.demo5.Brand;

import java.util.List;

public interface IBrandService {
    List<Brand> findAll();
    void add(Brand brand);
    Brand findById(int id);
}
