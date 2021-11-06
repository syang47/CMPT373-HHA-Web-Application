package hha.website;

import hha.website.models.Department;
import hha.website.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Set;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, String> {
    @Query("SELECT departmentname FROM Department")
    Collection<String> queryDepartmentNames();

    @Query("SELECT users FROM Department WHERE departmentname = 'NICU_PAED'")
    Set<User> queryUsersInNICU();

    @Query("SELECT reportsSubmitted FROM Department WHERE departmentname = ?1")
    Integer queryTotalReportsSubmittedForDepartment(String departmentname);

    @Modifying
    @Query("UPDATE Department SET reportsSubmitted = reportsSubmitted + 1 WHERE departmentname = ?1")
    void updateDepartmentReportsSubmitted(String departmentname);
}