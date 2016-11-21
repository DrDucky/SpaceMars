package spacemars.loic.com.spacemars.ui.marsrover.pictures;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import android.content.Context;
import android.util.Log;

import spacemars.loic.com.spacemars.Config;

import static android.content.ContentValues.TAG;

/**
 * Created by lmecatti on 21/11/2016.
 */

public class MarsRoverPicturesInteractorImpl implements MarsRoverPicturesInteractor {


    private Context mContext;

    public MarsRoverPicturesInteractorImpl(Context pContext) {
        this.mContext = pContext;
    }

    @Override
    public void requestPicturesToApi(String pDate, final OnDataRetrievedListener pOnDataRetrievedListener) {

        final String URL_API = Config.BASE_URL_API + Config.API_KEY + Config.PICTURE_EARTH_DATE_KEY + pDate;

        final RequestQueue queue = Volley.newRequestQueue(mContext);
        StringRequest vRequestHotel = new StringRequest(Request.Method.GET,
                URL_API, new Response.Listener<String>() {

            @Override
            public void onResponse(String pResponse) {
                Log.d(TAG, pResponse);
                pOnDataRetrievedListener.onSuccess(pResponse);
            }
        }, new Response.ErrorListener() {

            @Override
            public void onErrorResponse(VolleyError vVolleyError) {
                pOnDataRetrievedListener.onError();
            }
        });
        //Request added to queue for launch
        queue.add(vRequestHotel);
    }
}
