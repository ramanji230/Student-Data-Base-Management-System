package customexception;
//4.)
public class InvaildChoiceException extends RuntimeException{
	
	private String message;
	
	public InvaildChoiceException(String message) {
		this.message=message;
	}
	
	@Override
	public String getMessage() {
		return message;
	}
	

}
