package com.github.codingricky.marvel;

import java.io.IOException;
import java.util.List;

import com.github.codingricky.marvel.model.MarvelCharacter;
import com.github.codingricky.marvel.model.Result;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class RestClientTest {

    public static final int COMIC_ID = 6908;
    private RestClient restClient;

    @Before
    public void before() {
        String publicKey = System.getenv("PUBLIC_KEY");
        if (StringUtils.isBlank(publicKey)) {
            publicKey = System.getProperty("PUBLIC_KEY");
        }
        String privateKey = System.getenv("PRIVATE_KEY");
        if (StringUtils.isBlank(privateKey)) {
            privateKey = System.getProperty("PRIVATE_KEY");
        }

        assertThat(publicKey).isNotEmpty();
        assertThat(privateKey).isNotEmpty();

        restClient = new RestClient(privateKey, publicKey);
    }

    @Test
    public void testGetCharacters() throws IOException {
        Result<MarvelCharacter> characters = restClient.getCharacters(new ParameterBuilder().withLimit(5).create());
        assertThat(characters.getData().getCount()).isEqualTo(5);
    }

    @Test
    public void testGetCharactersWithName() throws IOException {
        Result<MarvelCharacter> characters = restClient.getCharacters(new ParameterBuilder().withName("Black Widow").create());
        assertThat(characters.getData().getTotal()).isEqualTo(1);
        assertThat(characters.getData().getResults().get(0).getName()).isEqualTo("Black Widow");
    }

    @Test
    public void testGetCharactersWithComics() throws IOException {
        Result<MarvelCharacter> characters = restClient.getCharacters(new ParameterBuilder().withComics(COMIC_ID).orderBy("name").create());
        assertThat(characters.getData().getCount()).isEqualTo(2);
        final List<MarvelCharacter> results = characters.getData().getResults();

        assertThat(results.get(0).getName()).isEqualTo("Black Widow");
        assertThat(results.get(1).getName()).isEqualTo("Spider-Man");
    }

    @Test
    public void testGetCharactersOrderBy() throws IOException {
        Result<MarvelCharacter> characters = restClient.getCharacters(new ParameterBuilder().withComics(COMIC_ID).orderBy("-name").orderBy("modified").create());
        final List<MarvelCharacter> results = characters.getData().getResults();

        assertThat(results.get(0).getName()).isEqualTo("Spider-Man");
        assertThat(results.get(1).getName()).isEqualTo("Black Widow");
    }

    @Test
    public void testGetCharacter() throws IOException {
        Result<MarvelCharacter> character = restClient.getCharacter(1009521);
        assertThat(character.getData().getResults().get(0).getName().trim()).isEqualTo("Hank Pym");
    }
}
