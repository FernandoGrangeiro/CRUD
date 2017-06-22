package com.example.fernando42.myapplication;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.fernando42.myapplication.Controller.BancoController;

public class MainActivity extends AppCompatActivity {
    EditText editora;
    EditText autor;
    EditText titulo;
    Button botao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         titulo = (EditText)findViewById(R.id.editText);
         autor = (EditText)findViewById((R.id.editText2));
         editora = (EditText)findViewById(R.id.editText6);

       botao =(Button) findViewById(R.id.button);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BancoController crud= new BancoController(getBaseContext());
                String tituloString = titulo.getText().toString();
                String autorString = autor.getText().toString();
                String editoraString = editora.getText().toString();
                String resultado;
                resultado=crud.insereDado(tituloString,autorString,editoraString);
                Toast.makeText(getApplicationContext(), resultado, Toast.LENGTH_LONG).show();
                Intent intent= new Intent(MainActivity.this,Consultar.class);
                startActivity(intent);


            }
        });
    }
}
