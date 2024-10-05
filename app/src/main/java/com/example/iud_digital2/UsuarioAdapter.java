package com.example.iud_digital2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.resource.bitmap.CircleCrop;
import com.example.iud_digital2.models.Usuario;

import java.util.List;

public class UsuarioAdapter extends RecyclerView.Adapter<UsuarioAdapter.UsuarioViewHolder> {
    private final List<Usuario> usuarios;

    public UsuarioAdapter(List<Usuario> usuarios) {
        this.usuarios = usuarios;
    }

    @NonNull
    @Override
    public UsuarioViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_usuario, parent, false);
        return new UsuarioViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull UsuarioViewHolder holder, int position) {
        Usuario usuario = usuarios.get(position);
        holder.textViewIdUsuario.setText("ID: " + usuario.getId());
        holder.textViewNombreUsuario.setText(usuario.getNombre());
        holder.textViewEmailUsuario.setText(usuario.getEmail());

        Glide.with(holder.itemView.getContext())
                .load(R.drawable.user)
                .placeholder(R.drawable.user)
                .transform(new CircleCrop())
                .into(holder.imageViewUsuario);
    }

    @Override
    public int getItemCount() {
        return usuarios.size();
    }

    static class UsuarioViewHolder extends RecyclerView.ViewHolder {
        TextView textViewIdUsuario;
        TextView textViewNombreUsuario;
        TextView textViewEmailUsuario;
        ImageView imageViewUsuario;

        UsuarioViewHolder(View itemView) {
            super(itemView);
            textViewIdUsuario = itemView.findViewById(R.id.textViewIdUsuario);
            textViewNombreUsuario = itemView.findViewById(R.id.textViewNombreUsuario);
            textViewEmailUsuario = itemView.findViewById(R.id.textViewEmailUsuario);
            imageViewUsuario = itemView.findViewById(R.id.imageViewUsuario);
        }
    }
}
