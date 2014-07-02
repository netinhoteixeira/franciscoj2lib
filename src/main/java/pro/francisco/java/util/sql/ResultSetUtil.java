package pro.francisco.java.util.sql;

import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author Francisco Ernesto Teixeira <fco.ernesto@gmail.com>
 */
public class ResultSetUtil {

    public static Boolean isEmpty(ResultSet resultSet) throws SQLException {
        return (!resultSet.isBeforeFirst() && resultSet.getRow() == 0);
    }

    public static Boolean isNotEmpty(ResultSet resultSet) throws SQLException {
        return !ResultSetUtil.isEmpty(resultSet);
    }

}
