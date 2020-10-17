package com.example.fullstackdemo;

import com.example.fullstackdemo.models.Brand;
import com.example.fullstackdemo.models.Designer;
import com.example.fullstackdemo.models.Division;
import com.example.fullstackdemo.repositories.BrandRepository;
import com.example.fullstackdemo.repositories.DesignerRepository;
import com.example.fullstackdemo.repositories.DivisionRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Controller;

import javax.annotation.Resource;

@Controller
public class Populator implements CommandLineRunner {

    @Resource
    private DivisionRepository divisionRepo;
    @Resource
    private DesignerRepository designerRepo;
    @Resource
    private BrandRepository brandRepo;

    @Override
    public void run(String... args) throws Exception {

        Division justDoIt = new Division("Just Do It");
        Division swoosh = new Division("Swoosh");
        divisionRepo.save(justDoIt);
        divisionRepo.save(swoosh);

        Designer mau = new Designer("Tran", "Mau");
        Designer tam = new Designer("Tri", "Tam");
        Designer schultz = new Designer("Marcelo", "Shultz");
        Designer bigvava = new Designer("Guga", "Bigvava");
        Designer babii = new Designer("Anatolli", "Babii");
        designerRepo.save(mau);
        designerRepo.save(tam);
        designerRepo.save(schultz);
        designerRepo.save(bigvava);
        designerRepo.save(babii);

        Brand threeguyssketch = new Brand("Three Guys Sketch","Art of a simple character.","/images/threeguyssketch.png" ,justDoIt, mau,tam);
        Brand nikeAirMaxSeries = new Brand("Nike Air Max Series", "Art created using elements from the Nike Air Max series.", "/images/nikeairmaxseries.jpg",justDoIt, schultz);
        Brand runningWoman = new Brand("Running Woman", "Art created to display a woman in motion.","/images/runningwoman.png" ,justDoIt, bigvava);
        Brand toothPasteSwoosh = new Brand("Toothpaste Swoosh", "Art using toothpaste to create the most recognizable symbol.","/images/toothpasteswoosh.jpg" ,swoosh, babii);
        brandRepo.save(threeguyssketch);
        brandRepo.save(nikeAirMaxSeries);
        brandRepo.save(runningWoman);
        brandRepo.save(toothPasteSwoosh);

    }
}
