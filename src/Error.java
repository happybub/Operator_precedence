

public class Error extends Exception{

	private static final long serialVersionUID = 1L;
	String error;
	Error(String error){
		this.error = error;
	}
	public String toString() {
		return this.error;
	}
}
