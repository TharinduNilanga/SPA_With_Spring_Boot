package lk.ijse.dto;

import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

import java.time.LocalDate;
import java.time.LocalTime;
import java.util.List;

/**
 * @author Tharindu Nilanga
 * @created 7/2/2022
 */
@NoArgsConstructor
@AllArgsConstructor
@Data
@ToString
public class OrderDTO {
    private String oId;
    private CustomerDTO customer;
    private int discount;
    private double totalPrice;

    @JsonFormat(pattern = "yyyy-MM-dd")
    private LocalDate date;

    @JsonFormat(pattern = "HH:mm:ss")
    private LocalTime time;

    List<OrderDetailsDTO> orderDetails;
}
