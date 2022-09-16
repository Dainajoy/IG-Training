package com.springboot.librarymanagementsystem.config;



import com.springboot.librarymanagementsystem.batch.BookItemProcessor;
import com.springboot.librarymanagementsystem.model.Books_Info;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.configuration.annotation.JobBuilderFactory;
import org.springframework.batch.core.configuration.annotation.StepBuilderFactory;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemReader;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;



@Configuration
@EnableBatchProcessing

public class SpringBatchConfiguration {
    private static final Logger log = LoggerFactory.getLogger(SpringBatchConfiguration.class);

    @Bean
    FlatFileItemReader<Books_Info> itemReader() {
        log.info("File Reading Started.");

        FlatFileItemReader<Books_Info> flatFileItemReader = new FlatFileItemReader<>();
        flatFileItemReader.setResource(new FileSystemResource("src/main/resources/Book.csv"));
        flatFileItemReader.setLineMapper(getlineMapper());
        flatFileItemReader.setName("CSV-Reader");
        flatFileItemReader.setLinesToSkip(1);

        log.info("File Reading Ended.");
        return flatFileItemReader;
    }

    @Bean
    public Job job(JobBuilderFactory jobBuilderFactory, StepBuilderFactory stepBuilderFactory,
                   ItemReader<Books_Info> itemReader, ItemProcessor<Books_Info, Books_Info> itemProcessor, ItemWriter<Books_Info> itemWriter) throws Exception {

        log.info("Batch job started.");
        Step step = stepBuilderFactory.get("ETL-file-load").<Books_Info, Books_Info>chunk(200).reader(itemReader)
                .processor(itemProcessor).writer(itemWriter).build();
        log.info("Batch job ended.");
        return jobBuilderFactory.get("ETL-Load").incrementer(new RunIdIncrementer()).start(step).build();
    }

    @Bean
    public LineMapper<Books_Info> getlineMapper() {
        log.info("Mapping with CSV File Started.");
        DefaultLineMapper<Books_Info> defaultLineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

        lineTokenizer.setDelimiter(",");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames(new String[] { "bookId","author","price","bookName","noOfCopies","bookPublication","totalPages"});

        BeanWrapperFieldSetMapper<Books_Info> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(Books_Info.class);
        defaultLineMapper.setLineTokenizer(lineTokenizer);
        defaultLineMapper.setFieldSetMapper(fieldSetMapper);
        log.info("Mapping with CSV File Ended.");
        return defaultLineMapper;

    }
}
