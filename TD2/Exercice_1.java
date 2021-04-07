
import visidia.simulation.SimulationConstants;
import visidia.simulation.process.algorithm.LC1_Algorithm;
import visidia.simulation.process.edgestate.MarkedState;

public class Exercice_1 extends LC1_Algorithm{

	int k = 10;
	int n = 8;
	@Override
	protected void beforeStart() {
		setLocalProperty("label", vertex.getLabel());
		setLocalProperty("s", 0 + (int)(Math.random() * (k -1)));
		setLocalProperty("id", vertex.getId());
		setLocalProperty("jeton", false);
		putProperty("Affichage", getLocalProperty("s"), SimulationConstants.PropertyStatus.DISPLAYED);
	}

	@Override
	public String getDescription() {
		return "Etoile ouverte Leader \n";
	}

	@Override
	protected void onStarCenter() {
		for(int i = 0; i<vertex.getDegree(); i++) {
			if(getLocalProperty("id").equals(0)) {
				if((int)getNeighborProperty(i, "id") != 1) {
					if(getNeighborProperty(i, "s").equals(getLocalProperty("s"))) {
						setLocalProperty("s", ((int)getLocalProperty("s")+1)%k);
					}
				}
			}else {
				if(getNeighborProperty(i, "id").equals(vertex.getId()-1)) {
					if(getNeighborProperty(i, "s") != (getLocalProperty("s"))) {
						setLocalProperty("s", (int)getNeighborProperty(i, "s"));
					}
				}
			}
			
		}
		putProperty("Affichage", getLocalProperty("s"), SimulationConstants.PropertyStatus.DISPLAYED);
	}

	@Override
	public Object clone() {
		return new Exercice_1();
	}
	
}
