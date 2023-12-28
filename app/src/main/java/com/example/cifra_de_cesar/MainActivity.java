package com.example.cifra_de_cesar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity {


    private EditText textOriginal;
    private TextView textCifrado;
    private EditText editChave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textOriginal = findViewById(R.id.textOriginal);
        textCifrado = findViewById(R.id.textCifrado);
        editChave = findViewById(R.id.editChave);

        final EditText editChave = findViewById(R.id.editChave);
        final EditText textOriginal = findViewById(R.id.textOriginal);



    }

    public void Cesar(View view) {
        Toast toast = new Toast(this);
        toast.setText("TEXTO/CHAVE\nNÃO INSERIDO");

        String msg = textOriginal.getText().toString().toLowerCase();
        if (msg.equals("")) {
            toast.show();
            return;
        }
        if (editChave.getText().toString().equals("")) {
            toast.show();
            return;
        }
        int chave = Integer.parseInt(editChave.getText().toString());
        if (chave > 26) {
            Toast.makeText(this, "CHAVE INVÁLIDA!", Toast.LENGTH_SHORT).show();
            return;
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
        textCifrado.setText(msgCifra);

    }

}