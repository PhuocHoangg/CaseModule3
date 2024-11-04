package Service.Android;

import Repository.PhoneRepo.InPhoneRepository;
import Repository.PhoneRepo.PhoneRepository;
import com.example.demo5.Android;

import java.util.Collections;
import java.util.List;

public class AndroidService implements IAndroidService {
   private final InPhoneRepository inPhoneRepo=new PhoneRepository();
    @Override
    public List<Android> findAll() {
        return inPhoneRepo.findAll();
    }
}
