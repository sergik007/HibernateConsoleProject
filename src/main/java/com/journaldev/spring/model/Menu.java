package com.journaldev.spring.model;

import com.journaldev.spring.controller.Command;

import java.util.EnumSet;

/**
 * Created by sergey on 30.6.17.
 */
public class Menu {
    private EnumSet<Command> commands;

    public Menu(EnumSet<Command> commands) {
        this.commands = commands;
    }

    public EnumSet<Command> getCommands() {
        return commands;
    }

    public void setCommands(EnumSet<Command> commands) {
        this.commands = commands;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Menu menu = (Menu) o;

        return commands != null ? commands.equals(menu.commands) : menu.commands == null;
    }

    @Override
    public int hashCode() {
        return commands != null ? commands.hashCode() : 0;
    }

    @Override
    public String toString() {
        return "Menu{" +
                "commands=" + commands +
                '}';
    }
}
