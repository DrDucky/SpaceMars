package spacemars.loic.com.spacemars.ui.marsrover.pictures;

import java.util.List;

import spacemars.loic.com.spacemars.models.Picture;

/**
 * Created by lmecatti on 21/11/2016.
 */

public interface MarsRoverPicturesPresenter {

    /**
     * Request the pictures to Interactor
     */
    void requestPictures();

    /**
     * Parse pictures using Gson
     *
     * @param response received by network
     * @return a list of all picture
     */
    List<Picture> parsePictures(String response);
}
