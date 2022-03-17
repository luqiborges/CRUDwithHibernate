package aplicacao;

import java.sql.Date;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import org.hibernate.Session;

import modelo.Usuario;

public class Principal {

	public static void main(String[] args) {
		Scanner leitor = new Scanner(System.in);
		int opcaoEscolhida = 0;
		
		//cria a instância de um EntityManager
		EntityManagerFactory fabrica = Persistence.createEntityManagerFactory("vacinacao");
		EntityManager em = fabrica.createEntityManager();
		
		while(opcaoEscolhida != 5) {
			System.out.println("Escolha uma das opções abaixo: ");
			System.out.println("1: Consulta por ID");
			System.out.println("2: Inserção");
			System.out.println("3: Exclusão");
			System.out.println("4: Listar todos usuários");
			System.out.println("5: Sair");
			opcaoEscolhida = leitor.nextInt();
			leitor.nextLine();
			
			if(opcaoEscolhida == 1) {
				System.out.println("Digite o ID do usuário que deseja consultar:");
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
				
				System.out.println("Digite o nome do usuário:");
				nome = leitor.nextLine();
				
				System.out.println("Digite o ano de nascimento do usuario:");
				dataString = leitor.nextLine();
				System.out.println("Digite o mes de nascimento do usuario:");
				dataString += "-" + leitor.nextLine();
				System.out.println("Digite o dia de nascimento do usuario:");
				dataString += "-" + leitor.nextLine();
				data_nasc = java.sql.Date.valueOf(dataString);
				
				System.out.println("Digite o sexo do usuário:");
				sexo = leitor.nextLine();
				
				System.out.println("Digite o logradouro do usuário:");
				logradouro = leitor.nextLine();
				
				System.out.println("Digite o numero residencial do usuário:");
				numero = leitor.nextInt();
				leitor.nextLine();
				
				System.out.println("Digite o setor do usuário:");
				setor = leitor.nextLine();
				
				System.out.println("Digite a cidade do usuário:");
				cidade = leitor.nextLine();
				
				System.out.println("Digite a UF do usuário:");
				uf = leitor.nextLine();

				Usuario novoUsuario = new Usuario(nome,data_nasc,sexo,logradouro,numero,setor,cidade,uf);
				em.getTransaction().begin();
				em.persist(novoUsuario);
				em.getTransaction().commit();
				
			}
			
			if(opcaoEscolhida == 3) {
				System.out.println("Digite o ID do usuário que deseja excluir:");
				long Id = leitor.nextInt();
				leitor.nextLine();
				Usuario usuario = em.find(Usuario.class, Id);
				em.getTransaction().begin();
				em.remove(usuario);
				em.getTransaction().commit();
				
			}
			
			if(opcaoEscolhida == 4) {
				String jpql = "SELECT u FROM Usuario u";
				List<Usuario> listaUsuarios = em.createQuery(jpql, Usuario.class).getResultList();
				
				System.out.println("\n");
				System.out.println("Lista de usuarios: ");
				for(Usuario u : listaUsuarios) {
					System.out.println(u.toString());
				}
				System.out.println("\n");
			}
			
			
		}
		leitor.close();
		

	}

}
