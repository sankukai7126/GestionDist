
import java.util.ArrayList;
import java.util.Random;

import visidia.simulation.SimulationConstants;
import visidia.simulation.process.algorithm.LC1_Algorithm;
import visidia.simulation.process.edgestate.MarkedState;


public class Exercice1 extends LC1_Algorithm{
	@Override
	protected void beforeStart() {
		String couleur[] = {"R","V","B"};
		setLocalProperty("label", vertex.getLabel());
	}

	@Override
	public String getDescription() {
		return "Etoile ouverte Leader \n";
	}

	@Override
	protected void onStarCenter() {
		String couleurV[] = new String[2];
		for(int i = 0; i<2; i++) {
			couleurV[i] = (String) getNeighborProperty(i, "label");
		}
		if(getLocalProperty("label").equals(couleurV[0]) && getLocalProperty("label").equals(couleurV[1])) {
			ArrayList<String> couleurPossible = new ArrayList<String>();
			couleurPossible.add("R"); couleurPossible.add("V"); couleurPossible.add("B");
			for(int i = 0; i<2; i++) {
				for(int j = 0; j<couleurPossible.size(); j++) {
					if(couleurV[i] == couleurPossible.get(j)) {
						couleurPossible.remove(j);
					}
				}
			}
			int randCol = 0 + (int)(Math.random() * (couleurPossible.size() -1));
			setLocalProperty("label", couleurPossible.get(randCol));
			
		}else if(getLocalProperty("label").equals(couleurV[0]) || getLocalProperty("label").equals(couleurV[1]) ) {
			ArrayList<String> couleurPossible = new ArrayList<String>();
			couleurPossible.add("R"); couleurPossible.add("V"); couleurPossible.add("B");
			for(int i = 0; i<2; i++) {
				for(int j = 0; j<couleurPossible.size(); j++) {
					if(couleurV[i] == couleurPossible.get(j)) {
						couleurPossible.remove(j);
					}
				}
			}
			
			int randCol = 0 + (int)(Math.random() * (couleurPossible.size() -1));
			setLocalProperty("label", couleurPossible.get(randCol));
			
		}else if((String)(getLocalProperty("label")) != couleurV[0] && (String)(getLocalProperty("label")) != couleurV[1] ) {
			ArrayList<String> couleurPossible = new ArrayList<String>();
			couleurPossible.add("R"); couleurPossible.add("V"); couleurPossible.add("B");
			for(int i = 0; i<2; i++) {
				for(int j = 0; j<couleurPossible.size(); j++) {
					if(couleurV[i] == couleurPossible.get(j)) {
						couleurPossible.remove(j);
					}
				}
			}
			int randCol = 0 + (int)(Math.random() * (couleurPossible.size() -1));
			setLocalProperty("label", couleurPossible.get(randCol));
		}
	}

	@Override
	public Object clone() {
		return new Exercice1();
	}

}
