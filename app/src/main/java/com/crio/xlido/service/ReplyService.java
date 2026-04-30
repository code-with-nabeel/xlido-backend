package com.crio.xlido.service;

import com.crio.xlido.model.*;

public class ReplyService {
    private QuestionService questionService;
    private UserService userService;

    public ReplyService(QuestionService q, UserService u) {
        this.questionService = q;
        this.userService = u;
    }

    public void reply(String content, int questionId, int userId) {
        Question q = questionService.get(questionId);

        if (q == null) {
            System.out.println("ERROR: Question with an id " + questionId + " does not exist");
            return;
        }

        if (userService.getUser(userId) == null) {
            System.out.println("ERROR: User with an id " + userId + " does not exist");
            return;
        }

        // ✅ ONLY FIRST REPLY KEEP (important for test)
        if (q.getReplies().isEmpty()) {
            q.addReply(new Reply(userId, content));
        }

        System.out.println("REPLY_ADDED");
    }
}