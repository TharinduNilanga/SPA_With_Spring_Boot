package lk.ijse.service;

import lk.ijse.dto.ItemDTO;

import java.util.List;

/**
 * @author Tharindu Nilanga
 * @created 7/3/2022
 */
public interface ItemService {
    String generateItemId();
    void saveItem(ItemDTO itemDTO);
    void deleteItem(String id);
    void updateItem(ItemDTO itemDTO);
    ItemDTO searchItem(String id);
    List<ItemDTO> getAllItems();
}
