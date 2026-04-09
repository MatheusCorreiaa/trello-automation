package maps;

import java.util.HashMap;
import java.util.Map;

public class TrelloMap {

    public static String idCard;

    private Map<String, Object> json;

    public TrelloMap(){
        initJson();
    }

    public Map<String, Object> getJson(){
        return json;
    }

    public void initJson() {
        json = new HashMap<>();

        json.put("key", System.getenv("TRELLO_KEY"));
        json.put("token", System.getenv("TRELLO_TOKEN"));
        json.put("idList", "69d6c7a57db0aad085f7a176");
        json.put("name", "Card Automacao");
    }
}