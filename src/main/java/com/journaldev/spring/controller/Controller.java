package com.journaldev.spring.controller;

import com.journaldev.spring.controller.exception.ControllerException;
import com.journaldev.spring.model.Menu;
import com.journaldev.spring.model.Person;
import com.journaldev.spring.service.exception.ServiceException;
import com.journaldev.spring.service.factory.ServiceFactory;
import com.journaldev.spring.views.ConsoleReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

/**
 * Created by sergey on 30.6.17.
 */
public class Controller {
    private static final Logger logger = LoggerFactory.getLogger(Controller.class);

    private Menu menu;
    private ServiceFactory serviceFactory;

    public Controller(Menu menu, ServiceFactory serviceFactory) {
            logger.debug("конструктор controller");
            this.menu = menu;
            this.serviceFactory = serviceFactory;
            logger.info("Session is opened");
    }

    public Menu getMenu() {
        return menu;
    }

    public void setMenu(Menu menu) {
        this.menu = menu;
    }

    public ServiceFactory getServiceFactory() {
        return serviceFactory;
    }

    public void setServiceFactory(ServiceFactory serviceFactory) {
        this.serviceFactory = serviceFactory;
    }

    public Object perform(Command command) throws ControllerException{
        logger.debug("Object perform(Command command)");
        List<Person> persons = null;
        try {
            switch (command) {
                case GET_ALL_PERSONS:
                    persons = (List<Person>) serviceFactory.getPersonService().listPersons();
                    break;
            }
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
        return persons;
    }
    public void perform(Command command, Object o) throws ControllerException{
        logger.debug("конструктор controller");
        try {
            switch (command) {
                case ADD_PERSON:
                    serviceFactory.getPersonService().addPerson((Person)o);
                    break;
                case EDIT_PERSON:
                    serviceFactory.getPersonService().updatePerson((Person) o);
                    break;
            }
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
    }
    public Object perform(Command command, Integer id) throws ControllerException{
        logger.debug("конструктор controller");
        Person person = null;
        try {
            switch (command) {
                case DELETE_PERSON:
                    serviceFactory.getPersonService().removePerson(id);
                    break;
                case GET_PERSON:
                    person =serviceFactory.getPersonService().getPersonById(id);
                    break;
            }
        } catch (ServiceException e) {
            throw new ControllerException(e);
        }
        return person;
    }
    public Command getCommand() throws ControllerException {
        String consoleString = ConsoleReader.read().replace(" ", "_")
                .replace("-", "_")
                .toUpperCase();
        Command command = null;
        try {
            command = Command.valueOf(consoleString);
            if (menu.getCommands().contains(command)) {
                return command;
            } else {
                throw new ControllerException("menu doesn't contains this command");
            }
        } catch (IllegalArgumentException e) {
            throw new ControllerException("неправильный ввод данных");
        }
    }
}
