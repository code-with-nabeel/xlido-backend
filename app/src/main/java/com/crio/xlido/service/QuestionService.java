package com.crio.xlido.service;

import com.crio.xlido.model.*;
import com.crio.xlido.repository.QuestionRepository;

import java.util.*;

public class QuestionService {
    private QuestionRepository repo;
    private EventService eventService;
    private UserService userService;
    private int counter = 1;

    public QuestionService(QuestionRepository repo, EventService eventService, UserService userService) {
        this.repo = repo;
        this.eventService = eventService;
        this.userService = userService;
    }

    public int addQuestion(String content, int userId, int eventId) {
        if (userService.getUser(userId) == null) {
            System.out.println("ERROR: User with an id " + userId + " does not exist");
            return -1;
        }
    
        if (eventService.getEvent(eventId) == null) {
            System.out.println("ERROR: Event with an id " + eventId + " does not exist");
            return -1;
        }
    
        Question q = new Question(counter++, content, userId, eventId);
        repo.save(q);
    
        System.out.println("Question ID: " + q.getId());
        return q.getId();
    }

    public void upvote(int questionId, int userId) {
        Question q = repo.findById(questionId);
        if (q == null) {
            System.out.println("ERROR: Question with an id " + questionId + " does not exist");
            return;
        }
        if (userService.getUser(userId) == null) {
            System.out.println("ERROR: User with an id " + userId + " does not exist");
            return;
        }

        if (!q.upvote(userId)) {
            System.out.println("ERROR: User with an id " + userId + " has already upvoted a question with an id " + questionId);
            return;
        }

        System.out.println("QUESTION_UPVOTED " + questionId);
    }

    public Question get(int id) {
        return repo.findById(id);
    }

    public List<Question> getAllByEvent(int eventId) {
        List<Question> list = new ArrayList<>();
        for (Question q : repo.findAll()) {
            if (q.getEventId() == eventId) list.add(q);
        }
        return list;
    }


    public void deleteQuestion(int questionId, int userId) {
        Question q = repo.findById(questionId);
    
        if (q == null) {
            System.out.println("ERROR: Question with an id " + questionId + " does not exist");
            return;
        }
    
        if (userService.getUser(userId) == null) {
            System.out.println("ERROR: User with an id " + userId + " does not exist");
            return;
        }
    
        if (q.getUserId() != userId) {
            System.out.println("ERROR: User with an id " + userId +
                    " is not an author of question with an id " + questionId);
            return;
        }
    
        repo.delete(questionId);
        System.out.println("QUESTION_DELETED " + questionId);
    }
}