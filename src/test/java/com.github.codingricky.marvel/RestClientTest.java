package com.github.codingricky.marvel;

import java.io.IOException;
import java.util.List;

import com.github.codingricky.marvel.model.Comic;
import com.github.codingricky.marvel.model.Creator;
import com.github.codingricky.marvel.model.Event;
import com.github.codingricky.marvel.model.MarvelCharacter;
import com.github.codingricky.marvel.model.Result;
import com.github.codingricky.marvel.model.Series;
import com.github.codingricky.marvel.model.Story;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class RestClientTest {

    private static final int AMAZING_SPIDER_MAN_COMIC_ID = 6908;
    private static final int AVENGERS_COMIC_ID = 17519;
    private static final int BLACK_WIDOW_ID = 1009189;
    private static final int ACTS_OF_VENGEANCE_EVENT_ID = 116;
    private static final int FIFTEEN_LOVE_SERIES_ID = 13379;
    private static final int STORY_ID = 3;

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
        Result<MarvelCharacter> characters = restClient.getCharacters(new CharacterParameterBuilder().withLimit(5).create());
        assertThat(characters.getData().getCount()).isEqualTo(5);
    }

    @Test
    public void testGetCharactersWithName() throws IOException {
        Result<MarvelCharacter> characters = restClient.getCharacters(new CharacterParameterBuilder().withName("Black Widow").create());
        assertThat(characters.getData().getTotal()).isEqualTo(1);
        MarvelCharacter blackWidow = characters.getData().getResults().get(0);
        assertThat(blackWidow.getName()).isEqualTo("Black Widow");
        assertThat(blackWidow.getId()).isEqualTo(BLACK_WIDOW_ID);
    }

    @Test
    public void testGetCharactersWithComics() throws IOException {
        Result<MarvelCharacter> characters = restClient.getCharacters(new CharacterParameterBuilder().withName("Black Widow").addComic(AVENGERS_COMIC_ID).orderBy("name").create());

        assertThat(characters.getData().getCount()).isEqualTo(1);
        final List<MarvelCharacter> results = characters.getData().getResults();

        assertThat(results.get(0).getId()).isEqualTo(BLACK_WIDOW_ID);
    }

    @Test
    public void testGetCharactersOrderBy() throws IOException {
        Result<MarvelCharacter> characters = restClient.getCharacters(new CharacterParameterBuilder().addComic(AMAZING_SPIDER_MAN_COMIC_ID).orderBy("-name").orderBy("modified").create());
        final List<MarvelCharacter> results = characters.getData().getResults();

        assertThat(results.get(0).getName()).isEqualTo("Spider-Man");
        assertThat(results.get(1).getName()).isEqualTo("Black Widow");
    }

    @Test
    public void testGetCharacter() throws IOException {
        Result<MarvelCharacter> character = restClient.getCharacter(BLACK_WIDOW_ID);
        assertThat(character.getData().getResults().get(0).getName().trim()).isEqualTo("Black Widow");
    }

    @Test
    public void testGetCharactersComics() throws IOException {
        Result<Comic> comics = restClient.getCharactersComics(BLACK_WIDOW_ID);
        assertThat(comics.getData()).isNotNull();
    }

    @Test
    public void testGetCharactersEvents() throws IOException {
        Result<Event> events = restClient.getCharactersEvents(BLACK_WIDOW_ID);
        assertThat(events.getData()).isNotNull();
    }

    @Test
    public void testGetCharactersStories() throws IOException {
        Result<Story> stories = restClient.getCharactersStories(BLACK_WIDOW_ID);
        assertThat(stories.getData()).isNotNull();
    }

    @Test
    public void testGetCharactersSeries() throws IOException {
        Result<Series> series = restClient.getCharactersSeries(BLACK_WIDOW_ID);
        assertThat(series.getData()).isNotNull();
    }

    @Test
    public void testGetComics() throws Exception {
        Result<Comic> comics = restClient.getComics();
        assertThat(comics.getData()).isNotNull();
    }

    @Test
    public void testGetComicsById() throws Exception {
        Result<Comic> comics = restClient.getComics(AMAZING_SPIDER_MAN_COMIC_ID);
        assertThat(comics.getData()).isNotNull();
        assertThat(comics.getData().getResults().get(0).getTitle()).contains("Amazing Spider-Man");
    }

    @Test
    public void testGetComicsEvents() throws Exception {
        Result<Event> events = restClient.getComicsEvents(AMAZING_SPIDER_MAN_COMIC_ID);
        assertThat(events.getData()).isNotNull();
    }

    @Test
    public void testGetComicsCharacters() throws Exception {
        Result<MarvelCharacter> characters = restClient.getComicsCharacters(AMAZING_SPIDER_MAN_COMIC_ID);
        assertThat(characters.getData()).isNotNull();
    }

    @Test
    public void testGetComicsCreators() throws Exception {
        Result<Creator> creators = restClient.getComicsCreators(AMAZING_SPIDER_MAN_COMIC_ID);
        assertThat(creators.getData()).isNotNull();
    }

    @Test
    public void testGetComicsStories() throws Exception {
        Result<Story> stories = restClient.getComicsStories(AMAZING_SPIDER_MAN_COMIC_ID);
        assertThat(stories.getData()).isNotNull();
    }

    @Test
    public void testGetEvents() throws Exception {
        Result<Event> events = restClient.getEvents();
        assertThat(events.getData()).isNotNull();
    }

    @Test
    public void testGetEventsByEventId() throws Exception {
        Result<Event> events = restClient.getEvents(ACTS_OF_VENGEANCE_EVENT_ID);
        assertThat(events.getData()).isNotNull();
        assertThat(events.getData().getResults().get(0).getTitle()).contains("Acts of Vengeance!");
    }

    @Test
    public void testGetEventsCharacters() throws Exception {
        Result<MarvelCharacter> characters = restClient.getEventsCharacters(ACTS_OF_VENGEANCE_EVENT_ID);
        assertThat(characters.getData()).isNotNull();
    }

    @Test
    public void testGetEventsComics() throws Exception {
        Result<Comic> comics = restClient.getEventsComics(ACTS_OF_VENGEANCE_EVENT_ID);
        assertThat(comics.getData()).isNotNull();
    }

    @Test
    public void testGetEventsCreators() throws Exception {
        Result<Creator> creators = restClient.getEventsCreators(ACTS_OF_VENGEANCE_EVENT_ID);
        assertThat(creators.getData()).isNotNull();
    }

    @Test
    public void testGetEventsStories() throws Exception {
        Result<Story> stories = restClient.getEventsStories(ACTS_OF_VENGEANCE_EVENT_ID);
        assertThat(stories.getData()).isNotNull();
    }

    @Test
    public void testGetSeries() throws Exception {
        Result<Series> series = restClient.getSeries();
        assertThat(series.getData()).isNotNull();
    }

    @Test
    public void testGetSeriesBySeriesId() throws Exception {
        Result<Series> series = restClient.getSeries(FIFTEEN_LOVE_SERIES_ID);
        assertThat(series.getData()).isNotNull();
    }

    @Test
    public void testGetSeriesCharacters() throws Exception {
        Result<MarvelCharacter> characters = restClient.getSeriesCharacters(FIFTEEN_LOVE_SERIES_ID);
        assertThat(characters.getData()).isNotNull();
    }

    @Test
    public void testGetSeriesComics() throws Exception {
        Result<Comic> comics = restClient.getSeriesComics(FIFTEEN_LOVE_SERIES_ID);
        assertThat(comics.getData()).isNotNull();
    }

    @Test
    public void testGetSeriesCreators() throws Exception {
        Result<Creator> creators = restClient.getSeriesCreators(FIFTEEN_LOVE_SERIES_ID);
        assertThat(creators.getData()).isNotNull();
    }

    @Test
    public void testGetSeriesStories() throws Exception {
        Result<Story> stories = restClient.getSeriesStories(FIFTEEN_LOVE_SERIES_ID);
        assertThat(stories.getData()).isNotNull();
    }

    @Test
    public void testGetStories() throws Exception {
        Result<Story> stories = restClient.getStories();
        assertThat(stories.getData()).isNotNull();
        System.out.println(stories.getData());
    }

    @Test
    public void testGetStoriesByStoryId() throws Exception {
        Result<Story> stories = restClient.getStories(STORY_ID);
        assertThat(stories.getData()).isNotNull();
    }

    @Test
    public void testGetStoriesCharacters() throws Exception {
        Result<MarvelCharacter> characters = restClient.getStoriesCharacters(STORY_ID);
        assertThat(characters.getData()).isNotNull();
    }

    @Test
    public void testGetStoriesComics() throws Exception {
        Result<Comic> comics = restClient.getStoriesComics(STORY_ID);
        assertThat(comics.getData()).isNotNull();
    }

    @Test
    public void testGetStoriesCreators() throws Exception {
        Result<Creator> creators = restClient.getStoriesCreators(STORY_ID);
        assertThat(creators.getData()).isNotNull();
    }

}
