package developer.shivam.jsonparsingwithperfecto.util;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import developer.shivam.jsonparsingwithperfecto.model.Feed;

public class ParseJson {

    public static List<Feed> ofTypeFeed(String jsonString) {
        List<Feed> list = new ArrayList<>();

        /**
         *  '{' This stands for a json object
         *  '[' This stands for a json Array
         *
         *  Since first character in the jsonString is '{' so we will initialize
         *   whole string as a JsonObject
         */
        try {

            JSONObject parentObject = new JSONObject(jsonString);
            /**
             * This parentObject then contain a array named "feeds"
             *  we will then take out that array from jsonSting
             */

            JSONArray feedsArray = parentObject.getJSONArray("feed");
            /**
             * Then for this array we will start a loop to take out every child
             *  data and save it in list
             */

            for (int i = 0; i < feedsArray.length(); i++ ) {
                /**
                 * We will extract jsonObject from every position
                 */
                JSONObject feedObject = feedsArray.getJSONObject(i);
                Feed feed = new Feed();
                feed.setId(feedObject.getString("id"));
                feed.setName(feedObject.getString("name"));
                feed.setImage(feedObject.getString("image"));
                feed.setProfilePicture(feedObject.getString("profilePic"));
                feed.setStatus(feedObject.getString("status"));
                feed.setBackground(feedObject.getString("image"));

                /**
                 * Finally add this model object to custom list
                 */
                list.add(feed);
            }

        } catch (JSONException e) {
            e.printStackTrace();
        }
        return list;
    }

}
