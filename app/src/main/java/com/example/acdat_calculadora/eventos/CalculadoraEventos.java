package com.example.acdat_calculadora.eventos;

import android.view.View;

import com.example.acdat_calculadora.MainActivity;
import com.example.acdat_calculadora.R;
import com.example.acdat_calculadora.databinding.ActivityMainBinding;

public class CalculadoraEventos implements View.OnClickListener {

    private MainActivity calculadora;
    private ActivityMainBinding binding;

    public CalculadoraEventos(MainActivity calculadora){
        this.calculadora = calculadora;
        binding = calculadora.getBinding();

        binding.btnMC.setOnClickListener(this);
        binding.btnMMas.setOnClickListener(this);
        binding.btnMMenos.setOnClickListener(this);
        binding.btnMR.setOnClickListener(this);
        binding.btnC.setOnClickListener(this);
        binding.btnPorcentaje.setOnClickListener(this);
        binding.btnDiv.setOnClickListener(this);
        binding.btnMul.setOnClickListener(this);
        binding.btnRestar.setOnClickListener(this);
        binding.btnSumar.setOnClickListener(this);
        binding.btnIgual.setOnClickListener(this);
        binding.btnComa.setOnClickListener(this);
        binding.btn0.setOnClickListener(this);
        binding.btn1.setOnClickListener(this);
        binding.btn2.setOnClickListener(this);
        binding.btn3.setOnClickListener(this);
        binding.btn4.setOnClickListener(this);
        binding.btn5.setOnClickListener(this);
        binding.btn6.setOnClickListener(this);
        binding.btn7.setOnClickListener(this);
        binding.btn8.setOnClickListener(this);
        binding.btn9.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
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
            case R.id.btnDiv:
                calculadora.setSignoPantalla("/");
                break;
            case R.id.btnMul:
                calculadora.setSignoPantalla("x");
                break;
            case R.id.btnRestar:
                calculadora.setSignoPantalla("-");
                break;
            case R.id.btnSumar:
                calculadora.setSignoPantalla("+");
                break;
            case R.id.btnIgual:
                calculadora.maximizarSolucion();
                break;
            case R.id.btnComa:
                calculadora.setNumPantalla(".");
                break;
            case R.id.btn0:
                calculadora.setNumPantalla("0");
                break;
            case R.id.btn1:
                calculadora.setNumPantalla("1");
                break;
            case R.id.btn2:
                calculadora.setNumPantalla("2");
                break;
            case R.id.btn3:
                calculadora.setNumPantalla("3");
                break;
            case R.id.btn4:
                calculadora.setNumPantalla("4");
                break;
            case R.id.btn5:
                calculadora.setNumPantalla("5");
                break;
            case R.id.btn6:
                calculadora.setNumPantalla("6");
                break;
            case R.id.btn7:
                calculadora.setNumPantalla("7");
                break;
            case R.id.btn8:
                calculadora.setNumPantalla("8");
                break;
            case R.id.btn9:
                calculadora.setNumPantalla("9");
                break;
        }
    }
}
