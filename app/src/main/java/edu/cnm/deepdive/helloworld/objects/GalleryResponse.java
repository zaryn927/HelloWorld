package edu.cnm.deepdive.helloworld.objects;

import com.google.gson.annotations.SerializedName;
import java.util.List;

/**
 * Created by zaryn on 7/20/2017.
 */

public class GalleryResponse {
  @SerializedName("success")
  boolean success;
  @SerializedName("status")
  int status;
  @SerializedName("data")
  List<Image> data;

  public boolean getSuccess() {
    return success;
  }

  public int getStatus() {
    return status;
  }

  public List<Image> getData() {
    return data;
  }
}
