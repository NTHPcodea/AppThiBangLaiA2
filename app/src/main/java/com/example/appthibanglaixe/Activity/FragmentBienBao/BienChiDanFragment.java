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

public class BienChiDanFragment extends Fragment {
    ListView lstbienbaochidan;
    ArrayList<bienbao> arrayListBienBaoChiDan;
    BienBaoAdapter bienBaoAdapter;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public BienChiDanFragment() {
    }

    public static BienChiDanFragment newInstance(String param1, String param2) {
        BienChiDanFragment fragment = new BienChiDanFragment();
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
        View view = inflater.inflate(R.layout.fragment_bien_chi_dan, container, false);
        lstbienbaochidan = view.findViewById(R.id.fbc_lst_bienbaochidan);
        ArrayList<bienbao> arraybienbao1 = new ArrayList<>();
        arraybienbao1.add(new bienbao(R.drawable.r301a,"Xe chỉ được đi thẳng"));
        arraybienbao1.add(new bienbao(R.drawable.r301b,"Xe chỉ được rẽ phải"));
        arraybienbao1.add(new bienbao(R.drawable.r301c,"Xe chỉ được rẽ trái"));
        arraybienbao1.add(new bienbao(R.drawable.r301d,"Xe chỉ được rẽ phải"));
        arraybienbao1.add(new bienbao(R.drawable.r301e,"Xe chỉ được rẽ trái"));
        arraybienbao1.add(new bienbao(R.drawable.i405a,"Đường cụt bên phải"));
        arraybienbao1.add(new bienbao(R.drawable.r303,"Nơi giao nhau chạy theo vòng xuyến"));
        arraybienbao1.add(new bienbao(R.drawable.r305,"Đường dành cho người đi bộ"));
        arraybienbao1.add(new bienbao(R.drawable.r306,"Tốc độ tối thiểu cho phép"));
        arraybienbao1.add(new bienbao(R.drawable.r307,"Hết tốc độ tối thiểu cho phép"));

        bienBaoAdapter = new BienBaoAdapter(getActivity(), arraybienbao1);
        lstbienbaochidan.setAdapter(bienBaoAdapter);
        return view;
    }


}