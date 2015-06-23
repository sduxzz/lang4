package lang4.validator.core;

import java.io.IOException;
import java.util.Arrays;

/**
 * 失败原因
 * 
 * @author xiezhenzong
 * 
 */
public class Reason {

    private Appendable out;

    /**
     * 使用默认 Appendable
     */
    public Reason() {
        out = new StringBuilder();
    }

    /**
     * 指定appendable
     * 
     * @param out appendable
     */
    public Reason(Appendable out) {
        if (out == null) {
            throw new IllegalArgumentException("out can't be null");
        }
        this.out = out;
    }

    /**
     * 添加一个原因到当前对象
     * 
     * @param message 原因
     * @return Reason 让append支持链式调用
     */
    public Reason append(String message) {
        try {
            out.append(message);
        } catch (IOException e) {
            throw new RuntimeException("Could not write reason", e);
        }
        return this;
    }

    /**
     * 添加一个原因到当前对象
     * 
     * @param value 原因的值
     * @return Reason 让append支持链式调用
     */
    public Reason append(Object value) {
        if (value == null) {
            return append("null");
        }
        if (value instanceof Object[]) {
            return append(Arrays.toString((Object[]) value));
        }
        return append(value.toString());
    }

    @Override
    public String toString() {
        return out.toString();
    }
}
