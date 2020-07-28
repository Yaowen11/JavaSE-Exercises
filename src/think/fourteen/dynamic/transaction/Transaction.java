package think.fourteen.dynamic.transaction;

import java.io.IOException;

/**
 * @author z
 */
public interface Transaction {

    /**
     * begin
     */
    void begin();

    /**
     * flush
     * @throws IOException io
     */
    void flush() throws IOException;

    /**
     * commit
     */
    void commit();

    /**
     * rollback
     */
    void rollback();
}
