package com.example.cifra_de_cesar;

import java.util.Arrays;

public class Cifrador {
    private String[] alfabetoOriginal;
    private String[] alfabetoCifrado;

    public void criaAlfabeto(int chave) {

        String alfa = "abcdefghijklmnopqrstuvwxyz";
        String alfaChave = alfa.substring(chave, 26);
        String alfaCifrado = alfaChave + alfa.substring(0, chave);

        String[] alfaOri = new String[26];
        String[] alfaCifr = new String[26];

        int x = 0;
        for (String l : alfa.split("")) {
            alfaOri[x] = l;
            x++;
        }

        int n = 0;
        for (String a : alfaCifrado.split("")) {
            alfaCifr[n] = a;
            n++;
        }

        alfabetoOriginal = alfaOri;
        alfabetoCifrado = alfaCifr;

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
