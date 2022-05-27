package rxwriter.drug;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.Test;

public class DrugConceptTest {

    public final static DrugConcept TEST_CONCEPT = new DrugConcept(new DrugClassification[]{
        DrugClassification.ANTIANXIETY,
        DrugClassification.ANALGESICS_NARCOTIC,
        DrugClassification.NARCOTIC_ANTHISTAMINE});

    @Test
    void drugBelongsInConceptIfOneClassMatches() {
        DispensableDrug drug = new DispensableDrug("adrug", 
        new DrugClassification[]{
            DrugClassification.ANTIANXIETY,
            DrugClassification.ANALGESIC}, false);
          
        assertTrue(TEST_CONCEPT.isDrugInConcept(drug));    
    }

    @Test
    void drugNotInConceptIfNoClassMatches() {
        DispensableDrug drug = new DispensableDrug("adrug", 
        new DrugClassification[]{
            DrugClassification.ANTIFUNGAL,
            DrugClassification.ANALGESIC}, false);
          
        assertFalse(TEST_CONCEPT.isDrugInConcept(drug));    
    }
}
