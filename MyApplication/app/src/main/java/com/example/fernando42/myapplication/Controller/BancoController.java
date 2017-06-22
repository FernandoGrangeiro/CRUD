package com.example.fernando42.myapplication.Controller;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
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
    public Cursor carregaDados(){
        Cursor cursor;
        String[] campos={TabelaLivros.ID,TabelaLivros.TITULO};
        db= banco.getReadableDatabase();
        cursor= db.query(TabelaLivros.TABELA,campos,null, null, null, null, null, null);
        if (cursor !=null) {
            cursor.moveToFirst();
        }
        db.close();
        return  cursor;


    }

    public Cursor carregaById(int id){
        Cursor cursor;
        String[] campos ={
                TabelaLivros.TITULO,TabelaLivros.AUTOR,TabelaLivros.EDITORA};
        String where=TabelaLivros. ID+ "="+id;
        db= banco.getReadableDatabase();
        cursor= db.query(TabelaLivros.TABELA, campos,where,null,null,null,null,null);
        if(cursor !=null){
            cursor.moveToFirst();

        }
        db.close();
        return cursor;
    }

    public void alterarRegistro(int id, String titulo, String autor, String editora ){

        ContentValues valores;
        String where;

        db= banco.getWritableDatabase();

        where =TabelaLivros.ID+"=" +id;
        valores= new ContentValues();
        valores.put(TabelaLivros.TITULO,titulo);
        valores.put(TabelaLivros.AUTOR,autor);
        valores.put(TabelaLivros.EDITORA,editora);

        db.update(TabelaLivros.TABELA,valores,where,null);
        db.close();
    }

    public void deletaRegistro( int id){
        String where= TabelaLivros.ID+"="+id;
        db=banco.getReadableDatabase();
        db.delete(TabelaLivros.TABELA,where,null);
        db.close();
    }
}
