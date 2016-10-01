import java.util.List;

import com.bdqn.news.entity.Topic;
import com.bdqn.news.service.TopicService;
import com.bdqn.news.service.impl.TopicServiceImpl;

public class testTopicService {
	public static void main(String[] args) {
		TopicService test = new TopicServiceImpl();
		List<Topic> tName = test.getTopic("*");
		for (int i = 0; i < tName.size(); i++) {

			System.out.println(tName.get(i).gettName());
			System.out.println(tName.get(i).getTid());
		}
	}
}
