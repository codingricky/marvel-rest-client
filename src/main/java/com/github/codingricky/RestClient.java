package com.github.codingricky;

import java.io.IOException;
import java.security.NoSuchAlgorithmException;

import org.apache.commons.codec.digest.DigestUtils;
import us.monoid.web.Resty;

public class RestClient {
    public static void main(String[] args) throws NoSuchAlgorithmException, IOException {
        String publicKey = args[0];
        String privateKey = args[1];
        long timeStamp = System.currentTimeMillis();
        int limit = 5;

        String stringToHash = timeStamp + privateKey + publicKey;
        String hash = DigestUtils.md5Hex(stringToHash);

        String url = String.format("http://gateway.marvel.com/v1/public/characters?timeStamp=%i&apikey=%s&hash=%s&limit=%i", timeStamp, publicKey, hash, limit);
        String output = new Resty().text(url).toString();
        System.out.println(output);
    }
}
