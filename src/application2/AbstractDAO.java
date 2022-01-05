package application2;

import java.sql.Connection;
//class abstraite qui assure la connection
public class AbstractDAO {
protected Connection connection= SingleConnection.getConnection();
}
