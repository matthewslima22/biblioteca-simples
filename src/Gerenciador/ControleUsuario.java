/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Gerenciador;

import Modelo.ModeloUsuario;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;

import java.sql.*;

/**
 *
 * @author Matthews
 */
public class ControleUsuario {
    
    ConexaoBD conex = new ConexaoBD();
    ModeloUsuario mod = new ModeloUsuario();
    
    public void Salvar(ModeloUsuario mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("insert into usuario(nome_usuario, livros_usuario, valor_em_reais) values(?,?,5)");
            pst.setString(1, mod.getNome());
            pst.setInt(2, mod.getLivros());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Inseridos com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Inserir os Dados!\nErro:"+ex);
        }
        
        conex.desconecta();
    }
    
    public void Editar(ModeloUsuario mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("update usuario set nome_usuario=?, livros_usuario=? where cod_usuario=?");
            pst.setString(1, mod.getNome());
            pst.setInt(2, mod.getLivros());
            pst.setInt(3, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Alterados Com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro na Alteração dos Dados!\n"+ex);
        }
        
        
        conex.desconecta();
    }    
    
    public void Excluir(ModeloUsuario mod){
        conex.conexao();
        try {
            PreparedStatement pst = conex.con.prepareStatement("delete from usuario where cod_usuario=?");
            pst.setInt(1, mod.getCodigo());
            pst.execute();
            JOptionPane.showMessageDialog(null, "Dados Excluidos com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Ecluir Dados!\n"+ex);
        }
        
        
        conex.desconecta();
    }
            
            
    
    public ModeloUsuario buscaUsuario(ModeloUsuario mod){
        conex.conexao();
        conex.executaSql("select *from usuario where nome_usuario like'%"+mod.getPesquisa()+"%'");
        try {
            conex.rs.first();
            mod.setCodigo(conex.rs.getInt("cod_usuario"));
            mod.setNome(conex.rs.getString("nome_usuario"));
            mod.setLivros(conex.rs.getInt("livros_usuario"));
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Buscar usuario!\nErro:"+ex);
        }
        
        conex.desconecta();
        return mod;
    }
    
}
