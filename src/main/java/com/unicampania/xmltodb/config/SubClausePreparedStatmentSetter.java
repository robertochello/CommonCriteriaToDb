package com.unicampania.xmltodb.config;

import com.unicampania.xmltodb.model.Fclass;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class SubClausePreparedStatmentSetter implements ItemPreparedStatementSetter<Fclass> {
    @Override
    public void setValues(Fclass item, PreparedStatement ps) throws SQLException {

        if (item.getFcInformativeNotes().getSubClause().getId()==null) {
            ps.clearBatch();
        } else {
            ps.setString(1, item.getFcInformativeNotes().getSubClause().getTitle());
            ps.setString(2, item.getFcInformativeNotes().getSubClause().getId());
            ps.setString(3, item.getId());
            ps.setString(4, item.getFcInformativeNotes().getSubClause().getId());
            ps.addBatch();

        }
    }
}
