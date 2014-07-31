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

The MIT License (MIT)

Copyright (c) 2014 Ricky Yim

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.



TODO
====
* Add support for all the API
* Add instructions on how to build the library