package com.example.appthibanglaixe.Activity;

import android.app.Activity;
import android.app.DownloadManager;
import android.app.VoiceInteractor;
import android.content.Context;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonArrayRequest;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.appthibanglaixe.Adapter.Cauhoi_traloiAdapter;
import com.example.appthibanglaixe.R;
import com.example.appthibanglaixe.data.DbContract;
import com.example.appthibanglaixe.data.sqDuLieu;
import com.example.appthibanglaixe.entity.modify;
import com.example.appthibanglaixe.model.bode;
import com.example.appthibanglaixe.model.cauhoi_traloi;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Timer;
import java.util.TimerTask;

public class Tab_Test_Fragment extends Fragment {
    Toolbar toobar;
    ListView lstthisathoach;
    ArrayList<bode> arrayListcauhoi;
    Cauhoi_traloiAdapter cauhoiTraloiAdapter;
    sqDuLieu  data;
    int index = -1;
    Context context;
    ArrayList<cauhoi_traloi> arrayList1;
    private int mpage = 1;
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private String mParam1;
    private String mParam2;

    public Tab_Test_Fragment() {
    }

    public static Tab_Test_Fragment newInstance(String param1, String param2) {
        Tab_Test_Fragment fragment = new Tab_Test_Fragment();
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
        View view = inflater.inflate(R.layout.fragment_tab__test_,container,false);
        toobar = view.findViewById(R.id.ftt_toobar_thisathoach);

        lstthisathoach = view.findViewById(R.id.ftt_resview);
        sqDuLieu data = new sqDuLieu(getActivity());
        ArrayList<bode> valuse = data.getDuLieuBoDe();
        arrayListcauhoi = valuse;
        cauhoiTraloiAdapter = new Cauhoi_traloiAdapter(getActivity(), arrayListcauhoi);
        lstthisathoach.setAdapter(cauhoiTraloiAdapter);


        lstthisathoach.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                index = position + 1;
                sendata(index,position);
            }

            private void sendata(int i,int position) {
                if(valuse.get(position).getKetqua().isEmpty()){
                    Intent intent = new Intent(getActivity(), SatHoachActivity.class);
                    intent.putExtra("data",i);
                    startActivity(intent);
                }
                else {
                    Intent intent = new Intent(getActivity(), KetQuaThiActivity.class);
                    intent.putExtra("bode",i);
                    startActivity(intent);
                }
            }
        });
        return view;
    }
}