package org.serratec.com.backend.projeto03.service;

import java.util.ArrayList;
import java.util.List;

import org.serratec.com.backend.projeto03.exceptions.NumeroNaoEncontrado;
import org.serratec.com.backend.projeto03.exceptions.SaldoInsuficiente;
import org.serratec.com.backend.projeto03.models.ContaEntity;
import org.serratec.com.backend.projeto03.models.OperacaoEntity;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

@Service
public class ApiService {
//	CRIANDO ARRAY DE LISTA DE CONTA
	List<ContaEntity> list = new ArrayList<ContaEntity>();

////	metodo criado para retornar a lista
	public List<ContaEntity> readAll() {
		return this.list;// retornando a lista no apache
	}

	// metodo para retornar pelo numero da conta
	public ContaEntity readCount(Integer numero) {
		for (ContaEntity contaEntity : list) {
			if (numero == contaEntity.getNumero()) {
				return contaEntity;
			}
		}
		throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Conta não existe");

	}

// criando metodo para criar a lista e preencher
	public ContaEntity create(ContaEntity conta) {
		for (ContaEntity contaEntity : list) {
			if (contaEntity.getNumero() == contaEntity.getNumero()) {
				return null;
			}
		

		}
		list.add(conta);
		return conta;
	}

//criando metodo para dar update na lista
	public ContaEntity update(ContaEntity conta, Integer numero) throws NumeroNaoEncontrado {
		for (ContaEntity contaEntity : list) {// percorre a lista
			if (numero == contaEntity.getNumero()) {
				contaEntity.setTitular(conta.getTitular());
				contaEntity.setNumero(conta.getNumero());
				return contaEntity;
			}
		}
		throw new NumeroNaoEncontrado("Conta não existe");
	}

//criando metodo delete da lista
	public String delete(Integer numero) throws NumeroNaoEncontrado {
		for (ContaEntity contaEntity : list) {
			if (numero == contaEntity.getNumero()) {
				list.remove(contaEntity);
				return "Conta deletada.";
			}
		}
		throw new NumeroNaoEncontrado("Número da Conta não existe");
	}

// método para
	public String atualizaSaldo(Integer numero, OperacaoEntity operacao) throws SaldoInsuficiente, NumeroNaoEncontrado {
		for (ContaEntity contaEntity : list) {
			if (numero == contaEntity.getNumero()) {
				switch (operacao.getTipo()) {
				case DEBITO:
					if (operacao.getValor() <= contaEntity.getSaldo()) {
						contaEntity.setSaldo(contaEntity.getSaldo() - operacao.getValor());
						return "O novo saldo é: " + contaEntity.getSaldo();
					}
					throw new SaldoInsuficiente("Saldo insuficiente");

				case CREDITO:
					contaEntity.setSaldo(contaEntity.getSaldo() + operacao.getValor());
					return "O atual saldo da conta é: " + contaEntity.getNumero();

				case DEPOSITO:
					contaEntity.setSaldo(contaEntity.getSaldo() + operacao.getValor());
					return "O saldo atual é: " + contaEntity.getSaldo();
				}

			}
		}
		throw new NumeroNaoEncontrado("Número da Conta não existe");

	}

}
