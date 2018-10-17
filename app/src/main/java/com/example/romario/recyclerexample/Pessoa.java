package com.example.romario.recyclerexample;

import android.arch.lifecycle.ViewModel;
import android.support.annotation.NonNull;
import android.support.v7.util.SortedList;


public class Pessoa {

    String nome;


    public Pessoa(String nome) {
        this.nome = nome;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

}
