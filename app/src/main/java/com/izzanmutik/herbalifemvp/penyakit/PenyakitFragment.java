package com.izzanmutik.herbalifemvp.penyakit;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.izzanmutik.herbalifemvp.R;
import com.izzanmutik.herbalifemvp.model.Penyakit;

import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 */
public class PenyakitFragment extends Fragment implements PenyakitContract.View{

    private PenyakitContract.Presenter mPresenter;

    private PenyakitAdapter mAdapter;

    private RecyclerView mRecyclerView;

    public PenyakitFragment() {
        // Required empty public constructor
    }

    

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_penyakit, container, false);
    }

    @Override
    public void showPenyakitList(List<Penyakit> katalogList) {

    }

    @Override
    public void showDetailPenyakit(long id) {

    }

    @Override
    public void setPresenter(PenyakitContract.Presenter presenter) {

    }
}
