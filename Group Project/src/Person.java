/*
    SWEN 383 - Final Group Project
    Team Name: Machine Code Migos
    Team Members: Blake Wesel, Bryce Jones, Regina Bass, Hansel Leal, Samuel Crouch
    Date Due: April 17
*/


public class Person {
    //class attributes
    private int id;
    private String name;
    private String home_address;
    private String mobile_phone;
    private String email_address;
    private String password;

    //Constructors


    public Person() {
        id = -1;
        name = "";
        home_address = "";
        mobile_phone = "";
        email_address = "";
        password = "";
    }

    public Person(int id, String name, String home_address, String mobile_phone, String email_address, String password) {
        this.id = id;
        this.name = name;
        this.home_address = home_address;
        this.mobile_phone = mobile_phone;
        this.email_address = email_address;
        this.password = password;
    }

    //accesors and mutators

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getHome_address() {
        return home_address;
    }

    public void setHome_address(String home_address) {
        this.home_address = home_address;
    }

    public String getMobile_phone() {
        return mobile_phone;
    }

    public void setMobile_phone(String mobile_phone) {
        this.mobile_phone = mobile_phone;
    }

    public String getEmail_address() {
        return email_address;
    }

    public void setEmail_address(String email_address) {
        this.email_address = email_address;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    /*
-------------------------------------------------------------------------------------------------------------
                        Additional Methods below here
                        -updateInfo();
                        -verify();
    */


}
