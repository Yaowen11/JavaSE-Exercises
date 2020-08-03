package think.fourteen.dynamic.transaction;

import java.io.FileWriter;
import java.io.IOException;

/**
 * @author z
 */
public class FileTransactionImpl implements Transaction {

    private final FileWriter fileWriter;

    public FileTransactionImpl(FileWriter fileWriter) {
        this.fileWriter = fileWriter;
    }

    @Override
    public void flush() throws IOException {
        fileWriter.flush();
    }

    @Override
    public void begin() {

    }

    @Override
    public void commit() {

    }

    @Override
    public void rollback() {

    }

}
