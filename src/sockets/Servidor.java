package sockets;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

public class Servidor {

	private static Socket socket;
	private static ServerSocket server;

	private static DataInputStream entrada;
	private static DataOutputStream saida;

	public static void main(String[] args) {

		try {

			//Criar porta de recepção
			server = new ServerSocket(50000);
			socket = server.accept();

			//Criar os fluxos de entrada e saída
			entrada = new DataInputStream(socket.getInputStream());
			saida = new DataOutputStream(socket.getOutputStream());

			//Recebimento do valor inteiro
			String CPF = entrada.readUTF();

			//Verificação do CPF
			System.out.println("\nResultado: ");
			// usando os metodos isCPF() e imprimeCPF() da classe "ValidaCPF"
			if (ValidaCPF.isCPF(CPF) == true)
				saida.writeUTF(ValidaCPF.imprimeCPF(CPF));//Envio dos dados
			else 
				System.out.println("Erro, CPF invalido !!!\n");

			//Envio dos dados		
			socket.close();

		} catch(Exception e) {
			e.printStackTrace();
		}

	}





}
