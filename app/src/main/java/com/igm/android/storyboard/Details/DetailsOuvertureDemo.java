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

public class DetailsOuvertureDemo extends FragmentActivity implements TabListener {

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
                    "Bouteflika",


            };

            // Array of integers points to images stored in /res/drawable/
            int[] imagesperso = new int[]{
                    R.drawable.boutefjpg,


            };

            // Array of strings to store currencies
            String[] nationalite = new String[]{
                    "Algerienne",


            };
            String[] ActionDat = new String[]{
                    "Abdelaziz Bouteflika, né le 2 mars 1937 à Oujda au Maroc, est un homme d’État algérien. Il est le 5eme président de la République algérienne démocratique et populaire depuis le 27 avril 1999. "


            };


            String[] titre = new String[]{
                    "La Révolution algérie"

            };

            // Array of integers points to images stored in /res/drawable/
            int[] imagesevent = new int[]{
                    R.drawable.boutefjpg,


            };

            // Array of strings to store currencies
            String[] date = new String[]{
                    "1988"

            };
            String[] Description = new String[]{
                    "Les émeutes d'octobre 1988, violemment réprimées, vont entrainer la promulgation d'une nouvelle constitution qui prône la démocratie et le multipartisme235. Le processus est toutefois brutalement interrompu, à la suite de la victoire électorale du Front islamique du salut en 1991, parti islamiste visant la création d'un État islamique et remettant en cause l'option démocratique"

            };


            if (arg0 == 0) {
                fragment = new EvenementFragment(titre, imagesevent, date, Description);

            }
            if (arg0 == 1) {
                fragment = new FragmentPersonnages(nom, imagesperso, nationalite, ActionDat);
            }
            if (arg0 == 2) {
                //			fragment=new Carte(36.608724,4.671636);

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
