package com.example.doanjavak17;

import android.graphics.Bitmap;

public class Room {
    private int resourceimage;
    private String name;

    public Room(int resourceimage, String name) {
        this.resourceimage = resourceimage;
        this.name = name;
    }
    public int getResourceimage() {
        return resourceimage;
    }

    public void setResourceimage(int resourceimage) {
        this.resourceimage = resourceimage;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
