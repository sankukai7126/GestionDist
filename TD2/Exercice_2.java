
import java.util.ArrayList;

import visidia.simulation.SimulationConstants;
import visidia.simulation.process.algorithm.LC1_Algorithm;
import visidia.simulation.process.edgestate.MarkedState;

public class Exercice_2 extends LC1_Algorithm{

	int cmpt = 0;
	ArrayList<Integer> idVoisin = new ArrayList<Integer>();
	ArrayList<String> etatVoisin = new ArrayList<String>();
	
	@Override
	protected void beforeStart() {
		setLocalProperty("label", vertex.getLabel());
		setLocalProperty("id", vertex.getId());
		for(int i = 1; i<vertex.getDegree(); i++) {
			idVoisin.add((int)getNeighborProperty(i, "id"));
			etatVoisin.add(getNeighborProperty(i, "label").toString());
		}
	}

	@Override
	public String getDescription() {
		return "Etoile ouverte Leader \n";
	}

	@Override
	protected void onStarCenter() {
		
		for(int i = 1; i<vertex.getDegree(); i++) {
			idVoisin.set(i, (int)getNeighborProperty(i, "id"));
			etatVoisin.set(i, getNeighborProperty(i, "label").toString());
		}
		if(getLocalProperty("label").equals("A")) {
			if(cmpt<7) {
				cmpt ++;
			}else {
				localTermination();
			}
		}
		
		
		putProperty("Affichage", getLocalProperty("s"), SimulationConstants.PropertyStatus.DISPLAYED);
	}

	@Override
	public Object clone() {
		return new Exercice_2();
	}
	
}
