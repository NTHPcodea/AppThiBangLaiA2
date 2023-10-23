package com.example.appthibanglaixe.Activity.FragmentBienBao;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.Volley;
import com.example.appthibanglaixe.Adapter.BienBaoAdapter;
import com.example.appthibanglaixe.R;
import com.example.appthibanglaixe.model.bienbao;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;

public class BienbaoCamFragment extends Fragment {
    ArrayList<bienbao> arraybienbao1;
    ListView lstbienbaocam;
    BienBaoAdapter bienBaoAdapter;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public BienbaoCamFragment() {
    }

    public static BienbaoCamFragment newInstance(String param1, String param2) {
        BienbaoCamFragment fragment = new BienbaoCamFragment();
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

        View view = inflater.inflate(R.layout.fragment_bienbao_cam,container, false);
        lstbienbaocam = view.findViewById(R.id.fb_lstbienbaocam);
        ArrayList<bienbao> arraybienbao1 = new ArrayList<>();
        arraybienbao1.add(new bienbao(R.drawable.bienbaoduongcam,"Đường cấm"));
        arraybienbao1.add(new bienbao(R.drawable.hinhshtruot,"Cấm đi ngược chiều"));
        arraybienbao1.add(new bienbao(R.drawable.bienbaocammoto, "Cấm xe Moto"));
        arraybienbao1.add(new bienbao(R.drawable.camotovamoto, "Cấm xe Moto và Oto"));
        arraybienbao1.add(new bienbao(R.drawable.camotorephai, "Cấm xe Oto rẽ phải"));
        arraybienbao1.add(new bienbao(R.drawable.camotoretrai, "Cấm xe Oto rẽ trái"));
        arraybienbao1.add(new bienbao(R.drawable.camxeoto, "Cấm xe Oto"));
        arraybienbao1.add(new bienbao(R.drawable.camquaydauxe, "Cấm quay đầu"));
        arraybienbao1.add(new bienbao(R.drawable.camotoquaydau, "Cấm Oto quay đầu"));
        arraybienbao1.add(new bienbao(R.drawable.camototai, "Cấm Oto tải"));
        arraybienbao1.add(new bienbao(R.drawable.p127, "Cấm vượt quá 50km/h"));



        bienBaoAdapter = new BienBaoAdapter(getActivity(),arraybienbao1);
        lstbienbaocam.setAdapter(bienBaoAdapter);
        return view;

    }

}