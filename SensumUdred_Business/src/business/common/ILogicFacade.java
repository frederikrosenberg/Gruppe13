/*
 * Lars Bjerregaard Jørgensen (larjo17)
 * Software Engineering at SDU
 * larjo17@student.sdu.dk
 */
package business.common;

import common.ICase;
import common.ICitizenData;
import java.util.List;



/**
 *
 * @author larsjorgensen
 */
public interface ILogicFacade {
    ICase openCase(ICitizenData citizenData);
    boolean closeCase(int caseId);
    ICase findActiveCase(int value, boolean isCpr);
    ICase findActiveCase(String name);
    List<? extends ICase> getAllActiveCases();
    List<? extends ICase> getActiveCases();
}
