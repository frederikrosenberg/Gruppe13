package business.logic;

import common.IPerson;

/**
 *
 * @author andreasmolgaard-andersen
 */
public class Person implements IPerson{

    private String name;
    private String phoneNumber;
    private String email;

    public Person(String name, String phoneNumber, String email) {
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.email = email;
    }
    
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    @Override
    public String getEmail() {
        return this.email;
    }
    
}
