package lk.ijse.repo;

import lk.ijse.entity.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

/**
 * @author Tharindu Nilanga
 * @created 7/2/2022
 */
public interface OrderRepo extends JpaRepository<Order,String> {
    @Query(value = "SELECT oId FROM `Order` ORDER BY oId DESC LIMIT 1",nativeQuery = true)
    String getId();
}
