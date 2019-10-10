package com.unicampania.xmltodb.config;

import com.unicampania.xmltodb.model.Fclass;
import com.unicampania.xmltodb.model.Ffamily;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FfamilyPreparedStatmentSetter implements ItemPreparedStatementSetter<Fclass> {

    @Override
    public void setValues(Fclass item, PreparedStatement ps) throws SQLException {

        for (int i = 0; i < item.getFfamilyList().size(); i++) {

            ps.setString(1,item.getFfamilyList().get(i).getId());
            ps.setString(2,item.getFfamilyList().get(i).getName());
            ps.setString(3,item.getId());
            ps.setString(4,item.getFfamilyList().get(i).getId());
            ps.addBatch();

        }

    }
}
