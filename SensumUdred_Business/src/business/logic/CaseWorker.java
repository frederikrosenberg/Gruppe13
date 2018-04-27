package business.logic;

import common.ICase;
import common.ICaseWorker;
import common.ICitizen;
import common.ICitizenData;
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
    private List<Case> cases;
    
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
        List<? extends ICitizen> citizens = department.getCitizens();
        Citizen citizen = null;
        for (ICitizen c : citizens) {
            if(c.getCpr() == data.getCitizen().getCpr()) {
                citizen = (Citizen) c;
            }
        }
        if(citizen == null) {
            citizen = new Citizen(data.getCitizen());
        }
        Case c = new Case(data.getState(), data.getConsent(), data.getReason(), data.getAvailableOffers(), data.getSourceOfRequest(), citizen, this);
        cases.add(c);
        return c;
    }
    
    /**
     * 
     * @param caseId
     * @return 
     */
    public boolean closeCase(int caseId) {
        for (Case aCase : cases) {
            if(aCase.getId() == caseId) {
                aCase.closeCase();
                department.addInactiveCase(aCase);
                cases.remove(aCase);
            }
        }
        return true;
    }
    
    /**
     * 
     * @param data
     * @return 
     */
    public boolean editCase(Case c, ICitizenData data) {
        c.setAvailableOffers(data.getAvailableOffers());
        c.setCaseWorker((CaseWorker)data.getCaseWorker());
        c.setCitizen((Citizen)data.getCitizen());
        c.setConsent(data.getConsent());
        c.setReason(data.getReason());
        c.setSourceOfReqeust(data.getSourceOfRequest());
        c.setState(data.getState());
        return true;
    }
    
    /**
     * Saves the 
     * @return 
     */
    public boolean saveCase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Gets all the active cases
     * @return All the active cases
     */
    public List<? extends ICase> getActiveCases() {
        return cases;
    }
    
    /**
     * 
     * @return 
     */
    @Override
    public int getEmployeeId() {
        return employeeId;
    }

    /**
     * 
     * @return 
     */
    @Override
    public String getUserId() {
        return userId;
    }
    
}
