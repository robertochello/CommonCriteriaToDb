DROP TABLE IF EXISTS listitemsfcousernotes;
DROP TABLE IF EXISTS feassignmentnotes;
DROP TABLE IF EXISTS feassignmentitem;
DROP TABLE IF EXISTS felement;
DROP TABLE IF EXISTS fcorationale;
DROP TABLE IF EXISTS fcoaudit;
DROP TABLE IF EXISTS fcomanagement;
DROP TABLE IF EXISTS fcolevelling;
DROP TABLE IF EXISTS fcoevaluatornotes;
DROP TABLE IF EXISTS fcousernotes;
DROP TABLE IF EXISTS fcodependencies;
DROP TABLE IF EXISTS fcohierarchical;
DROP TABLE IF EXISTS fcomponent;
DROP TABLE IF EXISTS ffevaluatornotes;
DROP TABLE IF EXISTS listitemsffusernotes;
DROP TABLE IF EXISTS ffusernotes;
DROP TABLE IF EXISTS ffbehaviour;
DROP TABLE IF EXISTS ffamily;
DROP TABLE IF EXISTS listitems;
DROP TABLE IF EXISTS subclausepara;
DROP TABLE IF EXISTS subclause;
DROP TABLE IF EXISTS fcinformativenotes;
DROP TABLE IF EXISTS fcintroduction;
DROP TABLE IF EXISTS fclass;


CREATE TABLE fclass(

    id VARCHAR(4) NOT NULL PRIMARY KEY,
    name VARCHAR(40)

) ;

CREATE TABLE fcintroduction(

    type VARCHAR(10),
    id VARCHAR(12) PRIMARY KEY,
    para VARCHAR(10000),
    idf VARCHAR(4),
    FOREIGN KEY (idf) REFERENCES fclass(id)

);

CREATE TABLE fcinformativenotes(

    type VARCHAR(10),
    id VARCHAR(12) PRIMARY KEY,
    para VARCHAR(10000),
    idf VARCHAR(4),
    FOREIGN KEY (idf) REFERENCES fclass(id)
);

CREATE TABLE subclause(

    title VARCHAR(100),
    id VARCHAR(100) PRIMARY KEY,
    idf VARCHAR(4),
    FOREIGN KEY (idf) REFERENCES fclass(id)
);

CREATE TABLE subclausepara(

    type VARCHAR(10),
    id VARCHAR(12) UNIQUE KEY,
    para VARCHAR(10000),
    idf VARCHAR(100),
    FOREIGN KEY (idf) REFERENCES subclause(id) on update cascade
);

CREATE TABLE listitems(

    task_id VARCHAR(2),
    id VARCHAR(12) UNIQUE KEY,
    text VARCHAR(10000),
    idf VARCHAR(100),
    FOREIGN KEY (idf) REFERENCES fcinformativenotes(id) on update cascade

);

CREATE TABLE ffamily(

    id VARCHAR(10) NOT NULL PRIMARY KEY,
    name VARCHAR(100),
    idf VARCHAR(4),
    FOREIGN KEY (idf) REFERENCES fclass(id) on update cascade

) ;


CREATE TABLE ffbehaviour(

    type VARCHAR(10),
    id VARCHAR(12) PRIMARY KEY,
    para VARCHAR(10000),
    idf VARCHAR(12),
    FOREIGN KEY (idf) REFERENCES ffamily(id) on update cascade

) ;

CREATE TABLE ffusernotes(

    type VARCHAR(10),
    id VARCHAR(12) UNIQUE KEY,
    para VARCHAR(10000),
    idf VARCHAR(10),
    FOREIGN KEY (idf) REFERENCES ffamily(id) on update cascade

) ;

CREATE TABLE listitemsffusernotes(

    task_id VARCHAR(2),
    id VARCHAR(12) UNIQUE KEY,
    text VARCHAR(10000),
    idf VARCHAR(100),
    FOREIGN KEY (idf) REFERENCES ffusernotes(id) on update cascade

);

CREATE TABLE ffevaluatornotes(

    type VARCHAR(10),
    id VARCHAR(12) PRIMARY KEY,
    para VARCHAR(10000),
    idf VARCHAR(10),
    FOREIGN KEY (idf) REFERENCES ffamily(id) on update cascade
) ;

CREATE TABLE fcomponent(

    id VARCHAR(10)  PRIMARY KEY,
    name VARCHAR(100),
    idf VARCHAR(10),
    FOREIGN KEY (idf) REFERENCES ffamily(id)
) ;

CREATE TABLE fcohierarchical(

    fcomponent VARCHAR(10) UNIQUE KEY,
    idf VARCHAR(10),
    FOREIGN KEY (idf) REFERENCES fcomponent(id)
) ;

CREATE TABLE fcodependencies(

    fcomponent VARCHAR(10),
    idf VARCHAR(10) ,
    FOREIGN KEY (idf) REFERENCES fcomponent(id)
) ;

CREATE TABLE fcousernotes(

    type VARCHAR(10),
    id VARCHAR(12) PRIMARY KEY,
    para VARCHAR(10000),
    idf VARCHAR(10),
    FOREIGN KEY (idf) REFERENCES fcomponent(id) on update cascade
) ;

CREATE TABLE listitemsfcousernotes(

    task_id VARCHAR(2),
    id VARCHAR(12) UNIQUE KEY,
    text VARCHAR(10000),
    idf VARCHAR(100),
    FOREIGN KEY (idf) REFERENCES fcousernotes(id) on update cascade

);

CREATE TABLE fcoevaluatornotes(

    type VARCHAR(10),
    id VARCHAR(12) PRIMARY KEY,
    para VARCHAR(10000),
    idf VARCHAR(10),
    FOREIGN KEY (idf) REFERENCES fcomponent(id) on update cascade
);



CREATE TABLE fcolevelling(

    type VARCHAR(10),
    id VARCHAR(12) UNIQUE KEY,
    para VARCHAR(10000),
    idf VARCHAR(10),
    FOREIGN KEY (idf) REFERENCES fcomponent(id) on update cascade
);

CREATE TABLE fcomanagement(

    num VARCHAR(2),
    id VARCHAR(20)PRIMARY KEY,
    equal VARCHAR(50),
    text VARCHAR(500) ,
    idf VARCHAR(10),
    FOREIGN KEY (idf) REFERENCES fcomponent(id) on update cascade

);
CREATE TABLE fcoaudit(

    num VARCHAR (2),
    id VARCHAR (20) PRIMARY KEY,
    level VARCHAR(10),
    equal VARCHAR(12),
    text VARCHAR(500),
    idf VARCHAR(10),
    FOREIGN KEY (idf) REFERENCES fcomponent(id) on update cascade

);


CREATE TABLE fcorationale(

    type VARCHAR(10),
    id VARCHAR(12) PRIMARY KEY,
    para VARCHAR(10000),
    idf VARCHAR(10),
    FOREIGN KEY (idf) REFERENCES fcomponent(id) on update cascade
);

CREATE TABLE felement(

    num VARCHAR(2),
    idr VARCHAR(20)PRIMARY KEY,
    id VARCHAR(20),
    text VARCHAR(500),
    idf VARCHAR(10),
    FOREIGN KEY (idf) REFERENCES fcomponent(id) on update cascade

);

CREATE TABLE feassignmentitem(

    idr VARCHAR(20) ,
    text VARCHAR(500),
    idf VARCHAR(20),
     FOREIGN KEY (idf) REFERENCES felement(idr) on update cascade

);

CREATE TABLE feassignmentnotes(

    type VARCHAR(10),
    id VARCHAR(20) PRIMARY KEY,
    para VARCHAR(10000),
    idf VARCHAR(20),
    FOREIGN KEY (idf) REFERENCES felement(idr) on update cascade
);


