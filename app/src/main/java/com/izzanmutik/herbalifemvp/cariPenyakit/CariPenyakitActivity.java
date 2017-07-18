package com.izzanmutik.herbalifemvp.cariPenyakit;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

import com.izzanmutik.herbalifemvp.R;
import com.izzanmutik.herbalifemvp.detailPenyakit.DetailPenyakitActivity;

public class CariPenyakitActivity extends AppCompatActivity
implements CariPenyakitContract.View{

    private CariPenyakitContract.Presenter mPresenter;

    private AutoCompleteTextView actv;

    private String[] items = { "Batuk Pada Anak", "Sakit Perut","Diare","Mual",
            "Kembung","Wasir","Biduran",
            "Demam","Step","Kencing Batu","Radang Paru-paru","Asma","Mimisan","Hepatitis",
            "Prostat","Keputihan","Diabetes Melitus","Bisul","Jerawat","Gatal berupa bintik-bintik merah bergelembung air",
            "Gatal pada bekas luka yang sudah kering","Nyeri haid","Haid bau anyir","Batuk Kering","Sariawan","Campak",
            "Borok","Jantung Lemah","Gangguan saraf","Rematik","Demam Pada Anak","Masuk Angin","Disentri","Hipertensi",
            "Diabetes","Kutu Air","Sakit Kepala","Flu","Bronkitis","Cacingan","Migrain","Maag","Cantengan","Osteoporosis"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cari_penyakit);

        final ActionBar mActionBar = getSupportActionBar();
        mActionBar.setDisplayHomeAsUpEnabled(true);
        mActionBar.setTitle("Cari Penyakit");

        actv = (AutoCompleteTextView) findViewById(R.id.cariPenyakit_actv);

        mPresenter = new CariPenyakitPresenter(this);
        mPresenter.start();
    }

    @Override
    public void setupAutoCompleteAdapter() {
        final ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>
                (this, android.R.layout.simple_list_item_1, items);
        actv.setAdapter(arrayAdapter);
        actv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String namaPenyakit = actv.getText().toString();
                mPresenter.openDetailPenyakit(namaPenyakit);
            }
        });
    }

    @Override
    public void showDetailPenyakit(long id, String nama) {
        Intent intent = new Intent(CariPenyakitActivity.this, DetailPenyakitActivity.class);
        intent.putExtra("PENYAKIT_ID", id);
        intent.putExtra("NAMA_PENYAKIT", nama);
        startActivity(intent);
    }

    @Override
    public void setPresenter(CariPenyakitContract.Presenter presenter) {
        mPresenter = presenter;
    }

    @Override
    public boolean onSupportNavigateUp(){
        finish();
        return true;
    }
}
