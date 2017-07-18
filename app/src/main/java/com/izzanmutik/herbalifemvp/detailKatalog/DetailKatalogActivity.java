package com.izzanmutik.herbalifemvp.detailKatalog;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.izzanmutik.herbalifemvp.R;

public class DetailKatalogActivity extends AppCompatActivity
        implements DetailKatalogContract.View{

    private long tumbuhanId;

    private String namaTumbuhan;

    private ActionBar mActionBar;

    private DetailKatalogContract.Presenter mPresenter;

    private TextView textViewKegunaan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_katalog);

        textViewKegunaan = (TextView) findViewById(R.id.detailKatalog_textViewKegunaan);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.tumbuhanId = extras.getLong("TUMBUHAN_ID");
            this.namaTumbuhan = extras.getString("NAMA_TUMBUHAN");
        }

        mPresenter = new DetailKatalogPresenter(this, tumbuhanId);
        mPresenter.start();

        mActionBar = getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setTitle(namaTumbuhan);

    }

    @Override
    public void showNamaTumbuhan(String namaTumbuhan) {
        mActionBar.setTitle(namaTumbuhan);
    }

    @Override
    public void showKegunaan(String kegunaan) {
        textViewKegunaan.setText(kegunaan);
    }

    @Override
    public void setPresenter(DetailKatalogContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
