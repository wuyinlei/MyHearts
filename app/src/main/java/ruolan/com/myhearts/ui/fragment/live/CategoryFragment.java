package ruolan.com.myhearts.ui.fragment.live;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ruolan.com.myhearts.R;
import ruolan.com.myhearts.contant.Contants;
import ruolan.com.myhearts.contant.HttpUrlPaths;

/**
 * A simple {@link Fragment} subclass.
 */
public class CategoryFragment extends Fragment {


    private int mIndex;
    private String url;

    public static CategoryFragment newInstance(int index) {
        // Required empty public constructor
        Bundle bundle = new Bundle();
        bundle.putInt(Contants.INDEX,index);
        CategoryFragment fragment = new CategoryFragment();
        fragment.setArguments(bundle);
        return fragment;
    }



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_category, container, false);
        mIndex = getArguments().getInt(Contants.INDEX);
        if (mIndex == 0){
            url = HttpUrlPaths.getDouyuLiveChannel();
        } else {
            url = HttpUrlPaths.getDouyuSubChannelBaseTag(mIndex);
        }
      //  Log.d("CategoryFragment", url);

        return view;
    }

}
