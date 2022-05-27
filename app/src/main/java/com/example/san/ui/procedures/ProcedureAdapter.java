package com.example.san.ui.procedures;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.san.databinding.ProcedureItemBinding;
import com.example.san.entities.Procedure;

import java.util.ArrayList;
import java.util.List;

public class ProcedureAdapter extends RecyclerView.Adapter<ProcedureAdapter.ProcedureHolder> {

    private List<Procedure> procedures = new ArrayList<>();
    private ProcedureViewModel procedureViewModel;
    private ProceduresFragment proceduresFragment;

    @NonNull
    @Override
    public ProcedureHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        ProcedureItemBinding binding = ProcedureItemBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new ProcedureHolder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull ProcedureHolder holder, int position) {
        Procedure procedure = procedures.get(position);
        String price = "Цена: " + procedure.getPrice();
        String startTime = "Начало: " + procedure.getStartAt();
        String endTime = "Конец: " + procedure.getEndAt();

        holder.binding.nameProcedure.setText(procedure.getName());
        holder.binding.priceProcedure.setText(price);
        holder.binding.startTimeProcedure.setText(startTime);
        holder.binding.endTimeProcedure.setText(endTime);
        holder.binding.imgProcedure.setImageResource(procedure.getPhotoResource());

        holder.binding.buyProcedure.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();
                String message = "Вы купили процедуру: " + procedures.get(pos).getName();
                Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
            }
        });

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();

                if(pos != RecyclerView.NO_POSITION){
                    String message = procedures.get(pos).getName() + ", позиция в листе - " + pos;
                    Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
                }
            }
        });

        holder.itemView.setOnLongClickListener(view -> {
            AlertDialog alertDialog = new AlertDialog.Builder(holder.itemView.getContext()).setMessage("Вы хотите удалить")
                    .setPositiveButton("Да", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int pos) {
                            procedureViewModel.delete(procedure);
                            String message = "Процедура " + procedure.getName() + " была удалена.";
                            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
                        }
                    }).setNegativeButton("НЕТ", null).create();
            alertDialog.show();
            return true;
        });
    }

    @Override
    public int getItemCount() {
        return procedures.size();
    }

    public static class ProcedureHolder extends RecyclerView.ViewHolder {
        ProcedureItemBinding binding;

        public ProcedureHolder(@NonNull ProcedureItemBinding procedureItemBinding) {
            super(procedureItemBinding.getRoot());
            this.binding = procedureItemBinding;
        }
    }

    public void setProcedures(List<Procedure> procedures){
        this.procedures = procedures;
        notifyDataSetChanged();
    }

    public void setProcedureViewModel(ProcedureViewModel procedureViewModel){
        this.procedureViewModel = procedureViewModel;
        notifyDataSetChanged();
    }

    public void setProceduresFragment(ProceduresFragment proceduresFragment){
        this.proceduresFragment = proceduresFragment;
        notifyDataSetChanged();
    }
}
