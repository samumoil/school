package net.samumoila.lainalaskuri_mallin_mukaan;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Muuttuja liukuvalintaan.
    private SeekBar sbKorkovalinta;
    // Muuttuja korkonäyttöön.
    private TextView korkonaytto;
    // Muuttuja lainamäärän kenttään.
    private EditText lainamaara_kentta;
    // Muuttuja lainan keston kenttään.
    private EditText lainankesto_kentta;
    //
    private TextView selitystekstikentta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        String strSelitysteksti = getString(R.string.selitysteksti_upper);
        String strLainanMaara = getString(R.string.lainamaara_teksti);
        String strLainanKesto = getString(R.string.lainankesto_teksti);
        String strKorko = getString(R.string.korkonaytto);

        // Nämä voidaan referoida vasta tässä vaiheessa!!!
        // Rererenssi liukuvalintaan.
        sbKorkovalinta = findViewById(R.id.sbKoronValinta);
        // Referenssi korkonäyttöön.
        korkonaytto = findViewById(R.id.tvKorkoprosentti);
        //
        lainamaara_kentta = findViewById(R.id.etLainamaara);
        //
        lainankesto_kentta = findViewById(R.id.etLainanKesto);
        //
        selitystekstikentta = findViewById(R.id.tvTulokset);

        sbKorkovalinta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                paivitaKorkoteksti();
                paivitaSelitysteksti();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });

        // Luodaan tekstimuutoksen kuuntelija.
        TekstiVahti tekstiVahti = new TekstiVahti();
        // Osoitetaan kumpikin tekstikenttä käyttämään tätä kuuntelijaoliota.
        lainamaara_kentta.addTextChangedListener(tekstiVahti);
        lainankesto_kentta.addTextChangedListener(tekstiVahti);


    }

    void paivitaKorkoteksti(){
        String lokalisoituKorkoteksti = getString(R.string.korkonaytto);
//        String korkoprosentti = String.format("%d %%", sbKorkovalinta.getProgress());
        String korkoprosentti = String.valueOf(sbKorkovalinta.getProgress());
        String naytettavaTeksti = lokalisoituKorkoteksti + " " + korkoprosentti + " %";
        korkonaytto.setText(naytettavaTeksti);
    }

    private class TekstiVahti implements TextWatcher {

        @Override
        public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

        @Override
        public void onTextChanged(CharSequence s, int start, int before, int count) {}

        @Override
        public void afterTextChanged(Editable s) {
            paivitaSelitysteksti();
        }
    }

    void paivitaSelitysteksti() {
        String naytettavaTeksti = String.format("%s/n", )
        try {
            double lainanmaara = Double.parseDouble(lainamaara_kentta.getText().toString());
            int lainankesto = Integer.getInteger(lainankesto_kentta.getText().toString());
            int korko = sbKorkovalinta.getProgress();
            double normalisoituKorko = korko / 100d;

            double kokonaisKorko = lainanmaara * normalisoituKorko * lainankesto/12;
            double kokonaismaara = lainanmaara + kokonaisKorko;



        } catch (NumberFormatException e) {

        }
    }
}