package com.izzanmutik.herbalifemvp.cariPenyakit;

import android.support.annotation.NonNull;

import com.izzanmutik.herbalifemvp.model.Penyakit;

/**
 * Created by Aizen on 18 Jul 2017.
 */

public class CariPenyakitPresenter implements CariPenyakitContract.Presenter {

    private CariPenyakitContract.View mView;

    public CariPenyakitPresenter(CariPenyakitContract.View mView) {
        this.mView = mView;
        mView.setPresenter(this);
    }

    @Override
    public void openDetailPenyakit(@NonNull String namaPenyakit) {
        Penyakit mPenyakit = Penyakit.getByNama(namaPenyakit);
        if (mPenyakit != null) {
            mView.showDetailPenyakit(mPenyakit.getPenyakitId(), mPenyakit.getNama());
        }
    }

    @Override
    public void start() {
        mView.setupAutoCompleteAdapter();
    }
}
