package pro.francisco.java.util.sql;

import java.io.InputStream;
import java.io.Reader;
import java.math.BigDecimal;
import java.net.URL;
import java.sql.Array;
import java.sql.Blob;
import java.sql.Clob;
import java.sql.Connection;
import java.sql.Date;
import java.sql.NClob;
import java.sql.ParameterMetaData;
import java.sql.PreparedStatement;
import java.sql.Ref;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.RowId;
import java.sql.SQLException;
import java.sql.SQLWarning;
import java.sql.SQLXML;
import java.sql.Time;
import java.sql.Timestamp;
import java.util.Calendar;
import pro.francisco.java.util.TextUtil;

public class PreparedStatementLogable implements PreparedStatement {

    Connection connection;
    PreparedStatement stmt;
    String sql;
    String[] parm;

    public PreparedStatementLogable(Connection connection, String sql)
            throws SQLException {
        this.connection = connection;
        this.sql = sql;

        this.stmt = connection.prepareStatement(sql);
        this.sql = sql;
        this.parm = new String[TextUtil.countOccurrences(sql, '?')];
    }

    @Override
    public String toString() {
        StringBuilder buff = new StringBuilder(this.sql);
        for (String parm1 : this.parm) {
            buff.append("\n").append(parm1);
        }
        return buff.toString();
    }

    @Override
    public ResultSet executeQuery()
            throws SQLException {
        return this.stmt.executeQuery();
    }

    @Override
    public int executeUpdate() throws SQLException {
        return this.stmt.executeUpdate();
    }

    @Override
    public void setNull(int parameterIndex, int sqlType) throws SQLException {
        if (this.parm.length > 0) {
            this.parm[(parameterIndex - 1)] = null;
        }
        this.stmt.setNull(parameterIndex, sqlType);
    }

    @Override
    public void setBoolean(int parameterIndex, boolean x) throws SQLException {
        if (this.parm.length > 0) {
            this.parm[(parameterIndex - 1)] = String.valueOf(x);
        }
        this.stmt.setBoolean(parameterIndex, x);
    }

    @Override
    public void setByte(int parameterIndex, byte x) throws SQLException {
        if (this.parm.length > 0) {
            this.parm[(parameterIndex - 1)] = String.valueOf(x);
        }
        this.stmt.setByte(parameterIndex, x);
    }

    @Override
    public void setShort(int parameterIndex, short x) throws SQLException {
        if (this.parm.length > 0) {
            this.parm[(parameterIndex - 1)] = String.valueOf(x);
        }
        this.stmt.setShort(parameterIndex, x);
    }

    @Override
    public void setInt(int parameterIndex, int x) throws SQLException {
        if (this.parm.length > 0) {
            this.parm[(parameterIndex - 1)] = String.valueOf(x);
        }
        this.stmt.setInt(parameterIndex, x);
    }

    @Override
    public void setLong(int parameterIndex, long x) throws SQLException {
        if (this.parm.length > 0) {
            this.parm[(parameterIndex - 1)] = String.valueOf(x);
        }
        this.stmt.setLong(parameterIndex, x);
    }

    @Override
    public void setFloat(int parameterIndex, float x) throws SQLException {
        if (this.parm.length > 0) {
            this.parm[(parameterIndex - 1)] = String.valueOf(x);
        }
        this.stmt.setFloat(parameterIndex, x);
    }

    @Override
    public void setDouble(int parameterIndex, double x) throws SQLException {
        if (this.parm.length > 0) {
            this.parm[(parameterIndex - 1)] = String.valueOf(x);
        }
        this.stmt.setDouble(parameterIndex, x);
    }

    @Override
    public void setBigDecimal(int parameterIndex, BigDecimal x) throws SQLException {
        if (this.parm.length > 0) {
            this.parm[(parameterIndex - 1)] = String.valueOf(x);
        }
        this.stmt.setBigDecimal(parameterIndex, x);
    }

    @Override
    public void setString(int parameterIndex, String x) throws SQLException {
        if (this.parm.length > 0) {
            this.parm[(parameterIndex - 1)] = String.valueOf(x);
        }
        this.stmt.setString(parameterIndex, x);
    }

    @Override
    public void setBytes(int parameterIndex, byte[] x) throws SQLException {
        if (this.parm.length > 0) {
            this.parm[(parameterIndex - 1)] = String.valueOf(x);
        }
        this.stmt.setBytes(parameterIndex, x);
    }

    @Override
    public void setDate(int parameterIndex, Date x) throws SQLException {
        if (this.parm.length > 0) {
            this.parm[(parameterIndex - 1)] = String.valueOf(x);
        }
        this.stmt.setDate(parameterIndex, x);
    }

    @Override
    public void setTime(int parameterIndex, Time x) throws SQLException {
        if (this.parm.length > 0) {
            this.parm[(parameterIndex - 1)] = String.valueOf(x);
        }
        this.stmt.setTime(parameterIndex, x);
    }

    @Override
    public void setTimestamp(int parameterIndex, Timestamp x) throws SQLException {
        if (this.parm.length > 0) {
            this.parm[(parameterIndex - 1)] = String.valueOf(x);
        }
        this.stmt.setTimestamp(parameterIndex, x);
    }

    @Override
    public void setAsciiStream(int parameterIndex, InputStream x, int length) throws SQLException {
        if (this.parm.length > 0) {
            this.parm[(parameterIndex - 1)] = String.valueOf(x);
        }
        this.stmt.setAsciiStream(parameterIndex, x, length);
    }

    @Override
    @Deprecated
    public void setUnicodeStream(int parameterIndex, InputStream x, int length) throws SQLException {
        if (this.parm.length > 0) {
            this.parm[(parameterIndex - 1)] = String.valueOf(x);
        }
        this.stmt.setUnicodeStream(parameterIndex, x, length);
    }

    @Override
    public void setBinaryStream(int parameterIndex, InputStream x, int length) throws SQLException {
        if (this.parm.length > 0) {
            this.parm[(parameterIndex - 1)] = String.valueOf(x);
        }
        this.stmt.setBinaryStream(parameterIndex, x, length);
    }

    @Override
    public void clearParameters() throws SQLException {
        if (this.parm.length > 0) {
            this.parm = new String[this.parm.length];
        }
        this.stmt.clearParameters();
    }

    @Override
    public void setObject(int parameterIndex, Object x, int targetSqlType, int scale) throws SQLException {
        if (this.parm.length > 0) {
            this.parm[(parameterIndex - 1)] = String.valueOf(x);
        }
        this.stmt.setObject(parameterIndex, x, targetSqlType, scale);
    }

    @Override
    public void setObject(int parameterIndex, Object x, int targetSqlType) throws SQLException {
        if (this.parm.length > 0) {
            this.parm[(parameterIndex - 1)] = ("" + x);
        }
        this.stmt.setObject(parameterIndex, x, targetSqlType);
    }

    @Override
    public void setObject(int parameterIndex, Object x) throws SQLException {
        if (this.parm.length > 0) {
            this.parm[(parameterIndex - 1)] = String.valueOf(x);
        }
        this.stmt.setObject(parameterIndex, x);
    }

    @Override
    public boolean execute() throws SQLException {
        return this.stmt.execute();
    }

    @Override
    public void addBatch() throws SQLException {
        this.stmt.addBatch();
    }

    @Override
    public void setCharacterStream(int parameterIndex, Reader reader, int length) throws SQLException {
        if (this.parm.length > 0) {
            this.parm[(parameterIndex - 1)] = reader.toString();
        }
        this.stmt.setCharacterStream(parameterIndex, reader, length);
    }

    @Override
    public void setRef(int parameterIndex, Ref x) throws SQLException {
        if (this.parm.length > 0) {
            this.parm[(parameterIndex - 1)] = String.valueOf(x);
        }
        this.stmt.setRef(parameterIndex, x);
    }

    @Override
    public void setBlob(int parameterIndex, Blob x) throws SQLException {
        if (this.parm.length > 0) {
            this.parm[(parameterIndex - 1)] = String.valueOf(x);
        }
        this.stmt.setBlob(parameterIndex, x);
    }

    @Override
    public void setClob(int parameterIndex, Clob x) throws SQLException {
        if (this.parm.length > 0) {
            this.parm[(parameterIndex - 1)] = String.valueOf(x);
        }
        this.stmt.setClob(parameterIndex, x);
    }

    @Override
    public void setArray(int parameterIndex, Array x) throws SQLException {
        if (this.parm.length > 0) {
            this.parm[(parameterIndex - 1)] = String.valueOf(x);
        }
        this.stmt.setArray(parameterIndex, x);
    }

    @Override
    public ResultSetMetaData getMetaData() throws SQLException {
        return this.stmt.getMetaData();
    }

    @Override
    public void setDate(int parameterIndex, Date x, Calendar cal) throws SQLException {
        if (this.parm.length > 0) {
            this.parm[(parameterIndex - 1)] = String.valueOf(x);
        }
        this.stmt.setDate(parameterIndex, x, cal);
    }

    @Override
    public void setTime(int parameterIndex, Time x, Calendar cal) throws SQLException {
        if (this.parm.length > 0) {
            this.parm[(parameterIndex - 1)] = String.valueOf(x);
        }
        this.stmt.setTime(parameterIndex, x, cal);
    }

    @Override
    public void setTimestamp(int parameterIndex, Timestamp x, Calendar cal) throws SQLException {
        if (this.parm.length > 0) {
            this.parm[(parameterIndex - 1)] = String.valueOf(x);
        }
        this.stmt.setTimestamp(parameterIndex, x, cal);
    }

    @Override
    public void setNull(int parameterIndex, int sqlType, String typeName) throws SQLException {
        if (this.parm.length > 0) {
            this.parm[(parameterIndex - 1)] = null;
        }
        this.stmt.setNull(parameterIndex, sqlType, typeName);
    }

    @Override
    public ResultSet executeQuery(String sql) throws SQLException {
        return this.stmt.executeQuery(sql);
    }

    @Override
    public int executeUpdate(String sql) throws SQLException {
        return this.stmt.executeUpdate(sql);
    }

    @Override
    public void close() throws SQLException {
        this.stmt.close();
    }

    @Override
    public int getMaxFieldSize() throws SQLException {
        return this.stmt.getMaxFieldSize();
    }

    @Override
    public void setMaxFieldSize(int max) throws SQLException {
        this.stmt.setMaxFieldSize(max);
    }

    @Override
    public int getMaxRows() throws SQLException {
        return this.stmt.getMaxRows();
    }

    @Override
    public void setMaxRows(int max) throws SQLException {
        this.stmt.setMaxRows(max);
    }

    @Override
    public void setEscapeProcessing(boolean enable) throws SQLException {
        this.stmt.setEscapeProcessing(enable);
    }

    @Override
    public int getQueryTimeout() throws SQLException {
        return this.stmt.getQueryTimeout();
    }

    @Override
    public void setQueryTimeout(int seconds) throws SQLException {
        this.stmt.setQueryTimeout(seconds);
    }

    @Override
    public void cancel() throws SQLException {
        this.stmt.cancel();
    }

    @Override
    public SQLWarning getWarnings() throws SQLException {
        return this.stmt.getWarnings();
    }

    @Override
    public void clearWarnings() throws SQLException {
        this.stmt.clearWarnings();
    }

    @Override
    public void setCursorName(String name) throws SQLException {
        this.stmt.setCursorName(name);
    }

    @Override
    public boolean execute(String sql) throws SQLException {
        return this.stmt.execute(sql);
    }

    @Override
    public ResultSet getResultSet() throws SQLException {
        return this.stmt.getResultSet();
    }

    @Override
    public int getUpdateCount() throws SQLException {
        return this.stmt.getUpdateCount();
    }

    @Override
    public boolean getMoreResults() throws SQLException {
        return this.stmt.getMoreResults();
    }

    @Override
    public void setFetchDirection(int direction) throws SQLException {
        this.stmt.setFetchDirection(direction);
    }

    @Override
    public int getFetchDirection() throws SQLException {
        return this.stmt.getFetchDirection();
    }

    @Override
    public void setFetchSize(int rows) throws SQLException {
        this.stmt.setFetchSize(rows);
    }

    @Override
    public int getFetchSize() throws SQLException {
        return this.stmt.getFetchSize();
    }

    @Override
    public int getResultSetConcurrency() throws SQLException {
        return this.stmt.getResultSetConcurrency();
    }

    @Override
    public int getResultSetType() throws SQLException {
        return this.stmt.getResultSetType();
    }

    @Override
    public void addBatch(String sql) throws SQLException {
        this.stmt.addBatch(sql);
    }

    @Override
    public void clearBatch() throws SQLException {
        this.stmt.clearBatch();
    }

    @Override
    public int[] executeBatch() throws SQLException {
        return this.stmt.executeBatch();
    }

    @Override
    public Connection getConnection() throws SQLException {
        return this.stmt.getConnection();
    }

    @Override
    public void setURL(int i, URL url) throws SQLException {
        this.stmt.setURL(i, url);
    }

    @Override
    public ParameterMetaData getParameterMetaData() throws SQLException {
        return this.stmt.getParameterMetaData();
    }

    @Override
    public void setRowId(int i, RowId rowid) throws SQLException {
        this.stmt.setRowId(i, rowid);
    }

    @Override
    public void setNString(int i, String string) throws SQLException {
        this.stmt.setNString(i, string);
    }

    @Override
    public void setNCharacterStream(int i, Reader reader, long l) throws SQLException {
        this.stmt.setNCharacterStream(i, reader, l);
    }

    @Override
    public void setNClob(int i, NClob nclob) throws SQLException {
        this.stmt.setNClob(i, nclob);
    }

    @Override
    public void setClob(int i, Reader reader, long l) throws SQLException {
        this.stmt.setClob(i, reader, l);
    }

    @Override
    public void setBlob(int i, InputStream in, long l) throws SQLException {
        this.stmt.setBlob(i, in, l);
    }

    @Override
    public void setNClob(int i, Reader reader, long l) throws SQLException {
        this.stmt.setNClob(i, reader, l);
    }

    @Override
    public void setSQLXML(int i, SQLXML sqlxml) throws SQLException {
        this.stmt.setSQLXML(i, sqlxml);
    }

    @Override
    public void setAsciiStream(int i, InputStream in, long l) throws SQLException {
        this.stmt.setAsciiStream(i, in, l);
    }

    @Override
    public void setBinaryStream(int i, InputStream in, long l) throws SQLException {
        this.stmt.setBinaryStream(i, in, l);
    }

    @Override
    public void setCharacterStream(int i, Reader reader, long l) throws SQLException {
        this.stmt.setCharacterStream(i, reader, l);
    }

    @Override
    public void setAsciiStream(int i, InputStream in) throws SQLException {
        this.stmt.setAsciiStream(i, in);
    }

    @Override
    public void setBinaryStream(int i, InputStream in) throws SQLException {
        this.stmt.setBinaryStream(i, in);
    }

    @Override
    public void setCharacterStream(int i, Reader reader) throws SQLException {
        this.stmt.setCharacterStream(i, reader);
    }

    @Override
    public void setNCharacterStream(int i, Reader reader) throws SQLException {
        this.stmt.setNCharacterStream(i, reader);
    }

    @Override
    public void setClob(int i, Reader reader) throws SQLException {
        this.stmt.setClob(i, reader);
    }

    @Override
    public void setBlob(int i, InputStream in) throws SQLException {
        this.stmt.setBlob(i, in);
    }

    @Override
    public void setNClob(int i, Reader reader) throws SQLException {
        this.stmt.setNClob(i, reader);
    }

    @Override
    public boolean getMoreResults(int i) throws SQLException {
        return this.stmt.getMoreResults(i);
    }

    @Override
    public ResultSet getGeneratedKeys() throws SQLException {
        return this.stmt.getGeneratedKeys();
    }

    @Override
    public int executeUpdate(String string, int i) throws SQLException {
        return this.stmt.executeUpdate(string, i);
    }

    @Override
    public int executeUpdate(String string, int[] ints) throws SQLException {
        return this.stmt.executeUpdate(string, ints);
    }

    @Override
    public int executeUpdate(String string, String[] strings) throws SQLException {
        return this.stmt.executeUpdate(string, strings);
    }

    @Override
    public boolean execute(String string, int i) throws SQLException {
        return this.stmt.execute(string, i);
    }

    @Override
    public boolean execute(String string, int[] ints) throws SQLException {
        return this.stmt.execute(string, ints);
    }

    @Override
    public boolean execute(String string, String[] strings) throws SQLException {
        return this.stmt.execute(string, strings);
    }

    @Override
    public int getResultSetHoldability() throws SQLException {
        return this.stmt.getResultSetHoldability();
    }

    @Override
    public boolean isClosed() throws SQLException {
        return this.stmt.isClosed();
    }

    @Override
    public void setPoolable(boolean bln) throws SQLException {
        this.stmt.setPoolable(bln);
    }

    @Override
    public boolean isPoolable() throws SQLException {
        return this.stmt.isPoolable();
    }

    @Override
    public <T> T unwrap(Class<T> type) throws SQLException {
        return this.stmt.unwrap(type);
    }

    @Override
    public boolean isWrapperFor(Class<?> type) throws SQLException {
        return this.stmt.isWrapperFor(type);
    }

    @Override
    public void closeOnCompletion() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public boolean isCloseOnCompletion() throws SQLException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
