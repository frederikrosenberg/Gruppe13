/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import business.common.ILogicFacade;
import business.common.ISecurityFacade;
import business.logic.LogicFacade;
import business.security.SecurityFacade;
import common.IBusinessFacade;
import common.ICase;
import common.ICaseWorker;
import common.ICitizenData;
import common.IDataObject;
import common.IPersistenceFacade;
import common.Role;
import java.util.List;

/**
 *
 * @author fsr19
 */
public class Business implements IBusinessFacade {

    private ILogicFacade logic;
    
    private ISecurityFacade security;
    
    private IPersistenceFacade persistence;
    
    public Business() {
        
    }
    
    
    
    @Override
    public boolean login(String username, String password) {
        String id = security.logIn(username, password);
        if (id == null) return false;
        if (security.hasAccess(Role.CASEWORKER)) {
            logic.setCaseWorker(id);
        }
        
        return true;
    }

    @Override
    public boolean logOut() {
        if (security.hasAccess(Role.CASEWORKER)) {
            logic.removeCaseWorker();
        }
        security.logOut();
        return true;
    }

    @Override
    public ICase openCase(ICitizenData citizenData) {
        if (security.hasAccess(Role.CASEWORKER)) {
            return logic.openCase(citizenData);
        } 
        return null;
    }

    @Override
    public boolean closeCase(int caseId) {
        if (security.hasAccess(Role.CASEWORKER)) {
            return logic.closeCase(caseId);
        }
        return false;
    }

    @Override
    public void closing() {
        save();
    }

    @Override
    public ICase findActiveCase(int value, boolean isCpr) {
        if (security.hasAccess(Role.CASEWORKER)) {
           return logic.findActiveCase(value, isCpr);
        }
        return null;
    }

    @Override
    public ICase findActiveCase(String name) {
        if (security.hasAccess(Role.CASEWORKER)) {
            return logic.findActiveCase(name);
        }
        return null;
    }

    @Override
    public List<? extends ICase> getAllActiveCases() {
        if (security.hasAccess(Role.CASEWORKER)) {
            return logic.getAllActiveCases();
        }
        return null;
    }

    @Override
    public List<? extends ICase> getActiveCases() {
        if (security.hasAccess(Role.CASEWORKER)) {
            return logic.getActiveCases();
        }
        return null;
    }

    @Override
    public void injectPersistence(IPersistenceFacade persistence) {
        this.persistence = persistence;
    }

    @Override
    public ICaseWorker getCaseWorker() {
        if (security.hasAccess(Role.CASEWORKER)) {
            return logic.getCaseWorker();
        }
        return null;
    }
    
    private void load() {
        if (persistence.saveAvailable()) {
            IDataObject data = persistence.load();
            logic = new LogicFacade(data.getDepartment());
            //security = new SecurityFacade(data.getUserManager());
            
        } else {
            logic = new LogicFacade();
            security = new SecurityFacade();
        }
    }
    
    private boolean save() {
        return persistence.save(security., logic.getDepartment());
    }
    
    
}
