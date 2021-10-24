package hha.website.services;

import hha.website.DepartmentRepository;
import hha.website.models.Department;
import hha.website.models.DepartmentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

@Service
@Transactional
public class DepartmentServiceImpl implements DepartmentService {

    @PersistenceContext private EntityManager em;

    @Autowired
    private DepartmentRepository departmentRepository;

    @Override
    public List<Department> findAll() {
        return em.createQuery("select * from Department", Department.class).getResultList();
    }

    public Department save(DepartmentDTO department) {
        Department newDepartment = new Department();
        newDepartment.setName(department.getName());
        newDepartment.setPoints(department.getPoints());
        return departmentRepository.save(newDepartment);
    }
}
