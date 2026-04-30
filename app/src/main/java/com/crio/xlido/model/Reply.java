package com.crio.xlido.model;

public class Reply {
    private int userId;
    private String content;

    public Reply(int userId, String content) {
        this.userId = userId;
        this.content = content;
    }

    public int getUserId() {
        return userId;
    }

    public String getContent() {
        return content;
    }
}