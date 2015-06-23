package lang4.validator.core;

import java.util.Collection;
import java.util.Map;

/**
 * 
 * Empty可以处理{@code String}, {@code Object[]}, {@code Collection<?>}, {@code Map<?,?>}
 * 
 * @author xiezhenzong
 * 
 */
public class Empty extends BaseAssertor<Object> {

    @Override
    public boolean doAssert(Object target) {
        if (target == null)
            return false;
        if (target instanceof String) {
            return ((String) target).isEmpty();
        } else if (target instanceof Collection<?>) {
            return ((Collection<?>) target).isEmpty();
        } else if (target instanceof Object[]) {
            return ((Object[]) target).length == 0;
        } else if (target instanceof Map<?, ?>) {
            return ((Map<?, ?>) target).isEmpty();
        } else {
            throw new Error("Empty don't support this type: " + target.getClass() + ", value： " + target);
        }
    }

    @Override
    protected void failedReason(Reason reason) {
        reason.append("emtpy");
    }

}
