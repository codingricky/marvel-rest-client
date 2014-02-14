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
        UrlBuilder urlBuilder = UrlBuilder.fromString(BASE_URL + "characters/" + characterId);
        return addAuthorisationParameters(urlBuilder).toString();
    }

    public String getCharacterComicsURL(int characterId) {
        UrlBuilder urlBuilder = UrlBuilder.fromString(BASE_URL + "characters/" + characterId + "/comics");
        urlBuilder = addAuthorisationParameters(urlBuilder);
        return urlBuilder.toString();
    }

    public String getCharactersURL(Parameters parameters) {
        UrlBuilder urlBuilder = UrlBuilder.fromString(BASE_URL + "characters");
        long timeStamp = System.currentTimeMillis();
        urlBuilder = parameters.addParameters(urlBuilder).addParameter("ts", String.valueOf(timeStamp))
                .addParameter("apikey", publicKey)
                .addParameter("hash", createHash(timeStamp));
        System.out.println(urlBuilder.toString());
        return urlBuilder.toString();
    }

    private UrlBuilder addAuthorisationParameters(UrlBuilder urlBuilder) {
        long timeStamp = System.currentTimeMillis();
        return urlBuilder.addParameter("ts", String.valueOf(timeStamp))
                .addParameter("apikey", publicKey)
                .addParameter("hash", createHash(timeStamp));
    }

    private String createHash(long timeStamp) {
        String stringToHash = timeStamp + privateKey + publicKey;
        return DigestUtils.md5Hex(stringToHash);
    }

}
