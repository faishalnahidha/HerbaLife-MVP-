package com.izzanmutik.herbalifemvp.katalog;

import android.support.annotation.NonNull;

import com.izzanmutik.herbalifemvp.BasePresenter;
import com.izzanmutik.herbalifemvp.BaseView;
import com.izzanmutik.herbalifemvp.model.Katalog;

import java.util.List;

/**
 * Created by Aizen on 16 Jul 2017.
 */

public interface KatalogContract {

    interface View extends BaseView<Presenter> {

        void showKatalog(List<Katalog> katalogList);

        void showDetailKatalog(long id);
    }

    interface Presenter extends BasePresenter {

        void loadKatalog();

        void openDetailKatalog(@NonNull Katalog katalog);
    }
}
