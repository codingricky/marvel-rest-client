package com.github.codingricky.marvel;

import gumi.builders.UrlBuilder;
import org.apache.commons.codec.digest.DigestUtils;

public class URLFactory {

    private static final String BASE_URL = "http://gateway.marvel.com/v1/public/";

    private final String publicKey;
    private final String privateKey;

    public URLFactory(String privateKey, String publicKey) {
        this.privateKey = privateKey;
        this.publicKey = publicKey;
    }

    public String getCharacterURL(int characterId) {
        long timeStamp = System.currentTimeMillis();
        String hash = createHash(timeStamp);
        return String.format("%scharacters/%d?ts=%d&apikey=%s&hash=%s", BASE_URL, characterId, timeStamp, publicKey, hash);
    }

    public String getCharacterComicsURL(int characterId) {
        long timeStamp = System.currentTimeMillis();
        String hash = createHash(timeStamp);
        return String.format("%scharacters/%d/comics?ts=%d&apikey=%s&hash=%s", BASE_URL, characterId, timeStamp, publicKey, hash);
    }

    private String createHash(long timeStamp) {
        String stringToHash = timeStamp + privateKey + publicKey;
        return DigestUtils.md5Hex(stringToHash);
    }

    public String getCharactersURL(Parameters parameters) {
        UrlBuilder urlBuilder = UrlBuilder.fromString(BASE_URL + "characters");
        long timeStamp = System.currentTimeMillis();
        urlBuilder = parameters.addParameters(urlBuilder).addParameter("ts", String.valueOf(timeStamp))
                .addParameter("apikey", publicKey)
                .addParameter("hash", createHash(timeStamp));
        return urlBuilder.toString();
    }
}
