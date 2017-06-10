# dmt-klout

Code to connect to the Klout API

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
