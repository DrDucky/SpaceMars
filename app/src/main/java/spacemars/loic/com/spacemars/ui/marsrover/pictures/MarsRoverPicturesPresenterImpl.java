package spacemars.loic.com.spacemars.ui.marsrover.pictures;

import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParser;

import android.content.Context;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.List;
import java.util.Locale;

import spacemars.loic.com.spacemars.models.Picture;

/**
 * Created by lmecatti on 21/11/2016.
 * Presenter for pictures of Mars. Link betweek the view ({@link MarsRoverPicturesView} and the datas
 */

public class MarsRoverPicturesPresenterImpl implements MarsRoverPicturesPresenter, OnDataRetrievedListener {

    private static final String PHOTOS_API_KEY = "photos";

    private MarsRoverPicturesView mView;

    private MarsRoverPicturesInteractorImpl mMarsRoverPicturesInteractorImpl;

    public static final SimpleDateFormat mDateFormat = new SimpleDateFormat("yyyy-MM-dd");

    private Context mContext;

    public MarsRoverPicturesPresenterImpl(Context pContext, MarsRoverPicturesView pView) {
        this.mView = pView;
        this.mContext = pContext;
        this.mMarsRoverPicturesInteractorImpl = new MarsRoverPicturesInteractorImpl(mContext);
    }

    @Override
    public void requestPictures() {
        mView.showProgress();
        String vDateToday = getYesterdayDateString();
        mMarsRoverPicturesInteractorImpl.requestPicturesToApi(vDateToday, this);
    }

    /**
     * Retourne la date d'hier au format yyyy-MM-dd
     * @return
     */
    private String getYesterdayDateString() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd", Locale.FRANCE);
        Calendar cal = Calendar.getInstance();
        cal.add(Calendar.DATE, -1);
        return dateFormat.format(cal.getTime());
    }

    @Override
    public List<Picture> parsePictures(String response) {
        Gson vGson = new Gson();
        JsonParser vparser = new JsonParser();
        JsonElement vJsonElement = vparser.parse(response);
        JsonObject vJsonObject = vJsonElement.getAsJsonObject();
        JsonElement vExactMatch = vJsonObject.get(PHOTOS_API_KEY);
        return Arrays.asList(vGson.fromJson(vExactMatch, Picture[].class));
    }

    @Override
    public void onSuccess(String response) {
        mView.hideProgress();
        List<Picture> vPictures = parsePictures(response);
        mView.setPictureAdapter(vPictures);
    }

    @Override
    public void onError() {
        mView.hideProgress();
    }
}
