package com.aarthivishakha.api;

import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicLong;
import javax.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class ItemService {
    private final Map<Long, Item> items = new LinkedHashMap<Long, Item>();
    private final AtomicLong sequence = new AtomicLong();

    public synchronized List<Item> list() { return new ArrayList<Item>(items.values()); }
    public synchronized Item find(long id) { return items.get(Long.valueOf(id)); }
    public synchronized Item create(Item input) {
        long id = sequence.incrementAndGet();
        Item item = new Item(Long.valueOf(id), input.name, input.price);
        items.put(Long.valueOf(id), item); return item;
    }
    public synchronized Item replace(long id, Item input) {
        if (!items.containsKey(Long.valueOf(id))) return null;
        Item item = new Item(Long.valueOf(id), input.name, input.price);
        items.put(Long.valueOf(id), item); return item;
    }
    public synchronized boolean delete(long id) { return items.remove(Long.valueOf(id)) != null; }
    public synchronized void clear() { items.clear(); sequence.set(0L); }
}
