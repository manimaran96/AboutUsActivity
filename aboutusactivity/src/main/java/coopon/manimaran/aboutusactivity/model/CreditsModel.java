package coopon.manimaran.aboutusactivity.model;

public class CreditsModel {
    private String name, about, url;

    public CreditsModel(String name, String about, String url) {
        this.name = name;
        this.about = about;
        this.url = url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbout() {
        return about;
    }

    public void setAbout(String about) {
        this.about = about;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
