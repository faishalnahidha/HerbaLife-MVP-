package com.izzanmutik.herbalifemvp.detailKatalog;

import com.izzanmutik.herbalifemvp.BasePresenter;
import com.izzanmutik.herbalifemvp.BaseView;

/**
 * Created by Aizen on 18 Jul 2017.
 */

public interface DetailKatalogContract {

    interface View extends BaseView<Presenter>{

        void showNamaTumbuhan(String namaTumbuhan);

        void showKegunaan(String kegunaan);
    }

    interface Presenter extends BasePresenter{

        void loadKatalog(long id);


    }
}
