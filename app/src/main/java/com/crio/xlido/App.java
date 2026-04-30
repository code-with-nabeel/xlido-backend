package com.crio.xlido;

import java.util.*;
import com.crio.xlido.repository.*;
import com.crio.xlido.service.*;
import com.crio.xlido.model.*;

public class App {

    UserService userService;
    EventService eventService;
    QuestionService questionService;
    ReplyService replyService;

    public App() {
        UserRepository ur = new UserRepository();
        EventRepository er = new EventRepository();
        QuestionRepository qr = new QuestionRepository();

        userService = new UserService(ur);
        eventService = new EventService(er, userService);
        questionService = new QuestionService(qr, eventService, userService);
        replyService = new ReplyService(questionService, userService);
    }

    public void run(List<String> commands) {
        for (String line : commands) {
            String[] parts = line.split(",", 2);
            String cmd = parts[0];

            switch (cmd) {
                case "CREATE_USER":
                    String[] u = parts[1].split(",");
                    userService.createUser(u[0], u[1]);
                    break;

                case "CREATE_EVENT":
                    String[] e = parts[1].split(",");
                    eventService.createEvent(e[0], Integer.parseInt(e[1]));
                    break;

                case "ADD_QUESTION":
                    String[] q = parts[1].split(",");
                    questionService.addQuestion(q[0], Integer.parseInt(q[1]),
                            Integer.parseInt(q[2]));
                    break;

                case "UPVOTE_QUESTION":
                    String[] up = parts[1].split(",");
                    questionService.upvote(Integer.parseInt(up[0]), Integer.parseInt(up[1]));
                    break;

                case "REPLY_QUESTION":
                    String[] r = parts[1].split(",");
                    replyService.reply(r[0], Integer.parseInt(r[1]), Integer.parseInt(r[2]));
                    break;

                case "LIST_QUESTIONS":
                    String[] l = parts[1].split(",");
                    listQuestions(Integer.parseInt(l[0]), l[1]);
                    break;

                case "DELETE_EVENT":
                    String[] de = parts[1].split(",");
                    eventService.deleteEvent(Integer.parseInt(de[0]), Integer.parseInt(de[1]));
                    break;

                case "DELETE_QUESTION":
                    String[] dq = parts[1].split(",");
                    questionService.deleteQuestion(Integer.parseInt(dq[0]),
                            Integer.parseInt(dq[1]));
                    break;
            }
        }
    }

    private void listQuestions(int eventId, String type) {
        List<Question> list = questionService.getAllByEvent(eventId);

        if (list.isEmpty()) {
            System.out.println("ERROR: Event with an id " + eventId + " does not exist");
            return;
        }

        if (type.equals("POPULAR")) {
            list.sort((a, b) -> b.getVotes() - a.getVotes());
        } else {
            Collections.reverse(list);
        }

        for (Question q : list) {
            System.out.println("Question ID: " + q.getId());
            System.out.println("Content: " + q.getContent());
            System.out.println("Votes: " + q.getVotes());
            System.out.println("Replies:");

            for (Reply r : q.getReplies()) {
                System.out.println("  - User " + r.getUserId() + ": " + r.getContent());
            }

            System.out.println();
        }
    }
}
