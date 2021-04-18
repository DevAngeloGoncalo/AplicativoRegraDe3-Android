package br.com.angelo.prj_prova;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText edt_se;
    private EditText edt_entao;
    private EditText edt_equivale;
    private EditText edt_resultado;
    private Button btn_calc;
    private Button btn_limpar;
    private Button btn_sair;
    private CheckBox edt_checkbox;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edt_se = findViewById(R.id.edt_se);
        edt_entao = findViewById(R.id.edt_entao);
        edt_equivale = findViewById(R.id.edt_equivale);
        edt_resultado = findViewById(R.id.edt_resultado);
        btn_calc = findViewById(R.id.btn_calc);
        btn_limpar = findViewById(R.id.btn_limpar);
        btn_sair = findViewById(R.id.btn_sair);
        edt_checkbox = findViewById(R.id.edt_checkbox);

        btn_calc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String se = edt_se.getText().toString();
                String entao = edt_entao.getText().toString();
                String equivale = edt_equivale.getText().toString();

                if (erro(se, equivale, entao))
                {
                    double seNumero = Double.parseDouble(edt_se.getText().toString());
                    double entaoNumero = Double.parseDouble(edt_entao.getText().toString());
                    double equivaleNumero = Double.parseDouble(edt_equivale.getText().toString());

                    edt_resultado.setText(String.valueOf(regraDeTres(seNumero, equivaleNumero, entaoNumero)));
                }
            }
        });

        btn_limpar.setOnClickListener((new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        }));

        btn_sair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, SaidaActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    private boolean erro(String se, String equivale, String entao)
    {
        if (TextUtils.isEmpty(se)) {
            Toast.makeText(this, "Você esqueceu de determinar o valor de Se", Toast.LENGTH_SHORT).show();
            return false;
        } else if (TextUtils.isEmpty(equivale)) {
            Toast.makeText(this, "Você esqueceu de determinar o valor de Equivale", Toast.LENGTH_SHORT).show();
            return false;
        } else if (TextUtils.isEmpty(entao)){
            Toast.makeText(this, "Você esqueceu de determinar o valor de Então", Toast.LENGTH_SHORT).show();
            return false;
        } else {
            return true;
        }
    }
    public double regraDeTres(double se, double equivale, double entao) {

        if (edt_checkbox.isChecked()){
            return ((se * equivale) / entao);
        }
        else
        {
            return ((entao * equivale) / se);
        }
    }
}