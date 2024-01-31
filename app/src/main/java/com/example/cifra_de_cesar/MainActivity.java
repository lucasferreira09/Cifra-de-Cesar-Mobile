package com.example.cifra_de_cesar;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity {


    private EditText textOriginal;
    private EditText editChave;
    private ImageButton cifrar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textOriginal = findViewById(R.id.textOriginal);
        editChave = findViewById(R.id.editChave);

        cifrar = findViewById(R.id.cifrar);

        final EditText editChave = findViewById(R.id.editChave);
        final EditText textOriginal = findViewById(R.id.textOriginal);

        cifrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                View infla = LayoutInflater.from(MainActivity.this).inflate(R.layout.text_cifrado, null);

                AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                builder.setView(infla);
                AlertDialog dialog = builder.create();

                TextView textResult = infla.findViewById(R.id.textResult);

                if (Cesar() != null){
                    textResult.setText(Cesar());
                    dialog.show();
                }
            }
        });


    }

    public String Cesar() {

        String msg = textOriginal.getText().toString().toLowerCase();
        if (msg.equals("")) {
            Toast.makeText(this, "TEXTO NÃO INSERIDO", Toast.LENGTH_SHORT).show();
            return null;
        }
        if (editChave.getText().toString().equals("")) {
            Toast.makeText(this, "CHAVE NÃO INSERIDA", Toast.LENGTH_SHORT).show();
            return null;
        }
        int chave = Integer.parseInt(editChave.getText().toString());
        if (chave > 26) {
            Toast.makeText(this, "CHAVE INVÁLIDA!", Toast.LENGTH_SHORT).show();
            return null;
        }
        String alfa = "abcdefghijklmnopqrstuvwxyz";
        String alfaChave = alfa.substring(chave, 26);
        String alfaCifrado = alfaChave + alfa.substring(0, chave);

        String[] alfaOri = new String[26];
        String[] alfaCesar = new String[26];

        int x = 0;
        for (String l : alfa.split("")) {
            alfaOri[x] = l;
            x++;
        }

        int n = 0;
        for (String a : alfaCifrado.split("")) {
            alfaCesar[n] = a;
            n++;
        }

        String msgCifra = "";

        for (String letra : msg.split("")) {
            if (letra.equals(" ")) {
                msgCifra += " ";
            } else {
                int index = Arrays.asList(alfaOri).indexOf(letra);
                if (index == -1){
                    msgCifra += letra;
                }
                else {
                    String letraCifra = alfaCesar[index];
                    msgCifra += letraCifra;
                }
            }
        }

        return msgCifra;
    }

}