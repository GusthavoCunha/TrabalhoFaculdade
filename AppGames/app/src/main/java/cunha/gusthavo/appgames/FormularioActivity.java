package cunha.gusthavo.appgames;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class FormularioActivity extends AppCompatActivity {


        private EditText etNome, etCriador;
        private Spinner spAno;
        private Button btnSalvar;
        private String acao;
        private Jogos jogos;


        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_formulario);


            etNome = findViewById(R.id.etNome);
            spAno = findViewById(R.id.spAno);
            etCriador = findViewById(R.id.etCriador);
            btnSalvar = findViewById(R.id.btnSalvar);

            acao = getIntent().getStringExtra("acao");

            if( acao.equals("editar")){
                carregarFormulario();
            }

            btnSalvar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    salvar();
                }
            });

        }

        private void carregarFormulario(){
            int idJogos = getIntent().getIntExtra("idJogos", 0);
            if(idJogos != 0){
                jogos = JogosDAO.getJogosById(this, idJogos);
                etNome.setText( jogos.getNome() );
                etCriador.setText( jogos.getCriador());

                String[] arrayAno = getResources().getStringArray(R.array.arrayAno);
                for ( int i= 1; i < arrayAno.length; i++){
                    if ( Integer.valueOf(arrayAno[i] ) == jogos.getAno()){
                        spAno.setSelection( i );
                    }
                }
            }

        }


    private void salvar(){
        if( spAno.getSelectedItemPosition() == 0 || etNome.getText().toString().isEmpty() || etCriador.getText().toString().isEmpty()) {
            Toast.makeText(this,"Todos os campos devem ser preenchidos!", Toast.LENGTH_SHORT).show();

        }else {
            if (acao.equals("novo")) {
                jogos = new Jogos();
            }

            jogos.setNome(etNome.getText().toString());
            jogos.setAno( Integer.valueOf(spAno.getSelectedItem().toString()) );
            jogos.setCriador(etCriador.getText().toString());

            if( acao.equals("editar")){
                JogosDAO.editar(jogos, this);
                finish();
            }else{
                JogosDAO.inserir( jogos, this);
                etNome.setText("");
                spAno.setSelection(0);
                etCriador.setText("");
            }
        }
    }

}
