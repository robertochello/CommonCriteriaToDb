package com.unicampania.xmltodb.config;

import com.unicampania.xmltodb.model.Fclass;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FcIntroductionPreparedStatmentSetter implements ItemPreparedStatementSetter<Fclass> {


    @Override
    public void setValues(Fclass item, PreparedStatement ps) throws SQLException {

        for (int i=0; i < item.getFcIntroduction().getP().size(); i++) {


                ps.setString(1, item.getFcIntroduction().getP().get(i).getType());
                ps.setString(2, item.getFcIntroduction().getP().get(i).getId());
                ps.setString(3, String.valueOf(item.getFcIntroduction().getP().get(i).getCombo()).replace("[", "").replace("]", ""));
                ps.setString(4, item.getId());
                ps.setString(5, item.getFcIntroduction().getP().get(i).getId());
                ps.addBatch();
        }
    }
}
