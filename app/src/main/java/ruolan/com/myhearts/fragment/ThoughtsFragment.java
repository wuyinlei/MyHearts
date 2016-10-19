package ruolan.com.myhearts.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import ruolan.com.myhearts.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ThoughtsFragment extends Fragment {



    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_thoughts, container, false);
    }

}
