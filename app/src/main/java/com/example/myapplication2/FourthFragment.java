package com.example.myapplication2;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

public class FourthFragment extends Fragment implements View.OnClickListener {
    TextView p4h;
    TextView p4f;
    private HistoryFragment historyFragment;
    private FavoritesFragment favoritesFragment;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_fourth, container, false);
        p4h = view.findViewById(R.id.nav_history);
        p4f = view.findViewById(R.id.nav_favorites);
        selectedFragment(0); // 默认显示第一个Fragment
        p4h.setOnClickListener(this);
        p4f.setOnClickListener(this);
        view.findViewById(R.id.nav_history_icon).setOnClickListener(this);
        view.findViewById(R.id.nav_favorites_icon).setOnClickListener(this);

        // 设置默认选中状态
        p4h.setSelected(true);
        view.findViewById(R.id.nav_history_icon).setSelected(true);
        p4f.setSelected(false);
        view.findViewById(R.id.nav_favorites_icon).setSelected(false);

        return view;
    }

    private void selectedFragment(int position) {
        FragmentManager fragmentManager = getChildFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();

        // 先隐藏所有 Fragment
        hideFragment(fragmentTransaction);

        // 显示目标 Fragment
        Fragment targetFragment = null;
        if (position == 0) {
            if (historyFragment == null) {
                historyFragment = new HistoryFragment();
            }
            targetFragment = historyFragment;
        } else if (position == 1) {
            if (favoritesFragment == null) {
                favoritesFragment = new FavoritesFragment();
            }
            targetFragment = favoritesFragment;
        }

        if (targetFragment != null) {
            if (targetFragment.isAdded()) {
                fragmentTransaction.show(targetFragment);
            } else {
                fragmentTransaction.add(R.id.mine_container, targetFragment);
            }
        }
        fragmentTransaction.commit();
    }

    private void hideFragment(FragmentTransaction fragmentTransaction) {
        if (historyFragment != null) {
            fragmentTransaction.hide(historyFragment);
        }
        if (favoritesFragment != null) {
            fragmentTransaction.hide(favoritesFragment);
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == R.id.nav_history || id == R.id.nav_history_icon) {
            onHistoryClick();
            selectedFragment(0);
        } else if (id == R.id.nav_favorites || id == R.id.nav_favorites_icon) {
            onFavoritesClick();
            selectedFragment(1);
        }
    }

    public void onHistoryClick() {
        getView().findViewById(R.id.nav_history_icon).setSelected(true);
        p4h.setSelected(true);
        getView().findViewById(R.id.nav_favorites_icon).setSelected(false);
        p4f.setSelected(false);
    }

    public void onFavoritesClick() {
        getView().findViewById(R.id.nav_history_icon).setSelected(false);
        p4h.setSelected(false);
        getView().findViewById(R.id.nav_favorites_icon).setSelected(true);
        p4f.setSelected(true);
    }
}