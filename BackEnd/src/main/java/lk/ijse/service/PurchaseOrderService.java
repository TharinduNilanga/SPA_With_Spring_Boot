package lk.ijse.service;

import lk.ijse.dto.OrderDTO;

import java.util.List;

/**
 * @author Tharindu Nilanga
 * @created 7/3/2022
 */
public interface PurchaseOrderService {

    String generateOrderId();
    void purchaseOrder(OrderDTO orderDTO);
    OrderDTO searchOrder(String id);
    List<OrderDTO> getAllOrders();
}
