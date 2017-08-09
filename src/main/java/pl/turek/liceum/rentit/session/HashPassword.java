/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pl.turek.liceum.rentit.session;

import com.google.common.base.Charsets;
import com.google.common.hash.Hashing;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
/**
 *
 * @author miszcz
 */
public class HashPassword {
    public static String hashPassword(String password) throws NoSuchAlgorithmException, UnsupportedEncodingException{
        String output = Hashing.sha256().hashString(password, Charsets.UTF_8).toString();
        System.out.println(output);
        return output;
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
    
    public static void main (String [] args) throws NoSuchAlgorithmException, UnsupportedEncodingException {
        String password = "admin";
        System.out.println(password);
        System.out.println(hashPassword(password));
    }
}
