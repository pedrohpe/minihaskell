package br.unb.poo.mh.expressoes.matematicas;

import br.unb.poo.mh.Expressao;
import br.unb.poo.mh.ExpressaoBinaria;
import br.unb.poo.mh.Tipo;
import br.unb.poo.mh.Valor;
import br.unb.poo.mh.ValorInteiro;


public class ExpressaoMultiplicacao extends ExpressaoBinaria {

	public ExpressaoMultiplicacao(Expressao expDireita, Expressao expEsquerda) {
		super(expDireita, expEsquerda);
	}

	@Override
	public Valor avaliar() {
		ValorInteiro v1 = (ValorInteiro)expEsquerda.avaliar();
		ValorInteiro v2 = (ValorInteiro)expDireita.avaliar();
		
		return new ValorInteiro(v1.getValor() * v2.getValor());
	}

	@Override
	public Tipo tipo() {
		return (expEsquerda.tipo() == Tipo.Inteiro && expDireita.tipo() == Tipo.Inteiro) ? Tipo.Inteiro :
		 Tipo.Error;
	}

	public boolean checarTipo() {
		// TODO Auto-generated method stub
		return tipo().equals(Tipo.Inteiro);
		
	}
}