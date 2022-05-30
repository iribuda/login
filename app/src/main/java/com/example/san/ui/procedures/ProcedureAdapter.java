package com.example.san.ui.procedures;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.san.databinding.ProcedureItemBinding;
import com.example.san.entities.BoughtProcedure;
import com.example.san.entities.Procedure;
import com.example.san.room.AppDatabase;
import com.example.san.ui.boughtProcedures.BoughtProcedureAdapter;
import com.example.san.ui.boughtProcedures.BoughtProcedureViewModel;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ProcedureAdapter extends RecyclerView.Adapter<ProcedureAdapter.ProcedureHolder> {

    private List<Procedure> procedures = new ArrayList<>();
    private ProcedureViewModel procedureViewModel;
    private BoughtProcedureViewModel boughtProcedureViewModel;
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
                Procedure pickedProcedure = procedures.get(pos);
                String message = "Вы купили процедуру: " + pickedProcedure.getName();
                Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
                Date current = new Date();
                SimpleDateFormat formatter = new SimpleDateFormat("dd.MM.yyyy");
                String date = formatter.format(current);
                BoughtProcedure boughtProcedure = new BoughtProcedure(pickedProcedure.getName(),
                        pickedProcedure.getPrice(), date, pickedProcedure.getPhotoResource());
                boughtProcedureViewModel.insert(boughtProcedure);
//                if(boughtProcedureViewModel.isAddToBoughtProcedure(boughtProcedure)!=1){
//                    boughtProcedureViewModel.insert(boughtProcedure);
//                }
//                else{
//                    String message2 = "Вы уже приобрели процедуру: " + pickedProcedure.getName();
//                    Toast.makeText(view.getContext(), message2, Toast.LENGTH_SHORT).show();
//                }

//                boughtProcedureViewModel.insert(boughtProcedure);
//                System.out.println(boughtProcedureViewModel.getAllBoughtProcedures());

//                pickedProcedure.setIsBought(1);
//                procedureViewModel.update(pickedProcedure);
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

    public void setBoughtProcedureViewModel(BoughtProcedureViewModel boughtProcedureViewModel) {
        this.boughtProcedureViewModel = boughtProcedureViewModel;
        notifyDataSetChanged();
    }
}
