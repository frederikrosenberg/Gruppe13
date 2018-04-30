/*
 * Lars Bjerregaard Jørgensen (larjo17)
 * Software Engineering at SDU
 * larjo17@student.sdu.dk
 */
package business.logic;

import business.common.ILogicFacade;
import common.ICase;
import common.ICitizenData;
import java.util.List;

/**
 *
 * @author larsjorgensen
 */
public class LogicFacade implements ILogicFacade {
    
    private Department department;
    private CaseWorker caseWorker;

    @Override
    public ICase openCase(ICitizenData citizenData) {
        return caseWorker.openCase(citizenData);
    }

    @Override
    public boolean closeCase(int caseId) {
        return caseWorker.closeCase(caseId);
    }

    @Override
    public ICase findActiveCase(int value, boolean isCpr) {
        return department.findActiveCase(value, isCpr);
    }

    @Override
    public ICase findActiveCase(String name) {
        return department.findActiveCase(name);
    }

    @Override
    public List<? extends ICase> getAllActiveCases() {
        return department.getAllActiveCases();
    }

    @Override
    public List<? extends ICase> getActiveCases() {
       return caseWorker.getActiveCases();
    }
    
}
