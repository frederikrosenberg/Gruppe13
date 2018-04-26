package business.logic;

import common.IPerson;

/**
 *
 * @author andreasmolgaard-andersen
 */
public class Person implements IPerson{

    private String name;
    private int mobilNumber;
    private String email;

    public Person(String name, int mobilNumber, String email) {
        this.name = name;
        this.mobilNumber = mobilNumber;
        this.email = email;
    }
    
    @Override
    public String getName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int getMobileNumber() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String getEmail() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
