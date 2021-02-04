package jijianjingfei.util;

public class JsonResult<T> {
	String result;
	String message;
	
	T resultContent;
	
	public static <T> JsonResult<T> getSuccessResult(T resultContent){
		JsonResult<T> result = new JsonResult<>();
		result.setResult("1");
		result.setResultContent(resultContent);
		return result;
	}

	public static <T> JsonResult<T> getErrorResult(String message){
		JsonResult<T> result = new JsonResult<>();
		result.setResult("0");
		result.setMessage(message);
		
		return result;
	}
	
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public T getResultContent() {
		return resultContent;
	}
	public void setResultContent(T resultContent) {
		this.resultContent = resultContent;
	}
}
