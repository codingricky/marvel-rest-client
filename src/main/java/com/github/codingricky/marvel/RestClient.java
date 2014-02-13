package com.github.codingricky.marvel;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.codingricky.marvel.model.MarvelCharacter;
import com.github.codingricky.marvel.model.Result;
import us.monoid.web.Resty;

import java.io.IOException;
import java.util.List;

public class RestClient {

    private final URLFactory urlFactory;

    public RestClient(String privateKey, String publicKey) {
        this.urlFactory = new URLFactory(privateKey, publicKey);
    }

    public Result<MarvelCharacter> getCharacters(int limit) throws IOException {
        final String result = new Resty().text(urlFactory.getCharactersURL(limit)).toString();
        final ObjectMapper objectMapper = new ObjectMapper();
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(Result.class, MarvelCharacter.class);
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

    public static void main(String[] args) throws IOException {
        String publicKey = args[0];
        String privateKey = args[1];
        final RestClient restClient = new RestClient(privateKey, publicKey);

        final Result<MarvelCharacter> characters = restClient.getCharacters(new ParameterBuilder().withLimit(5).create());
        System.out.println(characters.toString());
    }
}
