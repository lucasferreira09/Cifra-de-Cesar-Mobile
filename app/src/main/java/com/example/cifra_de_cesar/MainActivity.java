package com.example.cifra_de_cesar;

import static android.service.autofill.Validators.or;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity {

    private EditText editChave;
    private ImageButton cifrar;
    private Button insiraMsgOriginal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editChave = findViewById(R.id.editChave);
        cifrar = findViewById(R.id.cifrar);
        insiraMsgOriginal = findViewById(R.id.insiraMsgOriginal);

        editChave = findViewById(R.id.editChave);


        //Cria o AlertDialog para inserir a mensagem a ser cifrada
        View cifrando = LayoutInflater.from(MainActivity.this).inflate(R.layout.cifre_aqui, null);
        AlertDialog.Builder builder2 = new AlertDialog.Builder(MainActivity.this, R.style.CustomDialogTheme);
        builder2.setView(cifrando);

        EditText msgPraCifrar = cifrando.findViewById(R.id.msgPraCifrar);

        builder2.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });
        AlertDialog dialog2 = builder2.create();

        //Botão para inserir a mensagem a ser cifrada
        insiraMsgOriginal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog2.show();
            }
        });





        //Ao ser acionado, irá cifrar a mensagem
        //e abrir uma caixa de diálogo com a mensagem Cifrada
        cifrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //Verifica se foi inserido alguma Chave
                int chave = 0;
                String chaveText = editChave.getText().toString();
                if (!TextUtils.isEmpty(chaveText)) {
                    chave = Integer.parseInt(chaveText);
                }

                String msgOriginal = msgPraCifrar.getText().toString();

                if (verificaExisteMensagem(msgOriginal, chave) == true) {

                    Cifrador cifrador = new Cifrador();
                    cifrador.criaAlfabeto(chave);

                    //Cria o AlertDialog para exibir a mensagem cifrada
                    View infla = LayoutInflater.from(MainActivity.this).inflate(R.layout.text_cifrado, null);
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setView(infla);
                    AlertDialog dialog = builder.create();

                    //Adiciona a mensagem Cifrada no TextView
                    TextView textMensagemCifrada = infla.findViewById(R.id.textResult);
                    textMensagemCifrada.setText(cifrador.cifrarMensagem(msgOriginal));
                    dialog.show();
                } else {
                    Toast.makeText(MainActivity.this, "Dados Inválidos", Toast.LENGTH_SHORT).show();
                }

            }
        });

    }
    public boolean verificaExisteMensagem(String mensagem, int chave) {

        if (!mensagem.equals("") && chave <= 24 && chave >= 1) {
            return true;
        } else {
            return false;
        }
    }

}