package com.uninorte.proyecto1_final.fragmentos;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.uninorte.proyecto1_final.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class fragmento_rubrica extends Fragment {


    public fragmento_rubrica() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_fragmento_rubrica, container, false);
    }

}
