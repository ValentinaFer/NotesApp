package com.softulp.notesapp.ui.crear;

import android.app.Application;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.softulp.notesapp.MainActivity;

import java.util.List;

public class CrearViewModel extends AndroidViewModel {

    private List<String> notasList = MainActivity.notasList;

    public CrearViewModel(@NonNull Application application) {
        super(application);
    }

    public void agregarNuevaNota(String textNote){
        if (textNote.trim().isEmpty()){
            Toast.makeText(getApplication(), "No puede guardar notas vacias..", Toast.LENGTH_SHORT).show();
        } else {
            if (notasList.add(textNote)) {
                Toast.makeText(getApplication(), "!Nota agregada con exito!", Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(getApplication(), "Ocurrio un error al agregar la nota...", Toast.LENGTH_LONG).show();
            }
        }
    }

}