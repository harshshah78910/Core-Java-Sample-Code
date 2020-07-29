package exception;

public class Main {

	public static void main(String[] args) throws CustomException, InterruptedException {
		
		//Thread.currentThread().sleep(1000000);
		try
		{
			throw new CustomException("This is Custom Exception Example");
		}
		catch (CustomException e)
		{
			throw e;
		}
		
	}

}
