package business.security;

import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;
import java.security.spec.InvalidKeySpecException;
import java.util.Arrays;
import java.util.Base64;
import java.util.Random;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

/**
 * The class responsible for hashing passwords.
 *
 * @author Andreas Mølgaard-Andersen
 * @author Lars Bjerregaard Jørgensen
 * @author Frederik Rosenberg
 * @author Mikkel Larsen
 * @author Sebastian Christensen
 * @author Kasper Schødts
 */
public class Hasher {

    /**
     * Number of iterations
     */
    private final int ITERATIONS_COUNT = 10000;
    
    /**
     * The size of the hash
     */
    private final int SIZE = 256;
    
    /**
     * Random generator
     */
    private Random random;
    
    /**
     * Constructor for hasher class
     */
    public Hasher() {
        random = new SecureRandom();
    }

    /**
     * Hashes a password with a random salt and returns in string format.
     *
     * @param password is the String that is to be hashed
     * @return hashed version of data
     * 
     */
    public String hash(String password) {
            byte[] salt = getNextSalt();
            System.out.println(Base64.getUrlEncoder().withoutPadding().encodeToString(salt));
            byte[] key = pbkdf2(password.toCharArray(), salt);
            System.out.println(Base64.getUrlEncoder().withoutPadding().encodeToString(key));
            byte[] hash = new byte[salt.length + key.length];
            System.arraycopy(salt, 0, hash, 0, salt.length);
            System.arraycopy(key, 0, hash, salt.length, key.length);
            return Base64.getUrlEncoder().withoutPadding().encodeToString(hash);
    }
    
    /**
     * Check if the hash and the password match
     * @param password to be checked
     * @param hash to be checked against
     * @return if the password matched the hash
     */
    public boolean compare(String password, String hash) {
        byte[] hashBytes = Base64.getUrlDecoder().decode(hash);
        System.out.println(Base64.getUrlEncoder().withoutPadding().encodeToString(hashBytes));
        byte[] salt = Arrays.copyOfRange(hashBytes, 0, SIZE / 8);
        System.out.println(Base64.getUrlEncoder().withoutPadding().encodeToString(salt));
        byte[] check = pbkdf2(password.toCharArray(), salt);
        System.out.println(Base64.getUrlEncoder().withoutPadding().encodeToString(check));
        int zero = 0;
        for (int i = 0; i < check.length; i++) {
            zero |= hashBytes[salt.length + i] ^ check[i];
        }
        return zero == 0;
    }
    
    /**
     * Generates the hash
     * @param password to be hashed
     * @param salt to be used
     * @return byte array with the hashed password
     * @throws IllegalStateException if the algorithm can't be found or the PBEKeySpec is invalid
     */
    private byte[] pbkdf2(char[] password, byte[] salt) {
        PBEKeySpec spec = new PBEKeySpec(password, salt, ITERATIONS_COUNT, SIZE);
        try {
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            return keyFactory.generateSecret(spec).getEncoded();
        } catch (NoSuchAlgorithmException ex) {
            throw new IllegalStateException("No such algorithm");
        } catch (InvalidKeySpecException ex) {
            throw new IllegalStateException("Invaild key spec");
        }
    }
    
    /**
     * Gets a random salt
     * @return the salt in a byte array
     */
    private byte[] getNextSalt() {
        byte[] salt = new byte[SIZE / 8];
        random.nextBytes(salt);
        return salt;
    }
}
