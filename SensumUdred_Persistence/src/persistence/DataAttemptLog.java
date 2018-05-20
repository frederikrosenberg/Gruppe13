/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package persistence;

import common.ILoginAttemptLog;
import common.LogType;
import java.util.Date;

/**
 *
 * @author Frederik Rosenberg
 */
public class DataAttemptLog extends DataLog implements ILoginAttemptLog {
    
    private String username;
    
    
    public DataAttemptLog(LogType type, Date date, String username) {
        super(type, date, null);
        this.username = username;
    }

    @Override
    public String getUsername() {
        return username;
    }
    
}
