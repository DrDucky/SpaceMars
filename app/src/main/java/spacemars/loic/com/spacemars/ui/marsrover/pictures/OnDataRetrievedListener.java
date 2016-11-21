package spacemars.loic.com.spacemars.ui.marsrover.pictures;

/**
 * Created by lmecatti on 19/11/2016.
 * Listener used in Network result
 */

public interface OnDataRetrievedListener {

    /**
     * Generic onSuccess method
     */
    void onSuccess(String response);

    /**
     * Generic onError method
     */
    void onError();
}
