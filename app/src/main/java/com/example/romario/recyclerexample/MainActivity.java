package com.example.romario.recyclerexample;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.SearchView;
import android.view.inputmethod.EditorInfo;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    PessoaAdapter pessoaAdapter;
    List<Pessoa> pessoaList;
    SearchView searchView;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        searchView = findViewById(R.id.search);
        pessoaList = new ArrayList<>();

        Pessoa p = new Pessoa("Romario");
        Pessoa p1 = new Pessoa("Romario");
        Pessoa p2 = new Pessoa("Romario");
        Pessoa p3 = new Pessoa("Elias");
        Pessoa p4 = new Pessoa("Elias");
        Pessoa p5 = new Pessoa("Elias");
        pessoaList.add(p);
        pessoaList.add(p1);
        pessoaList.add(p2);
        pessoaList.add(p3);
        pessoaList.add(p4);
        pessoaList.add(p5);


        pessoaAdapter = new PessoaAdapter(pessoaList);


        recyclerView = findViewById(R.id.recycler);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(pessoaAdapter);

        searchView.setImeOptions(EditorInfo.IME_ACTION_DONE);
        searchView.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            @Override
            public boolean onQueryTextChange(String s) {
                pessoaAdapter.getFilter().filter(s);
                return true;
            }
        });
    }
}
