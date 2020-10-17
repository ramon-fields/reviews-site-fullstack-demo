package com.example.fullstackdemo;

import com.example.fullstackdemo.models.Brand;
import com.example.fullstackdemo.models.Designer;
import com.example.fullstackdemo.models.Division;
import com.example.fullstackdemo.repositories.BrandRepository;
import com.example.fullstackdemo.repositories.DesignerRepository;
import com.example.fullstackdemo.repositories.DivisionRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

@ExtendWith(SpringExtension.class)
@WebMvcTest
public class WebLayerTest {

    @MockBean
    private DivisionRepository divisionRepo;

    @MockBean
    private BrandRepository brandRepo;

    @MockBean
    private DesignerRepository designerRepo;

    @Autowired
    private MockMvc mockMvc;


    @Test
    public void divisionsShouldBeOkAndReturnDivisionsViewWithDivisionsModelAttribute() throws Exception {
        mockMvc.perform(get("/divisions"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("divisionsView"))
                .andExpect(model().attributeExists("divisions"));
    }

    @Test
    public void brandsShouldBeOkAndReturnBrandsViewWithBrandsModelAttribute() throws Exception {
        mockMvc.perform(get("/brands"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("brandsView"))
                .andExpect(model().attributeExists("brands"));
    }

    @Test
    public void designersShouldBeOkAndReturnDesignersViewWithDesignersModelAttribute() throws Exception {
        mockMvc.perform(get("/designers"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(view().name("designersView"))
                .andExpect(model().attributeExists("designers"));
    }

    @Test
    public void shouldBeOkForASingleDivisionEndpointWithDivisionViewAndDivisionModelAttribute() throws Exception {
        Division testDivision = new Division("Just Do It");
        when(divisionRepo.findDivisionByType("Just Do It")).thenReturn(testDivision);
        mockMvc.perform(get("/divisions/Just Do It"))
                .andExpect(status().isOk())
                .andExpect(view().name("divisionView"))
                .andExpect(model().attributeExists("division"));
    }

    @Test
    public void shouldBeOkForASingleBrandEndpointWithBrandViewAndDivisionModelAttribute() throws Exception {
        Division testDivision = new Division("Just Do It");
        Designer testDesigner = new Designer("First", "Last");
        Brand testBrand = new Brand("Title", "Description", testDivision, testDesigner);
        when(brandRepo.findById(1L)).thenReturn(java.util.Optional.of(testBrand));
        mockMvc.perform(get("/brands/1"))
                .andExpect(status().isOk())
                .andExpect(view().name("brandView"))
                .andExpect(model().attributeExists("brand"));
    }
}