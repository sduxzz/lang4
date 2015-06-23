package lang4.validator.core;

/**
 * 
 * 
 * target, comparedObj都为null也返回true
 * 
 * @author xiezhenzong
 * 
 */
public class Equal extends BaseAssertor<Object> {

    private Object comparedObj;

    /**
     * if target equal to comparedObj, then doAssert return true
     * 
     * @param comparedObj 相比较的对象
     */
    public Equal(Object comparedObj) {
        this.comparedObj = comparedObj;
    }

    @Override
    public boolean doAssert(Object target) {
        if (target == comparedObj) { // two object are the same object， include two null object;
            return true;
        }
        // one of these two object is not null
        return target != null ? target.equals(comparedObj) : comparedObj.equals(target);
    }

    @Override
    protected void failedReason(Reason reason) {
        reason.append("equal to ").append(comparedObj);
    }

}
