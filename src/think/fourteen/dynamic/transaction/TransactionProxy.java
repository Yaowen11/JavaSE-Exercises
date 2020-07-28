package think.fourteen.dynamic.transaction;

import java.io.IOException;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author z
 */
public class TransactionProxy implements InvocationHandler {

    private final Transaction transaction;

    public TransactionProxy(Transaction transaction) {
        this.transaction = transaction;
    }

    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        final String beginMethod = "begin";
        if (beginMethod.equals(method.getName())) {
            synchronized (proxy) {
                return method.invoke(transaction, args);
            }
        }
        final String commitMethod = "flush";
        if (commitMethod.equals(method.getName())) {
            synchronized (proxy) {
                try {
                    transaction.flush();
                    transaction.commit();
                } catch (IOException ioException) {
                    transaction.rollback();
                }
            }
        }
        return null;
    }
}
