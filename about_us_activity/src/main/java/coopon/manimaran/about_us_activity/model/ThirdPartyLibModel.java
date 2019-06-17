package coopon.manimaran.about_us_activity.model;

public class ThirdPartyLibModel {
    private String name, url, license, license_url;

    public ThirdPartyLibModel(String name, String url, String license, String license_url) {
        this.name = name;
        this.url = url;
        this.license = license;
        this.license_url = license_url;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLicense() {
        return license;
    }

    public void setLicense(String license) {
        this.license = license;
    }

    public String getLicense_url() {
        return license_url;
    }

    public void setLicense_url(String license_url) {
        this.license_url = license_url;
    }
}
