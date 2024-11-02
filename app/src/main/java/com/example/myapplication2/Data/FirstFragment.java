package com.example.myapplication2.Data;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.myapplication2.FirstFragment_next;
import com.example.myapplication2.FirstFragment_origin;
import com.example.myapplication2.R;


public class FirstFragment extends Fragment implements View.OnClickListener{
    TextView p1s1;
    TextView p1s2;
    private FirstFragment_origin firstFragment_origin;
    private FirstFragment_next firstFragment_next;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_first, container, false);
        p1s1 = view.findViewById(R.id.subpage1);
        p1s2 = view.findViewById(R.id.subpage2);
        selectedFragment(0);
        p1s1.setOnClickListener(this);
        p1s2.setOnClickListener(this);

        return view;
    }

    private void selectedFragment(int position) {
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        hideFragment(fragmentTransaction);
        if (position == 0) {
            if (firstFragment_origin == null) {
                firstFragment_origin = new FirstFragment_origin();
                fragmentTransaction.add(R.id.container, firstFragment_origin);
            } else {
                fragmentTransaction.show(firstFragment_origin);
            }
        } else {
            if (firstFragment_next == null) {
                firstFragment_next = new FirstFragment_next();
                fragmentTransaction.add(R.id.container, firstFragment_next);
            } else {
                fragmentTransaction.show(firstFragment_next);
                //mMeFragment.refreshData();
            }
        }
        fragmentTransaction.commit();
    }

    private void hideFragment(FragmentTransaction fragmentTransaction){
        if(firstFragment_origin != null){
            fragmentTransaction.hide(firstFragment_origin);
        }
        if(firstFragment_next !=null){
            fragmentTransaction.hide(firstFragment_next);
        }
    }

    @Override
    public void onClick(View v) {
        //跳转到别的activity
        if(v.getId() == R.id.subpage1){
            selectedFragment(0);
        }
        else if(v.getId() == R.id.subpage2){
            selectedFragment(1);
        }
    }


}