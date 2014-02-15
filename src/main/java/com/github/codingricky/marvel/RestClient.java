package com.github.codingricky.marvel;

import java.io.IOException;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.codingricky.marvel.model.Comic;
import com.github.codingricky.marvel.model.Event;
import com.github.codingricky.marvel.model.MarvelCharacter;
import com.github.codingricky.marvel.model.Result;
import com.github.codingricky.marvel.model.Story;
import us.monoid.web.Resty;

public class RestClient {

    private final URLFactory urlFactory;

    public RestClient(String privateKey, String publicKey) {
        this.urlFactory = new URLFactory(privateKey, publicKey);
    }

    public Result<Comic> getCharactersComics(int characterId) throws IOException {
        final String result = new Resty().text(urlFactory.getCharactersComicsURL(characterId)).toString();
        return convertToResult(Comic.class, result);
    }

    public Result<Event> getCharactersEvents(int characterId) throws IOException {
        final String result = new Resty().text(urlFactory.getCharactersEventURL(characterId)).toString();
        return convertToResult(Event.class, result);
    }

    public Result<Story> getCharactersStories(int characterId) throws IOException {
        final String result = new Resty().text(urlFactory.getCharactersStoriesURL(characterId)).toString();
        return convertToResult(Story.class, result);
    }

    public Result<MarvelCharacter> getCharacters(Parameters parameters) throws IOException {
        final String result = new Resty().text(urlFactory.getCharactersURL(parameters)).toString();
        return convertToResult(MarvelCharacter.class, result);
    }

    public Result<MarvelCharacter> getCharacter(int characterId) throws IOException {
        final String result = new Resty().text(urlFactory.getCharacterURL(characterId)).toString();
        return convertToResult(MarvelCharacter.class, result);
    }

    private <T> Result<T> convertToResult(Class clazz, String result) throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        JavaType javaType = objectMapper.getTypeFactory().constructParametricType(Result.class, clazz);
        return objectMapper.readValue(result, javaType);
    }
}
