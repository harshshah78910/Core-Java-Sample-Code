package concurrency;

import java.util.concurrent.Callable;

public class CallableTask implements Callable<String>{

	@Override
	public String call() throws Exception {
		// TODO Auto-generated method stub
		return "From Callable :" + Math.random();
	}

}
