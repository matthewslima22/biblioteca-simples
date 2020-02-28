
package Gerenciador;

import java.sql.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;


public class ConexaoBD {
    public Statement stm; //responsavel pelas pesquisas//
    public ResultSet rs;  // responsavel por guardar as pesquisas//
    public String driver = "org.postgresql.Driver";
    private String caminho = "jdbc:postgresql://localhost:5432/AluguelDeLivros";
    private String usuario = "postgres";
    private String senha = "4015";
    public Connection con; // resposavel pela conexão//
    
    public void conexao(){ // metodo resposavel por realizar a conexão com a base de dados//
        
        try {
            System.setProperty("jdbc.Drivers", driver);
            con=DriverManager.getConnection(caminho, usuario, senha);
            //JOptionPane.showMessageDialog(null, "Conexão Efetuada com Sucesso! ");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao se Conectar:\n"+ex.getMessage());
        }
    }
 
    public void executaSql(String sql){
        try {
            stm = con.createStatement(rs.TYPE_SCROLL_INSENSITIVE,rs.CONCUR_READ_ONLY);
            rs = stm.executeQuery(sql);
            
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao ExecutarSql:\n"+ex.getMessage());
        }
        
    }
    
    public void desconecta(){ // metodo resposavel por realizar a desconexão com a base de dados//
        try {
            con.close();
            //JOptionPane.showMessageDialog(null, "Desconectado com Sucesso!");
        } catch (SQLException ex) {
            JOptionPane.showMessageDialog(null, "Erro ao Fechar Conexão com o Banco de Dados:\n"+ex.getMessage());
        }
    }
}
