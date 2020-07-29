package exception;

public class CustomException extends Exception {

	private String mssg;

	CustomException(String mssg) {
		super(mssg);
		this.mssg = mssg;

	}

//	@Override
//	public String toString()
//	{
//		return mssg;
//	}

}
