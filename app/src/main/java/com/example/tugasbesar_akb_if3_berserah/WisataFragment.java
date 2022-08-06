package com.example.tugasbesar_akb_if3_berserah;

//Tanggal Pengerjaan : 4 Agustus 2022
//NIM   : 10119107
//Nama  : Bagas Eko Pambudi
//NIM   : 10119093
//Nama  : Rafli Solihudin
//Kelas : IF-3

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link WisataFragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class WisataFragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public WisataFragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment WisataFragment.
     */
    // TODO: Rename and change types and number of parameters
    public static WisataFragment newInstance(String param1, String param2) {
        WisataFragment fragment = new WisataFragment();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
//         Inflate the layout for this fragment
        View view =LayoutInflater.from(getContext()).inflate(R.layout.fragment_wisata, container, false);

        RecyclerView recyclerView =(RecyclerView) view.findViewById(R.id.recyclerViewList);
        new Firebasehelper().readWisata(new Firebasehelper.DataStatus() {
            @Override
            public void dataIsLoaded(List<Wisata> listWisata, List<String> keys) {
                new RV_Config().setConfig(recyclerView, getContext(), listWisata, keys);
            }

            @Override
            public void dataIsInserted() {

            }

            @Override
            public void dataIsUpdated() {

            }

            @Override
            public void dataIsDeleted() {

            }
        });
        return view;
    }
}