package spacemars.loic.com.spacemars.models;

import com.google.gson.annotations.SerializedName;

/**
 * Created by lmecatti on 21/11/2016.
 */

public class Picture {

    private int id;

    private Camera camera;

    @SerializedName("img_src")
    private String imgUrl;

    @SerializedName("earth_date")
    private String earthDate;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Camera getCamera() {
        return camera;
    }

    public void setCamera(Camera camera) {
        this.camera = camera;
    }

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

    public String getEarthDate() {
        return earthDate;
    }

    public void setEarthDate(String earthDate) {
        this.earthDate = earthDate;
    }
}
