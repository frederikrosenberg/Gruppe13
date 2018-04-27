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
public interface IDepartment {
    String getName();
    String getTreatmentArea();
    String getAddress();
    String getEmail();
    String getPhoneNumber();
    List<? extends ICase> getInactiveCases();
    List<? extends ICitizen> getCitizens();
    List<? extends ICase> getAllActiveCases();
    List<? extends ICaseWorker> getCaseWorkers();
}
