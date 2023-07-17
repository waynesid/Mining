package com.AthenaData.Mining.Config;

/**
 * @author wayne
 * @Date 17/07/2023
 */

import com.AthenaData.Mining.Batch.MatchStatsProcessor;
import com.AthenaData.Mining.Model.MatchStats;
import com.AthenaData.Mining.Model.MatchStatsDto;
import org.springframework.batch.core.Job;
import org.springframework.batch.core.Step;
import org.springframework.batch.core.configuration.annotation.EnableBatchProcessing;
import org.springframework.batch.core.job.builder.JobBuilder;
import org.springframework.batch.core.launch.support.RunIdIncrementer;
import org.springframework.batch.core.listener.JobListenerFactoryBean;
import org.springframework.batch.core.repository.JobRepository;
import org.springframework.batch.core.step.builder.StepBuilder;
import org.springframework.batch.item.database.BeanPropertyItemSqlParameterSourceProvider;
import org.springframework.batch.item.database.JdbcBatchItemWriter;
import org.springframework.batch.item.file.FlatFileItemReader;
import org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper;
import org.springframework.batch.item.file.mapping.DefaultLineMapper;
import org.springframework.batch.item.file.transform.DelimitedLineTokenizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;

import javax.sql.DataSource;

@Configuration
@EnableBatchProcessing
public class SpringBatchConfig {

    public JobBuilder jobBuilder;

    public StepBuilder stepBuilder;

    public DataSource dataSource;

    @Bean
    public FlatFileItemReader<MatchStats> reader() {
        FlatFileItemReader<MatchStats> reader = new FlatFileItemReader<MatchStats>();
        reader.setResource(new ClassPathResource("MatchStats.csv"));

        reader.setLineMapper(new DefaultLineMapper<MatchStats>() {{
            setLineTokenizer(new DelimitedLineTokenizer() {{
                setNames("league", "year", "h_a", "xG", "xGA", "npxG", "npxGA", "deep", "deep_allowed", "scored", "missed", "xpts", "result", "date", "wins", "draws", "loses", "pts", "npxGD", "ppda_coef", "ppda_att", "ppda_def", "oppda_coef", "oppda_att", "oppda_def", "team", "xG_diff", "xGA_diff", "xpts_diff");
            }});
            setFieldSetMapper(new BeanWrapperFieldSetMapper() {{
                setTargetType(MatchStats.class);
            }});
        }});
        return reader;
    }

    @Bean
    public MatchStatsProcessor processor() {
        return new MatchStatsProcessor();
    }

 /*   @Bean
    public JdbcBatchItemWriter<MatchStatsDto> writer() {
        JdbcBatchItemWriter<MatchStatsDto> writer = new JdbcBatchItemWriter<MatchStatsDto>();
        writer.setItemSqlParameterSourceProvider(new BeanPropertyItemSqlParameterSourceProvider<>());
        writer.setSql("INSERT INTO MatchStats (first_name,last_name,company_name,address,city,county,state,zip) " +
                "VALUES (:firstName, :lastName,:companyName,:address,:city,:county,:state,:zip)");
        writer.setDataSource(dataSource);
        return writer;
    }*/
}
