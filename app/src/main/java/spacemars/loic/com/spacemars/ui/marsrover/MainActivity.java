package spacemars.loic.com.spacemars.ui.marsrover;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import butterknife.ButterKnife;
import butterknife.OnClick;
import spacemars.loic.com.spacemars.R;
import spacemars.loic.com.spacemars.ui.marsrover.pictures.MarsRoverPicturesActivity;

public class MainActivity extends AppCompatActivity {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);

        this.mContext = this;
    }

    @OnClick(R.id.button_mars_rover)
    public void goToMarsRoverPictures() {
        Intent vIntentMarsRoverPictures = new Intent(mContext, MarsRoverPicturesActivity.class);
        startActivity(vIntentMarsRoverPictures);
    }
}
