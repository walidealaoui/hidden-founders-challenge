package com.example.hp.androidchallenge.Model;

import android.util.Log;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

/**
 * Created by Hp on 29/09/2018.
 */

public class RepoDataModel {

    private String repo_name;
    private String repo_description;
    private String owner_name;
    private int number_of_stars;
    private String avatar;





    public String getRepo_name() {
        return repo_name;
    }

    public String getRepo_description() {
        return repo_description;
    }

    public String getOwner_name() {
        return owner_name;
    }

    public int getNumber_of_stars() {
        return number_of_stars;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setRepo_name(String repo_name) {
        this.repo_name = repo_name;
    }

    public void setRepo_description(String repo_description) {
        this.repo_description = repo_description;
    }

    public void setOwner_name(String owner_name) {
        this.owner_name = owner_name;
    }

    public void setNumber_of_stars(int number_of_stars) {
        this.number_of_stars = number_of_stars;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }
}
