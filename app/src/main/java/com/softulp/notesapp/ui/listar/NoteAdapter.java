package com.softulp.notesapp.ui.listar;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.softulp.notesapp.R;

import java.util.List;

public class NoteAdapter extends RecyclerView.Adapter<NoteAdapter.ViewHolderNote> {

    private List<String> notesList;
    private LayoutInflater li;

    public NoteAdapter(List<String> notesList, LayoutInflater li) {
        this.notesList = notesList;
        this.li = li;
    }

    @NonNull
    @Override
    public ViewHolderNote onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = li.inflate(R.layout.card_note, parent, false);
        return new ViewHolderNote(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolderNote holder, int position) {
        holder.tvNote.setText(notesList.get(position));
    }

    @Override
    public int getItemCount() {
        return notesList.size();
    }

    public class ViewHolderNote extends RecyclerView.ViewHolder {

        TextView tvNote;

        public ViewHolderNote(@NonNull View itemView) {
            super(itemView);
            tvNote = itemView.findViewById(R.id.tvNote);
        }
    }


}
