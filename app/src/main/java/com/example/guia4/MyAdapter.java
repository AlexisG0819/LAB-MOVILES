package com.example.guia4;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyAdapter extends RecyclerView.Adapter<MyAdapter.MyViewHolder> {

    private List<Tareas> list;

    public MyAdapter(List<Tareas> list) {
        this.list = list;
    }
    public  void removeItem(int position){
        list.remove(position);
        notifyItemRemoved(position);
    }
    public class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener, View.OnLongClickListener {
        public TextView tvTitulo, tvDescripcion, tvFecha, tvHora;
        public  MyViewHolder(View v) {
            super(v);
            tvTitulo = v.findViewById(R.id.tvTitulo);
            tvDescripcion = v.findViewById(R.id.tvDescripcion);
            tvFecha = v.findViewById(R.id.tvFecha);
            tvHora = v.findViewById(R.id.tvHora);
            v.setOnClickListener(this);
            v.setOnLongClickListener(this);
        }
        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            String titulo = list.get(position).getTitulo();
            String descripcion = list.get(position).getDescripcion();
            String fecha = list.get(position).getFecha();
            String hora = list.get(position).getHora();


        }
        @Override
        public boolean onLongClick(View view) {
            int position = getAdapterPosition();
            String item = list.get(position).getDescripcion();

            Toast.makeText(view.getContext(), "Elemento presionado: " + item, Toast.LENGTH_SHORT).show();

            return true;
        }
    }
    @NonNull
    @Override
    public MyAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recycle_item, parent, false);
        MyViewHolder vh = new MyViewHolder(v);
        return vh;
    }
    @Override
    public void onBindViewHolder(@NonNull MyAdapter.MyViewHolder holder, int position) {
        holder.tvTitulo.setText(list.get(position).getTitulo().toString());
        holder.tvDescripcion.setText(list.get(position).getDescripcion().toString());
        holder.tvFecha.setText(list.get(position).getFecha().toString());
        holder.tvHora.setText(list.get(position).getHora().toString());
    }
    @Override
    public int getItemCount() {
        return list.size();
    }
}



