import java.io.Serializable;  

public class SumaResponse implements Serializable {  
    private static final long serialVersionUID = 1L;  
    private int sum;  
    private String message;  

    public SumaResponse(int sum, String message) {  
        this.sum = sum;  
        this.message = message;  
    }  

    public int getSum() {  
        return sum;  
    }  

    public void setSum(int sum) {  
        this.sum = sum;  
    }  

    public String getMessage() {  
        return message;  
    }  

    public void setMessage(String message) {  
        this.message = message;  
    }  
}