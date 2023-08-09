package biz.nellemann.mdexpl.model;

import javafx.scene.paint.Color;

public class NetworkService {

    private String name;
    private String type;
    private String subType;
    private String app;
    private String url;
    private Color color;

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


    @Override
    public String toString() {
        return name + " (" + type + "), app=" + app + ", url=" + url;
    }

    @Override
    public boolean equals(Object o) {
        if (o == this) return true;
        if (!(o instanceof NetworkService networkService)) {
            return false;
        }
        return networkService.name.equals(name) && networkService.type.equals(type) && networkService.url.equals(url);
    }

}


