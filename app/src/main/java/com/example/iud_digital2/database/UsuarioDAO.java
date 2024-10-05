package com.example.iud_digital2.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


import com.example.iud_digital2.models.Usuario;

import java.util.ArrayList;
import java.util.List;

public class UsuarioDAO {
    private DatabaseHelper dbHelper;

    public UsuarioDAO(Context context) {
        dbHelper = new DatabaseHelper(context);
    }

    public void agregarUsuario(Usuario usuario) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nombre", usuario.getNombre());
        values.put("email", usuario.getEmail());
        db.insert("usuario", null, values);
        db.close();
    }

    public void actualizarUsuario(Usuario usuario) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put("nombre", usuario.getNombre());
        values.put("email", usuario.getEmail());
        db.update("usuario", values, "id = ?", new String[]{String.valueOf(usuario.getId())});
        db.close();
    }

    public void eliminarUsuario(int id) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        db.delete("usuario", "id = ?", new String[]{String.valueOf(id)});
        db.close();
    }

    public List<Usuario> obtenerUsuarios() {
        List<Usuario> usuarios = new ArrayList<>();
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = db.query("usuario", null, null, null, null, null, null);

        if (cursor != null && cursor.moveToFirst()) {
            do {
                int idColumnIndex = cursor.getColumnIndex("id");
                int nombreColumnIndex = cursor.getColumnIndex("nombre");
                int emailColumnIndex = cursor.getColumnIndex("email");

                if (idColumnIndex == -1 || nombreColumnIndex == -1 || emailColumnIndex == -1) {
                    Log.e("Database Error", "Una o más columnas no existen en la consulta.");
                    break;
                }

                int id = cursor.getInt(idColumnIndex);
                String nombre = cursor.getString(nombreColumnIndex);
                String email = cursor.getString(emailColumnIndex);
                usuarios.add(new Usuario(id, nombre, email));
            } while (cursor.moveToNext());
        }

        if (cursor != null) {
            cursor.close();
        }
        db.close();
        return usuarios;
    }

    public Usuario obtenerUsuarioPorId(int id) {
        SQLiteDatabase db = dbHelper.getReadableDatabase();
        Cursor cursor = null;

        try {
            cursor = db.query("usuario", null, "id = ?", new String[]{String.valueOf(id)}, null, null, null);

            if (cursor != null && cursor.moveToFirst()) {
                int nombreColumnIndex = cursor.getColumnIndex("nombre");
                int emailColumnIndex = cursor.getColumnIndex("email");

                if (nombreColumnIndex == -1 || emailColumnIndex == -1) {
                    Log.e("Database Error", "Una o más columnas no existen en la consulta.");
                    return null;
                }

                String nombre = cursor.getString(nombreColumnIndex);
                String email = cursor.getString(emailColumnIndex);
                return new Usuario(id, nombre, email);
            }
        } catch (Exception e) {
            Log.e("Database Error", "Error al obtener el usuario por ID: " + e.getMessage());
        } finally {
            if (cursor != null) {
                cursor.close();
            }
            db.close();
        }
        return null;
    }
}
