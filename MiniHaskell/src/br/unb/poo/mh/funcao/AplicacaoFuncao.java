package br.unb.poo.mh.funcao;

import java.util.List;

import br.unb.poo.mh.Ambiente;
import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.Tipo;
import br.unb.poo.mh.Valor;

/**
 * Corresponde a uma expressao do tipo 
 * aplicacao de funcao. 
 * 
 * @author rbonifacio
 */
public class AplicacaoFuncao implements Expressao {
	
	private String nome;
	private List<Expressao> parametros;

	public AplicacaoFuncao(String nome, List<Expressao> parametros) {
		this.nome = nome;
		this.parametros = parametros;
	}

	@Override
	public Valor avaliar() {
		DeclaracaoFuncao dec = Ambiente.instance().
				getDeclaracaoFuncao(nome, parametros.size());
		
		Ambiente.instance().empilha();
		
		for(int i = 0; i < dec.getArgs().size(); i++) {
			Argumento arg = dec.getArgs().get(i);
			Expressao pmt = parametros.get(i);
			
			Ambiente.instance().associaExpressao(arg.getId(), pmt);
		}
		Valor res = dec.getCorpo().avaliar();
		Ambiente.instance().desempilha();
		
		return res;
	}

	@Override
	public Tipo tipo() {
		DeclaracaoFuncao dec = Ambiente.instance().
				getDeclaracaoFuncao(nome, parametros.size());
		
		Argumento arg;
		
		for(Expressao p: parametros){
			arg = dec.getArgs().get(parametros.indexOf(p));
			
			if(!p.tipo().equals(arg.getTipo())){
				//ERRO: tipo declarado eh diferente do tipo da expressao
				return Tipo.Error;
			}
		}
		return Tipo.Funcao;
	}

	@Override
	public boolean checarTipo() {
		return tipo().equals(Tipo.Funcao);
	}
	
	
	
	
	

}
