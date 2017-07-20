package edu.cnm.deepdive.helloworld;

import android.app.Application;
import edu.cnm.deepdive.helloworld.api.API;
import edu.cnm.deepdive.helloworld.objects.GalleryResponse;
import edu.cnm.deepdive.helloworld.objects.Image;
import java.util.List;
import rx.SingleSubscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by zaryn on 7/14/2017.
 */

public class ImgurApplication extends Application {

  @Override
  public void onCreate() {
    super.onCreate();
    API.init();

  }
}
