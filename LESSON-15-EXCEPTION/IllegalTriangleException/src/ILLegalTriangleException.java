public class ILLegalTriangleException extends Exception{
    private String message;
    public ILLegalTriangleException(){}

    public ILLegalTriangleException(String message) {
        this.message = message;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
