package ru.stqa.pft.bugify.appmanager;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonParser;
import com.google.gson.reflect.TypeToken;
import com.jayway.restassured.RestAssured;
import ru.stqa.pft.bugify.model.Issue;

import java.io.IOException;
import java.util.Set;

/**
 * Created by RomanovaD on 09.07.2017.
 */
public class RestHelper {
    private final ApplicationManager app;

    public RestHelper(ApplicationManager app) {
        this.app = app;
    }

    public void login(){
        RestAssured.authentication = RestAssured.basic(app.getProperty("api.login"), "");
    }

    private Set<Issue> getIssues() throws IOException {
        String json = RestAssured.get(app.getProperty("web.baseURL") + "api/issues.json").asString();
        JsonElement parsed = new JsonParser().parse(json);
        JsonElement issues = parsed.getAsJsonObject().get("issues");
        return new Gson().fromJson(issues, new TypeToken<Set<Issue>>(){}.getType());
    }

    public String getIssueStatus(int id){
        String json = RestAssured.get(app.getProperty("web.baseURL") + String
                .format("api/issues/%s.json?attachments=false&comments=false&followers=false&history=false", id)).asString();
        JsonElement parsed = new JsonParser().parse(json);
        JsonElement state = parsed.getAsJsonObject().getAsJsonArray("issues").get(0).getAsJsonObject().get("state_name");
        return new Gson().fromJson(state, new TypeToken<String>(){}.getType());
    }
}
