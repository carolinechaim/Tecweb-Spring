package mvc.model;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;



public class taskDAO {
	private Connection connection = null;
	
	public taskDAO() throws ClassNotFoundException, SQLException {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/meus_dados?serverTimezone=UTC",
                "root", "9vpnvn00");
	}

	public void adiciona (Tasks task) throws SQLException {
		String sql = "INSERT INTO tasks" + "(usuario,tag,tarefa) values(?,?,?)";
		PreparedStatement stmt = connection.prepareStatement(sql);
		stmt.setNString(1,task.getUsuario());
		stmt.setNString(2,task.getTag());
		stmt.setNString(3,task.getTarefa());
		stmt.execute();
		stmt.close();
		
	}
	
	
	public List<Tasks> getListaMod(Tasks task) throws SQLException{
		List<Tasks> tasks = new ArrayList<Tasks>();
		
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM tasks WHERE tag =?;");
		stmt.setNString(1,task.getTag());
		ResultSet rs = stmt.executeQuery();
		
		
		
		while (rs.next()) {
			Tasks taskk = new Tasks();
			taskk.setId(rs.getInt("id"));
			taskk.setUsuario(rs.getNString("usuario"));
			taskk.setTag(rs.getNString("tag"));
			taskk.setTarefa(rs.getNString("tarefa"));
			
			tasks.add(taskk);
			
		}
		rs.close();
		stmt.close();
		
		return tasks;
		
	}
	

	
	
	public void remove (Integer id) throws SQLException {
	String sql = "DELETE FROM tasks WHERE id = ?";
	PreparedStatement stmt = connection.prepareStatement(sql);
	stmt.setInt(1, id);
	stmt.execute();
	stmt.close();
	}	
	
	public Tasks buscaPorId (Integer id) throws SQLException {
		Tasks task = new Tasks();
		
		PreparedStatement stmt = connection.prepareStatement("SELECT * FROM tasks WHERE id = ?");
		stmt.setLong(1,id);
		ResultSet rs = stmt.executeQuery();
		if(rs.next()) {
			task.setId(rs.getInt("id"));
			task.setTarefa(rs.getNString("tarefas"));
			
		}
		
		rs.close();
		stmt.close();
		
		
		return task;
		
		
		
	}
	
}
