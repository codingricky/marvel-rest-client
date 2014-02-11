package com.github.codingricky;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.digest.DigestUtils;
import us.monoid.web.JSONResource;
import us.monoid.web.Resty;

public class RestClient {
    public static void main(String[] args) throws NoSuchAlgorithmException {
        try {
            String publicKey = System.getenv("PUBLIC_KEY");
            String privateKey = System.getenv("PRIVATE_KEY");
            String ts = "1";

            String stringToHash = ts + privateKey + publicKey;
            String hash = DigestUtils.md5Hex(stringToHash);

            String url = "http://gateway.marvel.com/v1/public/characters?ts=" + ts + "&apikey=" + publicKey + "&hash=" + hash;
            String output = new Resty().text(url).toString();
            System.out.println(output);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
