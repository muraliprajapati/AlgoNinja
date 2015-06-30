package com.teamdroid.algoninja;

import java.util.UUID;

/**
 * Created by Murali on 25-06-2015.
 */
public class Algorithm {
    UUID algorithmID;
    String name;
    String description;
    boolean favourite;

    public Algorithm(){
        algorithmID = UUID.randomUUID();
    }


    public UUID getAlgorithmID() {
        return algorithmID;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isFavourite() {
        return favourite;
    }

    public void setFavourite(boolean favourite) {
        this.favourite = favourite;
    }
}
