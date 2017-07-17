package com.izzanmutik.herbalifemvp.penyakit;

import android.support.annotation.NonNull;

import com.izzanmutik.herbalifemvp.model.Penyakit;

import java.util.List;

/**
 * Created by Aizen on 17 Jul 2017.
 */

public class PenyakitPresenter implements PenyakitContract.Presenter{

    private final PenyakitContract.View mPenyakitView;

    public PenyakitPresenter(PenyakitContract.View mPenyakitView) {
        this.mPenyakitView = mPenyakitView;
        mPenyakitView.setPresenter(this);
    }

    @Override
    public void loadKPenyakit() {
        List<Penyakit> mPenyakitList;
        mPenyakitList = Penyakit.getAll();

        mPenyakitView.showPenyakitList(mPenyakitList);
    }

    @Override
    public void openDetailPenyakit(@NonNull Penyakit penyakit) {
        mPenyakitView.showDetailPenyakit(penyakit.getPenyakitId());
    }

    @Override
    public void start() {
        loadKPenyakit();
    }
}
