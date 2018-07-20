package telamaresrestaurantmd.com.app.models;

import java.io.Serializable;

public class Receipt implements Serializable {

    private String id, title, overview, posterPath, backdropPath;

    public Receipt(String id, String title, String overview, String posterPath, String backdropPath) {
        this.id = id;
        this.title = title;
        this.overview = overview;
        this.posterPath = posterPath;
        this.backdropPath = backdropPath;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getOverview() {
        return overview;
    }

    public void setOverview(String overview) {
        this.overview = overview;
    }

    public String getPosterPath() {
        return String.format("http://www.telamaresrestaurantmd.com/images/androidapp%s", posterPath);
    }

    public void setPosterPath(String posterPath) {
        this.posterPath = posterPath;
    }

    public String getBackdropPath() {
        return String.format("http://www.telamaresrestaurantmd.com/images/androidapp%s", backdropPath);
    }

    public void setBackdropPath(String backdropPath) {
        this.backdropPath = backdropPath;
    }
}
