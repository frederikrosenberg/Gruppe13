/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import common.ICaseLog;
import common.LogType;
import java.util.Date;

/**
 *
 * @author Frederik Rosenberg
 */
public class DataCaseLog extends DataLog implements ICaseLog {

    private int caseId;
    
    
    public DataCaseLog(LogType type, Date date, String userId, int caseId) {
        super(type, date, userId);
        this.caseId = caseId;
    }

    @Override
    public int getCaseId() {
        return caseId;
    }
    
}
