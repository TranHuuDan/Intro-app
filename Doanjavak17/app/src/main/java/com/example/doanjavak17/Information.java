package com.example.doanjavak17;

public class Information {
    private int resourceimage;
    private String name;
    private String value;

    public Information(int resourceimage, String name, String value) {
        this.resourceimage = resourceimage;
        this.name = name;
        this.value = value;
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

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
