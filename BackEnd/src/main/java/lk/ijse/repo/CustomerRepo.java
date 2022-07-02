package lk.ijse.repo;

import lk.ijse.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import sun.awt.SunHints;

/**
 * @author Tharindu Nilanga
 * @created 7/2/2022
 */
public interface CustomerRepo extends JpaRepository<Customer,String> {
 /*   @Query(value="SELECT id FROM Customer ORDER BY id ",nativeQuery=true);
    void gene*/

    @Query(value = "SELECT id FROM Customer ORDER BY id DESC LIMIT 1",nativeQuery = true)
    String getId();

}
