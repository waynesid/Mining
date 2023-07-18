package com.AthenaData.Mining.Config;

/**
 * @author wayne
 * @Date 17/07/2023
 */

import com.AthenaData.Mining.Model.MatchStats;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.step.builder.StepBuilder;
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
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.Resource;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {
    @Value("file:src/main/resources/*.csv")
    private Resource[] inputResources;

    @Bean
    public Job job(JobBuilder jobBuilderFactory,
                   StepBuilder stepBuilderFactory,
                   ItemReader<MatchStats> itemReader,
                   ItemProcessor<MatchStats, MatchStats> itemProcessor,
                   ItemWriter<MatchStats> itemWriter) {

        Step step = stepBuilderFactory
                .<MatchStats, MatchStats>chunk(200)
                .reader(itemReader)
                .processor(itemProcessor)
                .writer(itemWriter)
                .faultTolerant()
                .skipLimit(5000)
                .skip(Exception.class)
                .build();
        System.out.println("MatchStats reading step başarılı bir şekilde tamamlandı.");


        Job job = jobBuilderFactory
                .incrementer(new RunIdIncrementer())
                .start(step)
                .build();
        System.out.println("Job başarılı bir şekilde stepleri tamamladı.");
        return job;

    }

    @Bean
    public FlatFileItemReader<MatchStats> itemReader() {

        FlatFileItemReader<MatchStats> flatFileItemReader = new FlatFileItemReader<>();
        //flatFileItemReader.setResource(new FileSystemResource("src/main/resources/understand_per_game.csv"));
        String inputResource = "src/main/resources/understat_per_game.csv";
        //flatFileItemReader.setEncoding("UTF-8");
        flatFileItemReader.setResource(new FileSystemResource(inputResource));
        flatFileItemReader.setName("CSV-Reader");
        flatFileItemReader.setLinesToSkip(1);
        flatFileItemReader.setLineMapper(lineMapper());
        //flatFileItemReader.afterPropertiesSet();
        //flatFileItemReader.open(new ExecutionContext());
        return flatFileItemReader;
    }


    //TODO linetokenizer.setNames
    @Bean
    public LineMapper<MatchStats> lineMapper() {
        DefaultLineMapper<MatchStats> defaultLineMapper = new DefaultLineMapper<>();
        DelimitedLineTokenizer lineTokenizer = new DelimitedLineTokenizer();

        lineTokenizer.setDelimiter(";");
        lineTokenizer.setStrict(false);
        lineTokenizer.setNames(new String[]{"gender", "birthDate", "jobCategory", "salary", "jobTime", "prevExp", "minority"});

        BeanWrapperFieldSetMapper<MatchStats> fieldSetMapper = new BeanWrapperFieldSetMapper<>();
        fieldSetMapper.setTargetType(MatchStats.class);


        defaultLineMapper.setLineTokenizer(lineTokenizer);
        defaultLineMapper.setFieldSetMapper(fieldSetMapper);

        return defaultLineMapper;
    }
}
