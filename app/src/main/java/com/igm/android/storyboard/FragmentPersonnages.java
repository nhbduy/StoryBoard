package com.igm.android.storyboard;

import android.os.Bundle;
import android.support.v4.app.ListFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class FragmentPersonnages extends ListFragment {

    private String[] countries;
    private int[] flags;
    private String[] currency;
    private String[] actionsda;
    private int cpt = 0;


    public FragmentPersonnages(String[] a, int[] b, String[] c, String[] d) {

        this.countries = a;
        this.flags = b;
        this.currency = c;
        this.actionsda = d;
        cpt = a.length;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        // Each row in the list stores country name, currency and flag
        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();

        for (int i = 0; i < cpt; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("txt", "Nom Prenom : " + countries[i]);
            hm.put("cur", "Nationalité : " + currency[i]);
            hm.put("flag", Integer.toString(flags[i]));
            hm.put("actiondat", "Action datee : " + actionsda[i]);
            aList.add(hm);
        }

        // Keys used in Hashmap
        String[] from = {"flag", "txt", "cur", "actiondat"};

        // Ids of views in listview_layout
        int[] to = {R.id.flag, R.id.txt, R.id.cur, R.id.actiondat};

        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.listview_layout, from, to);

        setListAdapter(adapter);

        return super.onCreateView(inflater, container, savedInstanceState);
    }

}
