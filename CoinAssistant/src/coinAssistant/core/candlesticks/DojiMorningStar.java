package coinAssistant.core.candlesticks;

import java.awt.Color;
import java.util.ArrayList;

import coinAssistant.core.CandleStick;
import coinAssistant.core.Pattern;

public class DojiMorningStar extends Pattern{
	static private int taillePattern=3;
	static private Color patternColor=Color.green;
	final double RAPPORT_TAILLE=2;
	public DojiMorningStar() {}
	
	@Override
	public boolean isPatternPresent(ArrayList<CandleStick> data, int rg) {
		CandleStick first=data.get(rg);
		CandleStick second=data.get(rg+1);
		CandleStick third=data.get(rg+2);
		
		return(first.getBodySize()>second.getBodySize()*RAPPORT_TAILLE//corps du premier evenement suffisament grand
		&& !first.isAscend() //premier montant
		&& first.getMinBody()>second.getMaxBody() //gap entre les corps de 1 et 2
		&& second.getMinBody()>second.getMaxBody() //gap entre les corps de 2 et 3
		&& third.isAscend() //troisi�me descendant
		&& third.getBodySize()>second.getBodySize()*RAPPORT_TAILLE); //corps du trois�me suffisament grand
		
		
	}
	
	@Override
	public int getPatternSize() {return taillePattern;}
	
	@Override
	public String getName() {return "Etoile du Matin Doji";}
	
	@Override
	public String getDescription() {
		return "Structure de renversement de creux, c'est une configuration rare form�e "
				+ "de trois chandeliers : le premier est un grand chandelier baissier plein,"
				+ " le second un marteau noir marquant un nouveau plus-bas et qui cl�ture "
				+ "au-dessus de la cl�ture de la premi�re bougie, et le troisi�me est un "
				+ "tr�s petit chandelier blanc.";
	}
	
	@Override
	public Color getColor(){return patternColor;}
}
