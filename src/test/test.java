package test;

import com.bdqn.news.service.TopicService;
import com.bdqn.news.service.impl.TopicServiceImpl;

//this in my test
public class test {
	public static void main(String[] args) {
		System.out.println("����");
		
		/*	//�����޸�����
		TopicService test=new TopicServiceImpl();
		test.modifyTopic(33, "�ٱ�");*/
		
		/*	//�����������
		TopicService test=new TopicServiceImpl();
		test.addTopic("���ֶ��");*/
		
		/*	//����ɾ������
		TopicService test=new TopicServiceImpl();
		test.delTopic(31);*/
		
		/*	//�����޸�����
		NewsService test=new NewsServiceImpl();
		test.modifyNews(209, 2, "modifyTEST", "modifyTEST", "modifyTEST", "modifyTEST", "", "2016-09-16 21:37:19");*/
		
		/*	//�����������
		CommentsService test=new CommentsServiceImpl();
		test.addComments(48, "wow,so doge", "", "192.168.2.8", "coldplay");*/
		
		/*	//���Ի�ȡ����id�������
		CommentsService test=new CommentsServiceImpl();
		for (int i=0;i<test.getCommentByNid(108).size();i++) {
			System.out.println(test.getCommentByNid(108).get(i).getcAuthor());
			System.out.println(test.getCommentByNid(108).get(i).getcContent());
			System.out.println(test.getCommentByNid(108).get(i).getcDate());
			System.out.println(test.getCommentByNid(108).get(i).getCIP());
		}*/
		
		
		/*	//����ͨ��id��ȡ����
		NewsService test=new NewsServiceImpl();
		News instance=test.getNewsByNid(48);
		System.out.println("�������ű���:"+instance.getnTitle());*/
		
		/*  //�����������
		NewsDao testDao=new NewsDaoImpl();
		testDao.addNews(1, "����", "����", "������", "�Ҳ��������,����˵�����ĸ�λ��������", "c:/ѧϰ����", "");
		System.out.println("�Ѳ�������");*/
		
		/*//����DBconnect�е�getTime����
		DbConnect test=new DbConnect();
		System.out.println(test.getTime());*/
		
		/*//��ȡϵͳ��ǰʱ��,��yyyy-MM-dd HH:mm:ss��ʽ���
		SimpleDateFormat date=new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		System.out.println(date.format(new Date()));*/
		
		
		/*//������ҳ��������ű���������
		NewsService news=new NewsServiceImpl();
		List<News> side_list_1 = news.getNewsTiltle(1);
		System.out.println(side_list_1.get(0).getnTitle());	*/
		
		/*//����ɾ������
		test.deleteNewsByID(188);*/
		
		
		/*  //���Է�ҳ
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
