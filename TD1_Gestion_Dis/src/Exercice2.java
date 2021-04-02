import java.util.ArrayList;
import java.util.Random;

import visidia.simulation.SimulationConstants;
import visidia.simulation.process.algorithm.LC1_Algorithm;
import visidia.simulation.process.edgestate.MarkedState;

public class Exercice2 extends LC1_Algorithm{
	
	int n;
	boolean P;
	
	@Override
	protected void beforeStart() {
		P = false;
		n = 1 + (int)(Math.random() * 4 - 1);
		setLocalProperty("label", vertex.getLabel());
		setLocalProperty("a", -1);
		putProperty("Affichage", getLocalProperty("a"), SimulationConstants.PropertyStatus.DISPLAYED);
	}

	@Override
	public String getDescription() {
		return "Etoile ouverte Leader \n";
	}

	@Override
	protected void onStarCenter() {
		if(n>0) {
			n--;
		}else if( n== 0) {
			P = true;
			n--;
			setLocalProperty("a", 0);
		}else {
			int min = (int)getLocalProperty("a");
			for(int i = 0; i<vertex.getDegree(); i++) {
				if(min > (int)getNeighborProperty(i, "a")) {
					min = (int)getNeighborProperty(i, "a");
				}
			}
			setLocalProperty("a", min+1);
		}
		if(getLocalProperty("a").equals(5)) {
			globalTermination();
		}
		putProperty("Affichage", getLocalProperty("a"), SimulationConstants.PropertyStatus.DISPLAYED);
	}

	@Override
	public Object clone() {
		return new Exercice2();
	}
}
