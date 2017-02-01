package com.brollin.worldcapitalizer;

import android.os.Bundle;
import android.app.Activity;
import android.text.Html;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;

public class MainActivity extends Activity {

    public String[] countries;
    public String[] capitals;

    public final int ASK_COUNTRY = 1;
    public final int ASK_CAPITAL = 2;
    public int mode;

    public int maxIndex;
    public int lastIndex;
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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize all variables here
        countries = getResources().getStringArray(R.array.countries);
        capitals = getResources().getStringArray(R.array.capitals);
        maxIndex = countries.length;
        lastIndex = -1;
        mode = ASK_CAPITAL;

        // Initialize the spinner with mode options
        Spinner spinner = (Spinner) findViewById(R.id.sprCountryCapital);
        // Create an ArrayAdapter using the string array and a default spinner layout
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.country_or_capital, android.R.layout.simple_spinner_item);
        // Specify the layout to use when the list of choices appears
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        // Apply the adapter to the spinner
        spinner.setAdapter(adapter);
        // Create listener for responding to user actions
        spinner.setOnItemSelectedListener(new SpinnerActivity(this));
    }

    private String encode(String s) {
        s = s.replace(' ', '+');
        s = s.replace("\'", "%27s");
        return s;
    }

    public void switchCountryCapital(View view) {

        // TODO: implement mode = mode % 2
        if(mode == ASK_COUNTRY)
            mode = ASK_CAPITAL;
        else
            mode = ASK_COUNTRY;

        nextCountryCapital(view);
    }

    public void nextCountryCapital(View view) {

        TextView txtMain = (TextView) findViewById(R.id.txtMainText);
        TextView txtCountry = (TextView) findViewById(R.id.txtCountry);
        TextView txtCapital = (TextView) findViewById(R.id.txtCapital);

        // If the last index is not -1, then this is not the first country
        //  put the last country's name and capital in the 'answer box' below
        if (lastIndex > -1) {
            link = "<a href=\'http://en.wikipedia.org/w/index.php?title=Special:Search&search=" +
                    encode(countries[lastIndex]) + "\'>" + countries[lastIndex] + "</a>";
            txtCountry.setMovementMethod(LinkMovementMethod.getInstance());
            txtCountry.setText(Html.fromHtml(link));

            link = "<a href=\'http://en.wikipedia.org/w/index.php?title=Special:Search&search=" +
                    encode(capitals[lastIndex]) + "\'>" + capitals[lastIndex] + "</a>";
            txtCapital.setMovementMethod(LinkMovementMethod.getInstance());
            txtCapital.setText(Html.fromHtml(link));
        }
        // Otherwise, this is the first country
        else {
            // Change button text from Start to Next
            Button btnNext = (Button) findViewById(R.id.btnNext);
            btnNext.setText(R.string.next);
        }

        // Set a new country or capital
        lastIndex = (int)(Math.random() * (maxIndex));
        final ImageView imgView = (ImageView) findViewById(R.id.imgView);
        imgView.setImageResource(images[lastIndex]);

        if (mode == ASK_COUNTRY)
            txtMain.setText(countries[lastIndex]);
        else
            txtMain.setText(capitals[lastIndex]);

    }

    public class SpinnerActivity extends Activity implements OnItemSelectedListener {
        private MainActivity parentActivity;

        public SpinnerActivity(MainActivity activity) {
            super();
            this.parentActivity = activity;
        }

        public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
            parentActivity.switchCountryCapital(view);
        }

        public void onNothingSelected(AdapterView<?> parent) {
            // Another interface callback
        }
    }
}
