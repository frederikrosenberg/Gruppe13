/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package common;

import javafx.scene.input.MouseEvent;

/**
 *
 * @author Sebas
 */
public interface Idleable {

    public void resetIdle(MouseEvent event);

    public void logout(boolean timeOut);

}
