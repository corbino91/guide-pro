package com.bingo.guidepro.model;


public class Hunter {
    private String guid;
    private String firstName;
    private char middleInitial;
    private String lastName;
    private String cin;
    private String email;
    private String cellNumber;
    private String dayNumber;
    private String userName;
    private String password;
    private String address;

    public Hunter(String firstName) {
        this.firstName = firstName;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
}
