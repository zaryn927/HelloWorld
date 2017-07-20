package edu.cnm.deepdive.helloworld.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;

import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import edu.cnm.deepdive.helloworld.R;
import edu.cnm.deepdive.helloworld.adapters.ImageListAdapter;
import edu.cnm.deepdive.helloworld.api.API;
import edu.cnm.deepdive.helloworld.objects.GalleryResponse;
import edu.cnm.deepdive.helloworld.objects.Image;
import java.util.List;
import rx.SingleSubscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link ListFragment.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link ListFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ListFragment extends Fragment {


  private OnFragmentInteractionListener mListener;
  private ListView mListView;
  private Button mBtnRemoveFragment;

  public ListFragment() {
    // Required empty public constructor
  }

  /**
   * Use this factory method to create a new instance of
   * this fragment using the provided parameters.
   *
   * @return A new instance of fragment ListFragment.
   */
  // TODO: Rename and change types and number of parameters
  public static ListFragment newInstance() {
    ListFragment fragment = new ListFragment();
    Bundle args = new Bundle();
    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onActivityCreated(@Nullable Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    API.subredditGallery("cats")
        .subscribeOn(Schedulers.io())
        .observeOn(AndroidSchedulers.mainThread())
        .subscribe(new SingleSubscriber<GalleryResponse>() {
          @Override
          public void onSuccess(GalleryResponse value) {
            List<Image> data = value.getData();
            if (data != null) {
              ImageListAdapter adapter = new ImageListAdapter(
                  getContext(),
                  data
              );
              mListView.setAdapter(adapter);
            }
          }

          @Override
          public void onError(Throwable error) {
            error.printStackTrace();
          }
        });

  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    // Inflate the layout for this fragment
    View view = inflater.inflate(R.layout.fragment_list, container, false);
    mListView = (ListView)view.findViewById(R.id.fragmentList);
    mBtnRemoveFragment = (Button)view.findViewById(R.id.btnRemoveFragment);
    mBtnRemoveFragment.setOnClickListener(new OnClickListener() {
      @Override
      public void onClick(View v) {
        if (mListener != null) {
          mListener.onCloseClicked();
        }
      }
    });
    return view;
  }

  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
    if (context instanceof OnFragmentInteractionListener) {
      mListener = (OnFragmentInteractionListener) context;
    } else {
      throw new RuntimeException(context.toString()
          + " must implement OnFragmentInteractionListener");
    }
  }

  @Override
  public void onDetach() {
    super.onDetach();
    mListener = null;
  }

  /**
   * This interface must be implemented by activities that contain this
   * fragment to allow an interaction in this fragment to be communicated
   * to the activity and potentially other fragments contained in that
   * activity.
   * <p>
   * See the Android Training lesson <a href=
   * "http://developer.android.com/training/basics/fragments/communicating.html"
   * >Communicating with Other Fragments</a> for more information.
   */
  public interface OnFragmentInteractionListener {
    void onCloseClicked();
  }
}
