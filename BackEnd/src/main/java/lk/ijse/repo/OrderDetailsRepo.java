package lk.ijse.repo;

import lk.ijse.entity.OrderDetails;
import lk.ijse.entity.OrderItem_PK;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Tharindu Nilanga
 * @created 7/2/2022
 */
public interface OrderDetailsRepo extends JpaRepository<OrderDetails, OrderItem_PK> {
}
