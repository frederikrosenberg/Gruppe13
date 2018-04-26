package business.logic;

import common.ICase;
import common.ICaseWorker;
import common.ICitizenData;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 *
 * @author andreasmolgaard-andersen
 */
public class CaseWorker extends Person implements ICaseWorker{

    /**
     * 
     */
    private Department department;
    
    /**
     * 
     */
    private int employeeId;
    
    /**
     * 
     */
    private String userId;
    
    /**
     * 
     */
    private Case[] cases;
    
    /**
     * 
     * @param name
     * @param phoneNumber
     * @param email 
     * @param department 
     * @param employeeId 
     * @param userId 
     */
    public CaseWorker(String name, String phoneNumber, String email, Department department, int employeeId, String userId) {
        super(name, phoneNumber, email);
        this.department = department;
        this.employeeId = employeeId;
        this.userId = userId;
    }
    
    /**
     *
     * @param caseWorker
     * @param department
     */
    public CaseWorker(ICaseWorker caseWorker, Department department) {
        super(caseWorker.getName(), caseWorker.getPhoneNumber(), caseWorker.getEmail());
        this.employeeId = caseWorker.getEmployeeId();
        this.userId = caseWorker.getUserId();
        this.department = department;
    }

    /**
     * 
     * @param data
     * @return 
     */
    public Case openCase(ICitizenData data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * 
     * @param caseId
     * @return 
     */
    public boolean closeCase(int caseId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * 
     * @param data
     * @return 
     */
    public boolean editCase(ICitizenData data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * 
     * @return 
     */
    public boolean saveCase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * 
     * @param c
     * @return 
     */
    public boolean editCase(ICase c) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    } 
    
    /**
     * 
     * @return 
     */
    public List<? extends ICase> getActiveCases() {
        return Arrays.asList(cases);
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public int getEmployeeId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * 
     * @return 
     */
    @Override
    public String getUserId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
