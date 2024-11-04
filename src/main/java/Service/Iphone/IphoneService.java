package Service.Iphone;

import Repository.IphoneRepo.IIphoneRepository;
import Repository.IphoneRepo.IphoneRepository;
import Repository.PhoneRepo.InPhoneRepository;
import com.example.demo5.Iphone;

import java.util.Collections;
import java.util.List;

public class IphoneService implements InIphoneService {
    private final IIphoneRepository iphoneRepo=new IphoneRepository();

    @Override
    public List<Iphone> findAll() {
        return iphoneRepo.findAll();
    }
}
