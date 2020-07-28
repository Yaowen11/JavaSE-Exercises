package think.fourteen.dynamic.transaction;

import java.io.FileWriter;
import java.io.IOException;
import java.lang.reflect.Proxy;

/**
 * @author z
 */
public class DynamicProxyTransaction {
    public static void main(String[] args) {
        try {
            Transaction fileTransaction = new FileTransactionImpl(new FileWriter("proxy"));
            Transaction proxy = (Transaction) Proxy.newProxyInstance(
                    Transaction.class.getClassLoader(),
                    new Class[]{ Transaction.class},
                    new TransactionProxy(fileTransaction)
            );
            proxy.begin();
            proxy.commit();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }
    }
}
