package DAL;


import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import BD.ConexaoDB;
import Models.Pessoa;

public class PessoaDAO extends ConexaoDB  {
	public void IncluirPessoa(Pessoa pessoa)  {
		try {
			openConnection();
			String sql = "INSERT INTO Pessoa (nome,rg,tipo) VALUES (?,?,?)";
			int insertID;
			PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, pessoa.getNome());
			st.setString(2, pessoa.getRg());
			st.setInt(3, pessoa.getTipo());
			insertID = st.executeUpdate();
			pessoa.setId(insertID);
			con.commit();
		}catch (Exception e) {
			e.printStackTrace();
			if (con != null) {
	            try {
	                System.err.print("Rollback, erro durante operação");
	                con.rollback();
	            } catch(SQLException ex) {
	               ex.printStackTrace();
	            }
	        }
		}finally {
			closeConnection();
		}	
	}
	
	public Pessoa BuscarPessoaRG(String rg) {
		Pessoa pessoa = null;
		try {
			openConnection();
			String sql = "SELECT * FROM Pessoa p WHERE p.rg like ?";			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, rg);
			ResultSet rst = st.executeQuery();
			if(rst.next()) {
				pessoa = new Pessoa(
								rst.getInt("id"),
								rst.getString("nome"),
								rst.getString("rg"),
								rst.getInt("tipo"));
				pessoa.setId(rst.getInt("id"));
				return pessoa;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		return null;
	}
	
	public Pessoa BuscarPessoa(int id) {
		Pessoa pessoa = null;
		try {
			openConnection();
			String sql = "SELECT * FROM Pessoa p WHERE p.id like ?";			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet rst = st.executeQuery();
			if(rst.next()) {
				pessoa = new Pessoa(
								rst.getInt("id"),
								rst.getString("nome"),
								rst.getString("rg"),
								rst.getInt("tipo"));
				pessoa.setId(rst.getInt("id"));
				return pessoa;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		return null;
	}
	
	public void ExcluirPessoaId(int id) {
		try {
			openConnection();
			
			String sql = "DELETE Pessoa WHERE id = ?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			
			st.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			if (con != null) {
	            try {
	                con.rollback();
	            } catch(SQLException ex) {
	               ex.printStackTrace();
	            }
	        }

			e.printStackTrace();
		}finally {
			closeConnection();
		}
	}
	
	public void ExcluirPessoaRg(String rg) {
		try {
			openConnection();
			
			String sql = "DELETE Pessoa WHERE rg = ?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, rg);
			
			st.executeUpdate();
			con.commit();
		} catch (SQLException e) {
			if (con != null) {
	            try {
	                con.rollback();
	            } catch(SQLException ex) {
	               ex.printStackTrace();
	            }
	        }

			e.printStackTrace();
		}finally {
			closeConnection();
		}
	}
	
	public void EditarPessoa(Pessoa pessoa) {
		try {
			openConnection();
			String sql = "UPDATE Reserva SET nome = ?, rg = ?, tipo = ? WHERE id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, pessoa.getNome());
			st.setString(2, pessoa.getRg());
			st.setInt(3, pessoa.getTipo());
			st.setInt(4, pessoa.getId());
			st.executeUpdate();
			con.commit();
		} catch (Exception e) {
			if (con != null) {
	            try {
	                con.rollback();
	            } catch(SQLException ex) {
	               ex.printStackTrace();
	            }
	        }
			e.printStackTrace();
		}finally {
			closeConnection();
		}
	}
}

