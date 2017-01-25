package main.java.com.my.util.test;

import java.net.URLDecoder;
import java.util.Base64;

public class DecoderTest {
    public static void main(String[] args) {
        String a = "";
        String z = "";
        try {
            a = URLDecoder.decode(a, "UTF-8");
            System.out.println("url deconde\n" + a);
            String[] c = a.split("[|]");
            for (String item : c) {
                System.out.println(item);
                z += new String(Base64.getDecoder().decode(item), "UTF-8") + "|";
            }
            z = z.substring(0, z.length() - 1);
            System.out.println("base64 deconde\n" + z);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
