package edu.cnm.deepdive.helloworld.adapters;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.view.LayoutInflater;
import android.view.TextureView;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;
import edu.cnm.deepdive.helloworld.R;
import edu.cnm.deepdive.helloworld.objects.Image;
import java.util.List;

/**
 * Created by zaryn on 7/20/2017.
 */

public class ImageListAdapter extends BaseAdapter {
  private List<Image> mImages;
  private Context mContext;

  public  ImageListAdapter(Context context, List<Image> images) {
    mImages = images;
    mContext = context;
  }

  @Override
  public int getCount() {
    return (mImages != null) ? mImages.size() : 0;
  }

  @Override
  public Object getItem(int position) {
    return (mImages != null && position < mImages.size())
            ? mImages.get(position)
            : null;
  }

  @Override
  public long getItemId(int position) {
    return 0;
  }

/*  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    if (convertView == null) {
      convertView = LayoutInflater.from(mContext)
                    .inflate(R.layout.image_list_item, parent, false);
    }

    Image image = (Image)getItem(position);
    TextView txtImageTitle = (TextView)convertView.findViewById(R.id.txtImageTitle);
    if (image != null && txtImageTitle != null) {
      txtImageTitle.setText(image.getTitle());
    }
    return convertView;
  }*/

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    if (convertView == null) {
      convertView = LayoutInflater.from(mContext).inflate(R.layout.image_list_item, parent, false);
    }

    Image image = (Image)getItem(position);
    TextView txtImageTitle = (TextView)convertView.findViewById(R.id.txtImageTitle);
    txtImageTitle.setText(image.getTitle());

    ImageView imageView = (ImageView)convertView.findViewById(R.id.image);
    Bitmap bitmap = image.getDownloadedImage(mContext);
    if (bitmap != null) {
      imageView.setImageBitmap(bitmap);
    }
    else {
      if (mContext instanceof Activity) {
        image.downloadImage((Activity) mContext, new Runnable() {
          @Override
          public void run() {
            notifyDataSetChanged();
          }
        });
      }
    }
    return convertView;
  }
}
