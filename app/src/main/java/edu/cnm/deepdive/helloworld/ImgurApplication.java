package edu.cnm.deepdive.helloworld;

import android.app.Application;
import edu.cnm.deepdive.helloworld.api.API;

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
