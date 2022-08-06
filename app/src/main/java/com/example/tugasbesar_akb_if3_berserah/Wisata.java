package com.example.tugasbesar_akb_if3_berserah;

//Tanggal Pengerjaan : 1 Agustus 2022
//NIM   : 10119107
//Nama  : Bagas Eko Pambudi
//NIM   : 10119093
//Nama  : Rafli Solihudin
//Kelas : IF-3

import com.google.firebase.database.Exclude;

import java.io.Serializable;

public class Wisata  {


    private String nama;
    private String lokasi;

    public Wisata(){}

        public Wisata(String nama, String lokasi) {
        this.nama = nama;
        this.lokasi = lokasi;

    }

    public String getNama()
    {
        return nama;
    }

    public void setNama(String nama)
    {
        this.nama = nama;
    }

    public String getLokasi()
    {
        return lokasi;
    }

    public void setLokasi(String lokasi)
    {
        this.lokasi = lokasi;
    }

}
