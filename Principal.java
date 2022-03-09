package aplicacao;

import java.sql.Date;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import modelo.Usuario;

public class Principal {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		int opcaoEscolhida = 0;
		
		//cria a inst�ncia de um EntityManager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("vacinacao");
		EntityManager em = fabrica.createEntityManager();
		
		while(opcaoEscolhida != 4) {
			System.out.println("Escolha uma das op��es abaixo: ");
			System.out.println("1: Consulta por ID");
			System.out.println("2: Inser��o");
			System.out.println("3: Exclus�o");
			System.out.println("4: Sair");
			opcaoEscolhida = leitor.nextInt();
			leitor.nextLine();
			
			if(opcaoEscolhida == 1) {
				System.out.println("Digite o ID do usu�rio que deseja consultar:");
				long Id = leitor.nextInt();
				leitor.nextLine();
				Usuario usuario = em.find(Usuario.class, Id);
				System.out.println(usuario.toString());
				
			}
			
			if(opcaoEscolhida == 2) {
				String nome, sexo, logradouro, setor, cidade, uf;
				String dataString;
				Date data_nasc;
				int numero;
				
				System.out.println("Digite o nome do usu�rio:");
				nome = leitor.nextLine();
				
				System.out.println("Digite o ano de nascimento do usuario:");
				dataString = leitor.nextLine();
				System.out.println("Digite o mes de nascimento do usuario:");
				dataString += "-" + leitor.nextLine();
				System.out.println("Digite o dia de nascimento do usuario:");
				dataString += "-" + leitor.nextLine();
				data_nasc = java.sql.Date.valueOf(dataString);
				
				System.out.println("Digite o sexo do usu�rio:");
				sexo = leitor.nextLine();
				
				System.out.println("Digite o logradouro do usu�rio:");
				logradouro = leitor.nextLine();
				
				System.out.println("Digite o numero residencial do usu�rio:");
				numero = leitor.nextInt();
				leitor.nextLine();
				
				System.out.println("Digite o setor usu�rio:");
				setor = leitor.nextLine();
				
				System.out.println("Digite a cidade do usu�rio:");
				cidade = leitor.nextLine();
				
				System.out.println("Digite a UF do usu�rio:");
				uf = leitor.nextLine();

				Usuario novoUsuario = new Usuario(nome,data_nasc,sexo,logradouro,numero,setor,cidade,uf);
				em.getTransaction().begin();
				em.persist(novoUsuario);
				em.getTransaction().commit();
				
			}
			
			if(opcaoEscolhida == 3) {
				System.out.println("Digite o ID do usu�rio que deseja excluir:");
				long Id = leitor.nextInt();
				leitor.nextLine();
				Usuario usuario = em.find(Usuario.class, Id);
				em.getTransaction().begin();
				em.remove(usuario);
				em.getTransaction().commit();
				
			}
			
			
		}
		leitor.close();
		

	}

}
