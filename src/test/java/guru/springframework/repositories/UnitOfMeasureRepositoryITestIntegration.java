package guru.springframework.repositories;

import guru.springframework.domain.UnitOfMeasure;
import junit.framework.TestCase;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class UnitOfMeasureRepositoryITestIntegration extends TestCase {

    @Autowired
    UnitOfMeasureRepository unitOfMeasureRepository;


    public void setUp() throws Exception {
        super.setUp();
    }

    @Test
    public void testFindByDescription() {
        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Teaspoon");
        assertEquals("Teaspoon", uomOptional.get().getDescription());
    }

    @Test
    public void testFindByDescriptionCup(){
        Optional<UnitOfMeasure> uomOptional = unitOfMeasureRepository.findByDescription("Cup");
        assertEquals("Cup", uomOptional.get().getDescription());
    }
}
