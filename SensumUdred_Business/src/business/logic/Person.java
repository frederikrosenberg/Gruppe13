package business.logic;

import common.IPerson;

/**
 *
 * @author andreasmolgaard-andersen
 */
public class Person implements IPerson{

    private String name;
    private int mobileNumber;
    private String email;

    public Person(String name, int mobileNumber, String email) {
        this.name = name;
        this.mobileNumber = mobileNumber;
        this.email = email;
    }
    
    @Override
    public String getName() {
        return this.name;
    }

    @Override
    public int getMobileNumber() {
        return this.mobileNumber;
    }

    @Override
    public String getEmail() {
        return this.email;
    }
    
}
