package com.github.codingricky.marvel.model;

import java.util.List;

import org.apache.commons.lang3.builder.ToStringBuilder;

public class Series {
//    id (int, optional): The unique ID of the series resource.,
//    title (string, optional): The canonical title of the series.,
//    description (string, optional): A description of the series.,
//    resourceURI (string, optional): The canonical URL identifier for this resource.,
//    urls (Array[Url], optional): A set of public web site URLs for the resource.,
//    startYear (int, optional): The first year of publication for the series.,
//    endYear (int, optional): The last year of publication for the series (conventionally, 2099 for ongoing series) .,
//    rating (string, optional): The age-appropriateness rating for the series.,
//    modified (Date, optional): The date the resource was most recently modified.,
//    thumbnail (Image, optional): The representative image for this series.,
//    comics (ComicList, optional): A resource list containing comics in this series.,
//    stories (StoryList, optional): A resource list containing stories which occur in comics in this series.,
//    events (EventList, optional): A resource list containing events which take place in comics in this series.,
//    characters (CharacterList, optional): A resource list containing characters which appear in comics in this series.,
//    creators (CreatorList, optional): A resource list of creators whose work appears in comics in this series.,
//    next (SeriesSummary, optional): A summary representation of the series which follows this series.,
//    previous (SeriesSummary, optional): A summary representation of the series which preceded this series.
    private int id;
    private String title;
    private String description;
    private String resourceURI;
    private List<URL> urls;
    private int startYear;
    private int endYear;
    private String rating;
    private String modified;
    private Image thumbnail;
    private ComicList comics;
    private StoryList stories;
    private EventList events;
    private CharacterList characters;
    private CreatorList creators;
    private SeriesSummary next;
    private SeriesSummary previous;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
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

    public int getStartYear() {
        return startYear;
    }

    public void setStartYear(int startYear) {
        this.startYear = startYear;
    }

    public int getEndYear() {
        return endYear;
    }

    public void setEndYear(int endYear) {
        this.endYear = endYear;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getModified() {
        return modified;
    }

    public void setModified(String modified) {
        this.modified = modified;
    }

    public Image getThumbnail() {
        return thumbnail;
    }

    public void setThumbnail(Image thumbnail) {
        this.thumbnail = thumbnail;
    }

    public ComicList getComics() {
        return comics;
    }

    public void setComics(ComicList comics) {
        this.comics = comics;
    }

    public StoryList getStories() {
        return stories;
    }

    public void setStories(StoryList stories) {
        this.stories = stories;
    }

    public EventList getEvents() {
        return events;
    }

    public void setEvents(EventList events) {
        this.events = events;
    }

    public CharacterList getCharacters() {
        return characters;
    }

    public void setCharacters(CharacterList characters) {
        this.characters = characters;
    }

    public CreatorList getCreators() {
        return creators;
    }

    public void setCreators(CreatorList creators) {
        this.creators = creators;
    }

    public SeriesSummary getNext() {
        return next;
    }

    public void setNext(SeriesSummary next) {
        this.next = next;
    }

    public SeriesSummary getPrevious() {
        return previous;
    }

    public void setPrevious(SeriesSummary previous) {
        this.previous = previous;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }
}
