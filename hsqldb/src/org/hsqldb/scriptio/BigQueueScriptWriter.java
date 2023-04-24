package org.hsqldb.scriptio;

import org.hsqldb.*;
import org.hsqldb.lib.FileAccess;

import java.io.OutputStream;

public class BigQueueScriptWriter extends ScriptWriterBase {

    public BigQueueScriptWriter(Database db) {
        super(db);
    }

    @Override
    protected void initBuffers() {
// init bigque
    }

    @Override
    public void writeRow(Session session, Row row, Table table) {

    }

    @Override
    protected void writeDataTerm() {}

    @Override
    protected void writeSessionIdAndSchema(Session session) {
        // increament bytecount
    }

    @Override
    public void writeLogStatement(Session session, String s) {
// increament bytecount
    }

    @Override
    public void writeOtherStatement(Session session, String s) {
// increament bytecount
    }

    @Override
    public void writeInsertStatement(Session session, Row row, Table table) {
// increament bytecount
    }

    @Override
    public void writeDeleteStatement(Session session, Table table, Object[] data) {
// increament bytecount
    }

    @Override
    public void writeSequenceStatement(Session session, NumberSequence seq) {
// increament bytecount
    }

    @Override
    public void writeCommitStatement(Session session) {
// increament bytecount
    }

    @Override
    public void close() {
// set bytecount to 0
    }

    // overriding because there is no force flushing in bigqueue
    @Override
    public void forceSync() {
        // do nothing
    }

    // might not need to override
//    @Override
//    public void start() {
//        // do nothing
//    }
//
//    @Override
//    public void stop() {
//        // do nothing
//    }
}
