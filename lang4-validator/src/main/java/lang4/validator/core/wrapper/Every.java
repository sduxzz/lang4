package lang4.validator.core.wrapper;

import lang4.validator.core.Assertor;
import lang4.validator.core.Reason;

/**
 * 对数组中每个元素的某个字段进行断言
 * 
 * @author xiezhenzong
 * 
 */
public class Every extends BaseWrapper {

    private Object[] objArrayPool;

    public Every(Object[] objPool) {
        checkNullParameter(objPool, "EveryField require not null ObjPool parameter");
        this.objArrayPool = objPool;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> boolean doAssert(Assertor<T> assertor, Reason reason) {
        checkNullParameter(assertor, "decorator require not null assertor");
        if (objArrayPool.length == 0) {
            return true;
        }
        for (Object o : objArrayPool) {
            T t = (T) o;
            if (!assertor.doAssert(t)) {
                reason.append("Every assertor find illegal object, see detial: ");
                assertor.describe(t, reason);
                return false;
            }
        }
        return true;
    }

}
