package com.github.codingricky.marvel.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import java.util.Date;
import java.util.List;

@JsonIgnoreProperties(ignoreUnknown = true)
public class MarvelCharacter {

    private int id;
    private String name;
    private String description;
    private Date modified;
    private String resourceURI;
    private List<URL> urls;
    private Image thumbnail;
    private ComicList comicList;
    private StoryList storyList;
    private EventList eventList;
    private SeriesList seriesList;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }

    public String getResourceURI() {
        return resourceURI;
    }

    public void setResourceURI(String resourceURI) {
        this.resourceURI = resourceURI;
    }

    public List<URL> getUrls() {
        return urls;
    }

    public void setUrls(List<URL> urls) {
        this.urls = urls;
    }

    public Image getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Image thumbnail) {
        this.thumbnail = thumbnail;
    }

    public ComicList getComicList() {
        return comicList;
    }

    public void setComicList(ComicList comicList) {
        this.comicList = comicList;
    }

    public StoryList getStoryList() {
        return storyList;
    }

    public void setStoryList(StoryList storyList) {
        this.storyList = storyList;
    }

    public EventList getEventList() {
        return eventList;
    }

    public void setEventList(EventList eventList) {
        this.eventList = eventList;
    }

    public SeriesList getSeriesList() {
        return seriesList;
    }

    public void setSeriesList(SeriesList seriesList) {
        this.seriesList = seriesList;
    }

    @Override
    public String toString() {
        return "MarvelCharacter{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", description='" + description + '\'' +
                ", modified=" + modified +
                ", resourceURI='" + resourceURI + '\'' +
                ", urls=" + urls +
                ", thumbnail=" + thumbnail +
                ", comicList=" + comicList +
                ", storyList=" + storyList +
                ", eventList=" + eventList +
                ", seriesList=" + seriesList +
                '}';
    }
}
