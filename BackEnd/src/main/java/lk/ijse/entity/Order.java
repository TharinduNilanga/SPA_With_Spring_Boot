package lk.ijse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * @author Tharindu Nilanga
 * @created 7/2/2022
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Order {
    @Id
    private String oId;

    @ManyToOne(cascade = {CascadeType.REFRESH,CascadeType.DETACH})
    @JoinColumn(name = "cusId",referencedColumnName = "id",nullable = false)
    private Customer   customer;

    private int discount;
    private double totalPrice;
    private LocalDate date;
    private LocalTime time;

    @OneToMany(mappedBy = "order",cascade = CascadeType.ALL)
    private List<OrderDetails> orderDetails;
}
