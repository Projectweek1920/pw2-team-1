package ucll.project.domain.user;

public class NotAuthorizedException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    public NotAuthorizedException() {
        super();
    }
    public NotAuthorizedException (String message) {
        super(message);
    }
}
