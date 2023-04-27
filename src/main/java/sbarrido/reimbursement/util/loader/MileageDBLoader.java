package sbarrido.reimbursement.util.loader;

import java.util.Calendar;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import sbarrido.reimbursement.model.destination.Destination;
import sbarrido.reimbursement.model.expense.Mileage;
import sbarrido.reimbursement.repository.destination.DestinationRepository;
import sbarrido.reimbursement.repository.expense.MileageRepository;

@Component
@Order(1)
public class MileageDBLoader implements CommandLineRunner {
    private final DestinationRepository dRepository;
    private final MileageRepository mRepository;

    @Autowired
    public MileageDBLoader(DestinationRepository destinations, MileageRepository mileage) {
        this.dRepository = destinations;
        this.mRepository = mileage;
    }
    
    @Override
    public void run(String... strings) throws Exception {
        initializeDestinations();
        initializeMileages();
    }

    private void initializeDestinations() {
       Destination chicago = new Destination("Chicago", 50.2);
       Destination indy = new Destination("Indy", 15.5);
       Destination washington = new Destination("Washington", 100.92);

       this.dRepository.save(chicago);
       this.dRepository.save(indy);
       this.dRepository.save(washington);
    }
    private void initializeMileages() {
        Date myDate = new Date();
        Calendar cal = Calendar.getInstance();
        cal.set(2022, 5, 4);
        Date diffDate = cal.getTime();
        String mydesc = "General Description";

        Mileage chicago = new Mileage(myDate, mydesc, this.dRepository.findByLocation("Chicago"));
        Mileage indy = new Mileage(myDate, mydesc, this.dRepository.findByLocation("Indy"));
        Mileage washington = new Mileage(myDate, mydesc, this.dRepository.findByLocation("Washington"));

        Mileage chicagoDiff = new Mileage(diffDate, mydesc, this.dRepository.findByLocation("Chicago"));
        

        this.mRepository.save(chicago);
        this.mRepository.save(indy);
        this.mRepository.save(washington);
        this.mRepository.save(chicagoDiff);
    }
}