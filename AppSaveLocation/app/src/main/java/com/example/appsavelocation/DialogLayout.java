package com.example.appsavelocation;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class DialogLayout extends AppCompatActivity {

    private double latitude, longitude;
    private EditText etNomee;
    private TextView tvLat, tvLon;
    private Localizacao localizacao;
    private String acao;
    private Button acceptButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.dialog);


        etNomee = findViewById(R.id.etNome);
        tvLat = findViewById(R.id.tvLatitude);
        tvLon = findViewById(R.id.tvLongitude);
        acceptButton = findViewById(R.id.acceptButton);

        acao = getIntent().getStringExtra("acao");

        if (acao.equals("editar")) {
            carregarLocalizacao();
        }

        acceptButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                salvar();
            }
        });

    }

    private void carregarLocalizacao() {
        int idLocalizacao = getIntent().getIntExtra("idLocalizacao", 0);
        if (idLocalizacao != 0) {
            localizacao = LocalizacaoDAO.getLocalizacaoById(this, idLocalizacao);
            etNomee.setText(localizacao.getNome());
            tvLon.setText(String.valueOf(localizacao.getLongitude()));
            tvLat.setText(String.valueOf(localizacao.getLatitude()));
        }

    }

    private void salvar() {
        if (etNomee.getText().toString().isEmpty() || etNomee == null) {
            Toast.makeText(this, "Todos os campos devem ser preenchidos!", Toast.LENGTH_SHORT).show();

        } else {
            if (acao.equals("novo")) {
                localizacao = new Localizacao();
            }

            localizacao.setNome(etNomee.getText().toString());
            localizacao.setLongitude(Double.parseDouble(tvLon.getText().toString()));
            localizacao.setLatitude(Double.parseDouble(tvLat.getText().toString()));


            if (acao.equals("editar")) {
                LocalizacaoDAO.editar(localizacao, this);
                finish();
            } else {
                LocalizacaoDAO.inserir(localizacao, this);
                etNomee.setText("");
                tvLon.setText("");
                tvLat.setText(" ");
            }
        }
    }
}
