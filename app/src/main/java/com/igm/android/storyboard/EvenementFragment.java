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

public class EvenementFragment extends ListFragment {

    private String[] titreEvent;
    private int[] imageEvent;
    private String[] dateEvent;
    private String[] descriptionEvent;
    private int cpt = 0;

    /*public EvenementFragment() {
        // Required empty public constructor

    }*/


    public static EvenementFragment newInstance(String[] a, int[] b, String[] c, String[] d) {
        EvenementFragment ef = new EvenementFragment();

        Bundle bundle = new Bundle();

        bundle.putStringArray("titreEvent", a);
        bundle.putIntArray("imageEvent", b);
        bundle.putStringArray("dateEvent", c);
        bundle.putStringArray("descriptionEvent", d);
        bundle.putInt("cpt", a.length);

        ef.setArguments(bundle);

        /*this.titreEvent = a;
        this.imageEvent = b;
        this.dateEvent = c;
        this.descriptionEvent = d;
        cpt = a.length;*/

        return ef;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        titreEvent = getArguments().getStringArray("titreEvent");
        imageEvent = getArguments().getIntArray("imageEvent");
        dateEvent = getArguments().getStringArray("dateEvent");
        descriptionEvent = getArguments().getStringArray("descriptionEvent");
        cpt = getArguments().getInt("cpt");
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View v = inflater.inflate(R.layout.listview_layout_evenement, container, false);
        // Each row in the list stores country name, currency and flag
        List<HashMap<String, String>> aList = new ArrayList<HashMap<String, String>>();
        v = super.onCreateView(inflater, container, savedInstanceState);
        for (int i = 0; i < cpt; i++) {
            HashMap<String, String> hm = new HashMap<String, String>();
            hm.put("txt", "Titre evenement : " + titreEvent[i]);
            hm.put("cur", "Date evenement : " + dateEvent[i]);
            hm.put("flag", Integer.toString(imageEvent[i]));
            hm.put("actiondat", "Description : \n \n " + descriptionEvent[i]);
            aList.add(hm);

        }

        // Keys used in Hashmap
        String[] from = {"flag", "txt", "cur", "actiondat"};

        // Ids of views in listview_layout
        int[] to = {R.id.imageevent, R.id.titreevent, R.id.dateevent, R.id.descriptionevent};

        // Instantiating an adapter to store each items
        // R.layout.listview_layout defines the layout of each item
        SimpleAdapter adapter = new SimpleAdapter(getActivity().getBaseContext(), aList, R.layout.listview_layout_evenement, from, to);

        setListAdapter(adapter);


        return v;
    }

}


	



	
	

	



