package lang4.validator.core;

/**
 * 
 * if target is null, then return false
 * 
 * @author xiezhenzong
 * 
 */
public class IsTrue extends BaseAssertor<Boolean> {

    @Override
    public boolean doAssert(Boolean target) {
        return target != null ? target : false;
    }

    @Override
    protected void failedReason(Reason reason) {
        reason.append("true");
    }

}
