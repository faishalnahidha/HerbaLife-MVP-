package com.izzanmutik.herbalifemvp.cariPenyakit;

import android.support.annotation.NonNull;

import com.izzanmutik.herbalifemvp.BasePresenter;
import com.izzanmutik.herbalifemvp.BaseView;

/**
 * Created by Aizen on 18 Jul 2017.
 */

public interface CariPenyakitContract {

    interface View extends BaseView<Presenter> {

        void setupAutoCompleteAdapter();

        void showDetailPenyakit(long id, String nama);
    }

    interface Presenter extends BasePresenter {

        void openDetailPenyakit(@NonNull String namaPenyakit);
    }
}
