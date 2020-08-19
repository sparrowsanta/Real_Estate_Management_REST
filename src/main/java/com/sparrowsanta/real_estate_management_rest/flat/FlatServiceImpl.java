package com.sparrowsanta.real_estate_management_rest.flat;


import com.sparrowsanta.real_estate_management_rest.standardJpa.AbstractBaseRepositoryImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional
public class FlatServiceImpl extends AbstractBaseRepositoryImpl<Flat, Long> implements FlatService {

    @Autowired
    private FlatRepository flatRepository;

    public FlatServiceImpl(FlatRepository flatRepository) {
        super(flatRepository);
    }
    // other specialized methods from the MyDomainService interface


    public Flat saveFlat(Flat flat) {
        flatRepository.myOwnFindBy("2");
        return flat;
    }

    public void saveTest(){
        System.out.println("s");
    }

}
