package lang4.validator.core;

/**
 * 
 * Range断言。 满足[left <= target[0] < target[1] <= right]
 * 
 * @author xiezhenzong
 * 
 */
public class Range<T extends Comparable<T>> extends BaseAssertor<T[]> {

    private T left;
    private T right;

    public Range(T left, T right) {
        check(left, right);
        this.left = left;
        this.right = right;
    }

    @Override
    public boolean doAssert(T[] target) {
        if (target == null) { // not null assert
            return false;
        }
        if (target.length < 2) {
            return false;
        }
        T start = target[0];
        T end = target[1];
        if (start == null || end == null) {
            return false;
        }
        return left.compareTo(start) <= 0 && start.compareTo(end) < 0 && end.compareTo(right) <= 0;
    }

    @Override
    protected void failedReason(Reason reason) {
        reason.append("in range [");
        reason.append(left).append(", ").append(right);
        reason.append("]");
    }

    private void check(T left, T right) {
        checkNullParameter(left, "Range require not null left parameter");
        checkNullParameter(right, "Range require not null right parameter");
        if (left.compareTo(right) > 0) {
            throw new IllegalArgumentException("Range find left bigger than right, it's illegal");
        }
    }

}
