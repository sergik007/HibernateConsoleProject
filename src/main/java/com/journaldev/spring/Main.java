package com.journaldev.spring;

import com.journaldev.spring.controller.Controller;
import com.journaldev.spring.views.MainView;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by sergey on 30.6.17.
 */
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext("");
        MainView mainView =(MainView) context.getBean("mainView");

    }
}
