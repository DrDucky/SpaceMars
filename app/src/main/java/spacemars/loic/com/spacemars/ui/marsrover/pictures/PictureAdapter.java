package spacemars.loic.com.spacemars.ui.marsrover.pictures;

import com.squareup.picasso.Picasso;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

import spacemars.loic.com.spacemars.R;
import spacemars.loic.com.spacemars.models.Picture;

/**
 * Created by lmecatti on 19/11/2016.
 * Adapter use to populate our listView of Pictures of Mars
 */

public class PictureAdapter extends ArrayAdapter<Picture> {

    private Context mContext;

    public PictureAdapter(Context context, int resource, List<Picture> hotels) {
        super(context, resource, hotels);
        this.mContext = context;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        PictureViewHolder vPictureViewHolder;

        if (convertView == null) {
            LayoutInflater vi;
            vi = LayoutInflater.from(getContext());
            convertView = vi.inflate(R.layout.picturerow, null);

            vPictureViewHolder = new PictureViewHolder();
            vPictureViewHolder.vPictureId = (TextView) convertView.findViewById(R.id.picture_id_tv);
            vPictureViewHolder.vPicturePhoto = (ImageView) convertView.findViewById(R.id.picture_imageview);
            vPictureViewHolder.vPictureDate = (TextView) convertView.findViewById(R.id.picture_earth_date_tv);
            convertView.setTag(vPictureViewHolder);
        } else {
            vPictureViewHolder = (PictureViewHolder) convertView.getTag();

        }

        Picture vPicture = getItem(position);

        if (vPicture != null) {

            if (vPictureViewHolder.vPictureId != null) {
                vPictureViewHolder.vPictureId.setText(String.valueOf(vPicture.getId()));
            }

            if (vPictureViewHolder.vPicturePhoto != null) {
                Picasso.with(mContext).load(vPicture.getImgUrl()).into(vPictureViewHolder.vPicturePhoto);
            }

            if (vPictureViewHolder.vPictureDate != null) {
                vPictureViewHolder.vPictureDate.setText(vPicture.getEarthDate());
            }
        }

        return convertView;
    }

    static class PictureViewHolder {
        TextView vPictureId;
        TextView vPictureDate;
        ImageView vPicturePhoto;
    }
}
