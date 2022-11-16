package com.amsidh.mvc.service.impl;

import com.amsidh.mvc.entity.Item;
import com.amsidh.mvc.repository.ItemRepository;
import com.amsidh.mvc.service.ItemService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class ItemServiceImpl implements ItemService {

    private final ItemRepository itemRepository;

    @Cacheable(value = "itemCache")
    public Item getItemForId(String id) {
        log.info("Calling itemRepository to fetch the Item with id {}", id);
        return itemRepository.findById(id)
                .orElseThrow(RuntimeException::new);
    }

}
