package org.hsqldb.scriptio;

import com.leansoft.bigqueue.BigQueueImpl;
import com.leansoft.bigqueue.IBigQueue;
import org.hsqldb.*;
import org.hsqldb.error.Error;
import org.hsqldb.error.ErrorCode;

import java.io.IOException;

public class BigQueueScriptWriter extends ScriptWriterText {

    private IBigQueue bigQueue;
    public BigQueueScriptWriter(Database db, String file,
                            boolean includeCachedData, boolean newFile,
                            boolean isUserScript) {
        super(db, file, includeCachedData, newFile, isUserScript);
    }

    @Override
    public void openFile() {
        try {
            this.bigQueue = new BigQueueImpl(".", outFile);
        } catch (IOException e) {
            throw Error.error(e, ErrorCode.FILE_IO_ERROR, "Failed to open BigQueue");
        }
    }

    @Override
    void writeRowOutToFile() {
        synchronized (this.bigQueue) {
            try {
                this.bigQueue.enqueue(rowOut.getBuffer());
                byteCount += rowOut.size();
                lineCount++;
            } catch (IOException e) {
                throw Error.error(e, ErrorCode.FILE_IO_ERROR, "Failed to enqueue to BigQueue");
            }
        }
    }

    @Override
    public void close() {
        if (isClosed) {
            return;
        }

        try {
            this.bigQueue.close();
            isClosed = true;
        } catch (IOException e) {
            throw Error.error(e, ErrorCode.FILE_IO_ERROR, "Failed to close BigQueue");
        }

        byteCount = 0;
        lineCount = 0;
    }

    @Override
    public void sync() {
        // do nothing
    }

    @Override
    public void forceSync() {
        // do nothing
    }

    @Override
    public void checkExists(Database db, String file, boolean isNewFile) {
        // do nothing
    }

    @Override
    public void start() {
        // do nothing
    }

    @Override
    public void stop() {
        // do nothing
    }

    @Override
    protected  void finishStream() {
        // do nothing
    }
}
