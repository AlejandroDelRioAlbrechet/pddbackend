/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.entities.user;

/**
 *
 * @author AliekhandroDelRio
 */
public final class User {

    /**
     * First name of a user
     */
    private int index;
    private String firstName;
    private String lastName;
    private String email;
    private String password;

    /**
     * Default constructor
     */
    public User() {
        setEmail("");
        setFirstName("");
        setLastName("");
        setPassword("");
    }

    /**
     * Constructor?
     *
     * @param email
     * @param password
     * @param firstName
     * @param lastName
     */
    public User(int index, String email, String password, String firstName, String lastName) {
        setIndex(index);
        setEmail(email);
        setPassword(password);
        setFirstName(firstName);
        setLastName(lastName);
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Override
    public String toString() {
        return "User{" + "index=" + index + ", firstName=" + firstName + ", lastName=" + lastName + ", email=" + email + ", password=" + password + '}';
    }
}
