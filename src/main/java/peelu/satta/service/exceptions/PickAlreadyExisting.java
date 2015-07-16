package peelu.satta.service.exceptions;

/**
 * Created by dabroal on 16/07/15.
 */
public class PickAlreadyExisting extends Exception {

    public PickAlreadyExisting(String s) {
        super(s);
        System.out.println(s);
    }
}
