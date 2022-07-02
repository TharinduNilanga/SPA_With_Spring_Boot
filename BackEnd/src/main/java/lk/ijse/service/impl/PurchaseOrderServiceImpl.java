package lk.ijse.service.impl;


import lk.ijse.dto.OrderDTO;
import lk.ijse.entity.Item;
import lk.ijse.entity.Order;
import lk.ijse.entity.OrderDetails;
import lk.ijse.repo.ItemRepo;
import lk.ijse.repo.OrderDetailsRepo;
import lk.ijse.repo.OrderRepo;
import lk.ijse.service.PurchaseOrderService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

/**
 * @author Tharindu Nilanga
 * @created 7/3/2022
 */
@Service
@Transactional
public class PurchaseOrderServiceImpl implements PurchaseOrderService {

    @Autowired
    private OrderRepo repo;
    @Autowired
    private OrderDetailsRepo detailsRepo;
    @Autowired
    private ItemRepo itemRepo;

    @Autowired
    private ModelMapper mapper;

    @Override
    public String generateOrderId() {
        if (repo.getId()==null){
            String id = repo.getId();
            int newId = Integer.parseInt(id.replace("O", ""));
            return String.format("O%03d",newId+1);
        }else {
            return "O001";
        }
    }

    @Override
    public void purchaseOrder(OrderDTO orderDTO) {
        Order order = mapper.map(orderDTO, Order.class);
        if (!repo.existsById(orderDTO.getOId())) {
            repo.save(order);
            if (orderDTO.getOrderDetails().size() < 1) {
                throw new RuntimeException("No Items Added...");
            }
            for (OrderDetails orderDetail : order.getOrderDetails()) {
                Item item = itemRepo.findById(orderDetail.getItemCode()).get();
                item.setQtyOnHand(item.getQtyOnHand() - orderDetail.getQty());
                itemRepo.save(item);
            }
        }else{
                throw new RuntimeException("Place Order Failed......");
            }

    }

    @Override
    public OrderDTO searchOrder(String id) {
        if (repo.existsById(id)){
            return mapper.map(repo.findById(id),OrderDTO.class);
        }else {
            throw new RuntimeException("No such Order....");
        }
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return mapper.map(repo.findAll(),new TypeToken<List<OrderDTO>>(){}.getType());
    }
}
