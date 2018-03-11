package coinAssistant.core;
import java.util.ArrayList;

public class CandleStick {

	private double open;
	private double close;
	private double low; 
	private double high;
	
	public Pattern motif;
	/** 
	 * Class constructor with array data
	*/
	public CandleStick(ArrayList<Double>data) {
		//parametres num�riques depuis les donn�es
		this.open=data.get(0);
		this.close=data.get(data.size()-1);
		this.low=data.get(0);
		this.high=data.get(0);
		for(double i:data) {
			if(i<low) {
				low=i;
			}
			if(i>high) {
				high=i;
			}
		}
		
		//initialisation du pattern
		motif=null;
	}
	/** 
	 * Class constructor with filtered data
	*/
	public CandleStick(double o,double c,double l,double h) {
		this.open=o;
		this.close=c;
		this.low=l;
		this.high=h;
	}
	
	public double getOpen() {return this.open;}
	public double getClose() {return this.close;}
	public double getLow() {return this.low;}
	public double getHigh() {return this.high;}
	
	public void setPattern(Pattern p) {
		motif=p;
	}
	
	/**
	 * D�termine si le candlestick est ascendant ou non
	 * @return true si le candlestick est ascendant, false sinon
	 */
	public boolean isAscend() {
		if(this.close>this.open) {return true;}
		return false;
	}
	
	/**
	 * Renvoie la taille du corps
	 * @return taille du corps
	 */
	public double getBodySize() {
		return Math.abs(open-close);
	}
	/**
	 * Renvoie le plus bas point {open;close}
	 * @return valeur du plus bas point
	 */
	public double getMinBody() {
		return Math.min(open, close);
	}
	/**
	 * Renvoie le plus haut point {open;close}
	 * @return valeur du plus haut point
	 */
	public double getMaxBody() {
		return Math.max(open,close);
	}
	
}
