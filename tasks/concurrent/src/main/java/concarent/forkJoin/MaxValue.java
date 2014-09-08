package concarent.forkJoin;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.concurrent.RecursiveTask;

public class MaxValue extends RecursiveTask<Integer> {
	
	private static final long serialVersionUID = -7304370868525220308L;
	List<Integer> ints = new ArrayList<Integer>();

	public MaxValue(List<Integer> ints) {
		this.ints = ints;
	}

	@Override
	protected Integer compute() {
		if(ints.size()>1000){
		
			MaxValue maxValue1=new MaxValue(ints.subList(0, ints.size()/2));
			maxValue1.fork();
			
			MaxValue maxValue2 = new MaxValue(ints.subList(ints.size()/2, ints.size()));
			
			return Math.max(maxValue2.compute(), maxValue1.join());
		}
		else{
			return Collections.max(ints);
		}
	
	}
	
}
