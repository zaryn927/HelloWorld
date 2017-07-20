package edu.cnm.deepdive.helloworld.objects;

import com.google.gson.annotations.SerializedName;

/**
 * Created by zaryn on 7/20/2017.
 */

public class Image {
  @SerializedName("id")
  String id;
  @SerializedName("title")
  String title;
  @SerializedName("description")
  String description;
  @SerializedName("link")
  String link;
  @SerializedName("datetime")
  String datetime;
  @SerializedName("views")
  String views;
  @SerializedName("score")
  String score;

  public String getId() {
    return id;
  }

  public String getTitle() {
    return title;
  }

  public String getDescription() {
    return description;
  }

  public String getLink() {
    return link;
  }

  public String getDatetime() {
    return datetime;
  }

  public String getViews() {
    return views;
  }

  public String getScore() {
    return score;
  }
}
