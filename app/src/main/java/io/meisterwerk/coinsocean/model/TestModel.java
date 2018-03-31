package io.meisterwerk.coinsocean.model;

public class TestModel {
    private String name;
    private boolean isGrowing;

    public TestModel() {
    }

    public TestModel(String name, boolean isGrowing) {
        this.name = name;
        this.isGrowing = isGrowing;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isGrowing() {
        return isGrowing;
    }

    public void setGrowing(boolean growing) {
        isGrowing = growing;
    }
}
