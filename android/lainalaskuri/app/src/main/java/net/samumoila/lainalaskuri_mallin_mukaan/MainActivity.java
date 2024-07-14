package net.samumoila.lainalaskuri_mallin_mukaan;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    // Referenssi liukuvalintaan.
    private SeekBar sbKorkovalinta = findViewById(R.id.sbKoronValinta);
    // Referenssi korkonäyttöön.
    private TextView korkonaytto = findViewById(R.id.tvKorkoprosentti);

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

        sbKorkovalinta.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                paivitaKorko();
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {
            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {
            }
        });



    public void paivitaKorko(){
        String lokalisoituKorkoteksti = getString(R.string.korkonaytto);
        String korkoprosentti = String.format("%d %%", sbKorkovalinta.getProgress());
        korkonaytto.setText(lokalisoituKorkoteksti + korkoprosentti);
    }

    }
}