package com.deltasigmaventures.item_management.service;

import com.deltasigmaventures.item_management.model.Item;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class ItemService {

    private final List<Item> items = new ArrayList<>();
// create a in memory array list which stores a collection list of items i.e. temporary db

    private final AtomicLong idGenerator = new AtomicLong(1);
// Gernates unique ID for each element , AtomicLong ensures:Safe ID generation in multi-threaded environments (multiple API calls at same time).

    public Item addItem(Item item) {
        item.setId(idGenerator.getAndIncrement());
        items.add(item);
        return item;
    }

// accepts an item id and avoids NullPointerException
    public Optional<Item> getItemById(Long id) {
        return items.stream()                    //Converts the list into a Java Stream
                .filter(i -> i.getId().equals(id))
                .findFirst();
    }
}


//Client sends request to add item
//Controller calls addItem()
//ID is generated & item is stored
//Client requests item by ID
//Controller calls getItemById()
//Item is returned (or empty)
