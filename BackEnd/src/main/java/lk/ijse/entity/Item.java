package lk.ijse.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.Id;

/**
 * @author Tharindu Nilanga
 * @created 6/26/2022
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
@Entity
public class Item {
    @Id
    private String code;
    private String name;
    private double unitPrice;
    private int qtyOnHand;

}
