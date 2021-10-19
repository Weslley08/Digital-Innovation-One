package models;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import conection_bd.ConnectionMysql;

public class AlunoDAO {

	// 1 - Consulta
	public List<Aluno> list() {
		// Preparar lista que ir� retornar alunos ap�s consultar o banco de dados;
		List<Aluno> alunos = new ArrayList<>();

		try (Connection conn = ConnectionMysql.getConnection()) {
			// Preparar consulta SQL.
			String sql = "SELECT * FROM aluno";

			// Preparar statement com os par�metros recebidos (nesta fun��o n�o tem
			// par�metros, pois ir� retornar todos os valores da tabela aluno)
			PreparedStatement stmt = conn.prepareStatement(sql);

			// Executa consulta e armazena o retorno da consulta no objeto "rs".
			ResultSet rs = stmt.executeQuery();

			// Criar um objeto aluno e guardar na lista de alunos.
			while (rs.next()) {
				int id = rs.getInt("id");
				String nome = rs.getString("nome");
				int idade = rs.getInt("idade");
				String estado = rs.getString("estado");

				alunos.add(new Aluno(id, nome, idade, estado));
			}
		} catch (SQLException e) {
			System.out.println("Listagem de alunos FALHOU!");
			e.printStackTrace();
		}

		// Retornar todos os alunos encontrados no banco de dados.
		return alunos;
	}

	// 1.1 - Consulta com filtro
	public Aluno getById(int id) {
		// Preparar objeto aluno para receber os valores do banco de dados.
		Aluno aluno = new Aluno();

		try (Connection conn = ConnectionMysql.getConnection()) {
			// Preparar consulta SQL
			String sql = "SELECT * FROM aluno WHERE id = ?";

			// Preparar statement com os par�metros recebidos
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);

			// Executa consulta e armazena o retorno da consulta no objeto "rs".
			ResultSet rs = stmt.executeQuery();

			// Guardar valores retornados da tabela aluno no objeto aluno
			if (rs.next()) {
				aluno.setId(rs.getInt("id"));
				aluno.setNome(rs.getString("nome"));
				aluno.setIdade(rs.getInt("idade"));
				aluno.setEstado(rs.getString("estado"));
			}

		} catch (SQLException e) {
			System.out.println("Listagem de alunos FALHOU!");
			e.printStackTrace();
		}

		// Retorna aluno encontrado no banco de dados.
		return aluno;
	}

	// 2 - Inser��o
	public void create(Aluno aluno) {
		try (Connection conn = ConnectionMysql.getConnection()) {

			// Preparar SQL para inser��o de dados do aluno.
			String sql = "INSERT INTO aluno(nome, idade, estado) VALUES(?, ?, ?)";

			// Preparar statement com os par�metros recebidos
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, aluno.getNome());
			stmt.setInt(2, aluno.getIdade());
			stmt.setString(3, aluno.getEstado());

			// Executa inser��o e armazena o numero de linhas afetadas
			int rowsAffected = stmt.executeUpdate();

			System.out.println("Inser��o BEM SUCEDIDA!. Foi adicionada " + rowsAffected + " linha");
		} catch (SQLException e) {
			System.out.println("Inser��o FALHOU!");
			e.printStackTrace();
		}
	}

	// 3 - Delete
	public void delete(int id) {
		try (Connection conn = ConnectionMysql.getConnection()) {

			// Preparar SQL para deletar uma linha.
			String sql = "DELETE FROM aluno WHERE id = ?";

			// Preparar statement com os par�metros recebidos
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setInt(1, id);

			// Executa delete e armazena o numero de linhas afetadas
			int rowsAffected = stmt.executeUpdate();

			System.out.println("Delete BEM SUCEDIDA! Foi deletada " + rowsAffected + " linha");
		} catch (SQLException e) {
			System.out.println("Delete FALHOU!");
			e.printStackTrace();
		}
	}

	// 4 - Atualizar
	public void update(Aluno aluno) {
		try (Connection conn = ConnectionMysql.getConnection()) {

			// Preparar SQL para atualizar linhas.
			String sql = "UPDATE aluno SET nome = ?, idade = ?, estado = ? WHERE id = ?";

			// Preparar statement com os par�metros recebidos
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, aluno.getNome());
			stmt.setInt(2, aluno.getIdade());
			stmt.setString(3, aluno.getEstado());
			stmt.setInt(4, aluno.getId());

			// Executa atualiza��o e armazena o numero de linhas afetadas
			int rowsAffected = stmt.executeUpdate();

			System.out.println("Atualiza��o BEM SUCEDIDA! Foi atualizada: " + rowsAffected + " linha");
		} catch (SQLException e) {
			System.out.println("Atualiza��o FALHOU!");
			e.printStackTrace();
		}
	}

}