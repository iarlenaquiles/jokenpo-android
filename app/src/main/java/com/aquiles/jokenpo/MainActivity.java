package com.aquiles.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void pedraSelecionada(View view) {
        this.opcaoSelecionada("pedra");
    }

    public void papelSelecionada(View view) {
        this.opcaoSelecionada("papel");
    }

    public void tesouraSelecionada(View view) {
        this.opcaoSelecionada("tesoura");
    }


    public void opcaoSelecionada(String escolhaUsuario) {
        ImageView imagemResultado = findViewById(R.id.imageResultado);

        int numero = new Random().nextInt(3);

        String[] opcoes = {"pedra", "papel", "tesoura"};
        String escolhaApp = opcoes[numero];

        switch (escolhaApp) {
            case "pedra":
                imagemResultado.setImageResource(R.drawable.pedra);
                break;
            case "papel":
                imagemResultado.setImageResource(R.drawable.papel);
                break;
            case "tesoura":
                imagemResultado.setImageResource(R.drawable.tesoura);
                break;
        }

        TextView text = findViewById(R.id.textResultado);
        if (
                (escolhaApp == "tesoura" && escolhaUsuario == "papel") ||
                        (escolhaApp == "papel" && escolhaUsuario == "pedra") ||
                        (escolhaApp == "pedra" && escolhaUsuario == "tesoura")
        ) {
            text.setText("voce perdeu :(");
        } else if (
                (escolhaApp == "papel" && escolhaUsuario == "tesoura") ||
                        (escolhaApp == "pedra" && escolhaUsuario == "papel") ||
                        (escolhaApp == "tesoura" && escolhaUsuario == "pedra")
        ) {
            text.setText("Voce ganhou :)");
        } else {
            text.setText("Deu empate");
        }

    }


}