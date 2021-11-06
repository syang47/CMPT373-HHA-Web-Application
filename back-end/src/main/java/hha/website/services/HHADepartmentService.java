package hha.website.services;

import hha.website.DepartmentRepository;
import hha.website.models.Department;
import hha.website.models.DepartmentDTO;
import hha.website.models.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import javax.annotation.PostConstruct;
import javax.transaction.Transactional;
import java.util.*;

@Service
@Transactional
public class HHADepartmentService {
    @Autowired
    private DepartmentRepository departmentRepository;

    @Lazy
    @Autowired
    private HHAUserDetailsService userDetailsService;

    public Optional<Department> loadDepartmentByDepartmentName(String department) {
        return departmentRepository.findById(department);
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

        Department nicu_paed = new Department();
        nicu_paed.setDepartmentname("NICU_PAED");
        nicu_paed.setPoints(0);
        nicu_paed.setReportsSubmitted(0);
        departmentRepository.save(nicu_paed);

        Department maternity = new Department();
        maternity.setDepartmentname("maternity");
        maternity.setPoints(0);
        maternity.setReportsSubmitted(0);
        departmentRepository.save(maternity);

        Department rehab = new Department();
        rehab.setDepartmentname("rehab");
        rehab.setPoints(0);
        rehab.setReportsSubmitted(0);
        departmentRepository.save(rehab);

        Department community_health = new Department();
        community_health.setDepartmentname("community_health");
        community_health.setPoints(0);
        community_health.setReportsSubmitted(0);
        departmentRepository.save(community_health);
    }




    public void addASubmittedReport(User user) {
        userDetailsService.addASubmittedReportForUser(user);
        departmentRepository.updateDepartmentReportsSubmitted(user.getDepartment().getDepartmentname());
    }

    public List<Department> listAllDepartments() {
        return departmentRepository.findAll();
    }

    public Collection<String> listDepartmentNames() {
        return departmentRepository.queryDepartmentNames();
    }

    public Integer listTotalReportsSubmittedForDepartment(String departmentname) {
        return departmentRepository.queryTotalReportsSubmittedForDepartment(departmentname);
    }
}
