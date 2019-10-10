package com.unicampania.xmltodb.config;

import com.unicampania.xmltodb.model.Fclass;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class FeAssignmentitemPreparedStatmentSetter implements ItemPreparedStatementSetter<Fclass> {
    @Override
    public void setValues(Fclass item, PreparedStatement ps) throws SQLException {

        for (int i = 0; i < item.getFfamilyList().size(); i++) {
            for (int j = 0; j < item.getFfamilyList().get(i).getFComponentList().size(); j++) {
                for (int k = 0; k < item.getFfamilyList().get(i).getFComponentList().get(j).getFElements().size(); k++) {
                    if(item.getFfamilyList().get(i).getFComponentList().get(j).getFElements().get(k).getFeAssignmentList().size()==0){

                        ps.setString(1,"");
                        ps.setString(2,"");
                        ps.setString(3, item.getFfamilyList().get(i).getFComponentList().get(j).getFElements().get(k).getIdf().get(0));
                        ps.setString(4,"");


                    }else{

                    for (int l = 0; l < item.getFfamilyList().get(i).getFComponentList().get(j).getFElements().get(k).getFeAssignmentList().size() ; l++) {

                        ps.setString(1,item.getFfamilyList().get(i).getFComponentList().get(j).getFElements().get(k).getId().concat(String.valueOf(l)));
                        ps.setString(2,item.getFfamilyList().get(i).getFComponentList().get(j).getFElements().get(k).getFeAssignmentList().get(l).getFeAssignmentitem().getText());
                        ps.setString(3, item.getFfamilyList().get(i).getFComponentList().get(j).getFElements().get(k).getIdf().get(l));
                        ps.setString(4,item.getFfamilyList().get(i).getFComponentList().get(j).getFElements().get(k).getId().concat(String.valueOf(l)));
                        ps.addBatch();

                    }
                    }

                }

            }
        }
    }
}
