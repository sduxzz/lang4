package lang4.validator.core;

/**
 * 
 * @author xiezhenzong
 * 
 */
public class Gt<T extends Comparable<T>> extends BaseAssertor<T> {

    private T compared;

    public Gt(T compared) {
        checkNullParameter(compared, "compared can't be null");
        this.compared = compared;
    }

    @Override
    public boolean doAssert(T target) {
        return target == null ? false : target.compareTo(compared) > 0;
    }

    @Override
    protected void failedReason(Reason reason) {
        reason.append("greater than ").append(compared);
    }

}
