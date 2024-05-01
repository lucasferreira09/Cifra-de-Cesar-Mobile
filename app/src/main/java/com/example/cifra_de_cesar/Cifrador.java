package com.example.cifra_de_cesar;

import java.util.Arrays;
import java.util.List;

public class Cifrador {
    private String[] alfabetoOriginal;
    private String[] alfabetoCifrado;

    public void criaAlfabeto(int chave) {

        String alfabeto = "abcdefghijklmnopqrstuvwxyz";
        String parteCifrada = alfabeto.substring(chave, 26);
        String alfabetoCifra = parteCifrada + alfabeto.substring(0, chave);

        String[] alfaOriginal = new String[26];
        String[] alfaCifrado = new String[26];

        int x = 0;
        for (String l : alfabeto.split("")) {
            alfaOriginal[x] = l;   //Prenche o alfaOriginal
            x++;
        }

        int n = 0;
        for (String a : alfabetoCifra.split("")) {
            alfaCifrado[n] = a;   //Prenche o alfaCifrado
            n++;
        }

        alfabetoOriginal = alfaOriginal;
        alfabetoCifrado = alfaCifrado;
    }

    public String cifrarMensagem(String mensagem) {

        String mensagemCifrada = "";

        for (String letra : mensagem.split("")) {

            //Se tiver espaço na mensagem, adiciona espaço
            if (letra.equals(" ")) {
                mensagemCifrada += " ";
            } else {

                int index = Arrays.asList(alfabetoOriginal).indexOf(letra);
                //Se for uma letra desconhecida ou número, adiciona o mesmo
                if (index == -1){
                    mensagemCifrada += letra;
                }
                else {
                    String letraCifra = alfabetoCifrado[index];
                    mensagemCifrada += letraCifra;
                }
            }
        }
        return mensagemCifrada;
    }
}
