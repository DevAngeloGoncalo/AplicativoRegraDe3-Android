package br.com.angelo.prj_prova;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;

public class AberturaActivity extends AppCompatActivity {

    MediaPlayer intro;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abertura);

        intro = MediaPlayer.create(AberturaActivity.this,R.raw.introsong);
        intro.start();

        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override public void run() {
                trocaDeTela();
                intro.stop();
            }
        }, 5000);
    }

    private void trocaDeTela(){
        Intent intent = new Intent(AberturaActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}