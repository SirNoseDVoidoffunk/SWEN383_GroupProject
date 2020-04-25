/**
 * Person class that's used as the parent class of employee and customer where shared attributes and methods can be
 * declared here
 * @version 4/25/20
 * @author Blake Wesel
 *         Hansel Leal
 *         Bryce Jones
 *         Regina Bass
 *         Samual Crouch
 */


public class Person {
    //class attributes
    private int id;
    private String name;
    private String home_address;
    private String home_phone;
    private String mobile_phone;
    private String email_address;
    private String password;

    //Constructors

    /**
     * Default constructor
     */
    public Person() {
        id = -1;
        name = "";
        home_address = "";
        home_phone = "";
        mobile_phone = "";
        email_address = "";
        password = "";

    }

    /**
     * Full parameterized constructor
     * @param id - Id of the person
     * @param name - Name of the person
     * @param home_address - Home address of the person
     * @param mobile_phone - Mobile Phone of the person
     * @param home_phone - Home Phone of the person
     * @param email_address - Email Address of the person
     * @param password - Password of the person
     */
    public Person(int id, String name, String home_address, String mobile_phone, String home_phone, String email_address, String password) {
        this.id = id;
        this.name = name;
        this.home_address = home_address;
        this.mobile_phone = mobile_phone;
        this.home_phone = home_phone;
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

    public String getHome_phone() {
        return home_phone;
    }

    public void setHome_phone(String home_phone) {
        this.home_phone = home_phone;
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

    /**
     * Validates credentials and returns the success of the validation
     * @param id - ID of the person
     * @param pass - Password
     * @return success - True if the login was successful, false if not
     */
    public boolean verify(int id, String pass) {
        if(this.id == id && pass.equals(this.password)) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Updates the information of the person based on the passed values. The value formats are as follows
     *
     * @param values - Updated information in this order:
     *      String name;
     *      String home_address;
     *      String home_phone;
     *      String mobile_phone;
     *      String email_address;
     *      String password;
     * @return none
     */
    public void updateInfo(String... values) {
        for(int i = 0; i < values.length; i++) {
            // cycles through the information and based on index, updates the corresponding attribute
            if(i == 0)      { this.name          = values[0];}
            else if(i == 1) { this.home_address  = values[1];}
            else if(i == 2) { this.home_phone    = values[2];}
            else if(i == 3) { this.mobile_phone  = values[3];}
            else if(i == 4) { this.email_address = values[4];}
            else if(i == 5) { this.password      = values[5];}
        }
    }


}
