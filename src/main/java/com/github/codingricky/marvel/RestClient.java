package com.github.codingricky.marvel;

import java.io.IOException;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.codingricky.marvel.model.Comic;
import com.github.codingricky.marvel.model.MarvelCharacter;
import com.github.codingricky.marvel.model.Result;
import us.monoid.web.Resty;

public class RestClient {

    private final URLFactory urlFactory;

    public RestClient(String privateKey, String publicKey) {
        this.urlFactory = new URLFactory(privateKey, publicKey);
    }

    public Result<Comic> getCharacterComics(int characterId) throws IOException {
        System.out.println(urlFactory.getCharacterComicsURL(characterId));
        final String result = new Resty().text(urlFactory.getCharacterComicsURL(characterId)).toString();
        final ObjectMapper objectMapper = new ObjectMapper();
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(Result.class, Comic.class);
        return objectMapper.readValue(result, javaType);
    }

    public Result<MarvelCharacter> getCharacters(Parameters parameters) throws IOException {
        final String result = new Resty().text(urlFactory.getCharactersURL(parameters)).toString();
        final ObjectMapper objectMapper = new ObjectMapper();
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(Result.class, MarvelCharacter.class);
        return objectMapper.readValue(result, javaType);
    }

    public Result<MarvelCharacter> getCharacter(int characterId) throws IOException {
        final String result = new Resty().text(urlFactory.getCharacterURL(characterId)).toString();
        final ObjectMapper objectMapper = new ObjectMapper();
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(Result.class, MarvelCharacter.class);
        return objectMapper.readValue(result, javaType);
    }
}
