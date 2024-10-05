package com.example.iud_digital2.services;

import android.content.Context;


import com.example.iud_digital2.database.UsuarioDAO;
import com.example.iud_digital2.models.Usuario;

import java.util.List;

public class UsuarioServiceImpl implements UsuarioService {
    private UsuarioDAO usuarioDAO;

    public UsuarioServiceImpl(Context context) {
        usuarioDAO = new UsuarioDAO(context);
    }

    @Override
    public void agregarUsuario(Usuario usuario) {
        usuarioDAO.agregarUsuario(usuario);
    }

    @Override
    public void actualizarUsuario(Usuario usuario) {
        usuarioDAO.actualizarUsuario(usuario);
    }

    @Override
    public void eliminarUsuario(int id) {
        usuarioDAO.eliminarUsuario(id);
    }

    @Override
    public List<Usuario> obtenerUsuarios() {
        return usuarioDAO.obtenerUsuarios();
    }

    @Override
    public Usuario obtenerUsuarioPorId(int id) {
        return usuarioDAO.obtenerUsuarioPorId(id);
    }
}
