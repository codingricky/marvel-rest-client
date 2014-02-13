package com.github.codingricky.marvel;

import java.io.IOException;

import com.github.codingricky.marvel.model.MarvelCharacter;
import com.github.codingricky.marvel.model.Result;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import static junit.framework.Assert.assertTrue;
import static org.fest.assertions.Assertions.assertThat;

public class RestClientTest {

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

        assertTrue("Public key is blank", !StringUtils.isBlank(publicKey));
        assertTrue("Private key is blank", !StringUtils.isBlank(privateKey));

        restClient = new RestClient(privateKey, publicKey);
    }

    @Test
    public void testGetCharacters() throws IOException {
        Result<MarvelCharacter> characters = restClient.getCharacters(new ParameterBuilder().withLimit(5).create());
        assertThat(characters.getData().getCount()).isEqualTo(5);
    }

    @Test
    public void testGetCharacter() throws IOException {
        Result<MarvelCharacter> character = restClient.getCharacter(1009521);
        assertThat(character.getData().getResults().get(0).getName().trim()).isEqualTo("Hank Pym");
    }
}
