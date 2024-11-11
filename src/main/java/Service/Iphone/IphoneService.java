package Service.Iphone;

import Repository.IphoneRepo.IIphoneRepository;
import Repository.IphoneRepo.IphoneRepository;
import com.example.demo5.Iphone;

import java.util.Collections;
import java.util.List;

public class IphoneService implements InIphoneService {
    private final IIphoneRepository iphoneRepo=new IphoneRepository();

    @Override
    public List<Iphone> findAll() {
        return iphoneRepo.findAll();
    }

    @Override
    public void add(Iphone phone) {
        iphoneRepo.add(phone);
    }

    @Override
    public Iphone findById(int id) {
        return iphoneRepo.findById(id);
    }

    @Override
    public void delete(int id) {
        iphoneRepo.delete(id);
    }

    @Override
    public void update(Iphone phone) {
        iphoneRepo.update(phone);
    }

}
