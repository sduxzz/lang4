package lang4.validator.core;

/**
 * 支持String, Long, Integer, Double
 *
 * @author xiezhenzong
 * 
 */
public class NotZero extends BaseAssertor<Object> {

    private static final String ZERO_STR = "0";
    private static final Long ZERO_LONG = Long.valueOf(0L);
    private static final Integer ZERO_INT = Integer.valueOf(0);
    private static final Double ZERO_DOUBLE = Double.valueOf(0D);

    @Override
    public boolean doAssert(Object target) {
        if (target == null) {
            return false;
        }
        if (target instanceof String) {
            return !ZERO_STR.equals(target);
        } else if (target instanceof Long) {
            return !ZERO_LONG.equals(target);
        } else if (target instanceof Integer) {
            return !ZERO_INT.equals(target);
        } else if (target instanceof Double) {
            Double targetLong = (Double) target;
            return Math.abs(targetLong - ZERO_DOUBLE) > 0.000001D;
        } else {
            throw new Error("Between don't support this type: " + target.getClass() + ", value： " + target);
        }
    }

    @Override
    protected void failedReason(Reason reason) {
        reason.append("notEqual to 0");
    }

}
