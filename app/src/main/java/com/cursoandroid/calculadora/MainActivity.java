package com.cursoandroid.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import net.objecthunter.exp4j.Expression;
import net.objecthunter.exp4j.ExpressionBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button numeroZero, numeroUm, numeroDois, numeroTres, numeroQuatro, numeroCinco, numeroSeis, numeroSete, numeroOito,
    numeroNove, ponto, soma, subtracacao, multiplicacao, divisao, igual,botaoLimpar;

    private TextView textoExpressao, textoResultado;
    private ImageView backspace;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        IniciarComponentes();
        getSupportActionBar().hide();


            numeroZero.setOnClickListener(this);
            numeroUm.setOnClickListener(this);
            numeroDois.setOnClickListener(this);
            numeroTres.setOnClickListener(this);
            numeroQuatro.setOnClickListener(this);
            numeroCinco.setOnClickListener(this);
            numeroSeis.setOnClickListener(this);
            numeroSete.setOnClickListener(this);
            numeroOito.setOnClickListener(this);
            numeroNove.setOnClickListener(this);
            ponto.setOnClickListener(this);
            soma.setOnClickListener(this);
            subtracacao.setOnClickListener(this);
            multiplicacao.setOnClickListener(this);
            divisao.setOnClickListener(this);

            botaoLimpar.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    textoExpressao.setText("");
                    textoResultado.setText("");
                }
            });

            backspace.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    TextView expressao = findViewById(R.id.text_expressao);
                    String string = expressao.getText().toString();

                    if (!string.isEmpty()){
                        byte var0 = 0;
                        int var1 = string.length()-1;
                        String textoExpressao = string.substring(var0, var1);
                        expressao.setText(textoExpressao);
                    }
                    textoResultado.setText("");
                }
            });

            igual.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {

                    try {
                        Expression expressao = new ExpressionBuilder(textoExpressao.getText().toString()).build();
                        double resultado = expressao.evaluate();
                        long longresult = (long) resultado ;

                        if (resultado == (double)longresult){
                            textoResultado.setText((CharSequence) String.valueOf(longresult));
                        }else{
                            textoResultado.setText((CharSequence) String.valueOf(resultado));
                        }
                    }catch (Exception e){

                    }


                }
            });


    }

    private void IniciarComponentes(){
        numeroZero = findViewById(R.id.zero);
        numeroUm = findViewById(R.id.um);
        numeroDois = findViewById(R.id.dois);
        numeroTres = findViewById(R.id.tres);
        numeroQuatro = findViewById(R.id.quatro);
        numeroCinco = findViewById(R.id.cinco);
        numeroSeis = findViewById(R.id.seis);
        numeroSete = findViewById(R.id.sete);
        numeroOito = findViewById(R.id.oito);
        numeroNove = findViewById(R.id.nove);
        ponto = findViewById(R.id.ponto);
        soma = findViewById(R.id.adicao);
        subtracacao = findViewById(R.id.subtracao);
        multiplicacao = findViewById(R.id.multiplicacao);
        divisao = findViewById(R.id.divisao);
        igual = findViewById(R.id.botao_igual);
        botaoLimpar = findViewById(R.id.botao_limpar);
        textoExpressao = findViewById(R.id.text_expressao);
        textoResultado = findViewById(R.id.resultado);
        backspace = findViewById(R.id.backspace);
    }
    public void AcrescentarUmaExpressao(String string, boolean limpar_dados){

        if(textoResultado.getText().equals("")){
           textoExpressao.setText(" ");
        }
        if (limpar_dados){
            textoResultado.setText(" ");
            textoExpressao.append(string);
        }else{
            textoExpressao.append(textoResultado.getText());
            textoExpressao.append(string);
            textoResultado.setText(" ");
        }
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.zero:
                 AcrescentarUmaExpressao("0", true);
                 break;

            case R.id.um:
                AcrescentarUmaExpressao("1", true);
                break;

            case R.id.dois:
                AcrescentarUmaExpressao("2", true);
                break;

            case R.id.tres:
                AcrescentarUmaExpressao("3", true);
                break;

            case R.id.quatro:
                AcrescentarUmaExpressao("4", true);
                break;

            case R.id.cinco:
                AcrescentarUmaExpressao("5", true);
                break;

            case R.id.seis:
                AcrescentarUmaExpressao("6", true);
                break;

            case R.id.sete:
                AcrescentarUmaExpressao("7", true);
                break;

            case R.id.oito:
                AcrescentarUmaExpressao("8", true);
                break;

            case R.id.nove:
                AcrescentarUmaExpressao("9", true);
                break;

            case R.id.ponto:
                AcrescentarUmaExpressao(".", true);
                break;

            case R.id.adicao:
                AcrescentarUmaExpressao("+", false);
                break;

            case R.id.subtracao:
                AcrescentarUmaExpressao("-", false);
                break;

            case R.id.multiplicacao:
                AcrescentarUmaExpressao("*", false);
                break;

            case R.id.divisao:
                AcrescentarUmaExpressao("/", false);
                break;



        }
    }
}