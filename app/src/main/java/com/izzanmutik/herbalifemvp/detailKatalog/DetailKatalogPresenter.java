package com.izzanmutik.herbalifemvp.detailKatalog;

import android.util.Log;

import com.izzanmutik.herbalifemvp.model.Katalog;

/**
 * Created by Aizen on 18 Jul 2017.
 */

public class DetailKatalogPresenter implements DetailKatalogContract.Presenter {

    private final DetailKatalogContract.View mDetailKatalogView;

    private long tumbuhanId;

    public DetailKatalogPresenter(DetailKatalogContract.View detailKatalogView, long tumbuhanId) {
        this.mDetailKatalogView = detailKatalogView;
        mDetailKatalogView.setPresenter(this);

        this.tumbuhanId = tumbuhanId;
    }

    @Override
    public void loadKatalog(long id) {
        Katalog mKatalog = Katalog.load(Katalog.class, id);

        Log.i("NAMA_TUMBUHAN", mKatalog.getNama());
        //mDetailKatalogView.showNamaTumbuhan(mKatalog.getNama().toString());
        mDetailKatalogView.showKegunaan(mKatalog.getKegunaan());
    }

    @Override
    public void start() {
        loadKatalog(tumbuhanId);
    }
}
