package com.izzanmutik.herbalifemvp.detailPenyakit;

import android.util.Log;

import com.izzanmutik.herbalifemvp.model.Penyakit;

/**
 * Created by Aizen on 18 Jul 2017.
 */

public class DetailPenyakitPresenter implements DetailPenyakitContract.Presenter {

    private final DetailPenyakitContract.View mView;

    private long penyakitId;

    public DetailPenyakitPresenter(DetailPenyakitContract.View mView, long penyakitId) {
        this.mView = mView;
        mView.setPresenter(this);

        this.penyakitId = penyakitId;
    }

    @Override
    public void loadKatalog(long id) {
        Penyakit mPenyakit = Penyakit.load(Penyakit.class, id);

        Log.i("NAMA_PENYAKIT", mPenyakit.getNama());
        mView.showBahanObat(mPenyakit.getBahanObat());
        mView.showTutorial(mPenyakit.getTutorial());
    }

    @Override
    public void start() {
        loadKatalog(penyakitId);
    }
}
