package com.crio.xlido.model;

import java.util.*;

public class Question {
    private int id;
    private String content;
    private int userId;
    private int eventId;
    private int votes = 0;
    private Set<Integer> upvotedUsers = new HashSet<>();
    private List<Reply> replies = new ArrayList<>();

    public Question(int id, String content, int userId, int eventId) {
        this.id = id;
        this.content = content;
        this.userId = userId;
        this.eventId = eventId;
    }

    public int getId() { return id; }
    public String getContent() { return content; }
    public int getVotes() { return votes; }
    public int getEventId() { return eventId; }
    public int getUserId() { return userId; }
    public List<Reply> getReplies() { return replies; }

    public boolean upvote(int userId) {
        if (upvotedUsers.contains(userId)) return false;
        upvotedUsers.add(userId);
        votes++;
        return true;
    }

    public void addReply(Reply reply) {
        replies.add(reply);
    }
}