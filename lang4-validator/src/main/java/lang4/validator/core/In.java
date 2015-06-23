package lang4.validator.core;

import java.util.Arrays;
import java.util.Collection;

/**
 *
 * @author xiezhenzong
 * 
 */
public class In<T> extends BaseAssertor<T> {

    private T[] objArrayPool;
    private Collection<T> objCollectionPool;

    public In(T[] objPool) {
        checkNullParameter(objPool, "In require not null ObjPool parameter");
        objArrayPool = objPool;
    }

    public In(Collection<T> objPool) {
        checkNullParameter(objPool, "In require not null ObjPool parameter");
        objCollectionPool = objPool;
    }

    @Override
    public boolean doAssert(T target) {
        if (objArrayPool != null) {
            return inArray(target);
        } else if (objCollectionPool != null) {
            return inCollection(target);
        } else { // never reach here
            throw new Error("In assert require a not null objPool parameter!");
        }
    }

    private boolean inCollection(T target) {
        if (!objCollectionPool.isEmpty()) {
            for (Object t : objCollectionPool) {
                if (equalTwoObj(target, t)) {
                    return true;
                }
            }
        }
        return false;
    }

    private boolean inArray(T target) {
        if (objArrayPool.length != 0) {
            for (Object t : objArrayPool) {
                if (equalTwoObj(target, t)) {
                    return true;
                }
            }
        }
        return false;
    }

    /**
     * 将source和target做equal比较
     * 
     */
    private boolean equalTwoObj(Object target, Object compared) {
        Equal equal = new Equal(compared);
        return equal.doAssert(target);
    }

    @Override
    protected void failedReason(Reason reason) {
        reason.append("in ");
        if (objArrayPool != null) {
            reason.append(Arrays.toString(objArrayPool));
        } else if (objCollectionPool != null) {
            reason.append(objCollectionPool);
        }
    }
}
