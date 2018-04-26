package common;

/**
 *
 * @author fsr19
 */
public interface IUser {
    Role getRole();
    String getUsername();
    String getUserId();
    String getPassword();
    String getName();
    boolean getActive();
}
