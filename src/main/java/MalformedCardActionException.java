public class MalformedCardActionException extends Exception {

    public String msg;

    public MalformedCardActionException(String _msg) {
        msg = _msg;
    }
}
