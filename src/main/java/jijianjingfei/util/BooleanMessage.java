/**
 * 
 */
package jijianjingfei.util;

public class BooleanMessage {
	private boolean ok = false;
	private Object message;
	public boolean isOk() {
		return ok;
	}
	public void setOk(boolean ok) {
		this.ok = ok;
	}
	public Object getMessage() {
		return message;
	}
	public void setMessage(Object message) {
		this.message = message;
	}
	
	public static BooleanMessage getSuccessMessage(Object message){
		BooleanMessage booleanMessage = new BooleanMessage();
		booleanMessage.setOk(true);
		booleanMessage.setMessage(message);
		return booleanMessage;
	}
	
	public static BooleanMessage getErrorMessage(String message){
		BooleanMessage booleanMessage = new BooleanMessage();
		booleanMessage.setOk(false);
		booleanMessage.setMessage(message);
		return booleanMessage;
	}
}
