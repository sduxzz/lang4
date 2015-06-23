package lang4.validator.core;

/**
 * 
 * Base {@code Assertor} implementation
 * 
 * @author xiezhenzong
 * 
 */
public abstract class BaseAssertor<T> implements Assertor<T> {

    /**
     * {@inheritDoc}
     * 
     * return true always
     */
    @Override
    public boolean doAssert(T target) {
        return true;
    }

    @Override
    public Assertor<T> not() {
        final BaseAssertor<T> original = this;
        return new BaseAssertor<T>() {

            @Override
            public boolean doAssert(T obj) {
                return !original.doAssert(obj);
            }

            @Override
            public String assertorName() {
                return "Not(" + original.getClass().getSimpleName() + ")";
            }

            @Override
            public void describe(T target, Reason reason) {
                reason.append(assertorName()).append(" find illegal object: ");
                reason.append(target);
            }

        };
    }

    @Override
    public Assertor<T> or(final Assertor<T> other) {
        final BaseAssertor<T> original = this;
        return new BaseAssertor<T>() {

            @Override
            public boolean doAssert(T obj) {
                return original.doAssert(obj) || other.doAssert(obj);
            }

            @Override
            public String assertorName() {
                StringBuilder sb = new StringBuilder("Or(");
                sb.append(original.assertorName());
                sb.append(", ");
                sb.append(other.assertorName());
                sb.append(")");
                return sb.toString();
            }

            @Override
            public void describe(T target, Reason reason) {
                reason.append(assertorName()).append(" find illegal object: ");
                reason.append(target);
            }
        };
    }

    @Override
    public Assertor<T> and(final Assertor<T> other) {
        final BaseAssertor<T> original = this;
        return new BaseAssertor<T>() {

            @Override
            public boolean doAssert(T obj) {
                return original.doAssert(obj) && other.doAssert(obj);
            }

            @Override
            public String assertorName() {
                StringBuilder sb = new StringBuilder("And(");
                sb.append(original.assertorName());
                sb.append(", ");
                sb.append(other.assertorName());
                sb.append(")");
                return sb.toString();
            }

            @Override
            public void describe(T target, Reason reason) {
                reason.append(assertorName()).append(" find illegal object: ");
                reason.append(target);
            }
        };
    }

    @Override
    public void describe(T target, Reason reason) {
        reason.append(assertorName()).append(" find illegal object: ");
        reason.append(target);
        reason.append(", reason: ");
        reason.append(target).append(" isn't ");
        failedReason(reason);
    }

    /**
     * 子类可以覆盖这个方法来描述失败的原因
     * 
     * @param Reason 失败的原因
     */
    protected void failedReason(Reason reason) {
    }

    @Override
    public String assertorName() {
        return this.getClass().getSimpleName();
    }

    protected void checkNullParameter(Object argument, String errorMessage) {
        if (argument == null) {
            throw new IllegalArgumentException(errorMessage);
        }
    }

}
