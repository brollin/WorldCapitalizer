package com.brollin.worldcapitalizer;

import android.os.Bundle;
import android.app.Activity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.Menu;
import android.view.View;
import android.webkit.URLUtil;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity {

    public String[] countries;
    public String[] capitals;
    public String[] temp;
    public boolean[] picked;
    public int mode;
    public int maxIndex;
    public int lastIndex;
    URLUtil u;
    String link;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialize all variables here
        countries = getResources().getStringArray(R.array.countries);
        capitals = getResources().getStringArray(R.array.capitals);
        temp = countries;
        maxIndex = countries.length;
        picked = new boolean[maxIndex]; // will initialize all values to zero (false)
        lastIndex = -1;
        mode = 1;

        //mode: 1 = ask country; 2 = ask capital
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    private String encode(String s) {
        s = s.replace(' ', '+');
        s = s.replace("\'", "%27s");
        return s;
    }

    public void switchCountryCapital(View view) {

        Button btnCountryCapitalSwitch = (Button) findViewById(R.id.btnCountryCapitalSwitch);

        if(mode == 1) {
            mode = 2;
            btnCountryCapitalSwitch.setText("Ask Country");
        }
        else {
            mode = 1;
            btnCountryCapitalSwitch.setText("Ask Capital");
        }

        // will switch the contents of the two String arrays containing capitals and countries
        temp = countries;
        countries = capitals;
        capitals = temp;

        nextCountry(null);
    }

    public void nextCountry(View view) {

        TextView txtMain = (TextView) findViewById(R.id.txtMainText);
        TextView txtCountry = (TextView) findViewById(R.id.txtCountry);
        TextView txtCapital = (TextView) findViewById(R.id.txtCapital);

        // if the last index is not -1, then this is not the first country
        // put the last country's name and capital in the 'answer box' below
        if (lastIndex > -1) {
            link = "<a href=\'http://en.wikipedia.org/w/index.php?title=Special:Search&search=" +  encode(countries[lastIndex]) + "\'>" + countries[lastIndex] + "</a>";
            txtCountry.setMovementMethod(LinkMovementMethod.getInstance());
            txtCountry.setText(Html.fromHtml(link));

            link = "<a href=\'http://en.wikipedia.org/w/index.php?title=Special:Search&search=" +  encode(capitals[lastIndex]) + "\'>" + capitals[lastIndex] + "</a>";
            txtCapital.setMovementMethod(LinkMovementMethod.getInstance());
            txtCapital.setText(Html.fromHtml(link));
        }

        // set a new country that has not been used before
        try {
            do {
                lastIndex = (int)(Math.random() * (maxIndex + 1));
            } while (picked[lastIndex]);
            //picked[lastIndex] = true; // TODO what to do when reached end?
        }
        catch(Exception ex) {}
        //txtMain.setText(countries[lastIndex]);
        txtMain.setText(countries[lastIndex]);

    }

}
