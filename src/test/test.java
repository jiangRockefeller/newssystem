package test;

import com.bdqn.news.service.TopicService;
import com.bdqn.news.service.impl.TopicServiceImpl;

//this in my test
public class test {
	public static void main(String[] args) {
		System.out.println("测试");
		
		/*	//测试修改主题
		TopicService test=new TopicServiceImpl();
		test.modifyTopic(33, "速报");*/
		
		/*	//测试添加主题
		TopicService test=new TopicServiceImpl();
		test.addTopic("欢乐恶搞");*/
		
		/*	//测试删除新闻
		TopicService test=new TopicServiceImpl();
		test.delTopic(31);*/
		
		/*	//测试修改新闻
		NewsService test=new NewsServiceImpl();
		test.modifyNews(209, 2, "modifyTEST", "modifyTEST", "modifyTEST", "modifyTEST", "", "2016-09-16 21:37:19");*/
		
		/*	//测试添加评论
		CommentsService test=new CommentsServiceImpl();
		test.addComments(48, "wow,so doge", "", "192.168.2.8", "coldplay");*/
		
		/*	//测试获取新闻id相关评论
		CommentsService test=new CommentsServiceImpl();
		for (int i=0;i<test.getCommentByNid(108).size();i++) {
			System.out.println(test.getCommentByNid(108).get(i).getcAuthor());
			System.out.println(test.getCommentByNid(108).get(i).getcContent());
			System.out.println(test.getCommentByNid(108).get(i).getcDate());
			System.out.println(test.getCommentByNid(108).get(i).getCIP());
		}*/
		
		
		/*	//测试通过id获取新闻
		NewsService test=new NewsServiceImpl();
		News instance=test.getNewsByNid(48);
		System.out.println("返回新闻标题:"+instance.getnTitle());*/
		
		/*  //测试添加新闻
		NewsDao testDao=new NewsDaoImpl();
		testDao.addNews(1, "哈哈", "哈哈", "成立拉", "我不是针对你,我是说在座的各位都是辣鸡", "c:/学习资料", "");
		System.out.println("已插入新闻");*/
		
		/*//测试DBconnect中的getTime方法
		DbConnect test=new DbConnect();
		System.out.println(test.getTime());*/
		
		/*//获取系统当前时间,以yyyy-MM-dd HH:mm:ss格式输出
		SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(date.format(new Date()));*/
		
		
		/*//测试主页侧边栏新闻标题分类输出
		NewsService news=new NewsServiceImpl();
		List<News> side_list_1 = news.getNewsTiltle(1);
		System.out.println(side_list_1.get(0).getnTitle());	*/
		
		/*//测试删除新闻
		test.deleteNewsByID(188);*/
		
		
		/*  //测试分页
		List<News> list = test.getPagingNewsTitleByTopic(1, 1, 6);
		System.out.println(list.size());
		for(int i=0;i<list.size();i++){
			System.out.println(list.get(i).getnTitle());
			System.out.println(list.get(i).getnCreatDate());
		}
		System.out.println("---------------------");
		List<News> list2 = test.getPagingNewsTitleByTopic(1, 2, 6);
		System.out.println(list2.size());
		for(int i=0;i<list2.size();i++){
			System.out.println(list2.get(i).getnTitle());
			System.out.println(list2.get(i).getnCreatDate());
		}*/
	}
}
