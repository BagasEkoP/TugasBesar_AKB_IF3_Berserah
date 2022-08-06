package com.example.tugasbesar_akb_if3_berserah;

//Tanggal Pengerjaan : 4 Agustus 2022
//NIM   : 10119107
//Nama  : Bagas Eko Pambudi
//NIM   : 10119093
//Nama  : Rafli Solihudin
//Kelas : IF-3

import androidx.annotation.NonNull;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;

public class Firebasehelper {
    private FirebaseDatabase firebaseDatabase;
    private DatabaseReference databaseReference;
    List<Wisata> listwisata = new ArrayList<Wisata>();

    public interface DataStatus{
        void dataIsLoaded(List<Wisata> listWisata, List<String> keys);
        void dataIsInserted();
        void dataIsUpdated();
        void dataIsDeleted();
    }


    public Firebasehelper() {
        firebaseDatabase = FirebaseDatabase.getInstance();
        databaseReference = firebaseDatabase.getReference("Wisata");
    }

    public void readWisata(final DataStatus dataStatus){
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                listwisata.clear();
                List<String> keys = new ArrayList<String>();
                for (DataSnapshot keyNode: snapshot.getChildren()) {
                    keys.add(keyNode.getKey());
                    Wisata wisata = keyNode.getValue(Wisata.class);
                    listwisata.add(wisata);
                }
                dataStatus.dataIsLoaded(listwisata, keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }


        });
    }
}
