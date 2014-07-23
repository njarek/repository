package pl.store.business.outbound;

import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;
import org.springframework.scheduling.quartz.QuartzJobBean;

public class JobScheduler extends QuartzJobBean {

	private RequestScheduler requestScheduler;

	@Override
	protected void executeInternal(JobExecutionContext arg0) throws JobExecutionException {
		requestScheduler.createAnsSendRequest();

	}

	public void setRequestScheduler(RequestScheduler requestScheduler) {
		this.requestScheduler = requestScheduler;
	}

}
