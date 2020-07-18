package DAL;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

import BD.ConexaoDB;
import Models.Apartamento;
import Models.ApartamentoPessoa;

public class ApartamentoPessoaDAO extends ConexaoDB  {
	public void IncluirApartamentoPessoa(ApartamentoPessoa apartamentoPessoa)  {
		try {
			openConnection();
			String sql = "INSERT INTO ApartamentoPessoa (pessoa_id, apartamento_id) VALUES (?,?)";
			int insertID;
			PreparedStatement st = con.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);
			st.setInt(1, apartamentoPessoa.getPessoa_id());
			st.setInt(2, apartamentoPessoa.getApartamento_id());
			insertID = st.executeUpdate();
			apartamentoPessoa.setId(insertID);
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
	
	public ArrayList<Integer> BuscarApartamentoPessoa(int apartamento_id) {
		try {
			openConnection();
			String sql = "SELECT * FROM Apartamento ap WHERE ap.aparamento_id = ?";			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, apartamento_id);
			ResultSet resultSet = st.executeQuery();
			
			ArrayList<Integer> ids =  new ArrayList<Integer>();
			
			while(resultSet.next()) {
				ids.add(resultSet.getInt("pessoa_id"));
			}
			
			return ids;
			
		}catch(SQLException e){
			e.printStackTrace();
		}finally {
			closeConnection();
		}
		return null;
	}

	public void ExcluirApartamentoPessoaApartamentoId(int apartamento_id) {
		try {
			openConnection();
			
			String sql = "DELETE ApartamentoPessoa ap WHERE ap.apartamento_id = ?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, apartamento_id);
			
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
	
	public void ExcluirApartamentoPessoaPessoaId(int pessoa_id) {
		try {
			openConnection();
			
			String sql = "DELETE ApartamentoPessoa ap WHERE ap.pessoa_id = ?";
			
			PreparedStatement st = con.prepareStatement(sql);
			st.setInt(1, pessoa_id);
			
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

}

