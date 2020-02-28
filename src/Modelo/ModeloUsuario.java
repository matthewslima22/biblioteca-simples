/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.sql.*;

public class ModeloUsuario {
    
    private int codigo;
    private String nome;
    private int Livros;
    private int valor;
    private String pesquisa;

    /**
     * @return the codigo
     */
    public int getCodigo() {
        return codigo;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * @return the Livros
     */
    public int getLivros() {
        return Livros;
    }

    /**
     * @param Livros the Livros to set
     */
    public void setLivros(int Livros) {
        this.Livros = Livros;
    }
    
    public int getValor() {
        return valor;
    }

    /**
     * @param codigo the codigo to set
     */
    public void setValor(int valor) {
        this.valor = valor;
    }

    /**
     * @return the pesquisa
     */
    public String getPesquisa() {
        return pesquisa;
    }

    /**
     * @param pesquisa the pesquisa to set
     */
    public void setPesquisa(String pesquisa) {
        this.pesquisa = pesquisa;
    }
    
}
