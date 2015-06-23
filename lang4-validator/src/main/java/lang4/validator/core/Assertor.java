package lang4.validator.core;

/**
 * 
 * @author xiezhenzong
 * 
 */
public interface Assertor<T> {

    boolean doAssert(T target);

    String assertorName();

    Assertor<T> not();

    Assertor<T> or(Assertor<T> other);

    Assertor<T> and(Assertor<T> other);
    
    /**
     * 描述失败的原因，放到Reason中
     * 
     */
    void describe(T target, Reason reason);

}
