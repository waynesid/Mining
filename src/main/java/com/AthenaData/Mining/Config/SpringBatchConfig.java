package com.AthenaData.Mining.Config;

/**
 * @author wayne
 * @Date 17/07/2023
 */

import com.AthenaData.Mining.Batch.DBWriter;
import com.AthenaData.Mining.Batch.MatchStatsProcessor;
import com.AthenaData.Mining.Model.MatchStats;
import com.AthenaData.Mining.Model.MatchStatsDto;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.ItemProcessor;
import org.springframework.batch.item.ItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.LineMapper;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.FileSystemResource;
import org.springframework.transaction.PlatformTransactionManager;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {
    @Bean
    public ItemWriter<MatchStats> writer() {
        return new DBWriter();
    }


    @Bean
    public Step step(ItemProcessor<MatchStats, MatchStats> processor, JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new StepBuilder("myStep", jobRepository)
                .<MatchStats, MatchStats>chunk(10, transactionManager)
                .reader(itemReader())
                .processor(processor)
                .writer(writer())
                .build();
    }

    @Bean
    public Job job(JobRepository jobRepository, PlatformTransactionManager transactionManager) {
        return new JobBuilder("myJob", jobRepository)
                .incrementer(new RunIdIncrementer())
                .flow(step(processor(),jobRepository,transactionManager))
                .end()
                .build();
    }


    @Bean
    public FlatFileItemReader<MatchStats> itemReader() {

        FlatFileItemReader<MatchStats> flatFileItemReader = new FlatFileItemReader<>();
        //flatFileItemReader.setResource(new FileSystemResource("src/main/resources/MatchStats.csv"));
        String inputResource = "src/main/resources/MatchStats.csv";
        //flatFileItemReader.setEncoding("UTF-8");
        flatFileItemReader.setResource(new FileSystemResource(inputResource));
        flatFileItemReader.setName("CSV-Reader");
        flatFileItemReader.setLinesToSkip(1);
        flatFileItemReader.setLineMapper(lineMapper());
        //flatFileItemReader.afterPropertiesSet();
        //flatFileItemReader.open(new ExecutionContext());
        return flatFileItemReader;
    }

/*
    @Bean
    public JdbcBatchItemWriter<MatchStats> matchStatsWriter(){
        JdbcBatchItemWriter<MatchStats> matchStatsJdbcBatchItemWriter = new JdbcBatchItemWriter<>();

        matchStatsJdbcBatchItemWriter.setDataSource(dataSource);

        matchStatsJdbcBatchItemWriter.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());

        matchStatsJdbcBatchItemWriter.afterPropertiesSet();

        return matchStatsJdbcBatchItemWriter;
    }*/

    //TODO LINE 122
    @Bean
    public LineMapper<MatchStats> lineMapper() {
        DefaultLineMapper<MatchStats> defaultLineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

        lineTokenizer.setDelimiter(";");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames(new String[]{"league", "year", "h_a", "xG", "xGA", "npxG", "npxGA", "deep", "deep_allowed", "scored", "missed", "xpts", "result", "date", "wins", "draws", "loses", "pts", "npxGD", "ppda_coef", "ppda_att", "ppda_def", "oppda_coef", "oppda_att", "oppda_def", "team", "xG_diff", "xGA_diff", "xpts_diff"});

        BeanWrapperFieldSetMapper<MatchStats> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(MatchStats.class);


        defaultLineMapper.setLineTokenizer(lineTokenizer);
        defaultLineMapper.setFieldSetMapper(fieldSetMapper);

        return defaultLineMapper;
    }


}
