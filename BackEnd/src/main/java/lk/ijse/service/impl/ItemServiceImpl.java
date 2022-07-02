package lk.ijse.service.impl;


import lk.ijse.dto.ItemDTO;
import lk.ijse.entity.Item;
import lk.ijse.repo.ItemRepo;
import lk.ijse.service.ItemService;
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
public class ItemServiceImpl implements ItemService {
    @Autowired
    private ItemRepo repo;

    @Autowired
    private ModelMapper mapper;


    @Override
    public String generateItemId() {
        if (repo.getId()==null){
            String id = repo.getId();
            int newId = Integer.parseInt(id.replace("I", ""));
            return String.format("I%03d",newId+1);
        }else {
            return "I001";
        }
    }

    @Override
    public void saveItem(ItemDTO itemDTO) {
        if (!repo.existsById(itemDTO.getCode())){
            repo.save(mapper.map(itemDTO, Item.class));
        }else {
            throw new RuntimeException("Item is already exists....");
        }
    }

    @Override
    public void deleteItem(String id) {
        if(repo.existsById(id)){
            repo.deleteById(id);
        }else {
            throw new RuntimeException("No such Item ...please check again....");
        }
    }

    @Override
    public void updateItem(ItemDTO itemDTO) {
        if (repo.existsById(itemDTO.getCode())){
            repo.save(mapper.map(itemDTO,Item.class));
        }else {
            throw new RuntimeException("No such Item to Update....");
        }
    }

    @Override
    public ItemDTO searchItem(String id) {
       if (repo.existsById(id)){
           return mapper.map(repo.findById(id),ItemDTO.class);
       }else {
           throw new RuntimeException("Please chech the "+id+" tryagain...");
       }
    }

    @Override
    public List<ItemDTO> getAllItems() {
        return mapper.map(repo.findAll(),new TypeToken<List<ItemDTO>>(){}.getType());
    }
}
