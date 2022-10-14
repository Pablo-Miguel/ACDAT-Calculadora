package com.example.acdat_calculadora.eventos;

import android.graphics.Color;
import android.view.View;
import android.widget.Button;

import com.example.acdat_calculadora.MainActivity;
import com.example.acdat_calculadora.R;
import com.example.acdat_calculadora.databinding.ActivityMainBinding;

public class CalculadoraEventos implements View.OnClickListener {

    private MainActivity calculadora;
    private ActivityMainBinding binding;

    public CalculadoraEventos(MainActivity calculadora){
        this.calculadora = calculadora;
        binding = calculadora.getBinding();

        Button button;
        for(int i = 0; i < binding.gridLayout.getChildCount(); i++){
            button = (Button) binding.gridLayout.getChildAt(i);
            button.setOnClickListener(this);
            if(button.getText().toString().matches("[0-9]") || button.getText().toString().equals(".")){
                button.setBackgroundColor(Color.parseColor("#FF9083"));
            }
            else {
                button.setBackgroundColor(Color.parseColor("#FF6F5F"));
            }
        }

    }

    @Override
    public void onClick(View view) {
        Button btn = (Button) view;
        if(btn.getText().toString().matches("[0-9]")){
            calculadora.setNumPantalla(btn.getText().toString());
        }
        else if(btn.getText().toString().matches("[-+/x]")) {
            calculadora.setSignoPantalla(btn.getText().toString());
        }
        switch (view.getId()){
            case R.id.btnMC:
                calculadora.setMemoriaCero();
                break;
            case R.id.btnMMas:
                calculadora.sumarRestarMemoria("+");
                break;
            case R.id.btnMMenos:
                calculadora.sumarRestarMemoria("-");
                break;
            case R.id.btnMR:
                calculadora.setMemoriaRes();
                break;
            case R.id.btnC:
                calculadora.restaurar();
                break;
            case R.id.btnPorcentaje:
                calculadora.setPorcentaje();
                break;
            case R.id.btnIgual:
                calculadora.maximizarSolucion();
                break;
            case R.id.btnComa:
                calculadora.setComaPantalla();
                break;
        }
    }
}
