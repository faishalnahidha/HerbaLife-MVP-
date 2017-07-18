package com.izzanmutik.herbalifemvp.detailPenyakit;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

import com.izzanmutik.herbalifemvp.R;

public class DetailPenyakitActivity extends AppCompatActivity
        implements DetailPenyakitContract.View {

    private long penyakitId;

    private String namaPenyakit;

    private ActionBar mActionBar;

    private DetailPenyakitContract.Presenter mPresenter;

    private TextView textViewBahanObat;

    private TextView textViewCaraMembuat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_penyakit);

        textViewBahanObat = (TextView) findViewById(R.id.detailPenyakit_textViewBahanObat);
        textViewCaraMembuat = (TextView) findViewById(R.id.detailPenyakit_textViewCaraMembuat);

        Bundle extras = getIntent().getExtras();
        if (extras != null) {
            this.penyakitId = extras.getLong("PENYAKIT_ID");
            this.namaPenyakit = extras.getString("NAMA_PENYAKIT");
        }

        mPresenter = new DetailPenyakitPresenter(this, penyakitId);
        mPresenter.start();

        mActionBar = getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setTitle(namaPenyakit);
    }

    @Override
    public void showNamaPenyakit(String namaPenyakit) {
        mActionBar.setTitle(namaPenyakit);
    }

    @Override
    public void showBahanObat(String bahanObat) {
        textViewBahanObat.setText(bahanObat);
    }

    @Override
    public void showTutorial(String tutorial) {
        textViewCaraMembuat.setText(tutorial);
    }

    @Override
    public void setPresenter(DetailPenyakitContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
