package com.softulp.notesapp.ui.listar;

import android.app.Application;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.softulp.notesapp.MainActivity;

import java.util.Collections;

public class ListarViewModel extends AndroidViewModel {

    private MutableLiveData<Boolean> listaOrdenadaBool;

    public ListarViewModel(@NonNull Application application) {
        super(application);
    }

    public LiveData<Boolean> getlistaOrdenadaBool() {
        if (listaOrdenadaBool == null){
            listaOrdenadaBool = new MutableLiveData<>();
        }
        return listaOrdenadaBool;
    }

    public void ordenarLista(){
        //todos estos metodos hacen exactamente lo mismo!
        //Collections.sort(MainActivity.notasList, String::compareToIgnoreCase);
        //Collections.sort(MainActivity.notasList, (nota1, nota2) -> nota1.compareToIgnoreCase(nota2));

        /*Comparator<String> comparadorPersonalizado = new Comparator<String>() {
            @Override
            public int compare(String nota1, String nota2) {
                return nota1.compareToIgnoreCase(nota2);
            }
        };
        Collections.sort(MainActivity.notasList, comparadorPersonalizado);*/

        if (!MainActivity.notasList.isEmpty()){
            Collections.sort(MainActivity.notasList, String.CASE_INSENSITIVE_ORDER);
            listaOrdenadaBool.setValue(true);
        } else {
            Toast.makeText(getApplication(), "No tiene ninguna nota guardada.", Toast.LENGTH_LONG).show();
            //listaOrdenadaBool.setValue(false); //no tiene mucho sentido este false, supongo..
        }


    }
}