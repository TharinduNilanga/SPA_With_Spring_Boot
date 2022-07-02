package lk.ijse.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
 * @author Tharindu Nilanga
 * @created 7/2/2022
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class ItemDTO {
    private String code;
    private String name;
    private double unitPrice;
    private int qtyOnHand;
}
