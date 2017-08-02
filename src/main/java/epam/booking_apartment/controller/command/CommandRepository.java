package epam.booking_apartment.controller.command;

import org.springframework.beans.factory.annotation.Autowired;

import java.util.Map;

public class CommandRepository {

    @Autowired
    private static Map<String, ICommand> repository;

    public static ICommand getCommand(String string) {
        return repository.get(string.toUpperCase());
    }
}
