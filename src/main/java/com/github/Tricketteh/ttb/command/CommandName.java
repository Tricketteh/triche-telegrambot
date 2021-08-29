package com.github.Tricketteh.ttb.command;

  /*
  Enumeration for {@link Command}'s.
  */

public enum CommandName {

    START("/start"),
    HELP("/help"),
    NO(" "),
    STOP("/stop");

    private final String CommandName;

    CommandName(String commandName){
        this.CommandName = commandName;
    }

    public String getCommandName(){
        return this.CommandName;
    }







}
