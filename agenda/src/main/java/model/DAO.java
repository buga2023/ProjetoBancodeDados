package model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

public class DAO {

	private static final String URL = "jdbc:postgresql://localhost:5432/AgendaContatos?useTimezone=true&serverTimezone=UTC";
	private static final String USUARIO = "postgres";
	private static final String SENHA = "88646480";

	public static Connection conectar() {
		Connection con = null;
		try {
			Class.forName("org.postgresql.Driver");
			con = DriverManager.getConnection(URL, USUARIO, SENHA);
			return con;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return null;

	}

	public void inseirContato(JavaBeans contato) {
		String create = "insert into contatos (nome,fone,email) values(?,?,?)";

		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(create);
			pst.setString(1, contato.getNome());
			pst.setString(2, contato.getFone());
			pst.setString(3, contato.getEmail());
			pst.executeUpdate();
			con.close();

		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public ArrayList<JavaBeans> listarContatos() {
		ArrayList<JavaBeans> contatos = new ArrayList<>();
		String read = "select * from contatos order by nome";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read);
			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				String idcon = rs.getString(1);
				String nome = rs.getString(2);
				String fone = rs.getString(3);
				String email = rs.getString(4);
				contatos.add(new JavaBeans(idcon, nome, fone, email));
			}
			con.close();
			return contatos;
		} catch (Exception e) {
			System.out.println(e);
			return null;
		}

	}

	public void selecionarContatos(JavaBeans contato) {
		String read2 = "SELECT * FROM contatos WHERE idcon=?";
		try {
			Connection con = conectar();
			PreparedStatement pst = con.prepareStatement(read2);

			try {
				int idconValue = Integer.parseInt(contato.getIdcon());
				pst.setInt(1, idconValue);
			} catch (NumberFormatException e) {
				pst.setString(1, contato.getIdcon());
			}

			ResultSet rs = pst.executeQuery();
			while (rs.next()) {
				contato.setIdcon(rs.getString(1));
				contato.setNome(rs.getString(2));
				contato.setFone(rs.getString(3));
				contato.setEmail(rs.getString(4));
			}
			con.close();
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public void alterarContato(JavaBeans contato) {
		String create="UPDATE contatos SET nome=?, fone=?, email=? WHERE idcon= ?";
		try (Connection con = conectar();
			     PreparedStatement pst = con.prepareStatement(create)) {

			    pst.setString(1, contato.getNome());
			    pst.setString(2, contato.getFone());
			    pst.setString(3, contato.getEmail());
			    pst.setInt(4, Integer.parseInt(contato.getIdcon()));

			    pst.executeUpdate();
			    con.close();

			} catch (Exception e) {
			    System.out.println(e);
			}
      
	}

}
