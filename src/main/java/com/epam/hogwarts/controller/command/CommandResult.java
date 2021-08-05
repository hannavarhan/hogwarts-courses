package com.epam.hogwarts.controller.command;

public class CommandResult {

    public enum RoutingType {
        FORWARD, REDIRECT
    }

    private RoutingType routingType;
    private String page;

    public CommandResult(String page, RoutingType routingType) {
        this.page = page;
        this.routingType = routingType;
    }

    public RoutingType getRoutingType() {
        return routingType;
    }

    public String getPage() {
        return page;
    }

}
