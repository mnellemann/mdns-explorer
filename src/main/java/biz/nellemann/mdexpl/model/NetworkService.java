package biz.nellemann.mdexpl.model;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.scene.paint.Color;

import java.util.*;

public class NetworkService {

    private String name;
    private String type;
    private String subType;
    private String app;
    private String url;
    private Color color;
    private final ArrayList<String> propertiesList = new ArrayList<>();


    public NetworkService(String name, String type, String subType, String app, String url, Color color) {
        this.name = name;
        this.type = type;
        this.subType = subType;
        this.app = app;
        this.url = url;
        this.color = color;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getSubType() {
        return subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getApp() {
        return app;
    }

    public void setApp(String app) {
        this.app = app;
    }


    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public void addProperty(String key, String value) {
        propertiesList.add(key + ": " + value);
    }

    public ArrayList<?> getProperties() {
        return propertiesList;
    }


    @Override
    public String toString() {
        return name + " (" + app + ") " + url;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        NetworkService networkService = (NetworkService) o;
        return Objects.equals(type, networkService.type) && Objects.equals(name, networkService.name) && Objects.equals(url, networkService.url);
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((url == null) ? 0 : url.hashCode());
        return result;
    }

}


