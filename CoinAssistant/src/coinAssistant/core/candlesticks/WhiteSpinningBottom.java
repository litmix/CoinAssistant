package coinAssistant.core.candlesticks;

import java.util.ArrayList;

import coinAssistant.core.CandleStick;
import coinAssistant.core.Pattern;

public class WhiteSpinningBottom extends Pattern {

	@Override
	public boolean isPatternPresent(ArrayList<CandleStick> data, int index) {
		if (index < 2)
			return false;
		CandleStick first = data.get(index);
		CandleStick firstBefore = data.get(index - 1);
		CandleStick secondBefore = data.get(index - 2); // doit s'inscrire dans une tendance baissi�re
		return !firstBefore.isAscend() &&
				!secondBefore.isAscend() &&
				first.isAscend() &&
				first.getLow() > firstBefore.getLow() &&
				first.getLowerShadowSize() > 2 * first.getBodySize() &&
				first.getUpperShadowSize() > 2 * first.getBodySize();
	}

	@Override
	public int getPatternSize() {
		return 1;
	}

}
