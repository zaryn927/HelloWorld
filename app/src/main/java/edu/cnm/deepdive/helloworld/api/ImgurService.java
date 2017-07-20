package edu.cnm.deepdive.helloworld.api;

import android.text.method.SingleLineTransformationMethod;
import edu.cnm.deepdive.helloworld.objects.GalleryResponse;
import retrofit2.http.GET;
import retrofit2.http.Path;
import rx.Single;

/**
 * Created by Sky Link on 7/14/2017.
 */

public interface ImgurService {
  @GET("gallery/r/{subreddit}/{sort}/{window}/{page}")
  Single<GalleryResponse> subredditGallery(
      @Path("subreddit") String subreddit,
      @Path("sort") String sort,
      @Path("window") String window,
      @Path("page") int page
  );
}
