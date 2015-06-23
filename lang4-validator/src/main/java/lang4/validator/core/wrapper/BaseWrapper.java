package lang4.validator.core.wrapper;

/**
 * AssertDecorator的基础实现
 * 
 * @author xiezhenzong
 * 
 */
public abstract class BaseWrapper implements Assertorwrapper {

    protected void checkNullParameter(Object argument, String errorMessage) {
        if (argument == null) {
            throw new IllegalArgumentException(errorMessage);
        }
    }
}
