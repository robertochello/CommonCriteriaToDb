package com.unicampania.xmltodb.config;

import com.unicampania.xmltodb.model.Fclass;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;

import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ItemBoldPreparedStatmentSetter implements ItemPreparedStatementSetter<Fclass> {


    @Override
    public void setValues(Fclass item, PreparedStatement ps) throws SQLException {

        for (int i = 0; i < item.getFfamilyList().size(); i++) {
            for (int j = 0; j < item.getFfamilyList().get(i).getFComponentList().size(); j++) {
                for (int k = 0; k < item.getFfamilyList().get(i).getFComponentList().get(j).getFcoUserNotes().getP().size(); k++) {
                    for (int l = 0; l <  item.getFfamilyList().get(i).getFComponentList().get(j).getFcoUserNotes().getP().get(k).getLists().size(); l++) {
                        if (item.getFfamilyList().get(i).getFComponentList().get(j).getFcoUserNotes().getP().get(k).getLists().size() == 0) {
                            ps.setString(1,"");
                            ps.setString(2,"");
                            ps.setString(3,"");
                            ps.setString(4,item.getFfamilyList().get(i).getFComponentList().get(j).getFcoUserNotes().getP().get(k).getId());
                            ps.setString(5,"");
                        }else {
                        for (int m = 0; m <item.getFfamilyList().get(i).getFComponentList().get(j).getFcoUserNotes().getP().get(k).getLists().size(); m++) {
                                for (int n = 0; n < item.getFfamilyList().get(i).getFComponentList().get(j).getFcoUserNotes().getP().get(k).getLists().get(m).getItem().size(); n++) {
                                ps.setString(1, String.valueOf(n));
                                ps.setString(2, item.getFfamilyList().get(i).getFComponentList().get(j).getFcoUserNotes().getP().get(k).getLists().get(m).getItem().get(n).getId());
                                ps.setString(3, String.valueOf(item.getFfamilyList().get(i).getFComponentList().get(j).getFcoUserNotes().getP().get(k).getLists().get(m).getItem().get(n).getBoldItem()));
                                ps.setString(4, item.getFfamilyList().get(i).getFComponentList().get(j).getFcoUserNotes().getP().get(k).getId());
                                ps.setString(5, item.getFfamilyList().get(i).getFComponentList().get(j).getFcoUserNotes().getP().get(k).getLists().get(m).getItem().get(n).getId());
                                ps.addBatch();
                                }
                                }
                            }

                        }
                    }
                }

            }
        }


    }
