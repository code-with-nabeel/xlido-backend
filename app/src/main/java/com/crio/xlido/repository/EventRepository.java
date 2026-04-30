package com.crio.xlido.repository;

import com.crio.xlido.model.Event;
import java.util.*;

public class EventRepository {
    private Map<Integer, Event> events = new HashMap<>();

    public void save(Event event) {
        events.put(event.getId(), event);
    }

    public Event findById(int id) {
        return events.get(id);
    }

    public void delete(int id) {
        events.remove(id);
    }
}