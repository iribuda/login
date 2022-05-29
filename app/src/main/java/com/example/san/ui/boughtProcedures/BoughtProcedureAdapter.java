package com.example.san.ui.boughtProcedures;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.san.databinding.BoughtProcedureItemBinding;
import com.example.san.databinding.ProcedureItemBinding;
import com.example.san.entities.BoughtProcedure;
import com.example.san.entities.Procedure;
import com.example.san.room.BoughtProcedureDao;
import com.example.san.ui.procedures.ProcedureAdapter;
import com.example.san.ui.procedures.ProcedureViewModel;

import java.util.ArrayList;
import java.util.List;

public class BoughtProcedureAdapter extends RecyclerView.Adapter<BoughtProcedureAdapter.Holder> {

    private List<BoughtProcedure> boughtProcedures = new ArrayList<>();
    private BoughtProcedureViewModel viewModel;

    @NonNull
    @Override
    public Holder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        BoughtProcedureItemBinding binding = BoughtProcedureItemBinding
                .inflate(LayoutInflater.from(parent.getContext()), parent, false);
        return new BoughtProcedureAdapter.Holder(binding);
    }

    @Override
    public void onBindViewHolder(@NonNull Holder holder, int position) {
        BoughtProcedure boughtProcedure = boughtProcedures.get(position);
        String price = "Цена: " + boughtProcedure.getPrice();
        String date = "Куплено: " + boughtProcedure.getDate();

        holder.binding.nameProcedure.setText(boughtProcedure.getName());
        holder.binding.priceProcedure.setText(price);
        holder.binding.date.setText(date);
        holder.binding.imgProcedure.setImageResource(boughtProcedure.getPhotoResource());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int pos = holder.getAdapterPosition();

                if(pos != RecyclerView.NO_POSITION){
                    String message = boughtProcedures.get(pos).getName() + ", позиция в листе - " + pos;
                    Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
                }
            }
        });

//        holder.itemView.setOnLongClickListener(view -> {
//            AlertDialog alertDialog = new AlertDialog.Builder(holder.itemView.getContext()).setMessage("Вы хотите удалить")
//                    .setPositiveButton("Да", new DialogInterface.OnClickListener() {
//                        @Override
//                        public void onClick(DialogInterface dialog, int pos) {
//                            procedureViewModel.delete(procedure);
//                            String message = "Процедура " + procedure.getName() + " была удалена.";
//                            Toast.makeText(view.getContext(), message, Toast.LENGTH_SHORT).show();
//                        }
//                    }).setNegativeButton("НЕТ", null).create();
//            alertDialog.show();
//            return true;
//        });
    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class Holder extends RecyclerView.ViewHolder{
        BoughtProcedureItemBinding binding;

        public Holder(@NonNull BoughtProcedureItemBinding binding) {
            super(binding.getRoot());
            this.binding = binding;
        }
    }

    public void setBoughtProcedures(List<BoughtProcedure> boughtProcedures){
        this.boughtProcedures = boughtProcedures;
        notifyDataSetChanged();
    }
}
