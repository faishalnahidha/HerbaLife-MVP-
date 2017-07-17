package com.izzanmutik.herbalifemvp.model;

import com.activeandroid.Model;
import com.activeandroid.annotation.Column;
import com.activeandroid.annotation.Table;
import com.activeandroid.query.Select;

import java.util.List;

/**
 * Created by Aizen on 16 Jul 2017.
 */

@Table(name = "Katalog", id = "TumbuhanID")
public class Katalog extends Model {

    @Column(name = "TumbuhanID")
    private long tumbuhanId;

    @Column(name = "Nama")
    private String nama;

    @Column(name = "Kegunaan")
    private String kegunaan;

    public Katalog(long tumbuhanId, String nama, String kegunaan) {
        super();
        this.tumbuhanId = tumbuhanId;
        this.nama = nama;
        this.kegunaan = kegunaan;
    }

    public Katalog() {
        super();
    }

    public long getTumbuhanId() {
        return tumbuhanId;
    }

    public void setTumbuhanId(long tumbuhanId) {
        this.tumbuhanId = tumbuhanId;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getKegunaan() {
        return kegunaan;
    }

    public void setKegunaan(String kegunaan) {
        this.kegunaan = kegunaan;
    }

    public static List<Katalog> getAll() {
        // This is how you execute a query
        return new Select()
                .from(Katalog.class)
                .orderBy("TumbuhanID ASC")
                .execute();
    }

    public static Katalog getRandom() {
        return new Select()
                .from(Katalog.class)
                .orderBy("RANDOM()")
                .executeSingle();
    }
}
