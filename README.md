Marvel Rest Client
=================

A simple wrapper to use the Rest api exposed by Marvel.

Before using the client, sign up to get a developer account here http://developer.marvel.com
to get a public/private key combination.

Usage
=====
In your pom.xml file add the following dependency. Use the latest version available.

```xml
<dependency>
    <groupId>com.github.codingricky</groupId>
    <artifactId>marvel-rest-client</artifactId>
    <version>0.1</version>
</dependency>
```

Now in your java code, to get a list of Marvel characters.

```java
RestClient restClient = new RestClient(privateKey, publicKey);
List<MarvelCharacter> characters = restClient.getCharacters();
```

To get a list of comics that a character has been in

```java
RestClient restClient = new RestClient(privateKey, publicKey);
Result<Comic> comics = restClient.getCharactersComics(new ComicParametersBuilder(BLACK_WIDOW_ID).create());
```

License
=======

!INCLUDE LICENSE.txt


TODO
====
* Add error handling
* Add support for all the API
* Proxy Support
* Add instructions on how to build the library