package hha.website.services;

import hha.website.DataInputRepository;
import hha.website.models.DataInputDTO;
import hha.website.models.DataInput;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collection;
import javax.transaction.Transactional;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

@Service
@Transactional
public class DataInputService{

    @PersistenceContext private EntityManager em;

    @Autowired
    private DataInputRepository dataInputRepository;

    public DataInput save(DataInputDTO department) {
        DataInput newDataInput = new DataInput();
        newDataInput.setAnnual(department.getAnnual());
        newDataInput.setMonthly(department.getMonthly());
        return dataInputRepository.save(newDataInput);
    }
    public Collection<String> listAnnualItem() {
        return dataInputRepository.queryAnnualItem();
    }
    public Collection<String> listMonthlyItem() {
        return dataInputRepository.queryMonthlyItem();
    }
    public Collection<String> listAllItem() {
        return dataInputRepository.queryAllItem();
    }
}
