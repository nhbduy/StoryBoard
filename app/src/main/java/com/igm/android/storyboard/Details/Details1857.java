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

public class Details1857 extends FragmentActivity implements TabListener {

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
        tab2.setText("Personnages Associ�s");
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
                    " Lalla Fatma N'Soumer",


            };

            // Array of integers points to images stored in /res/drawable/
            int[] imagesperso = new int[]{
                    R.drawable.fatma,


            };

            // Array of strings to store currencies
            String[] nationalite = new String[]{
                    "Algerienne",


            };
            String[] ActionDat = new String[]{
                    "personnalit� alg�rienne de la r�sistance des Kabyles contre la conqu�te de la Kabylie par la France dans les ann�es 1850"

            };


            String[] titre = new String[]{
                    "Conquete de la kabylie"

            };

            // Array of integers points to images stored in /res/drawable/
            int[] imagesevent = new int[]{
                    R.drawable.bat2,


            };

            // Array of strings to store currencies
            String[] date = new String[]{
                    "1857"

            };
            String[] Description = new String[]{
                    "Le territoire de l'ex-R�gence d'Alger est donc officiellement annex� par la France, mais la r�gion de la Kabylie qui ne reconna�t pas l'autorit� de l'�mir Abdelkader, et donc sa soumission � la France en 1847, r�siste encore. L'arm�e fran�aise d'Afrique contr�le alors tout le nord-ouest de l'Alg�rie. Les succ�s remport�s par l'arm�e fran�aise sur la r�sistance d'Abd el-Kader, renforcent la confiance fran�aise, et permettent de d�cr�ter, apr�s d�bats, la conqu�te de la Kabylie qui doit intervenir � l'issue de la guerre de Crim�e (1853 -1856) qui mobilise une partie des troupes fran�aises. Napol�on III souhaite disposer d'une force suffisante pour permettre une conqu�te durable de la Kabylie."

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
