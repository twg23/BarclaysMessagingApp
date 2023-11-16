package com.barclays;

//import com.barclays.util.populatePeople;
import com.barclays.util.populator;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BarclaysMessagingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(BarclaysMessagingAppApplication.class, args);

//		ApplicationContext context =SpringApplication.run(BarclaysMessagingAppApplication.class, args);
//		populator populate = context.getBean(populator.class);
//		populate.populate();
//
//		populatePeople populatePerson= context.getBean((populatePeople.class));
//		populatePerson.populatePerson();
//	}

}
}
