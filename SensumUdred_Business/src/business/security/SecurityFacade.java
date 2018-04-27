/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business.security;

import business.common.ISecurityFacade;

/**
 *The facade of the security Package
 * @author Krongrah
 */
public class SecurityFacade implements ISecurityFacade{

    private SecurityManager security = new SecurityManager();
    private UserManager users = new UserManager();
    
    
    
    
    
}
