package spacemars.loic.com.spacemars.ui.marsrover.pictures;

import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import spacemars.loic.com.spacemars.R;
import spacemars.loic.com.spacemars.models.Picture;

/**
 * Created by lmecatti on 21/11/2016.
 */

public class MarsRoverPicturesActivity extends AppCompatActivity implements MarsRoverPicturesView {

    private Context mContext;

    @BindView(R.id.lv_mars_rover_pictures)
    ListView mMarsRoverPicturesListView;

    @BindView(R.id.tv_loading_datas)
    TextView mLoadingdatas;

    private PictureAdapter mPictureAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.mars_rover_pictures);
        ButterKnife.bind(this);

        this.mContext = this;

        MarsRoverPicturesPresenterImpl vMarsRoverPicturesPresenterImpl = new MarsRoverPicturesPresenterImpl(mContext, this);
        vMarsRoverPicturesPresenterImpl.requestPictures();

    }

    @Override
    public void showProgress() {
        mLoadingdatas.setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        mLoadingdatas.setVisibility(View.GONE);
    }

    @Override
    public void setPictureAdapter(List<Picture> pictures) {
        mPictureAdapter = new PictureAdapter(this, R.layout.picturerow, pictures);
        mMarsRoverPicturesListView.setAdapter(mPictureAdapter);
    }
}
