package hha.website.services;

import hha.website.DepartmentRepository;
import hha.website.models.Department;
import hha.website.models.DepartmentDTO;
import hha.website.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
@Transactional
public class HHADepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;


    public Department loadDepartmentByDepartmentName(String department) {
        return departmentRepository.findByDepartmentname(department);
    }

    public Department save(DepartmentDTO data) {
        Department department = new Department();
        /*department.setUsers(data.getUsers());
        department.setDept(data.getDepartment());*/
        return departmentRepository.save(department);
    }

    @PostConstruct
    public void initializeDepartments() {
        System.out.println("initalizing departments...");

        //Set<User> initialUsers = new HashSet<User>();

        Department nicu_paed = new Department();
        nicu_paed.setId(1);
        /*nicu_paed.setUsers(initialUsers);
        nicu_paed.setDept("NICU_PAED");*/
        nicu_paed.setDepartmentname("NICU_PAED");
        departmentRepository.save(nicu_paed);

        Department maternity = new Department();
        maternity.setId(2);
        /*nicu_paed.setUsers(initialUsers);
        nicu_paed.setDept("maternity");*/
        maternity.setDepartmentname("maternity");
        departmentRepository.save(maternity);

        Department rehab = new Department();
        rehab.setId(3);
        /*nicu_paed.setUsers(initialUsers);
        nicu_paed.setDept("rehab");*/
        rehab.setDepartmentname("rehab");
        departmentRepository.save(rehab);

        Department community_health = new Department();
        community_health.setId(4);
        /*nicu_paed.setUsers(initialUsers);
        nicu_paed.setDept("community_health");*/
        community_health.setDepartmentname("community_health");
        departmentRepository.save(community_health);
    }

    public List<Department> listAllDepartments() {
        return departmentRepository.findAll();
    }

    public Collection<String> listDepartmentNames() {
        return departmentRepository.queryDepartmentNames();
    }

    public Collection<String> listUsersInNICU() {
        Set<String> usernames = new HashSet<>();
        for(User u: departmentRepository.queryUsersInNICU()) {
            usernames.add(u.getUsername());
        }
        return usernames;
    }
}
