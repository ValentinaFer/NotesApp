package com.softulp.notesapp.ui.listar;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.GridLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.GridLayoutManager;

import com.softulp.notesapp.MainActivity;
import com.softulp.notesapp.databinding.FragmentGalleryBinding;

import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class ListarFragment extends Fragment {

    private FragmentGalleryBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        ListarViewModel listarViewModel =
                new ViewModelProvider(this).get(ListarViewModel.class);

        binding = FragmentGalleryBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        listarViewModel.getlistaOrdenadaBool().observe(getViewLifecycleOwner(), new Observer<Boolean>() {
            @Override
            public void onChanged(Boolean aBoolean) {
                NoteAdapter adapter = new NoteAdapter(MainActivity.notasList, inflater);
                GridLayoutManager glm = new GridLayoutManager(getContext(), 1, GridLayoutManager.VERTICAL, false);
                binding.rvListaContainer.setAdapter(adapter);
                binding.rvListaContainer.setLayoutManager(glm);
            }
        });

        listarViewModel.ordenarLista();

        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}