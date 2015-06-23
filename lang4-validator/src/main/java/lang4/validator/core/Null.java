package lang4.validator.core;

/**
 *
 * @author xiezhenzong
 * 
 */
public class Null extends BaseAssertor<Object> {

    @Override
    public boolean doAssert(Object target) {
        return target == null;
    }

    @Override
    protected void failedReason(Reason reason) {
        reason.append("null");
    }

}
