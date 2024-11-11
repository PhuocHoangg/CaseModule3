package Service.Brand;

import Repository.BrandRepo.BrandRepository;
import Repository.BrandRepo.IBrandRepository;
import com.example.demo5.Brand;

import java.util.Collections;
import java.util.List;

public class BrandService implements IBrandService  {
    private final IBrandRepository repository=new BrandRepository();
    @Override
    public List<Brand> findAll() {
        return repository.findAll();
    }

    @Override
    public void add(Brand brand) {
        repository.add(brand);

    }

    @Override
    public Brand findById(int id) {
       return repository.findById(id);
    }
}
