package tec.fullmoonsapi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemRepository itemRepository;

    @GetMapping
    public List<ItemModule> getAllItems() {
        return itemRepository.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ItemModule> getItemById(@PathVariable Long id) {
        Optional<ItemModule> item = itemRepository.findById(id);
        if (item.isPresent()) {
            return ResponseEntity.ok(item.get());
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ItemModule createItem(@RequestBody ItemModule item) {
        return itemRepository.save(item);
    }

    @PutMapping("/{id}")
    public ResponseEntity<ItemModule> updateItem(@PathVariable Long id, @RequestBody ItemModule itemDetails) {
        Optional<ItemModule> itemOptional = itemRepository.findById(id);
        if (itemOptional.isPresent()) {
            ItemModule item = itemOptional.get();
            item.setIsFood(itemDetails.isFood());
            item.setName(itemDetails.getName());
            item.setPrice(itemDetails.getPrice());
            item.setCurrency(itemDetails.getCurrency());
            item.setImage(itemDetails.getImage());
            item.setTaste(itemDetails.getTaste());
            item.setEffect(itemDetails.getEffect());
            item.setAllergies(itemDetails.getAllergies());
            return ResponseEntity.ok(itemRepository.save(item));
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteItem(@PathVariable Long id) {
        Optional<ItemModule> itemOptional = itemRepository.findById(id);
        if (itemOptional.isPresent()) {
            itemRepository.delete(itemOptional.get());
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}