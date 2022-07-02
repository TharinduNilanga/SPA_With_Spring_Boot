package lk.ijse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.aspectj.weaver.ast.Or;

import javax.persistence.*;

/**
 * @author Tharindu Nilanga
 * @created 7/2/2022
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@IdClass(OrderItem_PK.class)
public class OrderDetails {
    @Id
    private String oId;
    private String itemCode;
    private int discount;
    private int qty;
    private double totalPrice;

    @ManyToOne
    @JoinColumn(name = "oId",referencedColumnName = "oId",insertable = false,updatable = false)
    private Order order;

    @ManyToOne
    @JoinColumn(name = "itemCode",referencedColumnName = "code",insertable = false,updatable = false)
    private Item item;


}
