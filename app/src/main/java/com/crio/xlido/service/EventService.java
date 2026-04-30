package com.crio.xlido.service;

import com.crio.xlido.model.Event;
import com.crio.xlido.repository.EventRepository;

public class EventService {
    private EventRepository repo;
    private UserService userService;
    private int counter = 1;

    public EventService(EventRepository repo, UserService userService) {
        this.repo = repo;
        this.userService = userService;
    }

    public int createEvent(String name, int userId) {
        if (userService.getUser(userId) == null) {
            System.out.println("ERROR: User with an id " + userId + " does not exist");
            return -1;
        }
    
        Event event = new Event(counter++, name, userId);
        repo.save(event);
    
        System.out.println("Event ID: " + event.getId());
        return event.getId();
    }

    public Event getEvent(int id) {
        return repo.findById(id);
    }
    

    public void deleteEvent(int eventId, int userId) {
        Event event = repo.findById(eventId);
    
        if (event == null) {
            System.out.println("ERROR: Event with an id " + eventId + " does not exist");
            return;
        }
    
        if (userService.getUser(userId) == null) {
            System.out.println("ERROR: User with an id " + userId + " does not exist");
            return;
        }
    
        if (event.getOrganizerId() != userId) {
            System.out.println("ERROR: User with an id " + userId +
                    " is not a organizer of Event with an id " + eventId);
            return;
        }
    
        repo.delete(eventId);
        System.out.println("EVENT_DELETED " + eventId);
    }
}