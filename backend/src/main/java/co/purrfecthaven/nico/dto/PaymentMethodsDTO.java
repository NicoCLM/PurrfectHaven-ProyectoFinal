package co.purrfecthaven.nico.dto;

/**
 * PaymentMethodsDTO
 */
public class PaymentMethodsDTO {

    private int methodId;
    private String methodName;

    //Getters & Setters
    
    public int getMethodId() {
        return this.methodId;
    }

    public void setMethodId(int methodId) {
        this.methodId = methodId;
    }

    public String getMethodName() {
        return this.methodName;
    }

    public void setMethodName(String methodName) {
        this.methodName = methodName;
    }
}
