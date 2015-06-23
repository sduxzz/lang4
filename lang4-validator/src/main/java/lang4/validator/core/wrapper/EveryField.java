package lang4.validator.core.wrapper;

import java.lang.reflect.Field;
import java.util.Collection;

import lang4.validator.core.Assertor;
import lang4.validator.core.Reason;

/**
 * 对集合中每个元素的某个字段进行断言
 * 
 * @author xiezhenzong
 * 
 */
public class EveryField<E> extends BaseWrapper {

    private String field;
    private Collection<E> objCollectionPool;
    private E[] objArrayPool;

    private EveryField(String field) {
        checkNullParameter(field, "EveryField need a not null field");
        this.field = field;
    }

    public EveryField(Collection<E> objPool, String field) {
        this(field);
        checkNullParameter(objPool, "EveryField require not null ObjPool parameter");
        this.objCollectionPool = objPool;
    }

    public EveryField(E[] objPool, String field) {
        this(field);
        checkNullParameter(objPool, "EveryField require not null ObjPool parameter");
        this.objArrayPool = objPool;
    }

    @Override
    public <T> boolean doAssert(Assertor<T> assertor, Reason reason) {
        checkNullParameter(assertor, "decorator require not null assertor");
        try {
            if (objArrayPool != null) {
                return checkInArray(assertor, reason);
            } else if (objCollectionPool != null) {
                return checkInCollection(assertor, reason);
            } else {
                // never reach this;
                throw new Error("EveryField require not null objPool");
            }
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    @SuppressWarnings("unchecked")
    private <T> boolean checkInCollection(Assertor<T> assertor, Reason reason) throws Exception {
        if (objCollectionPool.isEmpty()) {
            return true;
        }
        Class<? extends Object> classOfE = objCollectionPool.iterator().next().getClass();
        Field f = classOfE.getDeclaredField(field);
        f.setAccessible(true);
        for (E e : objCollectionPool) {
            T t = (T) f.get(e);
            if (!assertor.doAssert(t)) {
                reason.append("EveryField find illegal object, see detial: ");
                assertor.describe(t, reason);
                return false;
            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    private <T> boolean checkInArray(Assertor<T> assertor, Reason reason) throws Exception {
        if (objArrayPool.length == 0) {
            return true;
        }
        Class<? extends Object> classOfE = objArrayPool[0].getClass();
        Field f = classOfE.getDeclaredField(field);
        f.setAccessible(true);
        for (E e : objArrayPool) {
            T t = (T) f.get(e);
            if (!assertor.doAssert(t)) {
                reason.append("EveryField find illegal object, see detial: ");
                assertor.describe(t, reason);
                return false;
            }
        }
        return true;
    }

}
