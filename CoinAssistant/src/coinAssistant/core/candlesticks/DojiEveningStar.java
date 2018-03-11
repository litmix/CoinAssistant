package coinAssistant.core.candlesticks;

import java.util.ArrayList;
import coinAssistant.core.*;

public class DojiEveningStar extends Pattern{
	static private int taillePattern=3;
	final double RAPPORT_TAILLE=2;
	public DojiEveningStar() {}
	
	//identifie une sequence pr�cise comme correspondante au pattern ou non
	public boolean isPatternPresent(ArrayList<CandleStick> data, int rg) {
		CandleStick first=data.get(rg);
		CandleStick second=data.get(rg+1);
		CandleStick third=data.get(rg+2);
		
		return (first.getBodySize()>second.getBodySize()*RAPPORT_TAILLE//corps du premier evenement suffisament grand
		&& first.isAscend() //premier montant
		&& first.getMaxBody()<second.getMinBody() //gap entre les corps de 1 et 2
		&& second.getMaxBody()<second.getMinBody() //gap entre les corps de 2 et 3
		&& !third.isAscend() //troisi�me descendant
		&& third.getBodySize()>second.getBodySize()*RAPPORT_TAILLE); //corps du trois�me suffisament grand
	
		
	}
	
	//retourne la taille de l'�venement consid�r�
	public int getPatternSize() {return taillePattern;}
}
