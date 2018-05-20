/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import common.ILog;
import common.LogType;
import java.util.Date;

/**
 *
 * @author Frederik Rosenberg
 */
public class DataLog implements ILog {
    
    private LogType type;
    
    private Date date;
    
    private String userId;
    
    public DataLog(LogType type, Date date, String userId) {
        this.type = type;
        this.date = date;
        this.userId = userId;
    }

    @Override
    public LogType getLogType() {
        return type;
    }

    @Override
    public Date getDate() {
        return date;
    }

    @Override
    public String getUserId() {
        return userId;
    }
    
}
