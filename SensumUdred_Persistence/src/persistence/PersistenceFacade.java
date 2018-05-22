package persistence;

import common.ICase;
import common.ICaseLog;
import common.ICaseWorker;
import common.ICitizen;
import common.IDepartment;
import common.ILog;
import common.ILoginAttemptLog;
import common.IPersistenceFacade;
import common.IPerson;
import common.IUser;
import common.LogType;
import common.Role;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * The facade the that business layer communicate with.
 * 
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg 
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public class PersistenceFacade implements IPersistenceFacade {
    
    /**
     * The URL for the server
     */
    private final String dbServer;
    
    /**
     * The username to login to the database
     */
    private final String dbUserName;
    
    /**
     * The password to login to the database
     */
    private final String dbPassword;
    
    /**
     * 
     * @throws FileNotFoundException
     * @throws IOException 
     */
    public PersistenceFacade() throws FileNotFoundException, IOException {
        File credentials = new File("credentials.txt");
        
        Scanner s = new Scanner(credentials);
        
        List<String> lines = new ArrayList<>();
        
        while (s.hasNextLine()) {
            lines.add(s.nextLine());
        }
        
        if (lines.size() == 4) {
            dbUserName = lines.get(0);
            dbPassword = lines.get(1);
            String urlPort = lines.get(2);
            String db = lines.get(3);
            dbServer = "jdbc:postgresql://" + urlPort + "/" + db + "?ssl";
        } else {
            throw new java.io.IOException("File is not of correct format!\nNeeds to be four lines with username on the first line, password on the second line, server url + port on the thrid line and database bane on the fourh line");
        }
    }
    
    /**
     * Creates a connection to the database
     * @return a connection for the database
     * @throws SQLException when the driver has determined that the timeout value specified by the setLoginTimeout method has been exceeded and has at least tried to cancel the current database connection attempt
     */
    private Connection getDbConnection() throws SQLException {
        return DriverManager.getConnection(dbServer, dbUserName, dbPassword);
    }
    
     /**
     * Adds a user from a IUser and give the id from the database
     * @param user the given user
     * @return the id from the database
     */
    @Override
    public String addUser(IUser user) {
        //INSERT INTO "User" (Id, Username, Password, Active, Role, Name) VALUES (?,?,?,?,?,?) RETURNING Id
        
        try (Connection con = getDbConnection()) {
            PreparedStatement statement = con.prepareStatement("INSERT INTO \"User\" (Id, Username, Password, Active, Role, Name) VALUES (?,?,?,?,?,?) RETURNING Id");
            statement.setString(1, user.getUserId());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getPassword());
            statement.setBoolean(4, user.getActive());
            statement.setInt(5, user.getRole().ordinal());
            statement.setString(6, user.getName());
            ResultSet set = statement.executeQuery();
            set.next();
            return set.getString(1);
        } catch (SQLException ex) {
            Logger.getLogger(PersistenceFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    
    /**
     * Adds a case from a ICase and returns the id
     * @param _case the given case
     * @return the id from the database
     */
    @Override
    public int addCase(ICase _case) {
        //INSERT INTO "Case" (DepartmentName, CaseWorkerId, CitizenId, State, Consent, Reason, AvailableOffers, SourceOfRequest) VALUES (?,?,?,?,?,?,?,?) RETURNING Id
        
        try (Connection con = getDbConnection()) {
            PreparedStatement statement = con.prepareStatement("INSERT INTO \"Case\" (DepartmentName, CaseWorkerId, CitizenId, State, Consent, Reason, AvailableOffers, SourceOfRequest) VALUES (?,?,?,?,?,?,?,?) RETURNING Id");
            statement.setString(1, _case.getDepartment().getName());
            statement.setInt(2, _case.getCaseWorker().getId());
            statement.setInt(3, _case.getCitizen().getId());
            statement.setString(4, _case.getState());
            statement.setBoolean(5, _case.getConsent());
            statement.setString(6, _case.getReason());
            statement.setString(7, _case.getAvailableOffers());
            statement.setString(8, _case.getSourceOfRequest());
            ResultSet set = statement.executeQuery();
            set.next();
            return set.getInt(1);
        } catch (SQLException ex) {
            Logger.getLogger(PersistenceFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return -1;
    }
    
    
    /**
     * Adds a case worker from ICaseWorker and returns the id
     * Does not add
     * @param caseWorker the given case worker
     * @return the id from the database
     */
    @Override
    public int addCaseWorker(ICaseWorker caseWorker) {
        //INSERT INTO "Person" (DepartmentName, Email, PhoneNumber, Name) VALUES (?,?,?,?) RETURNING Id
        //INSERT INTO "CaseWorker" (Id, DepartmentName, UserId, EmployeeId) VALUES (Id,DepartmentName,?,?)
        
        try (Connection con = getDbConnection()) {
            int id = insertPerson(con, caseWorker);
            
            PreparedStatement statement = con.prepareStatement("INSERT INTO \"CaseWorker\" (Id, DepartmentName, UserId, EmployeeId) VALUES (?,?,?,?)");
            statement.setInt(1, id);
            statement.setString(2, caseWorker.getDepartmentName());
            statement.setString(3, caseWorker.getUserId());
            statement.setInt(4, caseWorker.getEmployeeId());
            statement.execute();
            
            return id;
        } catch (SQLException ex) {
            Logger.getLogger(PersistenceFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return -1;
    }
    
    
    private int insertPerson(Connection con, IPerson person) throws SQLException {
        //INSERT INTO "Person" (DepartmentName, Email, PhoneNumber, Name) VALUES (?,?,?,?) RETURNING Id
        
        PreparedStatement statement = con.prepareStatement("INSERT INTO \"Person\" (DepartmentName, Email, PhoneNumber, Name) VALUES (?,?,?,?) RETURNING Id");
        statement.setString(1, person.getDepartmentName());
        statement.setString(2, person.getEmail());
        statement.setString(3, person.getPhoneNumber());
        statement.setString(4, person.getPhoneNumber());
        ResultSet set = statement.executeQuery();
        return set.getInt(1);
    }

    /**
     * Adds a department from IDepartment and returns the id.
     * This does not add case workers, citizen or cases
     * @param department the given department
     * @return the id from the database
     */
    @Override
    public String addDeparment(IDepartment department) {
        //INSERT INTO "Department" (Name, Email, TreatmentArea, Address, PhoneNumber) VALUES (?,?,?,?,?) RETURNING Name
        
        try (Connection con = getDbConnection()) {
            PreparedStatement statement = con.prepareStatement("INSERT INTO \"Department\" (Name, Email, TreatmentArea, Address, PhoneNumber) VALUES (?,?,?,?,?) RETURNING Name");
            statement.setString(1, department.getName());
            statement.setString(2, department.getEmail());
            statement.setString(3, department.getTreatmentArea());
            statement.setString(4, department.getAddress());
            statement.setString(5, department.getPhoneNumber());
            ResultSet set = statement.executeQuery();
            set.next();
            return set.getString(1);
            
            
        } catch (SQLException ex) {
            Logger.getLogger(PersistenceFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    /**
     * Adds a citizen from ICitizen and returns the id
     * This does not add cases the citizen has
     * @param citizen the given citizen
     * @return the id from the database
     */
    @Override
    public int addCitizen(ICitizen citizen) {
        //INSERT INTO "Person" (DepartmentName, Email, PhoneNumber, Name) VALUES (?,?,?,?) RETURNING Id
        //INSERT INTO "Citizen" (Id, DepartmentName, Cpr, Gender, Address, relationshipStatus) VALUES (Id, DepartmentName,?,?,?,?)
        
        try (Connection con = getDbConnection()) {
            int id = insertPerson(con, citizen);
            
            PreparedStatement statement = con.prepareStatement("INSERT INTO \"Citizen\" (Id, DepartmentName, Cpr, Gender, Address, relationshipStatus) VALUES (Id, DepartmentName,?,?,?,?)");
            statement.setInt(1, id);
            statement.setString(2, citizen.getDepartmentName());
            statement.setString(3, citizen.getCpr());
            statement.setInt(4, citizen.getGender().ordinal());
            statement.setString(5, citizen.getAddress());
            statement.setInt(6, citizen.getRelationshipStatus().ordinal());
            statement.execute();
            
            return id;
        } catch (SQLException ex) {
            Logger.getLogger(PersistenceFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return -1;
    }

    /**
     * Adds a standard log from ILog and returns the id
     * @param log the given log
     * @return the id from the database
     */
    @Override
    public int addLog(ILog log) {
        //INSERT INTO "Log" (UserID, Type, DateTime) VALUES (?,?,?) RETURNING Id
        try(Connection con = getDbConnection()) {
            return insertLog(con, log);
        } catch (SQLException ex) {
            Logger.getLogger(PersistenceFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        return -1;
    }
    
    /**
     * Inserts a log into the database
     * @param con the connection to use
     * @param log the log to insert
     * @return the id of the log
     * @throws SQLException if a database access error occurs or this method is called on a closed connection
     */
    private int insertLog(Connection con, ILog log) throws SQLException {
        PreparedStatement statement = con.prepareStatement("INSERT INTO \"Log\" (UserID, Type, DateTime) VALUES (?,?,?) RETURNING Id");
        statement.setString(1, log.getUserId());
        statement.setInt(2, log.getLogType().ordinal());
        statement.setTimestamp(3, new Timestamp(log.getDate().getTime()));
        ResultSet set = statement.executeQuery();
        set.next();
        return set.getInt(1);
    }

    /**
     * Adds a attempt log from IAttemptLog and returns the id
     * @param log the given log
     * @return the id from the database
     */
    @Override
    public int addAttemptLog(ILoginAttemptLog log) {
        //INSERT INTO "Log" (UserID, Type, DateTime) VALUES (null,?,?) RETURNING Id
        //INSERT INTO "AttemptLog" (Id, UserName) VALUES (Id,?)
        
        try(Connection con = getDbConnection()) {
            int id = insertLog(con, log);
            if (id == -1) return -1;
            
            PreparedStatement statement = con.prepareStatement("INSERT INTO \"AttemptLog\" (Id, UserName) VALUES (?,?)");
            statement.setInt(1, id);
            statement.setString(2, log.getUsername());
            statement.execute();
            return id;
        } catch (SQLException ex) {
            Logger.getLogger(PersistenceFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return -1;
    }

     /**
     * Adds a case log from ICaseLog and returns the id
     * @param log the given log
     * @return the id from the database
     */
    @Override
    public int addCaseLog(ICaseLog log) {
        //INSERT INTO "Log" (UserID, Type, DateTime) VALUES (null,?,?) RETURNING Id
        //INSERT INTO "CaseLog" (Id, CaseId, CaseDepartmentName) VALUES (Id,?,?)
        
        try(Connection con = getDbConnection()) {
            int id = insertLog(con, log);
            if (id == -1) return -1;
            
            PreparedStatement statement = con.prepareStatement("INSERT INTO \"CaseLog\" (Id, CaseId, CaseDepartmentName) VALUES (?,?,?)");
            statement.setInt(1, id);
            statement.setInt(2, log.getCaseId());
            statement.setString(3, "Department"); //TODO get from log. Right now it is not added!
            statement.execute();
            return id;
        } catch (SQLException ex) {
            Logger.getLogger(PersistenceFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        
        
        return -1;
    }

    /**
     * Get all the logs from the database
     * @return the logs
     */
    @Override
    public List<? extends ILog> getLogs() {
        List<DataLog> logs = new ArrayList<>();
        
        try (Connection con = getDbConnection()) {
            PreparedStatement statement = con.prepareStatement("SELECT L.Id, L.UserId, L.Type, L.DateTime, A.UserName, C.CaseId, C.CaseDepartmentName FROM \"Log\" AS L LEFT JOIN \"AttemptLog\" AS A ON A.Id = L.Id LEFT JOIN \"CaseLog\" AS C ON C.Id = L.Id");
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                logs.add(getLogFromResultSet(set));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersistenceFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return logs;
    }

    /**
     * Get all the logs with at given type
     * @param type the type of log
     * @return the logs of that type
     */
    @Override
    public List<? extends ILog> getLogsOfType(LogType type) {
        List<DataLog> logs = new ArrayList<>();
        
        try (Connection con = getDbConnection()) {
            PreparedStatement statement = con.prepareStatement("SELECT L.Id, L.UserId, L.Type, L.DateTime, A.UserName, C.CaseId, C.CaseDepartmentName FROM \"Log\" AS L LEFT JOIN \"AttemptLog\" AS A ON A.Id = L.Id LEFT JOIN \"CaseLog\" AS C ON C.Id = L.Id WHERE L.Type = ?");
            statement.setInt(1, type.ordinal());
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                logs.add(getLogFromResultSet(set));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersistenceFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return logs;
    }
    
    /**
     * Creates a data log from a result from the database
     * @param set the given result set from the database
     * @return the data log created from the result set
     * @throws SQLException if a database access error occurs or this method is called on a closed result set
     */
    private DataLog getLogFromResultSet(ResultSet set) throws SQLException {
        LogType type = LogType.values()[set.getInt("type")];
        Date date = new Date(set.getTimestamp("datetime").getTime());
        String userId = set.getString("userid");
        switch (type) {
            case CASE_VIEWED:
            case OPEN_CASE:
            case CLOSE_CASE:
                return new DataCaseLog(type, date, userId, set.getInt("caseid"));
            case VIEW_LOG:
            case LOGIN:
            case LOGOUT:
            case TIMEOUT:
            case VIEW_ALL_CASES:
            case VIEW_CASEWORKERS_CASES:
                return new DataLog(type, date, userId);
            case ATTEMPT_LOGIN:
                return new DataAttemptLog(type, date, set.getString("username"));
            default:
                throw new AssertionError(type.name());   
        }
    }

    /**
     * Get a specific user
     * @param userId the id of the user
     * @return the given user or null if the user does not exist
     */
    @Override
    public IUser getUser(String userId) {
        //SELECT * FROM "User" WHERE "User".Id = ?
   
        
        try(Connection con = getDbConnection()) {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM \"User\" WHERE \"User\".Id = ?");
            statement.setString(1, userId);
            ResultSet set = statement.executeQuery();
            set.next();
            return getUserFromResultSet(set);
        } catch (SQLException ex) {
            Logger.getLogger(PersistenceFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    /**
     * Get all the users
     * @return all the users
     */
    @Override
    public List<? extends IUser> getUsers() {
        //SELECT * FROM "User"
        List<DataUser> users = new ArrayList<>();
        
        try (Connection con = getDbConnection()) {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM \"User\"");
            ResultSet set = statement.executeQuery();
            while (set.next()) {
                users.add(getUserFromResultSet(set));
            }
        } catch (SQLException ex) {
            Logger.getLogger(PersistenceFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return users;
        
    }
    
    /**
     * Creates a data user from a result from the database
     * @param set the given result set
     * @return the data user created
     * @throws SQLException if a database access error occurs or this method is called on a closed result set
     */
    private DataUser getUserFromResultSet(ResultSet set) throws SQLException {
        return new DataUser(
                Role.values()[set.getInt("role")],
                set.getString("username"),
                set.getString("userid"),
                set.getString("password"),
                set.getString("name"),
                set.getBoolean("active")
        );
    }

    /**
     * Get a specific department
     * @param id the given id
     * @return the specific department or null if the department does not exist
     */
    @Override
    public IDepartment getDepartment(String id) {
        //SELECT * FROM "Department" WHERE "Department".Name = ?
        try (Connection con = getDbConnection()) {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM \"Department\" WHERE \"Department\".Name = ?");
            statement.setString(1, id);
            ResultSet set = statement.executeQuery();
            set.next();
            return new DataDepartment(
                    set.getString("name"), 
                    set.getString("treatmentarea"), 
                    set.getString("address"), 
                    set.getString("email"), 
                    set.getString("phonenumber")
            );
        } catch (SQLException ex) {
            Logger.getLogger(PersistenceFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }

    /**
     * Gets a specific case from a citizen cpr
     * @param name The citizen cpr
     * @return A specific case from a citizen cpr
     */
    @Override
    public ICase getCase(String department, int caseId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

     
    @Override
    public ICase getCase(String department, String cpr) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Gets all inactive cases from a department
     * @param departmentName The department name
     * @return All inactice cases from a department
     */
    @Override
    public List<ICase> getAllCases(String departmentName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public List<ICase> getAllInactiveCases(String departmentName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Get all the cases belonging to that case worker
     * @param caseWorkerId the id of the case worker
     * @return the cases for the case worker, empty if the case worker does not exist
     */
    @Override
    public List<ICase> getCaseWorkersCases(String department, int caseWorkerId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    
    @Override
    public ICitizen getCitizen(String department, int id) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    /**
     * Get all the citizens from a department
     * @param departmentName The department name
     * @return all the citizens 
     */
    @Override
    public List<ICitizen> getCitizens(String departmentName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Closes a case
     * @param departmentName
     * @param caseId The case to close
     * @return True if the case is closed
     */
    @Override
    public boolean closeCase(String departmentName, int caseId) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Gets all the caseworkers from a department
     * @param departmentName Which department to get from
     * @return All the caseworkers from a department
     */
    @Override
    public List<ICaseWorker> getCaseworkers(String departmentName) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    /**
     * Gets a caseworker
     * @param departmentName The department name
     * @param userId The caseworkers user id
     * @return A caseworker
     */
    @Override
    public ICaseWorker getCaseworker(String departmentName, String userId) {
        //SELECT * FROM "CaseWorker" AS C INNER JOIN "Person" AS P ON C.Id = P.Id AND C.DepartmentName = P.DepartmentName WHERE C.Id = ? AND C.DepartmentName = ?
        
        try (Connection con = getDbConnection()) {
            PreparedStatement statement = con.prepareStatement("SELECT * FROM \"CaseWorker\" AS C INNER JOIN \"Person\" AS P ON C.Id = P.Id AND C.DepartmentName = P.DepartmentName WHERE C.Id = ? AND C.DepartmentName = ?");
            statement.setInt(1, id);
            statement.setString(2, departmentName);
            
        } catch (SQLException ex) {
            Logger.getLogger(PersistenceFacade.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    
}
