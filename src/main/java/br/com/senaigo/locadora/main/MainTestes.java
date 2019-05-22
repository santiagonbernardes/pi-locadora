package br.com.senaigo.locadora.main;

import br.com.senaigo.locadora.controller.ClienteTcpController;
import br.com.senaigo.locadora.model.*;
import br.com.senaigo.locadora.persistencia.Operacao;
import br.com.senaigo.locadora.utils.DataUtils;

import java.io.IOException;
import java.util.List;

public class MainTestes {

	public static void main(String[] args) {
		try {
			Categoria categoria = obtenhaCategoriaTeste();
			Cliente cliente = obtenhaClienteTeste();
			Endereco endereco = obtenhaEnderecoTeste();
			Funcionario funcionario = obtenhaFuncionarioTeste();
			Marca marca = obtenhaMarcaTeste();
			Modelo modelo = obtenhaModeloTeste();
			Motorista motorista = obtenhaMotoristaTeste();
			Veiculo veiculo = obtenhaVeiculoTeste();

			ClienteTcpController controller = new ClienteTcpController();
			controller.execute(categoria, Operacao.INCLUIR);//1
			controller.execute(cliente, Operacao.INCLUIR);//2
			controller.execute(endereco, Operacao.INCLUIR);//3
			controller.execute(funcionario, Operacao.INCLUIR);//4
			controller.execute(marca, Operacao.INCLUIR);//8
			controller.execute(modelo, Operacao.INCLUIR);//5
			controller.execute(motorista, Operacao.INCLUIR);//6
			controller.execute(veiculo, Operacao.INCLUIR);//7

			List<Veiculo> veiculos = (List<Veiculo>) controller.liste("Veiculo");
			System.out.println(veiculos.size());
			List<Cliente> clientes = (List<Cliente>) controller.liste("Cliente");
			System.out.println(clientes.size());
			List<Funcionario> funcionarios = (List<Funcionario>) controller.liste("Funcionario");
			System.out.println(funcionarios.size());
			List<Motorista> motoristas = (List<Motorista>) controller.liste("Motorista");
			System.out.println(motoristas);
		} catch (Exception e) {
			System.out.println("Erro: " + e.getMessage());
		}
	}

	private static Marca obtenhaMarcaTeste() {
		Marca marca = new Marca();
		marca.setNome("Ford");
		marca.setId(8);
		return marca;
	}

	private static Categoria obtenhaCategoriaTeste() {
		Categoria categoria = (Categoria) PersisteDadosFactory.obtenhaInstancia("Categoria");
		categoria.setNome("Econômica");
		categoria.setValorDiarioLocacao(156.78f);
		categoria.setId(1);
		return categoria;
	}

	private static Cliente obtenhaClienteTeste() {
		Cliente cliente = new Cliente();
		cliente.setNome("Emilson Teste");
		cliente.setRazaoSocial("Emilson Teste S/A");
		cliente.setNomeFantasia("Emilson Services");
		cliente.setTelefonePrincipal(obtenhaTelefonePrincipalTeste());
		cliente.setTelefoneAlternativo(obtenhaTelefoneAlternativoTeste());
		cliente.setCpf("123.456.789-00");
		cliente.setCnpj("12.345.789/0001-10");
		cliente.setDataNascimento(DataUtils.convertaStringParaLocalDate("13/04/1986"));
		cliente.setEmail("emilson@email.com");
		cliente.setEndereco(obtenhaEnderecoTeste());
		cliente.setId(2);
		return cliente;
	}

	private static Telefone obtenhaTelefonePrincipalTeste() {
		Telefone telefone = new Telefone();
		telefone.setDdd(62);
		telefone.setNumero(12345678);
		return telefone;
	}

	private static Telefone obtenhaTelefoneAlternativoTeste() {
		Telefone telefone = new Telefone();
		telefone.setDdd(26);
		telefone.setNumero(987654321);
		return telefone;
	}

	private static Endereco obtenhaEnderecoTeste() {
		Endereco endereco = new Endereco();
		endereco.setLogradouro("Rua da Fatesg");
		endereco.setNumero("123");
		endereco.setComplemento("Ed. SENAI");
		endereco.setCep("74123-321");
		endereco.setBairro("Leste Universitário");
		endereco.setCidade("Goiania");
		endereco.setEstado(EstadosBrasil.GO);
		endereco.setId(3);
		return endereco;
	}

	private static Funcionario obtenhaFuncionarioTeste() {
		Funcionario funcionario = new Funcionario();
		funcionario.setNome("Matheus Borba Teste");
		funcionario.setDataNascimento(DataUtils.convertaStringParaLocalDate("26/10/1997"));
		funcionario.setSenha("senha123");
		funcionario.setTelefoneAlternativo(obtenhaTelefoneAlternativoTeste());
		funcionario.setLogin("matheusborba");
		funcionario.setCarteiraDeTrabalho("123456789-0");
		funcionario.setRg("12345-6");
		funcionario.setEmail("matheusborba@email.com");
		funcionario.setTelefonePrincipal(obtenhaTelefonePrincipalTeste());
		funcionario.setEndereco(obtenhaEnderecoTeste());
		funcionario.setCpf("987.654.321-00");
		funcionario.setId(4);

		return funcionario;
	}

	private static Modelo obtenhaModeloTeste() {
		Modelo modelo = new Modelo();
		modelo.setNome("Gol");
		modelo.setMarca(obtenhaMarcaTeste());
		modelo.setId(5);
		return modelo;
	}

	private static Motorista obtenhaMotoristaTeste() {
		Motorista motorista = new Motorista();
		motorista.setNome("Bruno Motorista Teste");
		motorista.setEndereco(obtenhaEnderecoTeste());
		motorista.setCnh("1234A-B");
		motorista.setEmail("brunomotorista@email.com");
		motorista.setTelefoneAlternativo(obtenhaTelefoneAlternativoTeste());
		motorista.setTelefonePrincipal(obtenhaTelefonePrincipalTeste());
		motorista.setDataNascimento(DataUtils.convertaStringParaLocalDate("08/05/1999"));
		motorista.setCpf("000.000.000-00");
		motorista.setId(6);
		return motorista;
	}

	private static Veiculo obtenhaVeiculoTeste() {
		Veiculo veiculo = new Veiculo();
		veiculo.setPlaca("ABC-1234");
		veiculo.setModelo(obtenhaModeloTeste());
		veiculo.setEstado(Estado.LIVRE);
		veiculo.setValorCompra(50500.66f);
		veiculo.setAnoFabricacao(2019);
		veiculo.setRenavam(123545468464516L);
		veiculo.setCategoria(obtenhaCategoriaTeste());
		veiculo.setKmAtual(0);
		veiculo.setId(7);
		return veiculo;
	}
}
