package business.logic;

import common.ICase;
import common.ICaseWorker;
import common.ICitizenData;

/**
 *
 * @author andreasmolgaard-andersen
 */
public class CaseWorker extends Person implements ICaseWorker{

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
     * @param mobilNumber
     * @param email 
     */
    public CaseWorker(String name, int mobilNumber, String email) {
        super(name, mobilNumber, email);
    }
    
    /**
     *
     * @param caseWorker
     */
    public CaseWorker(ICaseWorker caseWorker) {
        super(caseWorker.getName(), caseWorker.getMobileNumber(), caseWorker.getEmail());
        
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
    public ICase[] getActiveCases() {
        return cases;
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
