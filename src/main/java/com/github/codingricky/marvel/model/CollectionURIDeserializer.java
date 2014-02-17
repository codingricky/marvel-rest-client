package com.github.codingricky.marvel.model;

import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.ObjectCodec;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.JsonDeserializer;
import com.fasterxml.jackson.databind.JsonNode;

import java.io.IOException;

public class CollectionURIDeserializer extends JsonDeserializer<CollectionURI> {
    @Override
    public CollectionURI deserialize(JsonParser jsonParser, DeserializationContext deserializationContext) throws IOException, JsonProcessingException {
        ObjectCodec oc = jsonParser.getCodec();
        JsonNode node = oc.readTree(jsonParser);
        CollectionURI collectionURI = new CollectionURI();
        if (node.has("service")) {
            String service = node.get("service").textValue();
            int id = node.get("id").intValue();
            collectionURI.setService(service);
            collectionURI.setId(id);
        } else {
            collectionURI.setCollectionURI(node.textValue());
        }

        return collectionURI;
    }
}
