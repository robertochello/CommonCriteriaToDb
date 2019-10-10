package com.unicampania.xmltodb.config;

import com.unicampania.xmltodb.model.Fclass;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FcoRationalePreparedStatmentSetter implements ItemPreparedStatementSetter<Fclass> {
    @Override
    public void setValues(Fclass item, PreparedStatement ps) throws SQLException {

        for (int i = 0; i <  item.getFfamilyList().size(); i++) {
            for (int j = 0; j < item.getFfamilyList().get(i).getFComponentList().size(); j++) {

                if (item.getFfamilyList().get(i).getFComponentList().get(j).getFcoRationale().getP().getId().equals("")) {
                    ps.setString(1,"");
                    ps.setString(2,"");
                    ps.setString(3,"");
                    ps.setString(4, item.getFfamilyList().get(i).getFComponentList().get(j).getId());
                    ps.setString(5,"");
                } else

                    ps.setString(1, item.getFfamilyList().get(i).getFComponentList().get(j).getFcoRationale().getP().getType());
                ps.setString(2, item.getFfamilyList().get(i).getFComponentList().get(j).getFcoRationale().getP().getId());
                ps.setString(3, String.valueOf(item.getFfamilyList().get(i).getFComponentList().get(j).getFcoRationale().getP().getCombo()));
                ps.setString(4, item.getFfamilyList().get(i).getFComponentList().get(j).getId());
                ps.setString(5, item.getFfamilyList().get(i).getFComponentList().get(j).getFcoRationale().getP().getId());
                ps.addBatch();
            }
            }

        }

}

