/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.turek.liceum.rentit.session;

import java.io.UnsupportedEncodingException;
import java.nio.charset.StandardCharsets;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 *
 * @author miszcz
 */
public class HashPassword {

    public static String hashPassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException {
//        String output = Hashing.sha256().hashString(password, Charsets.UTF_8).toString();
//        System.out.println(output);
//        return output;

//        private String generateSha256(String text) throws NoSuchAlgorithmException {
        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(password.getBytes(StandardCharsets.UTF_8));
        String encoded = Base64.getEncoder().encodeToString(hash); // Java 8 feature
        System.out.println("HashPassword"+encoded);
        return encoded;

//        String text = "abc";
//        MessageDigest digest = MessageDigest.getInstance("SHA-256");
//        byte[] hash = digest.digest(text.getBytes("UTF-8"));
//        byte[] encodedBytes = Base64.encodeBase64("Test".getBytes());
//        System.out.println("encodedBytes " + new String(encodedBytes));

//    }
//        MessageDigest md = MessageDigest.getInstance("SHA-256");
//        md.update(password.getBytes("UTF-8"));
//        byte[] b=md.digest();
////        StringBuilder sb = new StringBuilder();
////        for (byte b1 : b){
////            sb.append(Integer.toHexString(b1));
////        }
//        System.out.println(Base64.encode(b));
//        return b.toString();
    }

    public static void main(String[] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String password = "HBQrLQGqNOmja95IBkWlf9aeFBVdrPq1o/kle3f9yNg=";
        System.out.println(password);
        System.out.println(hashPassword(password));
    }
}
