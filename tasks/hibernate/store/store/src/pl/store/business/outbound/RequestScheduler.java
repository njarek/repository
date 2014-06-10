package pl.store.business.outbound;

import java.util.List;

import javax.inject.Inject;

import org.junit.experimental.categories.Categories.IncludeCategory;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import pl.store.domain.Basket;
import pl.store.persistance.LifecycleStatusUpdaterDao;
import pl.supplier.domain.Order;
import pl.supplier.domain.Requirements;


public class RequestScheduler {

	@Inject 
	private DataCollector dataCollector;

	@Inject
	private DataTransformer dataTransformer;
	
	@Inject 
	private RequestSender requestSender;
	
	@Inject
	private LifecycleStatusUpdaterDao lifecycleDao;
	
	
	public void createAnsSendRequest(){
		List<Order> baskets=dataCollector.getOrders();
//		Requirements requirements=dataTransformer.transform(baskets);
//		
//		String message=unmarshallRequirements(requirements);
//		try {
//			lifecycleDao.updateLifecycle(baskets,requestSender.sendRequest(message));
//		} catch (Exception e) {
//		}
		
		System.out.println("i'm working");
		
	}


	private String unmarshallRequirements(Requirements requirements) {
		// TODO Auto-generated method stub
		return null;
	}
	
	public static void main(String[] args) {
		new ClassPathXmlApplicationContext("requestScheduler.xml");
	}
}
