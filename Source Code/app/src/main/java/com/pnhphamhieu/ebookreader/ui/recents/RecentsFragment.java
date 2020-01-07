package com.pnhphamhieu.ebookreader.ui.recents;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.pnhphamhieu.ebookreader.MainActivity;
import com.pnhphamhieu.ebookreader.R;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import java.util.ArrayList;


public class RecentsFragment extends Fragment {

    private RecentsViewModel recentsViewModel;
    ArrayList<MainActivity.Product> listRecent;
    MainActivity.RecentListViewAdapter recentListViewAdapter;
    ListView listViewRecent;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        listRecent = new ArrayList<>();
        listRecent.add(new MainActivity.Product(1, "Iphone 6", 500));
        listRecent.add(new MainActivity.Product(2, "Iphone 7", 700));
        listRecent.add(new MainActivity.Product(3, "Sony Abc", 800));
        listRecent.add(new MainActivity.Product(4, "Samsung XYZ", 900));
        listRecent.add(new MainActivity.Product(5, "SP 5", 500));
        listRecent.add(new MainActivity.Product(6, "SP 6", 700));
        listRecent.add(new MainActivity.Product(7, "SP 7", 800));
        listRecent.add(new MainActivity.Product(8, "SP 8", 900));

        recentListViewAdapter = new MainActivity.RecentListViewAdapter(listRecent);
        listViewRecent = listViewRecent.findViewById(R.id.listrecent);
        listViewRecent.setAdapter(recentListViewAdapter);
    }

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        recentsViewModel =
                ViewModelProviders.of(this).get(RecentsViewModel.class);
        View root = inflater.inflate(R.layout.fragment_recents, container, false);

        recentsViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {

            }
        });
        return root;
    }




}