/*
 * Lars Bjerregaard Jørgensen (larjo17)
 * Software Engineering at SDU
 * larjo17@student.sdu.dk
 */
package business.logic;

import business.common.ILogicFacade;
import common.ICase;
import common.ICaseWorker;
import common.ICitizenData;
import common.IDepartment;

/**
 *
 * @author larsjorgensen
 */
public class LogicFacade implements ILogicFacade {
    
    private IDepartment department;
    private ICaseWorker caseWorker;

    @Override
    public ICase openCase(ICitizenData citizenData) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean closeCase(int caseId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ICase findActiveCase(int value, boolean isCpr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ICase findActiveCase(String name) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ICase[] getAllActiveCases() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public ICase[] getActiveCases() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
