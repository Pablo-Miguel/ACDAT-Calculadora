package com.example.acdat_calculadora;

import android.content.SyncStatusObserver;
import android.os.Build;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;

import com.example.acdat_calculadora.databinding.ActivityMainBinding;
import com.example.acdat_calculadora.eventos.CalculadoraEventos;

public class MainActivity extends AppCompatActivity {
    private ActivityMainBinding binding;
    private Double memoria;
    private Boolean igual, sign;
    private String lastNum, lastCad;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        memoria = 0.0;
        igual = false;
        sign = true;
        lastNum = "";
        lastCad = "";
        new CalculadoraEventos(this);

    }

    public ActivityMainBinding getBinding() {
        return binding;
    }

    public void setMemoriaRes() {
        if (!binding.lblResultado.getText().toString().equals("Infinity")) {
            memoria = Double.parseDouble(binding.lblResultado.getText().toString());
        }
    }

    public void setMemoriaCero() {
        memoria = 0.0;
    }

    public void sumarRestarMemoria(String signo) {
        establecerTamanyo();
        if (memoria != 0.0) {
            if (!igual) {
                if (memoria % 1 == 0) {
                    binding.lblOperacion.setText(binding.lblOperacion.getText() + signo + Math.round(memoria));
                } else {
                    binding.lblOperacion.setText(binding.lblOperacion.getText() + signo + Math.round(memoria * 100) / 100.0);
                }
                Double resultado = eval(binding.lblOperacion.getText().toString());
                if (resultado % 1 == 0) {
                    binding.lblResultado.setText("" + Math.round(resultado));
                } else {
                    binding.lblResultado.setText("" + (Math.round(resultado * 100) / 100.0));
                }
            } else {
                binding.lblOperacion.setText("" + memoria);
                if (memoria % 1 == 0) {
                    binding.lblResultado.setText("" + Math.round(memoria));
                } else {
                    binding.lblResultado.setText("" + (Math.round(memoria * 100) * 100.0));
                }
                igual = false;
            }
        }
    }

    public void setNumPantalla(String num) {
        establecerTamanyo();
        sign = true;
        if (!binding.lblResultado.getText().equals("Infinity")) {
            if (!igual) {
                lastNum += num;
                if (!num.equals(".")) {
                    if (Double.parseDouble(num) % 1 == 0) {
                        binding.lblOperacion.setText(binding.lblOperacion.getText() + "" + (Math.round(Double.parseDouble(num))));
                    } else {
                        binding.lblOperacion.setText(binding.lblOperacion.getText() + "" + (Math.round(Double.parseDouble(num) * 100) / 100.0));
                    }
                    Double resultado = eval(binding.lblOperacion.getText().toString());
                    if (resultado % 1 == 0) {
                        if(resultado.toString().equals("Infinity")){
                            binding.lblResultado.setText("" + resultado);
                        }
                        else{
                            binding.lblResultado.setText("" + Math.round(resultado));
                        }
                    } else {
                        if(resultado.toString().equals("Infinity")) {
                            binding.lblResultado.setText("" + resultado);
                        } else {
                            binding.lblResultado.setText("" + (Math.round(resultado * 100) / 100.0));
                        }
                    }
                } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                    if (lastNum.chars().filter(ch -> ch == '.').count() <= 1) {
                        binding.lblOperacion.setText(binding.lblOperacion.getText() + num);
                        binding.lblResultado.setText("" + eval(binding.lblOperacion.getText().toString()));
                    }
                }
            } else {
                if (Double.parseDouble(num) % 1 == 0) {
                    binding.lblOperacion.setText("" + (Math.round(Double.parseDouble(num))));
                    binding.lblResultado.setText("" + (Math.round(Double.parseDouble(num))));
                } else {
                    binding.lblOperacion.setText("" + (Math.round(Double.parseDouble(num) * 100) / 100.0));
                    binding.lblResultado.setText("" + (Math.round(Double.parseDouble(num) * 100) / 100.0));
                }
                igual = false;
            }

        }

    }

    public void setSignoPantalla(String signo) {
        establecerTamanyo();
        if (!binding.lblResultado.getText().equals("Infinity")) {
            if (sign) {
                if (!igual) {
                    binding.lblOperacion.setText(binding.lblOperacion.getText() + signo);
                    lastNum = "";
                    lastCad = binding.lblOperacion.getText().toString();
                } else {
                    binding.lblOperacion.setText(binding.lblResultado.getText() + signo);
                    igual = false;
                }
            }
            sign = false;
        }
    }

    private void establecerTamanyo() {
        binding.lblOperacion.setTextSize(50);
        binding.lblResultado.setTextSize(30);
    }

    public void setPorcentaje() {
        establecerTamanyo();
        if (!lastNum.equals("") && !lastCad.equals("") && !binding.lblResultado.getText().equals("Infinity")) {
            char car = binding.lblOperacion.getText().charAt(binding.lblOperacion.getText().length() - 1);
            if (car != '+' && car != '-' && car != 'x' && car != '/' && car != ' ') {
                if (!igual) {
                    if ((Double.parseDouble(lastNum) / 100.0) % 1 == 0) {
                        binding.lblOperacion.setText(lastCad + (Math.round(Double.parseDouble(lastNum) / 100.0)));
                    } else {
                        binding.lblOperacion.setText(lastCad + (Math.round(Double.parseDouble(lastNum) / 100.0 * 100) / 100.0));
                    }
                    Double resultado = eval(binding.lblOperacion.getText().toString());
                    if (eval(binding.lblOperacion.getText().toString()) % 1 == 0) {
                        binding.lblResultado.setText("" + (Math.round(resultado)));
                    } else {
                        binding.lblResultado.setText("" + (Math.round(resultado * 100) / 100.0));
                    }
                } else {
                    if ((Double.parseDouble(binding.lblResultado.getText().toString()) / 100.0) % 1 == 0) {
                        binding.lblOperacion.setText("" + (Math.round(Double.parseDouble(binding.lblResultado.getText().toString()) / 100.0)));
                        binding.lblResultado.setText("" + (Math.round(Double.parseDouble(binding.lblResultado.getText().toString()) / 100.0)));
                    } else {
                        binding.lblOperacion.setText("" + (Math.round(Double.parseDouble(binding.lblResultado.getText().toString()) / 100.0 * 100) / 100.0));
                        binding.lblResultado.setText("" + (Math.round(Double.parseDouble(binding.lblResultado.getText().toString()) / 100.0 * 100) / 100.0));
                    }
                    igual = false;
                    lastCad = "";
                    lastNum = "";
                }
            }
        }
    }

    public void restaurar() {
        binding.lblOperacion.setText("");
        binding.lblResultado.setText("0");
        establecerTamanyo();
    }

    public void maximizarSolucion() {
        binding.lblOperacion.setTextSize(30);
        binding.lblResultado.setTextSize(50);
        igual = true;
    }

    //Librería externa
    public static double eval(final String str) {
        return new Object() {
            int pos = -1, ch;

            void nextChar() {
                ch = (++pos < str.length()) ? str.charAt(pos) : -1;
            }

            boolean eat(int charToEat) {
                while (ch == ' ') nextChar();
                if (ch == charToEat) {
                    nextChar();
                    return true;
                }
                return false;
            }

            double parse() {
                nextChar();
                double x = parseExpression();
                if (pos < str.length()) throw new RuntimeException("Unexpected: " + (char) ch);
                return x;
            }

            // Grammar:
            // expression = term | expression `+` term | expression `-` term
            // term = factor | term `*` factor | term `/` factor
            // factor = `+` factor | `-` factor | `(` expression `)` | number
            //        | functionName `(` expression `)` | functionName factor
            //        | factor `^` factor

            double parseExpression() {
                double x = parseTerm();
                for (; ; ) {
                    if (eat('+')) x += parseTerm(); // addition
                    else if (eat('-')) x -= parseTerm(); // subtraction
                    else return x;
                }
            }

            double parseTerm() {
                double x = parseFactor();
                for (; ; ) {
                    if (eat('x')) x *= parseFactor(); // multiplication
                    else if (eat('/')) x /= parseFactor(); // division
                    else return x;
                }
            }

            double parseFactor() {
                if (eat('+')) return +parseFactor(); // unary plus
                if (eat('-')) return -parseFactor(); // unary minus

                double x;
                int startPos = this.pos;
                if (eat('(')) { // parentheses
                    x = parseExpression();
                    if (!eat(')')) throw new RuntimeException("Missing ')'");
                } else if ((ch >= '0' && ch <= '9') || ch == '.') { // numbers
                    while ((ch >= '0' && ch <= '9') || ch == '.') nextChar();
                    x = Double.parseDouble(str.substring(startPos, this.pos));
                } else if (ch >= 'a' && ch <= 'z') { // functions
                    while (ch >= 'a' && ch <= 'z') nextChar();
                    String func = str.substring(startPos, this.pos);
                    if (eat('(')) {
                        x = parseExpression();
                        if (!eat(')'))
                            throw new RuntimeException("Missing ')' after argument to " + func);
                    } else {
                        x = parseFactor();
                    }
                    if (func.equals("sqrt")) x = Math.sqrt(x);
                    else if (func.equals("sin")) x = Math.sin(Math.toRadians(x));
                    else if (func.equals("cos")) x = Math.cos(Math.toRadians(x));
                    else if (func.equals("tan")) x = Math.tan(Math.toRadians(x));
                    else throw new RuntimeException("Unknown function: " + func);
                } else {
                    throw new RuntimeException("Unexpected: " + (char) ch);
                }

                if (eat('^')) x = Math.pow(x, parseFactor()); // exponentiation

                return x;
            }
        }.parse();
    }
}