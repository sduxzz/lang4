package lang4.validator.core;

/**
 * 
 * target在start，end之间,闭区间。target如果是null，则返回false
 * 
 * @author xiezhenzong
 * 
 */
public class Between<T extends Comparable<T>> extends BaseAssertor<T> {

    private T left;
    private T right;

    public Between(T left, T right) {
        check(left, right);
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean doAssert(T target) {
        if (target == null)
            return false;
        return left.compareTo(target) <= 0 && target.compareTo(right) <= 0;
    }

    @Override
    protected void failedReason(Reason reason) {
        reason.append("between in [");
        reason.append(left).append(", ").append(right);
        reason.append("]");
    }

    private void check(T start, T end) {
        checkNullParameter(start, "Between require not null left parameter");
        checkNullParameter(end, "Between require not null right parameter");
        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException("Between find left bigger than right, it's illegal");
        }
    }

}
