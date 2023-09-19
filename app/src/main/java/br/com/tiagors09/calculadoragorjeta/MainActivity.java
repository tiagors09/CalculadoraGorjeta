package br.com.tiagors09.calculadoragorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {
    private TextInputEditText total;
    private TextView textViewPorcentagem, textViewGorjeta, textViewTotal;
    private SeekBar seekBarPorcentagem;
    private double porcentagem;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        this.total = findViewById(R.id.total);
        this.textViewPorcentagem = findViewById(R.id.textViewProcentagem);
        this.textViewGorjeta = findViewById(R.id.textViewGorjeta);
        this.textViewTotal = findViewById(R.id.textViewTotal);
        this.seekBarPorcentagem = findViewById(R.id.seekBarPorcentagem);

        this.seekBarPorcentagem.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                porcentagem = progress;
                textViewPorcentagem.setText(porcentagem+"%");
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}