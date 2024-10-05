package com.example.iud_digital2.controllers;

import android.content.Context;


import com.example.iud_digital2.models.Usuario;
import com.example.iud_digital2.services.UsuarioService;
import com.example.iud_digital2.services.UsuarioServiceImpl;

import java.util.List;

public class UsuarioController {

    private UsuarioService usuarioService;

    public UsuarioController(Context context) {
        usuarioService = new UsuarioServiceImpl(context);
    }

    public void agregarUsuario(Usuario usuario) {
        usuarioService.agregarUsuario(usuario);
    }

    public void actualizarUsuario(Usuario usuario) {
        usuarioService.actualizarUsuario(usuario);
    }

    public void eliminarUsuario(int id) {
        usuarioService.eliminarUsuario(id);
    }

    public List<Usuario> obtenerUsuarios() {
        return usuarioService.obtenerUsuarios();
    }

    public Usuario obtenerUsuarioPorId(int id) {
        return usuarioService.obtenerUsuarioPorId(id);
    }
}
