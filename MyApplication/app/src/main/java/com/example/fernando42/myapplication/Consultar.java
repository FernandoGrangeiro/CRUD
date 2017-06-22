package com.example.fernando42.myapplication;

import android.content.Intent;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import com.example.fernando42.myapplication.Controller.BancoController;
import com.example.fernando42.myapplication.Model.TabelaLivros;

public class Consultar extends AppCompatActivity {
    private ListView lista;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar);

        BancoController crud= new BancoController(getBaseContext());
        final Cursor cursor= crud.carregaDados();
        String[] nomeCampos= new String[] {TabelaLivros.ID,TabelaLivros.TITULO};
        int[] idViews= new int[]{R.id.idLivro,R.id.nomeLivro};

        SimpleCursorAdapter adaptador =new SimpleCursorAdapter(getBaseContext(),R.layout.livros_layout,cursor,nomeCampos,idViews,0);
        lista= (ListView)findViewById(R.id.listView);
        lista.setAdapter(adaptador);
        lista.setOnItemClickListener(new AdapterView.OnItemClickListener(){
            public  void onItemClick(AdapterView<?> parent, View view, int position, long id){
                String codigo;
                cursor.moveToPosition(position);
                codigo=cursor.getString(cursor.getColumnIndexOrThrow(TabelaLivros.ID));
                Intent intent= new Intent(Consultar.this, Alterar.class);
                intent.putExtra("codigo",codigo);
                startActivity(intent);
                finish();


        }
    });


    }


}

