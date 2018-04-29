public class MalformedJsonException extends Exception {

    public String msg;

    public MalformedJsonException(String _msg) {
        msg = _msg;
    }
}
