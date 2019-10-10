package com.unicampania.xmltodb.config;

import com.unicampania.xmltodb.model.Fclass;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FfEvaluatorNotesPreparedStatmentSetter implements ItemPreparedStatementSetter<Fclass> {
    @Override
    public void setValues(Fclass item, PreparedStatement ps) throws SQLException {

        for (int i = 0; i < item.getFfamilyList().size(); i++) {

            if(item.getFfamilyList().get(i).getFfEvaluatorNotes().getP().getId().equals("")){
                ps.setString(1,"");
                ps.setString(2,"");
                ps.setString(3,"");
                ps.setString(4,item.getFfamilyList().get(i).getId());
                ps.setString(5,"");
            }else {
                ps.setString(1,item.getFfamilyList().get(i).getFfEvaluatorNotes().getP().getType());
                ps.setString(2,item.getFfamilyList().get(i).getFfEvaluatorNotes().getP().getId());
                ps.setString(3, String.valueOf(item.getFfamilyList().get(i).getFfEvaluatorNotes().getP().getCombo()));
                ps.setString(4,item.getFfamilyList().get(i).getId());
                ps.setString(5,item.getFfamilyList().get(i).getFfEvaluatorNotes().getP().getId());
                ps.addBatch();
            }
        }
    }
}
