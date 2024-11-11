package Repository.BrandRepo;


import com.example.demo5.Brand;

import java.util.List;

public interface IBrandRepository {
    List<Brand> findAll();
    void add(Brand brand);
    Brand findById(int id);
}

