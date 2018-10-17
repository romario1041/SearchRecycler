package com.example.romario.recyclerexample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.util.SortedList;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Filter;
import android.widget.Filterable;
import android.widget.TextView;


import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class PessoaAdapter extends RecyclerView.Adapter<PessoaAdapter.ViewHolder> implements Filterable {

    List<Pessoa> listPessoa;
    List<Pessoa> listPessoaFull;

    public PessoaAdapter(List<Pessoa> pessoaList){
        this.listPessoa = pessoaList;
        this.listPessoaFull = new ArrayList<>(pessoaList);
    }

    @NonNull
    @Override
    public PessoaAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item,
                viewGroup, false);
        return new ViewHolder(v);    }

    @Override
    public void onBindViewHolder(@NonNull PessoaAdapter.ViewHolder viewHolder, int i) {
            Pessoa p = listPessoa.get(i);
            viewHolder.bind(p.getNome());
    }

    @Override
    public int getItemCount() {
        return listPessoa.size();
    }

    @Override
    public Filter getFilter() {
        return exampleFilter;
    }

    private Filter exampleFilter = new Filter() {
        @Override
        protected FilterResults performFiltering(CharSequence constraint) {
            List<Pessoa> filteredList = new ArrayList<>();

            if (constraint == null || constraint.length() == 0) {
                filteredList.addAll(listPessoaFull);
            } else {
                String filterPattern = constraint.toString().toLowerCase().trim();

                for (Pessoa item : listPessoaFull) {
                    if (item.getNome().toLowerCase().contains(filterPattern)) {
                        filteredList.add(item);
                    }
                }
            }

            FilterResults results = new FilterResults();
            results.values = filteredList;

            return results;
        }

        @Override
        protected void publishResults(CharSequence constraint, FilterResults results) {
            listPessoa.clear();
            listPessoa.addAll((List) results.values);
            notifyDataSetChanged();
        }
    };

        public class ViewHolder extends RecyclerView.ViewHolder {

        TextView nome;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.nome = itemView.findViewById(R.id.nome);
        }

        public void bind(String nome){
            this.nome.setText(nome);
        }
    }



}