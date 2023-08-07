package biz.nellemann.mdexpl.model;

public class NetworkService {

    private String name;
    private String type;
    private String app;
    private String url;

    public NetworkService(String name, String type, String app, String url) {
        this.name = name;
        this.type = type;
        this.app = app;
        this.url = url;
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


