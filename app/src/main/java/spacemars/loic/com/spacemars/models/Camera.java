package spacemars.loic.com.spacemars.models;

/**
 * Created by lmecatti on 21/11/2016.
 */

public class Camera {

    private int id;

    private String name;

    private String rover_id;

    private String full_name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRover_id() {
        return rover_id;
    }

    public void setRover_id(String rover_id) {
        this.rover_id = rover_id;
    }

    public String getFull_name() {
        return full_name;
    }

    public void setFull_name(String full_name) {
        this.full_name = full_name;
    }
}
