package com.journaldev.spring;

import com.journaldev.spring.controller.Command;
import com.journaldev.spring.controller.Controller;
import com.journaldev.spring.dao.impl.PersonDAOImpl;
import com.journaldev.spring.dao.factory.DAOFactory;
import com.journaldev.spring.model.Menu;
import com.journaldev.spring.service.impl.PersonServiceImpl;
import com.journaldev.spring.service.factory.ServiceFactory;
import com.journaldev.spring.views.MainView;

import java.util.EnumSet;

/**
 * Created by sergey on 30.6.17.
 */
public class Main1 {
    public static void main(String[] args) {
        MainView mainView = new MainView(new Controller(new Menu(
                EnumSet.of(Command.ADD_PERSON,Command.DELETE_PERSON,
                Command.EDIT_PERSON, Command.GET_ALL_PERSONS,
                Command.GET_PERSON)), new ServiceFactory(
                new PersonServiceImpl(new DAOFactory(new PersonDAOImpl())))));
        while (true) {
            mainView.show();
        }
    }
}
