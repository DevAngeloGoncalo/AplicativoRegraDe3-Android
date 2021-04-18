package br.com.angelo.prj_prova;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.Handler;

public class SaidaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saida);

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override public void run() {
                finish();
            }
        }, 5000);
    }
}