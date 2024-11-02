package com.example.myapplication2.Data;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.myapplication2.R;
import com.example.myapplication2.TimelineAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

public class FirstFragment_next extends Fragment {
    private RecyclerView Rv;
    private ArrayList<Map<String,Object>> listItem;
    private TimelineAdapter timelineAdapter;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first_next, container, false);

        // 初始化显示的数据
        initData();
        // 绑定数据到RecyclerView
        initView(view);

        return view;
    }

    // 初始化显示的数据
    public void initData(){
        listItem = new ArrayList<>();/*在数组中存放数据*/
        for (int i = 0; i < 10; ++i) {
            Map<String, Object> map = new HashMap<>();
            map.put("ItemIcon",R.drawable.mudanting);
            map.put("ItemTitle", "title_title_title " + i);
            map.put("ItemText1", "time " + i);
            map.put("ItemText2", "place" + i);
            map.put("ItemPrice", i+"");
            map.put("ItemDate","2024.11."+i);
            listItem.add(map);
        }
    }

    // 绑定数据到RecyclerView
    public void initView(View view){
        Rv = (RecyclerView) view.findViewById(R.id.my_recycler_view);
        //为ListView绑定适配器
        timelineAdapter = new TimelineAdapter(this.getActivity(),listItem);
        Rv.setLayoutManager(new LinearLayoutManager(this.getActivity()));
        Rv.setAdapter(timelineAdapter);
    }
}