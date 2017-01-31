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
import android.widget.ImageView;

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

    private Integer images[] = {
            R.drawable.afghanistan,
            R.drawable.albania,
            R.drawable.algeria,
            R.drawable.andorra,
            R.drawable.angola,
            R.drawable.antigua_and_barbuda,
            R.drawable.argentina,
            R.drawable.armenia,
            R.drawable.australia,
            R.drawable.austria,
            R.drawable.azerbaijan,
            R.drawable.bahamas,
            R.drawable.bahrain,
            R.drawable.bangladesh,
            R.drawable.barbados,
            R.drawable.belarus,
            R.drawable.belgium,
            R.drawable.belize,
            R.drawable.benin,
            R.drawable.bhutan,
            R.drawable.bolivia,
            R.drawable.bosnia_and_herzegovina,
            R.drawable.botswana,
            R.drawable.brazil,
            R.drawable.brunei,
            R.drawable.bulgaria,
            R.drawable.burkina_faso,
            R.drawable.burundi,
            R.drawable.cambodia,
            R.drawable.cameroon,
            R.drawable.canada,
            R.drawable.cape_verde,
            R.drawable.central_african_republic,
            R.drawable.chad,
            R.drawable.chile,
            R.drawable.china,
            R.drawable.colombia,
            R.drawable.comoros,
            R.drawable.congo,
            R.drawable.congo_democratic_republic_of_the,
            R.drawable.costa_rica,
            R.drawable.cote_divoire,
            R.drawable.croatia,
            R.drawable.cuba,
            R.drawable.cyprus,
            R.drawable.czech_republic,
            R.drawable.denmark,
            R.drawable.djibouti,
            R.drawable.dominica,
            R.drawable.dominican_republic,
            R.drawable.east_timor,
            R.drawable.ecuador,
            R.drawable.egypt,
            R.drawable.el_salvador,
            R.drawable.equatorial_guinea,
            R.drawable.eritrea,
            R.drawable.estonia,
            R.drawable.ethiopia,
            R.drawable.fiji,
            R.drawable.finland,
            R.drawable.france,
            R.drawable.gabon,
            R.drawable.gambia,
            R.drawable.georgia,
            R.drawable.germany,
            R.drawable.ghana,
            R.drawable.greece,
            R.drawable.grenada,
            R.drawable.guatemala,
            R.drawable.guinea,
            R.drawable.guinea_bissau,
            R.drawable.guyana,
            R.drawable.haiti,
            R.drawable.honduras,
            R.drawable.hungary,
            R.drawable.iceland,
            R.drawable.india,
            R.drawable.indonesia,
            R.drawable.iran,
            R.drawable.iraq,
            R.drawable.ireland,
            R.drawable.israel,
            R.drawable.italy,
            R.drawable.jamaica,
            R.drawable.japan,
            R.drawable.jordan,
            R.drawable.kazakhstan,
            R.drawable.kenya,
            R.drawable.kiribati,
            R.drawable.korea_north,
            R.drawable.korea_south,
            R.drawable.kosovo,
            R.drawable.kuwait,
            R.drawable.kyrgyzstan,
            R.drawable.laos,
            R.drawable.latvia,
            R.drawable.lebanon,
            R.drawable.lesotho,
            R.drawable.liberia,
            R.drawable.libya,
            R.drawable.liechtenstein,
            R.drawable.lithuania,
            R.drawable.luxembourg,
            R.drawable.macedonia,
            R.drawable.madagascar,
            R.drawable.malawi,
            R.drawable.malaysia,
            R.drawable.maldives,
            R.drawable.mali,
            R.drawable.malta,
            R.drawable.marshall_islands,
            R.drawable.mauritania,
            R.drawable.mauritius,
            R.drawable.mexico,
            R.drawable.micronesia,
            R.drawable.moldova,
            R.drawable.monaco,
            R.drawable.mongolia,
            R.drawable.montenegro,
            R.drawable.morocco,
            R.drawable.mozambique,
            R.drawable.myanmar_burma,
            R.drawable.namibia,
            R.drawable.nauru,
            R.drawable.nepal,
            R.drawable.netherlands,
            R.drawable.new_zealand,
            R.drawable.nicaragua,
            R.drawable.niger,
            R.drawable.nigeria,
            R.drawable.norway,
            R.drawable.oman,
            R.drawable.pakistan,
            R.drawable.palau,
            R.drawable.palestinian_state,
            R.drawable.panama,
            R.drawable.papua_new_guinea,
            R.drawable.paraguay,
            R.drawable.peru,
            R.drawable.philippines,
            R.drawable.poland,
            R.drawable.portugal,
            R.drawable.qatar,
            R.drawable.romania,
            R.drawable.russia,
            R.drawable.rwanda,
            R.drawable.saint_kitts_and_nevis,
            R.drawable.saint_lucia,
            R.drawable.saint_vincent_and_the_grenadines,
            R.drawable.samoa,
            R.drawable.san_marino,
            R.drawable.sao_tome_and_principe,
            R.drawable.saudi_arabia,
            R.drawable.senegal,
            R.drawable.serbia,
            R.drawable.seychelles,
            R.drawable.sierra_leone,
            R.drawable.singapore,
            R.drawable.slovakia,
            R.drawable.slovenia,
            R.drawable.solomon_islands,
            R.drawable.somalia,
            R.drawable.south_africa,
            R.drawable.south_sudan,
            R.drawable.spain,
            R.drawable.sri_lanka,
            R.drawable.sudan,
            R.drawable.suriname,
            R.drawable.swaziland,
            R.drawable.sweden,
            R.drawable.switzerland,
            R.drawable.syria,
            R.drawable.taiwan,
            R.drawable.tajikistan,
            R.drawable.tanzania,
            R.drawable.thailand,
            R.drawable.togo,
            R.drawable.tonga,
            R.drawable.trinidad_and_tobago,
            R.drawable.tunisia,
            R.drawable.turkey,
            R.drawable.turkmenistan,
            R.drawable.tuvalu,
            R.drawable.uganda,
            R.drawable.ukraine,
            R.drawable.united_arab_emirates,
            R.drawable.united_kingdom,
            R.drawable.united_states_of_america,
            R.drawable.uruguay,
            R.drawable.uzbekistan,
            R.drawable.vanuatu,
            R.drawable.vatican_city,
            R.drawable.venezuela,
            R.drawable.vietnam,
            R.drawable.yemen,
            R.drawable.zambia,
            R.drawable.zimbabwe
    };
    private int currImage = 0;

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
                //set pic to lastIndex
                final ImageView imgView = (ImageView) findViewById(R.id.imgView);
                imgView.setImageResource(images[lastIndex]);
            } while (picked[lastIndex]);
            //picked[lastIndex] = true; // TODO what to do when reached end?
        }
        catch(Exception ex) {}
        //txtMain.setText(countries[lastIndex]);
        txtMain.setText(countries[lastIndex]);

    }

}
