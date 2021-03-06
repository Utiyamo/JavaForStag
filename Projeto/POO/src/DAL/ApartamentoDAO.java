package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import BD.ConexaoDB;
import Models.Apartamento;
import Models.Pessoa;

public class ApartamentoDAO extends ConexaoDB  {
	public void IncluirApartamento(Apartamento apartamento)  {
		try {
			openConnection();
			String sql = "INSERT INTO Apartamento (andar, bloco, predio, numero) VALUES (?,?,?,?)";
			int insertID;
			PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setString(1, apartamento.getAndar());
			st.setString(2, apartamento.getBloco());
			st.setString(3, apartamento.getPredio());
			st.setString(4, apartamento.getNumero());
			insertID = st.executeUpdate();
			apartamento.setId(insertID);
			con.commit();
			
		}catch (Exception e) {
			e.printStackTrace();
			if (con != null) {
	            try {
	                System.err.print("Rollback, erro durante opera��o");
	                con.rollback();
	            } catch(SQLException ex) {
	               ex.printStackTrace();
	            }
	        }
		}finally {
			closeConnection();
		}	
	}
	
	public Apartamento BuscarApartamento(int id) {
		Apartamento apartamento;
		try {
			openConnection();
			String sql = "SELECT * FROM Apartamento a WHERE a.id = ?";			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, id);
			ResultSet resultSet = st.executeQuery();
			if(resultSet.next()) {
				apartamento = new Apartamento(
							resultSet.getInt("id"),
							resultSet.getString("andar"),
							resultSet.getString("bloco"),
							resultSet.getString("predio"),
							resultSet.getString("numero")
						);
				return apartamento;
			}
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		return null;
	}
	
	public void ExcluirApartamento(int id) {
		try {
			openConnection();
			
			String sql = "DELETE Apartamento WHERE id = ?";
			
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
	
	public void EditarApartamento(Apartamento apartamento) {
		try {
			openConnection();
			String sql = "UPDATE Apartamento SET andar= ?, bloco= ?, predio = ?, numero = ? WHERE id = ?";
			PreparedStatement st = con.prepareStatement(sql);
			st.setString(1, apartamento.getAndar());
			st.setString(2, apartamento.getBloco());
			st.setString(3, apartamento.getPredio());
			st.setString(4, apartamento.getNumero());
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

