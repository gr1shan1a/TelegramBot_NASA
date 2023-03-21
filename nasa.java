import com.fasterxml.jackson.annotation.JsonProperty;

public class nasa {
    private String copyright;
    private String date;
    private String explanation;
    private String hdurl;
    private String media_type;
    private String service_version;
    private String title;
    private String url;

    public nasa(
            @JsonProperty("Detlef Hartmann") String copyright,
            @JsonProperty("date") String date,
            @JsonProperty("explanation") String explanation,
            @JsonProperty("hdurl") String hdurl,
            @JsonProperty("mediaType") String mediaType,
            @JsonProperty("serviceVersion") String serviceVersion,
            @JsonProperty("title") String title,
            @JsonProperty("url") String url) {
        this.copyright = copyright;
        this.date = date;
        this.explanation = explanation;
        this.hdurl = hdurl;
        this.media_type = mediaType;
        this.service_version = serviceVersion;
        this.title = title;
        this.url = url;
    }

    public String getCopyright() {
        return copyright;
    }

    public String getDate() {
        return date;
    }

    public String getExplanation() {
        return explanation;
    }

    public String getHdurl() {
        return hdurl;
    }

    public String getMedia_type() {
        return media_type;
    }

    public String getService_version() {
        return service_version;
    }

    public String getTitle() {
        return title;
    }

    public String getUrl() {
        return url;
    }

    @Override
    public String toString() {
        return "nasa\n{" +
                "\ncopyright='" + copyright + '\'' +
                "\n, date='" + date + '\'' +
                "\n, explanation='" + explanation + '\'' +
                "\n, hdurl='" + hdurl + '\'' +
                "\n, media_type='" + media_type + '\'' +
                "\n, service_version='" + service_version + '\'' +
                "\n, title='" + title + '\'' +
                "\n, url='" + url + '\'' +
                '}';
    }
}
