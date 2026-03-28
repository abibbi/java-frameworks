package com.example.demo.bootstrap;

import com.example.demo.domain.InhousePart;
import com.example.demo.domain.OutsourcedPart;
import com.example.demo.domain.Part;
import com.example.demo.domain.Product;
import com.example.demo.repositories.OutsourcedPartRepository;
import com.example.demo.repositories.PartRepository;
import com.example.demo.repositories.ProductRepository;
import com.example.demo.service.OutsourcedPartService;
import com.example.demo.service.OutsourcedPartServiceImpl;
import com.example.demo.service.ProductService;
import com.example.demo.service.ProductServiceImpl;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Optional;


// this runs when the app starts to put sample data in the database for my skateboard store

@Component
public class BootStrapData implements CommandLineRunner {

    private final PartRepository partRepository;
    private final ProductRepository productRepository;

        private final OutsourcedPartRepository outsourcedPartRepository;


   public BootStrapData(PartRepository partRepository, ProductRepository productRepository, OutsourcedPartRepository outsourcedPartRepository) {
        this.partRepository = partRepository;
        this.productRepository = productRepository;
        this.outsourcedPartRepository = outsourcedPartRepository;
        this.inhousePartRepository = inhousePartRepository;
    }

    @Override
    public void run(String... args) throws Exception {

        // only add sample stuff if the database is empty so we dont delete anyones data
        long numParts = partRepository.count();
        long numProducts = productRepository.count();
        if(numParts == 0 && numProducts == 0 && productRepository.count() == 0) {

        
        // ----- 5 parts for BC Skateboard Shop -----
        // i used a 4-pack for wheels instead of 4 seperate wheel parts because
        // product uses a Set for parts so you cant add the same part twice (assignment said multi-pack)

        InhousePart deck = new InhousePart();
        deck.setName("8\" Maple Deck");
        deck.setPrice(45.0);
        deck.setInv(30);
        deck.setPartId(88001);
        deck.setMinValue(1);
        deck.setMaxValue(100);
        partRepository.save(deck);

        OutsourcedPart trucks = new OutsourcedPart();
        trucks.setName("Aluminum Trucks (pair)");
        trucks.setCompanyName("Thunder Trucks Co.");
        trucks.setPrice(38.0);
        trucks.setInv(45);
        trucks.setMinValue(1);
        trucks.setMaxValue(100);
        partRepository.save(trucks);

        InhousePart wheels = new InhousePart();
        wheels.setName("Street Wheels 52mm (4-pack)");
        wheels.setPrice(32.0);
        wheels.setInv(70);
        wheels.setPartId(88002);
        wheels.setMinValue(1);
        wheels.setMaxValue(100);
        partRepository.save(wheels);

        OutsourcedPart bearings = new OutsourcedPart();
        bearings.setName("ABEC-7 Bearings (set of 8)");
        bearings.setCompanyName("Bones Bearings Supply");
        bearings.setPrice(22.0);
        bearings.setInv(120);
        bearings.setMinValue(1);
        bearings.setMaxValue(100);
        partRepository.save(bearings);

        OutsourcedPart grip = new OutsourcedPart();
        grip.setName("Perforated Grip Tape Sheet");
        grip.setCompanyName("Jessup Manufacturing");
        grip.setPrice(7.50);
        grip.setInv(90);
        grip.setMinValue(1);
        grip.setMaxValue(100);
        partRepository.save(grip);
        

        // ----- 5 products -----

        Product standardComplete = new Product("Standard Complete Skateboard", 199.99, 12);
        standardComplete.getParts().add(deck);
        standardComplete.getParts().add(trucks);
        standardComplete.getParts().add(wheels);
        standardComplete.getParts().add(bearings);
        standardComplete.getParts().add(grip);
        deck.getProducts().add(standardComplete);
        trucks.getProducts().add(standardComplete);
        wheels.getProducts().add(standardComplete);
        bearings.getProducts().add(standardComplete);
        grip.getProducts().add(standardComplete);
        productRepository.save(standardComplete);
        partRepository.save(deck);
        partRepository.save(trucks);
        partRepository.save(wheels);
        partRepository.save(bearings);
        partRepository.save(grip);

        Product proComplete = new Product("Pro Complete Skateboard", 249.99, 8);
        proComplete.getParts().add(deck);
        proComplete.getParts().add(trucks);
        proComplete.getParts().add(wheels);
        proComplete.getParts().add(bearings);
        proComplete.getParts().add(grip);
        deck.getProducts().add(proComplete);
        trucks.getProducts().add(proComplete);
        wheels.getProducts().add(proComplete);
        bearings.getProducts().add(proComplete);
        grip.getProducts().add(proComplete);
        productRepository.save(proComplete);
        partRepository.save(deck);
        partRepository.save(trucks);
        partRepository.save(wheels);
        partRepository.save(bearings);
        partRepository.save(grip);

        Product deckAndGrip = new Product("Deck & Grip Bundle", 69.99, 15);
        deckAndGrip.getParts().add(deck);
        deckAndGrip.getParts().add(grip);
        deck.getProducts().add(deckAndGrip);
        grip.getProducts().add(deckAndGrip);
        productRepository.save(deckAndGrip);
        partRepository.save(deck);
        partRepository.save(grip);

        Product refreshKit = new Product("Trucks Wheels Bearings Kit", 129.99, 10);
        refreshKit.getParts().add(trucks);
        refreshKit.getParts().add(wheels);
        refreshKit.getParts().add(bearings);
        trucks.getProducts().add(refreshKit);
        wheels.getProducts().add(refreshKit);
        bearings.getProducts().add(refreshKit);
        productRepository.save(refreshKit);
        partRepository.save(trucks);
        partRepository.save(wheels);
        partRepository.save(bearings);

        Product tuneUp = new Product("Bearings & Grip Tune-Up", 39.99, 20);
        tuneUp.getParts().add(bearings);
        tuneUp.getParts().add(grip);
        bearings.getProducts().add(tuneUp);
        grip.getProducts().add(tuneUp);
        productRepository.save(tuneUp);
        partRepository.save(bearings);
        partRepository.save(grip);
        
        }

        System.out.println("done loading sample inventory - 5 parts and 5 products");
        System.out.println("product count: " + productRepository.count());
        System.out.println("part count: " + partRepository.count());
    }
}
