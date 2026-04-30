package com.crio.xlido.commands;

import java.util.List;
import com.crio.xlido.service.UserService;


public class CreateUserCommand implements Command {

    private UserService userService;

    public CreateUserCommand(UserService userService) {
        this.userService = userService;
    }

    @Override
    public void execute(List<String> tokens) {
        String email = tokens.get(1);
        String password = tokens.get(2);

        int userId = userService.createUser(email, password);
        System.out.println("User ID: " + userId);
    }
}