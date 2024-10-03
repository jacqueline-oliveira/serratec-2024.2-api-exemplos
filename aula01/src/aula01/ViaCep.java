package aula01;

import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.net.http.HttpResponse.BodyHandlers;
import java.util.Scanner;

public class ViaCep {
	public static void main(String[] args) throws IOException, InterruptedException  {
		 //Crio scanner para ler o cep desejado
		 Scanner leitura = new Scanner(System.in);
		 System.out.println("Digite o cep desejado: ");
		 var cep = leitura.nextLine();
		 
		 //Crio o client que é a classe que vai enviar a requisição
		 HttpClient client = HttpClient.newHttpClient();
		 
		 //Crio a requisição com a URI já concatenada com o cep desejado
		 HttpRequest request = HttpRequest.newBuilder()
		         .uri(URI.create("https://viacep.com.br/ws/" + cep + "/json/"))
		         .build();
		 
		 //Crio a resposta que será retornada pelo client.send
		 HttpResponse<String> response = client.send(request, BodyHandlers.ofString());
		 
		 //Exibo o corpo da resposta
		 System.out.println(response.body());
		 leitura.close();				
	}

}
