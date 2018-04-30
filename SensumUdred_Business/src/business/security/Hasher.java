package business.security;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * The class responsible for hashing passwords.
 *
 * @author Krongrah
 */
public class Hasher {

    /**
     * is the MessageDigest
     */
    private MessageDigest md;

    /**
     * If MessageDigest found an algorithm the ready is true otherwise it is
     * false
     */
    private boolean ready = false;

    /**
     * Constructor for the Hasher, initializes the messageDigest with the
     * SHA-256 encryption algorithm
     */
    public Hasher() {
        try {
            md = MessageDigest.getInstance("SHA-256");
            ready = true;
        } catch (NoSuchAlgorithmException ex) {
        }
    }

    /**
     * Returns true if the hasher is ready.
     *
     * @return true if the hasher is ready
     */
    public boolean isReady() {
        return ready;
    }

    /**
     * Encrypts a strong and returns it in hex format If the messageDigest is
     * not ready, returns null since it is not able to encrypt.
     *
     * @param data is the String that is to be encrypted
     * @return hashed version of data in hex format
     */
    public String hash(String data) {

        //checks if the messageDigest is ready
        if (!ready) {
            return null;
        }

        //loads the String into the as bytes messageDigest
        md.update(data.getBytes());

        //encrypts the bytes in the messageDigest with SHA-256 hashing algorithm
        byte[] SHA = md.digest();

        //Builds the String to be returned
        StringBuilder stringBuilder = new StringBuilder();

        //loops through the hashed bytes, and turns them into hex
        for (byte bytes : SHA) {
            stringBuilder.append(String.format("%02x", bytes & 0xff));
        }

        //Returns a hex String, built from the hashed bytes
        return stringBuilder.toString();
    }

}
