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

public class Details1870 extends FragmentActivity implements TabListener {

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
                    " Adolphe Crémieux",


            };

            // Array of integers points to images stored in /res/drawable/
            int[] imagesperso = new int[]{
                    R.drawable.cremieux,


            };

            // Array of strings to store currencies
            String[] nationalite = new String[]{
                    "Française",


            };
            String[] ActionDat = new String[]{
                    "Adolphe Crémieux, né Isaac Moïse le 30 avril 1796 à Nîmes et mort le 10 février 1880 à Paris, est un avocat, homme politique français. Il est l'auteur du décret Crémieux d'octobre 1870. Il fut ami de l'abbé Grégoire dont il fit l'éloge funèbre"

            };


            String[] titre = new String[]{
                    "Décrets Crémieux"

            };

            // Array of integers points to images stored in /res/drawable/
            int[] imagesevent = new int[]{
                    R.drawable.decret,


            };

            // Array of strings to store currencies
            String[] date = new String[]{
                    "1870"

            };
            String[] Description = new String[]{
                    "Le 24 octobre 1870, par le décret Crémieux, les 37 000 juifs d'Algérie passent du statut de sujets français (indigènes) au statut de citoyens français. Ce décret a été promulgué à Tours par le gouvernement de la Défense nationale. Son auteur est le ministre de la Justice, Isaac Adolphe Crémieux, juriste juif. Ce décret est ressenti par les indigènes algériens[Qui ?] comme une injustice[réf. nécessaire] car eux-mêmes restent soumis au sénatus-consulte de juillet 1865 sur le statut des personnes. Encore faut-il préciser que beaucoup, ne voulant pas renoncer au statut juridique coranique, étaient moins enclins à devenir « citoyens français"

            };


            if (arg0 == 0) {
                fragment = EvenementFragment.newInstance(titre, imagesevent, date, Description);

            }
            if (arg0 == 1) {
                fragment = FragmentPersonnages.newInstance(nom, imagesperso, nationalite, ActionDat);
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
