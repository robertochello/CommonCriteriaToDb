package com.unicampania.xmltodb.config;

import com.unicampania.xmltodb.model.Fclass;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FclassPreparedStatmentSetter implements ItemPreparedStatementSetter<Fclass> {

    @Override
    public void setValues(Fclass item, PreparedStatement ps) throws SQLException {

        ps.setString(1,item.getId());
        ps.setString(2,item.getName());
        ps.setString(3,item.getId());

    }
}
