package com.github.codingricky.marvel;

import org.apache.commons.codec.digest.DigestUtils;

public class URLFactory {

    private static final String BASE_URL = "http://gateway.marvel.com/v1/public/";

    private final String publicKey;
    private final String privateKey;

    public URLFactory(String privateKey, String publicKey) {
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }

    public String getCharactersURL(int limit) {
        long timeStamp = System.currentTimeMillis();
        String hash = createHash(timeStamp);
        return String.format("%scharacters?ts=%d&apikey=%s&hash=%s&limit=%d", BASE_URL, timeStamp, publicKey, hash, limit);
    }

    public String getCharacterURL(int characterId) {
        long timeStamp = System.currentTimeMillis();
        String hash = createHash(timeStamp);
        return String.format("%scharacters/%d?ts=%d&apikey=%s&hash=%s", BASE_URL, characterId, timeStamp, publicKey, hash);
    }

    private String createHash(long timeStamp) {
        String stringToHash = timeStamp + privateKey + publicKey;
        return DigestUtils.md5Hex(stringToHash);
    }
}
