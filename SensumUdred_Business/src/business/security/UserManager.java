package business.security;

import common.IUser;
import common.IUserManager;
import common.Role;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 *
 * @author Krongrah
 */
public class UserManager implements IUserManager {

    private List<User> users = new ArrayList();

    @Override
    public List<? extends IUser> getUsers() {
        return users;
    }

    public void addUser(String name, String username, String password, Role role) {
        users.add(new User(name, username, password, role, generateId()));

    }

    private String generateId() {
        String userId;
        loop:
        while (true) {
            userId = UUID.randomUUID().toString();
            for (User user : users) {
                if (user.getUserId().equals(userId)) {
                    continue loop;
                }
            }
            break;
        }
        return userId;
    }

}
