package com.igm.android.storyboard.Details;

import com.igm.android.storyboard.EvenementFragment;
import com.igm.android.storyboard.FragmentPersonnages;
import com.igm.android.storyboard.R;

import android.app.Activity;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.TextView;

import android.os.Bundle;
import android.provider.Settings;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.Activity;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;
import android.widget.EditText;

public class Details1902 extends FragmentActivity implements TabListener {

    ViewPager pager;
    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.details);

        pager = (ViewPager) findViewById(R.id.pager);
        pager.setAdapter(new MyAdapter(getSupportFragmentManager()));
        pager.setOnPageChangeListener(new ViewPager.OnPageChangeListener() {

            @Override
            public void onPageSelected(int position) {
                // TODO Auto-generated method stub
                actionBar.setSelectedNavigationItem(position);
            }

            @Override
            public void onPageScrolled(int arg0, float arg1, int arg2) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onPageScrollStateChanged(int arg0) {
                // TODO Auto-generated method stub

            }
        });

        actionBar = getActionBar();
        actionBar.setNavigationMode(ActionBar.NAVIGATION_MODE_TABS);

        Tab tab1 = actionBar.newTab();
        tab1.setText("Evenement");
        tab1.setTabListener(this);

        Tab tab2 = actionBar.newTab();
        tab2.setText("Personnages Associés");
        tab2.setTabListener(this);

        Tab tab3 = actionBar.newTab();
        tab3.setText("Carte");
        tab3.setTabListener(this);


        actionBar.addTab(tab1);
        actionBar.addTab(tab2);
        actionBar.addTab(tab3);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public void onTabReselected(Tab arg0, FragmentTransaction arg1) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onTabSelected(Tab tab, FragmentTransaction arg1) {
        // TODO Auto-generated method stub
        pager.setCurrentItem(tab.getPosition());
    }

    @Override
    public void onTabUnselected(Tab arg0, FragmentTransaction arg1) {
        // TODO Auto-generated method stub

    }

    class MyAdapter extends FragmentPagerAdapter {
        public MyAdapter(FragmentManager fm) {
            super(fm);
            // TODO Auto-generated constructor stub
        }

        @Override
        public Fragment getItem(int arg0) {
            // TODO Auto-generated method stub
            Fragment fragment = null;
            String evenement[] = {

            };

            // Array of strings storing country names
            String[] nom = new String[]{
                    " Gaston-Ernest Cottenest",


            };

            // Array of integers points to images stored in /res/drawable/
            int[] imagesperso = new int[]{
                    R.drawable.gaston,


            };

            // Array of strings to store currencies
            String[] nationalite = new String[]{
                    "Française",


            };
            String[] ActionDat = new String[]{
                    "Le lieutenant Cottenest, né en 1870 à Bergues et mort le 28 septembre 1914 à Mourmelon-le-Grand en Champagne, est un militaire français"


            };


            String[] titre = new String[]{
                    "Conquête du Sahara (1902)"

            };

            // Array of integers points to images stored in /res/drawable/
            int[] imagesevent = new int[]{
                    R.drawable.sahara,


            };

            // Array of strings to store currencies
            String[] date = new String[]{
                    "1881"

            };
            String[] Description = new String[]{
                    "Dans le sud, la prise de Laghouat et de Touggourt, la soumission des Beni-M'zab du Mzab (1852) et celle du Souf, reculent les limites de l'Algérie jusqu'au grand désert, territoire autonome, non soumis aux Ottomans, et jusque-là contrôlé par une confédération de tribus nomades touarègues, les Kel Ahaggar. À la suite de la bataille de Tit, le lieutenant Guillo Lohan reçoit la soumission à la France des Kel Ahaggar Kel Ahaggar en novembre 1902, dans le Hoggar"

            };


            if (arg0 == 0) {
                fragment = new EvenementFragment(titre, imagesevent, date, Description);

            }
            if (arg0 == 1) {
                fragment = new FragmentPersonnages(nom, imagesperso, nationalite, ActionDat);
            }
            if (arg0 == 2) {
//				fragment=new Carte(36.608724,4.671636);

            }
            return fragment;
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return 3;
        }


    }


}
