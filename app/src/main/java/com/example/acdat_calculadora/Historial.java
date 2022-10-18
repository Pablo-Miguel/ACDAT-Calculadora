package com.example.acdat_calculadora;

import android.app.Activity;
import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.acdat_calculadora.databinding.FragmentCalculadoraBinding;
import com.example.acdat_calculadora.databinding.FragmentHistorialBinding;
import com.example.acdat_calculadora.eventos.CalculadoraEventos;
import com.example.acdat_calculadora.servicio.Operacion;
import com.example.acdat_calculadora.servicio.Servicio;

import java.util.ArrayList;

public class Historial extends Fragment {

    private FragmentHistorialBinding binding;

    @Override
    public View onCreateView (LayoutInflater inflater,
                              ViewGroup container,
                              Bundle savedInstanceState) {
        binding = FragmentHistorialBinding.inflate(inflater, container, false);
        View view = binding.getRoot();

        if(!Servicio.getInstance().obtenerOperaciones().isEmpty()){
            binding.listHistorial.setVisibility(View.VISIBLE);
            binding.textView.setVisibility(View.INVISIBLE);
            ArrayList<String> listTemp = new ArrayList<String>();

            for (Operacion o : Servicio.getInstance().obtenerOperaciones()) {
                listTemp.add(o.getOperacion() + "\n" + o.getResultado());
            }

            binding.listHistorial.setAdapter(new ArrayAdapter<String>(view.getContext(), android.R.layout.simple_list_item_1, listTemp));
        }
        else{
            binding.textView.setText("No hay datos en el servicio");
            binding.listHistorial.setVisibility(View.INVISIBLE);
            binding.textView.setVisibility(View.VISIBLE);
        }

        return view;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }


}