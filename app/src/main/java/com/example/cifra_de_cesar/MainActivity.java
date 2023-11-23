package com.example.cifra_de_cesar;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity {


    private EditText editOriginal;
    private TextView textCifrado;
    private EditText editChave;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editOriginal = findViewById(R.id.editOriginal);
        textCifrado = findViewById(R.id.textCifrado);
        editChave = findViewById(R.id.editChave);

        final EditText editChave = findViewById(R.id.editChave);
        final EditText editOriginal = findViewById(R.id.editOriginal);

        editChave.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                editChave.setText("");
            }

        });
        editOriginal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                editOriginal.setText("");
            }
        });


    }

    public void Cesar(View view) {
        String msg = editOriginal.getText().toString();
        int chave = Integer.parseInt(editChave.getText().toString());
        String alfa = "abcdefghijklmnopqrstuvwxyz";
        String alfaChave = alfa.substring(chave, 26);
        String[] alfaOri = new String[26];
        String[] alfaCesar = new String[26];
        String alfaCifrado = alfaChave + alfa.substring(0, chave);

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
                String letraCifra = alfaCesar[index];
                msgCifra += letraCifra;
            }
        }
        textCifrado.setText(msgCifra);

    }

}