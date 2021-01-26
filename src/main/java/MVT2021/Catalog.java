package MVT2021;

import java.util.ArrayList;

public class Catalog {

    private ArrayList<Compartment> compartments;

    public Catalog() {

        compartments = new ArrayList<>();
    }

    public int getTotalSize() {
        return compartments.size();
    }

    public ArrayList<Compartment> getCompartments() {
        return this.compartments;
    }

    public void addCompartment(Compartment c) {
        compartments.add(c);
    }

    public Compartment getCompartmentByCompartmentId(String id) {
        Compartment compartment = null;
        compartments = this.getCompartments();
        for (Compartment c : compartments) {
            if (c.getId() == id) {
                compartment = c;
                break;
            }
        }

        return compartment;
    }

    public Compartment getCompartmentByProduct(Product product) {
        Compartment compartment = null;
        compartments = this.getCompartments();
        for (Compartment c : compartments) {
            if (c.getId() == product.getModelNr()) {
                compartment = c;
                break;
            }
        }

        return compartment;
    }
}
