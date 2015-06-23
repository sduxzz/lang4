package lang4.validator.core.wrapper;

import lang4.validator.core.Assertor;
import lang4.validator.core.Reason;

/**
 * wrapper for {@link Assertor}
 * 
 * @author xiezhenzong
 * 
 */
public interface Assertorwrapper {

    <T> boolean doAssert(Assertor<T> assertor, Reason reason);

}
