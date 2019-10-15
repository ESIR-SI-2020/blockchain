package utils;

import models.events.EventSample;

import java.io.*;
import java.security.MessageDigest;

public class EventUtil {
    //encryption d'un événement
    public static String applySha256(String input){
        try {
            MessageDigest digest = MessageDigest.getInstance("SHA-256");
            //appliquer SHA256 sur l'evenement
            byte[] hash = digest.digest(input.getBytes("UTF-8"));
            StringBuffer hexString = new StringBuffer(); // This will contain hash as hexidecimal
            for (int i = 0; i < hash.length; i++) {
                String hex = Integer.toHexString(0xff & hash[i]);
                if(hex.length() == 1) hexString.append('0');
                hexString.append(hex);
            }
            return hexString.toString();
        }
        catch(Exception e) {
            throw new RuntimeException(e);
        }
    }

    /*public static byte[] eventToBytes(EventSample input) {

        ByteArrayOutputStream bos = new ByteArrayOutputStream();
        ObjectOutput out = null;
        try {
            out = new ObjectOutputStream(bos);
            out.writeObject(input);
            out.flush();
            byte[] yourBytes = bos.toByteArray();
            bos.close();
            return yourBytes;
        } catch (IOException ex) {
            ex.printStackTrace();
            return null;
        }
    }

    public static EventSample bytesToEvent(byte[] input) {

        ByteArrayInputStream bis = new ByteArrayInputStream(input);
        ObjectInput in = null;
        try {
            in = new ObjectInputStream(bis);
            Object o = in.readObject();

            if (in != null) {
                in.close();
            }
            return (EventSample)o;
        } catch (IOException e)  {
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
        return null;
    }*/
}