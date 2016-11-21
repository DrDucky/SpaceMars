package spacemars.loic.com.spacemars.ui.marsrover.pictures;

/**
 * Created by lmecatti on 21/11/2016.
 * Retrieve the picture from Network
 */

public interface MarsRoverPicturesInteractor {

    /**
     * Retrieve pictures from the selected date
     *
     * @param pDate of pictures
     */
    void requestPicturesToApi(String pDate, final OnDataRetrievedListener pOnDataRetrievedListener);
}
