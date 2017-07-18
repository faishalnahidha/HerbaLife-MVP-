package com.izzanmutik.herbalifemvp.katalog;

import android.support.annotation.NonNull;

import com.izzanmutik.herbalifemvp.model.Katalog;

import java.util.List;

/**
 * Created by Aizen on 17 Jul 2017.
 */

public class KatalogPresenter implements KatalogContract.Presenter {

    private final KatalogContract.View mKatalogView;

    public KatalogPresenter(KatalogContract.View katalogView) {
        this.mKatalogView = katalogView;
        mKatalogView.setPresenter(this);
    }

    @Override
    public void loadKatalog() {
        List<Katalog> mKatalogList;
        mKatalogList = Katalog.getAll();

        mKatalogView.showKatalog(mKatalogList);
    }

    @Override
    public void openDetailKatalog(@NonNull Katalog katalog) {
        mKatalogView.showDetailKatalog(katalog.getTumbuhanId(), katalog.getNama());
    }

    @Override
    public void start() {
        loadKatalog();
    }

}
