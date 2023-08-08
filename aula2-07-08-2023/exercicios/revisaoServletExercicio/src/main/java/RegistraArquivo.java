import java.io.BufferedWriter;
import java.io.FileWriter;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;


public class RegistraArquivo {

	public String escrevernoArquivo(String nome, String email) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		
		LocalDateTime horaAtual = LocalDateTime.now();
		
		String enderecoArquivo = "C:\\Users\\Administrador\\eclipse-workspace\\revisaoServletExercicio\\src\\main\\webapp\\META-INF\\cadastro.txt";
		String escrita = horaAtual + " NOME:" +nome+ "EMAIL: " +email;
		
		try {
			BufferedWriter buWriter = new BufferedWriter(new FileWriter(enderecoArquivo, true));
			buWriter.append(escrita + "\n");
			buWriter.close();
			
			System.out.println("Deu bom");
			return "Deu bom no cadastro";
		} catch (Exception e) {
			System.out.println("Deu ruim no cadastro");
			return "Deu ruim no cadastro";
		}
		
		
		
	}
	
}
