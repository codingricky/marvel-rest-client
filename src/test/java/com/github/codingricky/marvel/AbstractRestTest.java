package com.github.codingricky.marvel;

import com.github.codingricky.marvel.RestClient;
import org.apache.commons.lang3.StringUtils;
import org.junit.Before;

import static org.fest.assertions.Assertions.assertThat;

public abstract class AbstractRestTest {

    protected static final int AMAZING_SPIDER_MAN_COMIC_ID = 6908;
    protected static final int AVENGERS_COMIC_ID = 17519;
    protected static final int BLACK_WIDOW_ID = 1009189;
    protected static final int ACTS_OF_VENGEANCE_EVENT_ID = 116;
    protected static final int FIFTEEN_LOVE_SERIES_ID = 13379;
    protected static final int STORY_ID = 3;

    protected RestClient restClient;

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
}
