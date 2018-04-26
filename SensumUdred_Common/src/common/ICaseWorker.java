/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import java.util.List;

/**
 *
 * @author fsr19
 */
public interface ICaseWorker extends IPerson {
    int getEmployeeId();
    String getUserId();
    List<? extends ICase> getActiveCases();
}
