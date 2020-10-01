package mvc.controller;
import java.sql.SQLException;

import org.springframework.stereotype.Controller;
import
org.springframework.web.bind.annotation.RequestMapping;

import mvc.model.Tasks;
import mvc.model.taskDAO;
@Controller



public class TarefasController {

	@RequestMapping("adiciona")
	

public String adiciona(Tasks task) throws ClassNotFoundException, SQLException {
	taskDAO dao= new
			
	taskDAO();
	dao.adiciona(task);
	return "adicionada";
			
		}
	@RequestMapping("criaTarefa")
	public String form() {
		return "formTarefa";
	}
	@RequestMapping("/")
public String execute() {
		System.out.println("Logica do mvc");
		return "info";

		
	}
	
	
	
	
	
}
