package com.igm.android.storyboard.Details;

import android.app.ActionBar;
import android.app.ActionBar.Tab;
import android.app.ActionBar.TabListener;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.Menu;

import com.igm.android.storyboard.EvenementFragment;
import com.igm.android.storyboard.FragmentPersonnages;
import com.igm.android.storyboard.R;

public class DetailsPrem extends FragmentActivity implements TabListener {

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
                    "Emir Khaled",


            };

            // Array of integers points to images stored in /res/drawable/
            int[] imagesperso = new int[]{
                    R.drawable.khaelhass,


            };

            // Array of strings to store currencies
            String[] nationalite = new String[]{
                    "Algerienne",


            };
            String[] ActionDat = new String[]{
                    "Khaled El-Hassani Ben El-Hachemi dit émir Khaled né en 1875 et mort en 1936 à Damas, est le petit-fils de l'émir Abd El-Kader. Il est assigné à résidence en Algérie en 1892, puis, il entame des études à Paris. Il est le fondateur du féminisme algérien après la Première Guerre mondiale1."


            };


            String[] titre = new String[]{
                    "Première Guerre mondiale"

            };

            // Array of integers points to images stored in /res/drawable/
            int[] imagesevent = new int[]{
                    R.drawable.premguer,


            };

            // Array of strings to store currencies
            String[] date = new String[]{
                    "1914"

            };
            String[] Description = new String[]{
                    "Pour faire face aux pertes humaines de la Grande Guerre, la France mobilisa les habitants des départements français d'Algérie : Musulmans, Juifs et Européens. Selon Gilbert Meynier, ce recrutement fut relativement facile grâce au paternalisme des officiers et dans une indifférence générale malgré quelques révoltes en 1914 et 1917 : la seconde fut peut être inspirée par l'appel des Turcs"

            };


            if (arg0 == 0) {
                fragment = EvenementFragment.newInstance(titre, imagesevent, date, Description);

            }
            if (arg0 == 1) {
                fragment = FragmentPersonnages.newInstance(nom, imagesperso, nationalite, ActionDat);
            }
            if (arg0 == 2) {
//       	fragment=new Carte(36.608724,4.671636);

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
