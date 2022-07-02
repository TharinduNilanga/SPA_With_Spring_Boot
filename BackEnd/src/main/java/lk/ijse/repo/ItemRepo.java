package lk.ijse.repo;

import lk.ijse.entity.Item;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Tharindu Nilanga
 * @created 7/2/2022
 */
public interface ItemRepo extends JpaRepository<Item,String> {
    @Query(value = "SELECT code FROM Item ORDER BY code DESC LIMIT 1",nativeQuery = true)
    String getId();

}
