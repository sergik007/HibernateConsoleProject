package com.journaldev.spring.views;

import com.journaldev.spring.controller.Command;
import com.journaldev.spring.controller.Controller;
import com.journaldev.spring.controller.exception.ControllerException;
import com.journaldev.spring.model.Person;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by sergey on 30.6.17.
 */
public class MainView {
    private static final Logger logger = LoggerFactory.getLogger(MainView.class);
    Controller controller;

    public MainView(Controller controller) {
        this.controller = controller;
    }

    public Controller getController() {
        return controller;
    }

    public void setController(Controller controller) {
        this.controller = controller;
    }

    public void show() {
        System.out.println("Введите команду: { " +
                "ADD_PERSON, " +
                "DELETE_PERSON, " +
                "GET_ALL_PERSONS, " +
                "EDIT_PERSON," +
                "GET_PERSON }");
        try {
            Command command = controller.getCommand();
            switch (command) {
                case DELETE_PERSON:
                    deletePerson();
                    break;
                case ADD_PERSON:
                    addPerson();
                    break;
                case EDIT_PERSON:
                    editPerson();
                    break;
                case GET_ALL_PERSONS:
                    getAllPersons();
                    break;
                case GET_PERSON:
                    getPerson();
                    break;
            }
        } catch (ControllerException e) {
            ConsoleReader.closeInputStream();
            logger.error("ошибка ",e);
        }

    }
    private void getAllPersons() throws ControllerException{
        List<Person> persons = (List<Person>)controller.perform(Command.GET_ALL_PERSONS);
        persons.forEach(System.out::println);
    }
    private void getPerson() throws ControllerException{
        System.out.println("Введите id");
        int id = Integer.parseInt(ConsoleReader.read());
        controller.perform(Command.GET_PERSON, id);
    }
    private void addPerson() throws ControllerException{
        Person person = new Person();
        System.out.println("Введите name");
        person.setName(ConsoleReader.read());
        System.out.println("Введите страну");
        person.setCountry(ConsoleReader.read());
        controller.perform(Command.ADD_PERSON, person);
    }
    private void deletePerson() throws ControllerException{
        System.out.println("Введите id");
        int id = Integer.parseInt(ConsoleReader.read());
        controller.perform(Command.DELETE_PERSON, id);
    }

    //протестить данный метод потом
    private void editPerson() throws ControllerException{
        System.out.println("Введите id");
        int id = Integer.parseInt(ConsoleReader.read());
        Person person = (Person) controller.perform(Command.GET_PERSON, id);
        System.out.println("Введите имя");
        person.setName(ConsoleReader.read());
        System.out.println("Введите страну");
        person.setCountry(ConsoleReader.read());
       controller.perform(Command.EDIT_PERSON, id);
    }

    public static void print(String s) {
        System.out.println(s);
    }
}
