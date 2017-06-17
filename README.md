# dmt-klout

Simple library to connect to the Klout API as explained in the [Setting up a Klout application](https://wil-low.com/directmediatips/chapter01/setupklout) section of the [Direct Media Tips and Tricks](https://wil-low.com/directmediatips) book.

This library is also available on the Maven Central Repository:

    <dependency>
      <groupId>com.directmediatips</groupId>
      <artifactId>dmt-klout</artifactId>
      <version>0.1.1</version>
    </dependency>

To use this library, create a `Klout` object with an API key that gives you access to the Klout API.

    Klout klout = new Klout(apiKey);
    
There are different methods to create a `UserId`.
For instance: if you know someone's screen name on Twitter, you can get this person's Klout ID like this:
    
    UserId id = klout.getUserIdFromTwitterScreenName(screenName);
   
Once you have a `UserId` instance, you can get:

* `User` information (e.g. the Klout score),
* `Influence` information (influencers and influencees), and
* `Topic` information.

The following lines show how to write this information to the `System.out`:
   
    System.out.println(klout.getUser(id));
    System.out.println(klout.getInfluence(id));
    System.out.println(klout.getTopics(id));
