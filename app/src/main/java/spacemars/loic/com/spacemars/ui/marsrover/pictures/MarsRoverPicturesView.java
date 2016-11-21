package spacemars.loic.com.spacemars.ui.marsrover.pictures;

import java.util.List;

import spacemars.loic.com.spacemars.models.Picture;

/**
 * Created by lmecatti on 21/11/2016.
 */

public interface MarsRoverPicturesView {

    /**
     * Simple loading text to show
     */
    void showProgress();

    /**
     * Simple loading text to hide
     */
    void hideProgress();

    /**
     * Set the adapter to populate the picture listview
     */
    void setPictureAdapter(List<Picture> hotels);
}
