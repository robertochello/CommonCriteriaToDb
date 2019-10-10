package com.unicampania.xmltodb.config;

import com.unicampania.xmltodb.model.Fclass;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FEelementPreparedStatmentSetter implements ItemPreparedStatementSetter<Fclass> {
    @Override
    public void setValues(Fclass item, PreparedStatement ps) throws SQLException {
        for (int i = 0; i < item.getFfamilyList().size(); i++) {
            for (int j = 0; j < item.getFfamilyList().get(i).getFComponentList().size() ; j++) {
                for (int k = 0; k < item.getFfamilyList().get(i).getFComponentList().get(j).getFElements().size(); k++) {
                    for (int l = 0; l < item.getFfamilyList().get(i).getFComponentList().get(j).getFElements().get(k).getValue().size(); l++) {

                        ps.setString(1, String.valueOf(l));
                        ps.setString(2, item.getFfamilyList().get(i).getFComponentList().get(j).getFElements().get(k).getIdf().get(l));
                        ps.setString(3, item.getFfamilyList().get(i).getFComponentList().get(j).getFElements().get(k).getId());
                        ps.setString(4, item.getFfamilyList().get(i).getFComponentList().get(j).getFElements().get(k).getValue().get(l));
                        ps.setString(5, item.getFfamilyList().get(i).getFComponentList().get(j).getId());
                        ps.setString(6, item.getFfamilyList().get(i).getFComponentList().get(j).getFElements().get(k).getIdf().get(l));
                        ps.addBatch();

                    }
                }
            }
        }
    }
}
