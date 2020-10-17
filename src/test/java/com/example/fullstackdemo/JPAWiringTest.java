package com.example.fullstackdemo;

import com.example.fullstackdemo.models.Brand;
import com.example.fullstackdemo.models.Designer;
import com.example.fullstackdemo.models.Division;
import com.example.fullstackdemo.repositories.BrandRepository;
import com.example.fullstackdemo.repositories.DesignerRepository;
import com.example.fullstackdemo.repositories.DivisionRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;

import java.util.Optional;

import static org.assertj.core.api.Assertions.assertThat;

@DataJpaTest
public class JPAWiringTest {

    @Autowired
    private TestEntityManager entityManager;

    @Autowired
    private DivisionRepository divisionRepo;
    @Autowired
    private DesignerRepository designerRepo;
    @Autowired
    private BrandRepository brandRepo;

    @Test
    public void divisionShouldHaveAListOfBrands() {
        Division testDivision = new Division("Test Type");
        Division testDivision2 = new Division("Test Type");
        Designer testDesigner1 = new Designer("Test firstName", "Test lastName");
        Brand testBrand = new Brand("Title","Description", testDivision, testDesigner1);
        Brand testBrand2 = new Brand("Title","Description", testDivision2, testDesigner1);

        divisionRepo.save(testDivision);
        divisionRepo.save(testDivision2);
        designerRepo.save(testDesigner1);
        brandRepo.save(testBrand);
        brandRepo.save(testBrand2);

        entityManager.flush();
        entityManager.clear();

        Optional<Division> retrievedDivisionOpt = divisionRepo.findById(testDivision.getId());
        Division retrievedDivision = retrievedDivisionOpt.get();
        assertThat(retrievedDivision.getBrands()).contains(testBrand);
    }

    @Test
    public void brandsShouldBeAbleToHaveMultipleDesigners() {
        Division testDivision = new Division("Test Type");
        Designer testDesigner1 = new Designer("Test firstName", "Test lastName");
        Designer testDesigner2 = new Designer("Test firstName", "Test lastName");
        Brand testBrand1 = new Brand("Title","Description", testDivision, testDesigner1, testDesigner2);
        Brand testBrand2 = new Brand("Title","Description", testDivision, testDesigner1);
        Brand testBrand3 = new Brand("Title","Description", testDivision, testDesigner2);

        divisionRepo.save(testDivision);
        designerRepo.save(testDesigner1);
        designerRepo.save(testDesigner2);
        brandRepo.save(testBrand1);
        brandRepo.save(testBrand2);
        brandRepo.save(testBrand3);

        entityManager.flush();
        entityManager.clear();

        Brand retrieveBrand = brandRepo.findById(testBrand1.getId()).get();
        Designer retrieveDesigner1 = designerRepo.findById(testDesigner1.getId()).get();
        Designer retrieveDesigner2 = designerRepo.findById(testDesigner1.getId()).get();
        assertThat(retrieveBrand.getDesigners()).contains(testDesigner1,testDesigner2);
    }
}