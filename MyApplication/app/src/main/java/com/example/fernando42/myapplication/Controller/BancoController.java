package com.example.fernando42.myapplication.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import com.example.fernando42.myapplication.Model.CriaBanco;
import com.example.fernando42.myapplication.Model.TabelaLivros;

/**
 * Created by Fernando42 on 21/06/2017.
 */

public class BancoController {
    private SQLiteDatabase db;
    private CriaBanco banco;

    public BancoController(Context context){
        banco= new CriaBanco(context);
    }
    public String insereDado(String titulo, String autor, String editora){
        ContentValues valores;
        long resultado;
        db= banco.getWritableDatabase();
        valores= new ContentValues();
        valores.put(TabelaLivros.TITULO,titulo);
        valores.put(TabelaLivros.AUTOR,autor);
        valores.put(TabelaLivros.EDITORA,editora);

        resultado=db.insert(TabelaLivros.TABELA,null,valores);
        db.close();

        if(resultado ==-1){
            return "Erro ao inserir registro";

        }else{
            return "Registro Inserido com sucesso";
        }
    }
}
