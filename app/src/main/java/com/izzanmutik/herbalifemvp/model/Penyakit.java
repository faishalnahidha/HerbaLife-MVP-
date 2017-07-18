package com.izzanmutik.herbalifemvp.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by Aizen on 16 Jul 2017.
 */

@Table(name = "Data_Penyakit", id = "PenyakitID")
public class Penyakit extends Model {

    @Column(name = "PenyakitID")
    private long penyakitId;

    @Column(name = "Nama")
    private String nama;

    @Column(name = "BahanObat")
    private String bahanObat;

    @Column(name = "Tutorial")
    private String tutorial;

    public Penyakit(long penyakitId, String nama, String bahanObat, String tutorial) {
        super();
        this.penyakitId = penyakitId;
        this.nama = nama;
        this.bahanObat = bahanObat;
        this.tutorial = tutorial;
    }

    public Penyakit() {
        super();
    }

    public long getPenyakitId() {
        return penyakitId;
    }

    public void setPenyakitId(long penyakitId) {
        this.penyakitId = penyakitId;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getBahanObat() {
        return bahanObat;
    }

    public void setBahanObat(String bahanObat) {
        this.bahanObat = bahanObat;
    }

    public String getTutorial() {
        return tutorial;
    }

    public void setTutorial(String tutorial) {
        this.tutorial = tutorial;
    }

    public static List<Penyakit> getAll() {
        // This is how you execute a query
        return new Select()
                .from(Penyakit.class)
                .orderBy("PenyakitID ASC")
                .execute();
    }

    public static Penyakit getRandom() {
        return new Select()
                .from(Penyakit.class)
                .orderBy("RANDOM()")
                .executeSingle();
    }

    public static Penyakit getByNama(String namaPenyakit) {
        return new Select()
                .from(Penyakit.class)
                .where("Nama = ?", namaPenyakit)
                .executeSingle();
    }
}
