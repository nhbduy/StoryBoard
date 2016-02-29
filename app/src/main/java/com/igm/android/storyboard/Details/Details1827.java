package com.igm.android.storyboard.Details;

import com.igm.android.storyboard.AndroidVideoPlayer;
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

public class Details1827 extends FragmentActivity implements TabListener {

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

        Tab tab4 = actionBar.newTab();
        tab4.setText("Media");
        tab4.setTabListener(this);


        actionBar.addTab(tab1);
        actionBar.addTab(tab2);
        actionBar.addTab(tab3);
        actionBar.addTab(tab4);


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
                    "Dey hocine",
                    "Pierre deval"

            };

            // Array of integers points to images stored in /res/drawable/
            int[] imagesperso = new int[]{
                    R.drawable.hocine,
                    R.drawable.duval,


            };

            // Array of strings to store currencies
            String[] nationalite = new String[]{
                    "Algerienne",
                    "Fran�aise",

            };
            String[] ActionDat = new String[]{
                    "Il succ�de � Ali Khodja en mars 1818 et prend quelques mesures lib�rales destin�es � rassurer les Europ�ens comme la lib�ration de certains otages ou la libert� de culte vis-�-vis des juifs",
                    " Il a �t� capitaine de la garde nationale durant la guerre de 1870",

                    "En f�vrier 1871 il a �t� nomm� Pr�fet de la Gironde. Il est devenu Pr�fet de la Seine le 28 mai 1873"

            };


            String[] titre = new String[]{
                    "Affaire de l'eventail"

            };

            // Array of integers points to images stored in /res/drawable/
            int[] imagesevent = new int[]{
                    R.drawable.eventail1827


            };

            // Array of strings to store currencies
            String[] date = new String[]{
                    "1827"

            };
            String[] Description = new String[]{
                    "Recevant le 30 avril 1827 en audience le consul de France Pierre Deval, le dey lui demande la r�ponse du roi de France � trois lettres � amicales � qu'il lui avait �crites. Le consul lui r�pondant que le roi ne peut lui r�pondre, et ajoutant, aux dires du dey, � des paroles outrageantes pour la religion musulmane � (que le dey ne pr�cise pas), celui-ci le frappe � deux ou trois fois de l�gers coups de chasse-mouche �7. Il n'y eut donc jamais de soufflet ou de coup d'�ventail, mais un pr�texte tout trouv� pour cr�er un incident diplomatique qui sera exploit� par la diplomatie fran�aise8. Le dey refusant de pr�senter ses excuses, l'affaire est consid�r�e par la France comme un casus belli entra�nant l'envoi d'une escadre pour op�rer le blocus du port d'Alger. L'escalade diplomatique conduira � l'exp�dition d'Alger."
            };


            if (arg0 == 0) {
                fragment = EvenementFragment.newInstance(titre, imagesevent, date, Description);
            }
            if (arg0 == 1) {
                fragment = FragmentPersonnages.newInstance(nom, imagesperso, nationalite, ActionDat);
            }
            if (arg0 == 2) {
//				fragment= new Carte(36.763226, 2.845073);

            }
            if (arg0 == 3) {
                fragment = new AndroidVideoPlayer();

            }

            return fragment;
        }

        @Override
        public int getCount() {
            // TODO Auto-generated method stub
            return 4;
        }


    }


}
