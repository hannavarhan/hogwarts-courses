package com.epam.hogwarts.command;

import com.epam.hogwarts.command.impl.LoginCommand;
import com.epam.hogwarts.command.impl.RegisterCommand;
import com.epam.hogwarts.command.impl.StartPageCommand;

import java.util.EnumMap;

import static com.epam.hogwarts.command.CommandType.*;

public class CommandProvider {
    private static CommandProvider instance;
    private EnumMap<CommandType, Command> commands;

    private CommandProvider() {
        commands = new EnumMap<>(CommandType.class);
        commands.put(LOGIN, new LoginCommand());
        commands.put(REGISTER, new RegisterCommand());
        commands.put(START_PAGE, new StartPageCommand());
        /*commands.put(LOGOUT, new LogoutCommand());
        commands.put(PERSONAL_PAGE, new PersonalPageCommand());
        commands.put(DEFAULT, new DefaultCommand());
        commands.put(HOME_PAGE, new HomePageCommand());
        commands.put(GO_TO_LOGIN_PAGE, new GoToLoginPageCommand());
        commands.put(CHANGE_LANGUAGE, new ChangeLanguageCommand());
        commands.put(SIGN_UP, new SignUpCommand());
        commands.put(GO_TO_SIGN_UP_PAGE, new GoToSignUpPageCommand());
        commands.put(CONFIRM_EMAIL, new ConfirmEmailCommand());
        commands.put(GO_TO_SEND_EMAIL_AGAIN_PAGE, new GoToSendEmailAgainPageCommand());
        commands.put(SEND_EMAIL_AGAIN, new SendEmailAgainCommand());
        commands.put(GO_TO_EMAIL_SENT_PAGE, new GoToEmailSentPageCommand());
        commands.put(GO_TO_EMAIL_CONFIRMED_PAGE, new GoToEmailConfirmedPageCommand());*/
    }

    public static CommandProvider getInstance() {
        instance = new CommandProvider();
        return instance;
    }

    public Command getCommand(CommandType commandType) {
        return commands.get(commandType);
    }

    public Command getCommand(String command) {
        CommandType commandType;
        if (command == null) {
            return commands.get(DEFAULT);
        }
        try {
            commandType = CommandType.valueOf(command.toUpperCase());
        } catch (IllegalArgumentException e) {
            commandType = DEFAULT;
        }
        return commands.get(commandType);
    }

}
