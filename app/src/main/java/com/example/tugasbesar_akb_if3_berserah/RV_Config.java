package com.example.tugasbesar_akb_if3_berserah;

//Tanggal Pengerjaan : 2 Agustus 2022
//NIM   : 10119107
//Nama  : Bagas Eko Pambudi
//NIM   : 10119093
//Nama  : Rafli Solihudin
//NIM   : 10119095
//Nama  : Ariq Alhafizh
//Kelas : IF-3

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RV_Config {
    private Context mcontext;
    private WisataAdapter wisataAdapter;
    public void setConfig(RecyclerView recyclerView, Context context, List<Wisata> listWisata, List<String> keys){
        mcontext = context;
        wisataAdapter = new WisataAdapter(listWisata, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(wisataAdapter);
    }

    class WisataItemView extends RecyclerView.ViewHolder {

        private TextView txtNama;
        private TextView txtLokasi;

        private String key;

        public WisataItemView(ViewGroup parent) {
            super(LayoutInflater.from(mcontext).inflate(R.layout.layout_item, parent, false));
            txtNama = (TextView) itemView.findViewById(R.id.txt_nama);
            txtLokasi = (TextView) itemView.findViewById(R.id.txt_lokasi);

        }

        public void bind(Wisata wisata, String key){
            txtNama.setText(wisata.getNama());
            txtLokasi.setText(wisata.getLokasi());
            this.key = key;
        }
    }
    class WisataAdapter extends RecyclerView.Adapter<WisataItemView>{
        private List<Wisata> listWisata;
        private List<String> keys;

        public WisataAdapter(List<Wisata> listWisata, List<String> keys) {
            this.listWisata = listWisata;
            this.keys = keys;
        }

        @NonNull
        @Override
        public WisataItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new WisataItemView(parent) ;
        }

        @Override
        public void onBindViewHolder(@NonNull WisataItemView holder, int position) {
            holder.bind(listWisata.get(position), keys.get(position));
        }

        @Override
        public int getItemCount() {
            return listWisata.size();
        }
    }
}
