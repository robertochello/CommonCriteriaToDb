package com.unicampania.xmltodb.config;

import com.unicampania.xmltodb.model.Fclass;
import com.unicampania.xmltodb.processor.FcIntroductionItenProcessor;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.support.CompositeItemWriter;
import org.springframework.batch.item.xml.StaxEventItemReader;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.oxm.jaxb.Jaxb2Marshaller;
import javax.sql.DataSource;
import java.util.Arrays;

@Configuration
@EnableBatchProcessing
public class BatchConf {

    @Autowired
    private JobBuilderFactory jobBuilderFactory;

    @Autowired
    private StepBuilderFactory stepBuilderFactory;

    @Autowired
    private DataSource dataSource;

    @Bean
    public FcIntroductionItenProcessor processor() {

        return new FcIntroductionItenProcessor();
    }


    @Bean
    ItemReader<Fclass> reader() {
        StaxEventItemReader<Fclass> reader = new StaxEventItemReader<Fclass>();
        reader.setResource(new ClassPathResource("fclass.xml"));
        reader.setFragmentRootElementName("f-class");
        Jaxb2Marshaller publicFigMarshaller = new Jaxb2Marshaller();
        publicFigMarshaller.setClassesToBeBound(Fclass.class);
        reader.setUnmarshaller(publicFigMarshaller);
        return reader;
    }

    @Bean
    public JdbcBatchItemWriter<Fclass> writerFclass() {
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO fclass(id,name) VALUES(?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new FclassPreparedStatmentSetter());
        return writer;
    }

    @Bean
    public JdbcBatchItemWriter<Fclass> writerFcIntroduction(){
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO fcintroduction(type,id,para,idf) VALUES(?,?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new FcIntroductionPreparedStatmentSetter());
        return writer;

    }


    @Bean
    public JdbcBatchItemWriter<Fclass> writerFcInformativeNotes(){
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO fcinformativenotes(type,id,para,idf) VALUES(?,?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new FcInformativeNotesPreparedStatmentSetter());
        return writer;

    }
    @Bean
    public JdbcBatchItemWriter<Fclass> writerSubClause(){
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO subclause(title,id,idf) VALUES(?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new SubClausePreparedStatmentSetter());
        return writer;
    }

    @Bean
    public JdbcBatchItemWriter<Fclass> writerSubClausePara(){
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO subclausepara(type,id,para,idf) VALUES(?,?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new SubClauseParaPreparedStatmentSetter());
        return writer;

    }

    @Bean
    public JdbcBatchItemWriter<Fclass> writerListItem(){
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO listitems(task_id,id,text,idf) VALUES(?,?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new ListItemPreparedStatmentSetter());
        return writer;

    }

    @Bean
    public JdbcBatchItemWriter<Fclass> writerFfamily(){
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO ffamily(id,name,idf) VALUES(?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new FfamilyPreparedStatmentSetter());
        return writer;

    }

    @Bean
    public JdbcBatchItemWriter<Fclass> writerFfBehaviour(){
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO ffbehaviour(type,id,para,idf) VALUES(?,?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new FfBehaviourPreparedStatmentSetter());
        return writer;

    }

    @Bean
    public JdbcBatchItemWriter<Fclass> writerFfUserNotes(){
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO ffusernotes(type,id,para,idf) VALUES(?,?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new FfUserNotesPreparedStatmentSetter());
        return writer;

    }

    @Bean
    public JdbcBatchItemWriter<Fclass> writerListItemFfUsertNotes(){
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO listitemsffusernotes(task_id,id,text,idf) VALUES(?,?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new ListItemFfUsertNotesPreparedStatmentSetter());
        return writer;

    }

    @Bean
    public JdbcBatchItemWriter<Fclass> writerFfEvaluatorNotes(){
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO ffevaluatornotes(type,id,para,idf) VALUES(?,?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new FfEvaluatorNotesPreparedStatmentSetter());
        return writer;

    }

    @Bean
    public JdbcBatchItemWriter<Fclass> writerFComponent(){
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO fcomponent(id,name,idf) VALUES(?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new FComponentPreparedStatmentSetter());
        return writer;

    }

    @Bean
    public JdbcBatchItemWriter<Fclass> writerFcoHierarchical(){
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO fcohierarchical(fcomponent,idf) VALUES(?,?) ON DUPLICATE KEY UPDATE fcomponent = ?");
        writer.setItemPreparedStatementSetter(new FcoHierarchicalPreparedStatmentSetter());
        return writer;

    }

    @Bean
    public JdbcBatchItemWriter<Fclass> writerFcoDependencies(){
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO fcodependencies(fcomponent,idf) VALUES(?,?)");
        writer.setItemPreparedStatementSetter(new FcoDependenciesPreparedStatmentSetter());
        return writer;

    }

    @Bean
    public JdbcBatchItemWriter<Fclass> writerFcoUserNotes(){
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO fcousernotes(type,id,para,idf) VALUES(?,?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new FcoUserNotesPreparedStatmentSetter());
        return writer;

    }

    @Bean
    public JdbcBatchItemWriter<Fclass> writerFcoEvaluatorNotes(){
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO fcoevaluatornotes(type,id,para,idf) VALUES(?,?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new FcoEvaluatorNotesPreparedStatmentSetter());
        return writer;

    }

    @Bean
    public JdbcBatchItemWriter<Fclass> writerListItemFcoUsertNotes(){
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO listitemsfcousernotes(task_id,id,text,idf) VALUES(?,?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new ItemBoldPreparedStatmentSetter());
        return writer;

    }

    @Bean
    public JdbcBatchItemWriter<Fclass> writerFcoLevelling(){
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO fcolevelling(type,id,para,idf) VALUES(?,?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new FcoLevellingPreparedStatmentSetter());
        return writer;

    }
    @Bean
    public JdbcBatchItemWriter<Fclass> writerFcoManagament(){
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO fcomanagement(num,id,equal,text,idf) VALUES(?,?,?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new FcoManagementPreparedStatmentSetter());
        return writer;

    }

    @Bean
    public JdbcBatchItemWriter<Fclass> writerFcoAudit(){
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO fcoaudit(num,id,level,equal,text,idf) VALUES(?,?,?,?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new FcoAuditPreparedStatmentSetter());
        return writer;

    }

    @Bean
    public JdbcBatchItemWriter<Fclass> writerFcoRationale(){
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO fcorationale(type,id,para,idf) VALUES(?,?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new FcoRationalePreparedStatmentSetter());
        return writer;

    }

    @Bean
    public JdbcBatchItemWriter<Fclass> writerFElement(){
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO felement(num,idr,id,text,idf) VALUES(?,?,?,?,?) ON DUPLICATE KEY UPDATE idr = ?");
        writer.setItemPreparedStatementSetter(new FEelementPreparedStatmentSetter());
        return writer;

    }

    @Bean
    public JdbcBatchItemWriter<Fclass> writerFeAssignmentitem(){
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO feassignmentitem(idr,text,idf) VALUES(?,?,?) ON DUPLICATE KEY UPDATE idr = ?");
        writer.setItemPreparedStatementSetter(new FeAssignmentitemPreparedStatmentSetter());
        return writer;
    }


    @Bean
    public JdbcBatchItemWriter<Fclass> writerFeAssignmentNotes(){
        JdbcBatchItemWriter<Fclass> writer = new JdbcBatchItemWriter<Fclass>();
        writer.setDataSource(dataSource);
        writer.setSql("INSERT INTO feassignmentnotes(type, id, para, idf) VALUES(?,?,?,?) ON DUPLICATE KEY UPDATE id = ?");
        writer.setItemPreparedStatementSetter(new FeAssignmentNotesPreparedStatmentSetter());
        return writer;

    }
    @Bean
    public Step step1() {
        return stepBuilderFactory.get("step1").<Fclass, Fclass>chunk(100).reader(reader()).processor(processor()).writer(compositeItemWriter()).build();
    }

    @Bean
    public Job exportPerosnJob() {
        return jobBuilderFactory.get("importPersonJob").incrementer(new RunIdIncrementer()).flow(step1()).end().build();
    }


    public CompositeItemWriter<Fclass> compositeItemWriter(){
        CompositeItemWriter writer = new CompositeItemWriter();
        writer.setDelegates(Arrays.asList(
                writerFclass(),
                writerFcIntroduction(),
                writerFcInformativeNotes(),
                writerSubClause(),
                writerSubClausePara(),
                writerListItem(),
                writerFfamily(),
                writerFfBehaviour(),
                writerFfUserNotes(),
                writerListItemFfUsertNotes(),
                writerFfEvaluatorNotes(),
                writerFComponent(),
                writerFcoHierarchical(),
                writerFcoDependencies(),
                writerFcoUserNotes(),
                writerListItemFcoUsertNotes(),
                writerFcoEvaluatorNotes(),
                writerFcoLevelling(),
                writerFcoManagament(),
                writerFcoAudit(),
                writerFcoRationale(),
                writerFElement(),
                writerFeAssignmentitem(),
                writerFeAssignmentNotes()));
        return writer;
    }
}

