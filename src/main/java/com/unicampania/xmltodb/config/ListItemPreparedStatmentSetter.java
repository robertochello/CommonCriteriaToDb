package com.unicampania.xmltodb.config;

import com.unicampania.xmltodb.model.Fclass;
import org.springframework.batch.item.database.ItemPreparedStatementSetter;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ListItemPreparedStatmentSetter implements ItemPreparedStatementSetter<Fclass> {


    @Override
    public void setValues(Fclass item, PreparedStatement ps) throws SQLException {

        if(item.getFcInformativeNotes().getP().size()==0) {
            ps.clearBatch();
        } else{
            for (int i = 0; i < item.getFcInformativeNotes().getP().size(); i++){
                if (item.getFcInformativeNotes().getP().get(i).getLists().size() == 0) {
                 ps.setString(1,"");
                 ps.setString(2,"");
                 ps.setString(3,"");
                 ps.setString(4, item.getFcInformativeNotes().getP().get(i).getId());
                 ps.setString(5,"");
                }else {
                    for (int j = 0; j <item.getFcInformativeNotes().getP().get(i).getLists().size()  ; j++) {
                        if(item.getFcInformativeNotes().getP().get(i).getLists().get(j).getItem().size()==0){
                            ps.clearBatch();
                        }else{
                            for (int k = 0; k <item.getFcInformativeNotes().getP().get(i).getLists().get(j).getItem().size() ; k++) {
                                ps.setString(1, String.valueOf(k));

                                if(item.getFcInformativeNotes().getP().get(i).getLists().get(j).getItem().get(k).getId() ==null){
                                   ps.setString(2, String.valueOf(k));
                                    ps.setString(5, String.valueOf(k));
                                }else
                                    {
                                    ps.setString(2,item.getFcInformativeNotes().getP().get(i).getLists().get(j).getItem().get(k).getId());
                                    ps.setString(5,item.getFcInformativeNotes().getP().get(i).getLists().get(j).getItem().get(k).getId());
                                }

                                ps.setString(3, String.valueOf(item.getFcInformativeNotes().getP().get(i).getLists().get(j).getItem().get(k).getCombo()));
                                ps.setString(4, item.getFcInformativeNotes().getP().get(i).getId());

                                ps.addBatch();
                            }
                        }

                    }
                }
            }
            }
    }
}

