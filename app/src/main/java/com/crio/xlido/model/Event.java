package com.crio.xlido.model;

public class Event {
    private int id;
    private String name;
    private int organizerId;

    public Event(int id, String name, int organizerId) {
        this.id = id;
        this.name = name;
        this.organizerId = organizerId;
    }

    public int getId() {
        return id;
    }

    public int getOrganizerId() {
        return organizerId;
    }
}