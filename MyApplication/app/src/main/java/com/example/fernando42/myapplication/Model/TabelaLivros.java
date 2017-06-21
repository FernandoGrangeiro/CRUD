package com.example.fernando42.myapplication.Model;

/**
 * Created by Fernando42 on 21/06/2017.
 */

public class TabelaLivros {


    public static final String TABELA = "livros";
    public static final String ID = "_id";
    public static final String TITULO = "titulo";
    public static final String AUTOR = "autor";
    public static final String EDITORA = "editora";

    public static String criaTabela(){
        String sql="CREATE TABLE "+TABELA+"("
                +ID+" integer primary key autoincrement,"
                +TITULO+" text,"
                +AUTOR+" text,"
                +EDITORA+" text"
                +")";
        return sql;
    }

    public static  String dropaTabela(){
        return  "DROP TABLE IF EXISTS"+ TABELA;
    }

}
