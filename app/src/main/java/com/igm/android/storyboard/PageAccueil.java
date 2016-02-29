package com.igm.android.storyboard;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class PageAccueil extends Activity implements OnClickListener {

    private EditText edit1 = null;

    private TimePicker pk;
    Button setting, parcour, apropo, ajouter;

    private ScheduleClient sc;


    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.menuprincipal);

        setting = (Button) findViewById(R.id.setting);
        setting.setOnClickListener(this);

        ajouter = (Button) findViewById(R.id.ajout);
        ajouter.setOnClickListener(this);

        pk = (TimePicker) findViewById(R.id.picker);

        parcour = (Button) findViewById(R.id.parcourirhist);
        parcour.setOnClickListener(this);

        sc = new ScheduleClient(this);
        sc.doBindService();


    }


    public void notification(int day, int month, int year, int hour, int minute, int second) {
        // Create a new calendar set to the date chosen
        // we set the time to midnight (i.e. the first minute of that day)
        Calendar c = Calendar.getInstance();
        c.set(year, month, day);
        c.set(Calendar.HOUR_OF_DAY, hour);
        c.set(Calendar.MINUTE, minute);
        c.set(Calendar.SECOND, second);
        // Ask our service to set an alarm for that date, this activity talks to the client that talks to the service

        sc.setAlarmForNotification(c);
        // Notify the user what they just did
        Toast.makeText(this, "Notification set for: " + day + "/" + (month + 1) + "/" + year, Toast.LENGTH_SHORT).show();
    }


    @Override
    public void onClick(View v) {
        // TODO Auto-generated method stub
        switch (v.getId()) {
            case R.id.setting:
                //	notification(12, 05, 2014, pk.getCurrentHour(), pk.getCurrentMinute(),0);
                Intent intent = new Intent(PageAccueil.this, Settings.class); //renvoie vers une classe
                startActivity(intent);
                break;

            case R.id.ajout:

				/*Intent intent2 = new Intent(Intent.ACTION_VIEW, Uri.parse(
						 "content://media/internal/images/media")); 
						 startActivity(intent2); 
				*/
                Intent intent2 = new Intent(PageAccueil.this, Main.class); //renvoie vers une classe
                startActivity(intent2);
                break;

            case R.id.parcourirhist:
                Intent intenttt = new Intent(PageAccueil.this, ListDates.class); //renvoie vers une classe
                startActivity(intenttt);
                break;

            default:
                break;
        }
    }


}
 
	
 
	
	