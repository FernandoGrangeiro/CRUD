package com.example.fernando42.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.fernando42.myapplication.Controller.BancoController;
import com.example.fernando42.myapplication.Model.TabelaLivros;

import static java.lang.Integer.parseInt;

public class Alterar extends AppCompatActivity {

        EditText livro;
        EditText autor;
        EditText editora;
        Button alterar;
        Cursor cursor;
        BancoController crud;
        String codigo;
        Button deletar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alterar);

        codigo= this.getIntent().getStringExtra("codigo");
        crud= new BancoController(getBaseContext());
        livro=(EditText)findViewById(R.id.editText4);
        autor=(EditText)findViewById(R.id.editText5);
        editora=(EditText)findViewById(R.id.editText6);
        alterar=(Button) findViewById(R.id.button);
        cursor = crud.carregaById(Integer.parseInt(codigo));
        livro.setText(cursor.getString(cursor.getColumnIndexOrThrow(TabelaLivros.TITULO)));
        autor.setText(cursor.getString(cursor.getColumnIndexOrThrow(TabelaLivros.AUTOR)));
        editora.setText(cursor.getString(cursor.getColumnIndexOrThrow(TabelaLivros.EDITORA)));
        deletar=(Button) findViewById(R.id.button2);
        deletar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.deletaRegistro(Integer.parseInt(codigo));
                Intent intent= new Intent(Alterar.this,Consultar.class);
                startActivity(intent);
                finish();
            }
        });

        alterar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                crud.alterarRegistro(Integer.parseInt(codigo),livro.getText().toString(),autor.getText().toString(),editora.getText().toString());
                Intent intent= new Intent(Alterar.this,Consultar.class);
                startActivity(intent);
                finish();
            }
        });
    }
}
