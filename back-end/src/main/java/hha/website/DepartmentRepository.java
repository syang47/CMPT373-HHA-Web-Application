package hha.website;

import hha.website.models.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import java.util.Collection;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Integer> {
    Department findByName(String departmentname);

    @Query("SELECT d.name FROM Department d ORDER BY id ASC")
    Collection<String> queryAllDepartmentNames();
    @Query("SELECT d.points FROM Department d ORDER BY id ASC")
    Collection<Integer> queryAllDepartmentPoints();
}
