package edu.cnm.deepdive.helloworld.database;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import edu.cnm.deepdive.helloworld.datatables.TableImages;
import edu.cnm.deepdive.helloworld.objects.Image;
import java.util.List;
import rx.Single;
import rx.SingleSubscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.functions.Action1;
import rx.schedulers.Schedulers;

/**
 * Created by zaryn on 7/21/2017.
 */

public class DatabaseMethods {

  public static void saveImages(final Activity activity, final List<Image> images, final Runnable callback) {
    Single.create(new Single.OnSubscribe<Boolean>() {
      @Override
      public void call(SingleSubscriber<? super Boolean> singleSubscriber) {
        if (images != null) {
          for (Image image : images) {
            image.saveToDB(activity);
          }
        }
        singleSubscriber.onSuccess(images != null);
      }
    })
        .subscribeOn(Schedulers.computation())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new Action1<Boolean>() {
                     @Override
                     public void call(Boolean success) {
                       if (callback != null && success) {
                         activity.runOnUiThread(callback);
                       }
                     }
                   },
            new Action1<Throwable>() {
              @Override
              public void call(Throwable throwable) {
                throwable.printStackTrace();
              }
            });
  }

  public static Cursor getImages(Context context) {
    Cursor c = null;
    SQLiteDatabase db = DatabaseHelper.getDatabase(context);
    if (db != null) {
      c = db.query(
          TableImages.NAME,
          null,
          null,
          null,
          null,
          null,
          TableImages.COL_DATETIME + " DESC"
      );
    }
    return c;
  }
}
