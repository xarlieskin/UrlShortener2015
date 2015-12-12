package urlshortener2015.heatwave.database;

import java.util.Arrays;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.SimpleMongoDbFactory;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

import com.mongodb.MongoClient;
import com.mongodb.MongoCredential;
import com.mongodb.ServerAddress;

import urlshortener2015.heatwave.entities.ShortURL;

@Configuration
@EnableMongoRepositories(basePackageClasses=urlshortener2015.heatwave.repository.ClickRepository.class)
@PropertySource(value = { "classpath:database.properties" })
public class MongoDbController implements DatabaseController {
	
	private static final Logger logger = LoggerFactory.getLogger(MongoDbController.class);
	
	@Value("${database.mongo.host}")
	private String host;
	@Value("${database.mongo.port}")
	private String port;
	@Value("${database.mongo.db}")
	private String db;
	@Value("${database.mongo.user}")
	private String user;
	@Value("${database.mongo.password}")
	private String password;
	
	@Bean
    public MongoDbFactory mongoDbFactory() throws Exception {
        ServerAddress sv = new ServerAddress(host, Integer.parseInt(port));
        MongoCredential credential = MongoCredential.createCredential(user, db, password.toCharArray());
        MongoClient mongoClient = new MongoClient(sv, Arrays.asList(credential));
        logger.debug("MongoDbController.mongoDbFactory");
        return new SimpleMongoDbFactory(mongoClient, db);
    }
	
	@Bean
	public MongoTemplate mongoTemplate() throws Exception{
		logger.debug("MongoDbController.mongoTemplate");
		return new MongoTemplate(mongoDbFactory());
	}
    
    public String getHost(){
    	return this.host;
    }
    
    public String getPort(){
    	return this.port;
    }
    
    public String getDb(){
    	return this.db;
    }

	@Override
	public ShortURL findByKey(String id) {
		return null;
	}

	@Override
	public ShortURL save(ShortURL su) {
		return null;
	}

	@Override
	public ShortURL mark(ShortURL su, boolean safeness) {
		return null;
	}

	@Override
	public void update(ShortURL su) {
		
	}

	@Override
	public void delete(String hash) {
		
	}

	@Override
	public Long count() {
		return null;
	}

	@Override
	public List<ShortURL> list(Long limit, Long offset) {
		return null;
	}

	@Override
	public List<ShortURL> findByTarget(String target) {
		return null;
	}

}
