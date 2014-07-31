package com.github.codingricky.marvel;

import com.github.codingricky.marvel.model.Comic;
import com.github.codingricky.marvel.model.Creator;
import com.github.codingricky.marvel.model.MarvelCharacter;
import com.github.codingricky.marvel.model.Result;
import com.github.codingricky.marvel.model.Series;
import com.github.codingricky.marvel.model.Story;
import com.github.codingricky.marvel.parameter.SeriesParametersBuilder;
import org.junit.Test;

import static org.fest.assertions.Assertions.assertThat;

public class SeriesRestTest extends AbstractRestTest {

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
        Result<MarvelCharacter> characters = restClient.getSeriesCharacters(new SeriesParametersBuilder(FIFTEEN_LOVE_SERIES_ID).create());
        assertThat(characters.getData()).isNotNull();
    }

    @Test
    public void testGetSeriesComics() throws Exception {
        Result<Comic> comics = restClient.getSeriesComics(new SeriesParametersBuilder(FIFTEEN_LOVE_SERIES_ID).create());
        assertThat(comics.getData()).isNotNull();
    }

    @Test
    public void testGetSeriesCreators() throws Exception {
        Result<Creator> creators = restClient.getSeriesCreators(new SeriesParametersBuilder(FIFTEEN_LOVE_SERIES_ID).create());
        assertThat(creators.getData()).isNotNull();
    }

    @Test
    public void testGetSeriesStories() throws Exception {
        Result<Story> stories = restClient.getSeriesStories(new SeriesParametersBuilder(FIFTEEN_LOVE_SERIES_ID).create());
        assertThat(stories.getData()).isNotNull();
    }
}
