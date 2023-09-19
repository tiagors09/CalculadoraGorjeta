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
            String valorRecuperado;
            double valorDigitado, gorjeta, totalPagar, porcentagem;
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                textViewPorcentagem.setText(Math.round(progress)+"%");
                this.valorRecuperado = total.getText().toString();
                this.porcentagem = progress;

                if(valorRecuperado == null || valorRecuperado.equals("")) {
                    Toast.makeText(
                            getApplicationContext(),
                            "Digite um valor primeiro",
                            Toast.LENGTH_LONG
                    ).show();
                } else {
                    this.valorDigitado = Double.parseDouble(valorRecuperado);
                    this.gorjeta = valorDigitado * (this.porcentagem/100);
                    this.totalPagar = gorjeta + valorDigitado;
                    textViewGorjeta.setText("R$ "+Math.round(gorjeta));
                    textViewTotal.setText("R$ "+Math.round(totalPagar));
                }
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