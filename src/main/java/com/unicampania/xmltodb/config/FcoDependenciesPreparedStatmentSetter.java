package com.unicampania.xmltodb.config;

import com.unicampania.xmltodb.model.Fclass;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FcoDependenciesPreparedStatmentSetter implements ItemPreparedStatementSetter<Fclass> {
    @Override
    public void setValues(Fclass item, PreparedStatement ps) throws SQLException {

        for (int i = 0; i < item.getFfamilyList().size(); i++) {
            for (int j = 0; j < item.getFfamilyList().get(i).getFComponentList().size(); j++) {
                if(item.getFfamilyList().get(i).getFComponentList().get(j).getFcoDependencies().getFcoDependsoncomponentList().size()==0){
                    ps.setString(1,"");
                    ps.setString(2,item.getFfamilyList().get(i).getFComponentList().get(j).getId());
                }else {
                    for (int k = 0; k < item.getFfamilyList().get(i).getFComponentList().get(j).getFcoDependencies().getFcoDependsoncomponentList().size(); k++) {
                        ps.setString(1,item.getFfamilyList().get(i).getFComponentList().get(j).getFcoDependencies().getFcoDependsoncomponentList().get(k).getFcomponent());
                        ps.setString(2,item.getFfamilyList().get(i).getFComponentList().get(j).getId());
                        ps.addBatch();
                    }
                }
            }

        }

    }
}
