package com.unicampania.xmltodb.config;

import com.unicampania.xmltodb.model.Fclass;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FComponentPreparedStatmentSetter implements ItemPreparedStatementSetter<Fclass> {

    @Override
    public void setValues(Fclass item, PreparedStatement ps) throws SQLException {

        for (int i = 0; i < item.getFfamilyList().size(); i++) {

            for (int j = 0; j < item.getFfamilyList().get(i).getFComponentList().size(); j++) {

                ps.setString(1, item.getFfamilyList().get(i).getFComponentList().get(j).getId());
                ps.setString(2, item.getFfamilyList().get(i).getFComponentList().get(j).getName());
                ps.setString(3, item.getFfamilyList().get(i).getId());
                ps.setString(4, item.getFfamilyList().get(i).getFComponentList().get(j).getId());
                ps.addBatch();

            }

        }
    }
}
