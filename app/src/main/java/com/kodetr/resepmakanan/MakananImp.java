package com.kodetr.resepmakanan;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class MakananImp extends SQLiteOpenHelper implements MakananInterface {

    private String NAMA_TBL = "tbl_makanan";

    public MakananImp(Context context) {
        super(context, "db_makanan", null, 1);
    }

    @Override
    public void onCreate(SQLiteDatabase sql) {
        sql.execSQL("CREATE TABLE '" + NAMA_TBL + "'(id INTEGER, nama TEXT, gambar TEXT, harga INTEGER, diskon INTEGER)");

        sql.execSQL("INSERT INTO '" + NAMA_TBL + "' VALUES(1, 'Pelecing Urap', 'https://img-global.cpcdn.com/recipes/00c15ce406741f9b/751x532cq70/pelecing-kangkung-khas-lombok-foto-resep-utama.jpg')");
        sql.execSQL("INSERT INTO '" + NAMA_TBL + "' VALUES(2, 'Bakso Lava', 'https://awsimages.detik.net.id/community/media/visual/2019/03/11/96e1fd79-41a6-4c82-8006-ef592a3c6f8d.jpeg?w=700&q=90')");

    }

    @Override
    public void onUpgrade(SQLiteDatabase sql, int i, int i1) {
        sql.execSQL("DROP TABLE '" + NAMA_TBL + "'");
    }

    @Override
    public Cursor read() {
        SQLiteDatabase sql = getReadableDatabase();
        return sql.rawQuery("SELECT * FROM '" + NAMA_TBL + "'", null);
    }

    @Override
    public void create(ResepMakanan makanan) {
        SQLiteDatabase sql = getWritableDatabase();
        sql.execSQL("INSERT INTO '" + NAMA_TBL + "' VALUES ('" + makanan.getId() + "', '" + makanan.getNama_makanan() + "', '" + makanan.getGambar() + "'");
    }

    @Override
    public void update(ResepMakanan makanan) {
        SQLiteDatabase sql = getWritableDatabase();
        sql.execSQL("UPDATE '" + NAMA_TBL + "' SET nama='" + makanan.getNama_makanan() + "', gambar='" + makanan.getGambar() + "'");
    }

    @Override
    public void delete(int id) {
        SQLiteDatabase sql = getWritableDatabase();
        sql.execSQL("DELETE FROM '" + NAMA_TBL + "' WHERE id='" + id + "'");
    }
}
