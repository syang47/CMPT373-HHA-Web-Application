package hha.website;

import hha.website.models.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Integer> {
    User findByUsername(String username);

    @Query("SELECT DISTINCT role FROM User")
    Collection<String> queryDistinctField();

    @Modifying
    @Query("UPDATE User SET reportsSubmitted = reportsSubmitted + 1 WHERE id = ?1")
    void updateUserReportsSubmitted(Integer id);

    @Query("SELECT u FROM User u WHERE department_id = ?1")
    List<User> findByDepartmentId(String departmentname);

    // public static final String FIND_USERNAMES = "SELECT username, role FROM User";
    // @Query(value=FIND_USERNAMES, nativeQuery = true)
    // public List<Object[]> findUserNames();


    @Query("SELECT u FROM User u WHERE employeeOfTheMonth = ?1")
    Optional<User> queryEmployeeOfTheMonth(String month);
}
