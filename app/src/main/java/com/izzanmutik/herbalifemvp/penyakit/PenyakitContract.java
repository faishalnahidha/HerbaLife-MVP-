package com.izzanmutik.herbalifemvp.penyakit;

import android.support.annotation.NonNull;

import com.izzanmutik.herbalifemvp.BasePresenter;
import com.izzanmutik.herbalifemvp.BaseView;
import com.izzanmutik.herbalifemvp.model.Penyakit;

import java.util.List;

/**
 * Created by Aizen on 17 Jul 2017.
 */

public interface PenyakitContract {

    interface View extends BaseView<Presenter> {

        void showPenyakitList(List<Penyakit> katalogList);

        void showDetailPenyakit(long id);
    }

    interface Presenter extends BasePresenter {

        void loadKPenyakit();

        void openDetailPenyakit(@NonNull Penyakit penyakit);
    }
}
