package com.example.iud_digital2;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.iud_digital2.controllers.UsuarioController;
import com.example.iud_digital2.models.Usuario;

public class MainActivity extends AppCompatActivity {
    private UsuarioController usuarioController;
    private EditText editTextNombre;
    private EditText editTextEmail;
    private EditText editTextId;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextNombre = findViewById(R.id.editTextNombre);
        editTextEmail = findViewById(R.id.editTextEmail);
        editTextId = findViewById(R.id.editTextId);
        Button buttonAgregarUsuario = findViewById(R.id.buttonAgregarUsuario);
        Button buttonActualizarUsuario = findViewById(R.id.buttonActualizarUsuario);
        Button buttonEliminarUsuario = findViewById(R.id.buttonEliminarUsuario);
        Button buttonBuscarUsuario = findViewById(R.id.buttonBuscarUsuario);
        Button buttonVerTodosLosUsuarios = findViewById(R.id.buttonVerTodosLosUsuarios);

        usuarioController = new UsuarioController(this);

        buttonAgregarUsuario.setOnClickListener(v -> agregarUsuario());

        buttonActualizarUsuario.setOnClickListener(v -> actualizarUsuario());

        buttonEliminarUsuario.setOnClickListener(v -> eliminarUsuario());

        buttonBuscarUsuario.setOnClickListener(v -> buscarUsuarioPorId());

        buttonVerTodosLosUsuarios.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, ListarUsuariosActivity.class);
            startActivity(intent);
        });

    }

    private void agregarUsuario() {
        String nombre = editTextNombre.getText().toString();
        String email = editTextEmail.getText().toString();
        if (!nombre.isEmpty() && !email.isEmpty()) {
            Usuario usuario = new Usuario(0, nombre, email);
            usuarioController.agregarUsuario(usuario);
            Toast.makeText(this, "Usuario agregado", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(this, "Por favor complete todos los campos", Toast.LENGTH_SHORT).show();
        }
    }

    private void actualizarUsuario() {
        int id = Integer.parseInt(editTextId.getText().toString());
        String nombre = editTextNombre.getText().toString();
        String email = editTextEmail.getText().toString();
        Usuario usuario = new Usuario(id, nombre, email);
        usuarioController.actualizarUsuario(usuario);
        Toast.makeText(this, "Usuario actualizado", Toast.LENGTH_SHORT).show();
    }

    private void eliminarUsuario() {
        int id = Integer.parseInt(editTextId.getText().toString());
        usuarioController.eliminarUsuario(id);
        Toast.makeText(this, "Usuario eliminado", Toast.LENGTH_SHORT).show();
    }

    private void buscarUsuarioPorId() {
        int id = Integer.parseInt(editTextId.getText().toString());
        Usuario usuario = usuarioController.obtenerUsuarioPorId(id);
        if (usuario != null) {
            editTextNombre.setText(usuario.getNombre());
            editTextEmail.setText(usuario.getEmail());
        } else {
            Toast.makeText(this, "Usuario no encontrado", Toast.LENGTH_SHORT).show();
        }
    }

}
