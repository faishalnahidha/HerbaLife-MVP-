package com.izzanmutik.herbalifemvp.detailPenyakit;

import com.izzanmutik.herbalifemvp.BasePresenter;
import com.izzanmutik.herbalifemvp.BaseView;

/**
 * Created by Aizen on 18 Jul 2017.
 */

public interface DetailPenyakitContract {

    interface View extends BaseView<Presenter> {

        void showNamaPenyakit(String namaPenyakit);

        void showBahanObat(String bahanObat);

        void showTutorial(String tutorial);
    }

    interface Presenter extends BasePresenter {

        void loadKatalog(long id);

    }
}
