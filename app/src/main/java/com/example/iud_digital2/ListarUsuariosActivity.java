package com.example.iud_digital2;

import android.os.Bundle;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.iud_digital2.controllers.UsuarioController;
import com.example.iud_digital2.models.Usuario;

import java.util.List;

public class ListarUsuariosActivity extends AppCompatActivity {
    private RecyclerView recyclerViewUsuarios;
    private UsuarioController usuarioController;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_listar_usuarios);

        recyclerViewUsuarios = findViewById(R.id.recyclerViewUsuarios);
        Button buttonVolver = findViewById(R.id.buttonVolver);
        usuarioController = new UsuarioController(this);

        listarUsuarios();

        buttonVolver.setOnClickListener(v -> finish());
    }

    private void listarUsuarios() {
        List<Usuario> usuarios = usuarioController.obtenerUsuarios();
        UsuarioAdapter usuarioAdapter = new UsuarioAdapter(usuarios);
        recyclerViewUsuarios.setLayoutManager(new LinearLayoutManager(this));
        recyclerViewUsuarios.setAdapter(usuarioAdapter);
    }
}
