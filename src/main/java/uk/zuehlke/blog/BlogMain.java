package uk.zuehlke.blog;

import org.apache.commons.lang.ArrayUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.yammer.dropwizard.Service;
import com.yammer.dropwizard.assets.AssetsBundle;
import com.yammer.dropwizard.config.Bootstrap;
import com.yammer.dropwizard.config.Configuration;
import com.yammer.dropwizard.config.Environment;

public class BlogMain extends Service<Configuration> {

	public static void main(String[] args) throws Exception {
		String[] serverArgs = (String[]) ArrayUtils.add(args, "server");
		serverArgs = (String[]) ArrayUtils.add(serverArgs, "src/main/resources/service.yaml");
		new BlogMain().run(serverArgs);
	}

	@Override
	public void initialize(Bootstrap<Configuration> bootstrap) {
		bootstrap.setName("posts");
		bootstrap.addBundle(new AssetsBundle("/assets/", "/", "index.html"));
	}

	@Override
	public void run(Configuration configuration, Environment environment) throws Exception {
		PostResource postResource = setupResource();
		environment.addResource(postResource);
	}

	private PostResource setupResource() {
		ApplicationContext ctx = new ClassPathXmlApplicationContext("spring-mongo-context.xml");
		return ctx.getBean(PostResource.class);
	}
}
