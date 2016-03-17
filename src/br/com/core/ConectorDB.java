package br.com.core;

import java.sql.*;

public class ConectorDB {
	
	private Connection conexao;
	private Statement st;//homologação
	private ResultSet resultado;
	
	public ConectorDB(){
		try{
			Class.forName("com.mysql.jdbc.Driver");
			conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/test","root","");
			st = conexao.createStatement();
		}catch(Exception error){
			System.out.println("Erro: " + error);
			System.exit(0);
		}
	}
	
	public void PegarDados(){
		try{
			String executar = "select * from persons";
			resultado = st.executeQuery(executar);
			System.out.println("Registros do Banco de Dados");
			
			while(resultado.next()){
				String nome = resultado.getString("nome");
				String idade = resultado.getString("idade");
				String id = resultado.getString("idade");
				System.out.println("Nome: "+nome+"   " + "Idade: " + idade);
			}
		}catch(Exception error){
			System.out.println("Erro ao pegar dados :>" + error);
		}
	}
}
