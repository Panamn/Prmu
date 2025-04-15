package com.example.recyclerview;

public class State {

    private String name;
    private String capital;
    private int flagResource;

    public State(int flagResource, String capital, String name) {
        this.flagResource = flagResource;
        this.capital = capital;
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public int getFlagResource() {
        return flagResource;
    }

    public void setFlagResource(int flagResource) {
        this.flagResource = flagResource;
    }

}
