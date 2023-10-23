package com.example.appthibanglaixe.Activity.FragmentBienBao;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

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


public class BienHieuLenhFragment extends Fragment {
    ListView lstbienbaohieulenh;
    ArrayList<bienbao> arrayListBienBao;
    BienBaoAdapter bienBaoAdapter;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public BienHieuLenhFragment() {
    }

    public static BienHieuLenhFragment newInstance(String param1, String param2) {
        BienHieuLenhFragment fragment = new BienHieuLenhFragment();
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
        View view = inflater.inflate(R.layout.fragment_bien_hieu_lenh, container, false);
        lstbienbaohieulenh = view.findViewById(R.id.fbh_lst_bienbaohieuhenh);
        ArrayList<bienbao> arraybienbao1 = new ArrayList<>();
        arraybienbao1.add(new bienbao(R.drawable.r301b,"Đường một chiều bên phải"));
        arraybienbao1.add(new bienbao(R.drawable.r301c,"Đường một chiều bên trái"));
        arraybienbao1.add(new bienbao(R.drawable.r301d,"Quẹo phải"));
        arraybienbao1.add(new bienbao(R.drawable.r301e,"Quẹo trái"));
        arraybienbao1.add(new bienbao(R.drawable.i405a,"Đường cụt bên phải"));
        arraybienbao1.add(new bienbao(R.drawable.i409,"Được phép quay đầu xe"));
        arraybienbao1.add(new bienbao(R.drawable.i424a,"Cầu vượt qua đường cho người đi bộ"));

        bienBaoAdapter = new BienBaoAdapter(getActivity(), arraybienbao1);
        lstbienbaohieulenh.setAdapter(bienBaoAdapter);
        return view;
    }

}